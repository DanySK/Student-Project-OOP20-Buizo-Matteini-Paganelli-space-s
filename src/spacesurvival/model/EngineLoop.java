package spacesurvival.model;

import spacesurvival.controller.gui.CtrlGUI;
import spacesurvival.controller.gui.CtrlGame;
import spacesurvival.controller.gui.CtrlSound;
import spacesurvival.model.collision.hitevent.HitBorderEvent;
import spacesurvival.model.collision.hitevent.HitBulletEvent;
import spacesurvival.model.collision.hitevent.HitMainGameObject;
import spacesurvival.model.collision.hitevent.HitTakeableGameObject;
import spacesurvival.model.common.P2d;
import spacesurvival.model.gameobject.Edge;
import spacesurvival.model.gameobject.Status;
import spacesurvival.model.gameobject.fireable.Boss;
import spacesurvival.model.gameobject.fireable.FireEnemy;
import spacesurvival.model.gameobject.fireable.weapon.Bullet;
import spacesurvival.model.gameobject.main.Asteroid;
import spacesurvival.model.gameobject.main.ChaseEnemy;
import spacesurvival.model.gameobject.main.MainObject;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;
import spacesurvival.model.gameobject.movable.MovableObject;
import spacesurvival.model.gameobject.takeable.TakeableGameObject;
import spacesurvival.model.gameobject.takeable.ammo.Ammo;
import spacesurvival.model.gameobject.takeable.heart.Heart;
import spacesurvival.model.gameobject.takeable.heart.HeartType;
import spacesurvival.model.sound.CmdAudioType;
import spacesurvival.model.worldevent.WorldEvent;
import spacesurvival.model.worldevent.WorldEventListener;
import spacesurvival.utilities.Score;
import spacesurvival.utilities.path.SoundPath;
import spacesurvival.utilities.SystemVariables;
import spacesurvival.utilities.ThreadUtils;
import spacesurvival.utilities.dimension.Screen;

import java.awt.geom.AffineTransform;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class EngineLoop extends Thread implements WorldEventListener {
    /**
     * Frames per second of the game.
     */
    public static final int FPS = 30;

    private final CtrlGUI controlGUI;
    private final CtrlGame controlGame;
    private final CtrlSound controlSound;

    private final List<WorldEvent> eventQueue;
    private final List<SoundPath> soundQueue;

    public EngineLoop() {
        this.controlGUI = new CtrlGUI();
        this.eventQueue = new LinkedList<>();
        this.soundQueue = new LinkedList<>();
        this.controlGame = this.controlGUI.getCtrlGame();
        this.controlSound = this.controlGUI.getCtrlSound();
    }

    public void initGame() {
        this.controlGUI.assignSoundLoop();
        this.controlGame.assignMovementListenerInShip();
        this.controlGame.setEventListenerInWorld(this);
        this.controlGame.assignWorld();
        this.controlSound.setSoundLoop(this.controlGUI.getCurrentGUI());
        this.controlSound.setCmdAudioLoop(CmdAudioType.AUDIO_ON);
        this.controlGUI.startGUI();
    }

    @Override
    public void run() {
        long lastTime = System.currentTimeMillis();
        long current = 0L;
        final int nbThreadsss = Thread.getAllStackTraces().keySet().size();


        while (true) {
            if (!this.controlGame.isGameOver()) {
                current = System.currentTimeMillis();
                final int elapsed = (int) (current - lastTime);
                int nbThreads = Thread.getAllStackTraces().keySet().size();

                if (this.controlGUI.isInGame()) {
                    if (!this.controlGUI.isInPause()) {
                        //processInput();
                        renderMovement();
                        render();
                        waitForNextFrame(current);
                        lastTime = current;
                        updateGame();
                        nbThreads = Thread.getAllStackTraces().keySet().size();

                        System.out.println("Numero dei thread current -> " + nbThreads);
                    }
                }

                if (this.controlGUI.isInGame() || !this.controlGUI.isInPause()) {
                    waitForNextFrame(current);
                    lastTime = current;
                }
            } else {
                renderGameOver();

                while (this.controlGUI.isInGameOver()) {
                    waitForNextFrame(current);
                    lastTime = current;
                }

            }

        }
    }

    protected void waitForNextFrame(final long current) {
        final long dt = System.currentTimeMillis() - current;
        if (dt < FPS) {
            ThreadUtils.sleep(FPS - dt);
        }
    }

    protected void processInput() {
//        gameState.getWorld().getShip().updateInput(controller);
    }

    protected final void updateGame() {
        this.controlGame.updateStateWorld();
        this.checkEvents();
        this.checkSoundEffects();
        this.checkGameObjectsDead();
        this.assignTargetToEnemies();
        this.controlGame.updateHUD();
    }

    private void checkGameObjectsDead() {
        final World world = this.controlGame.getWorld();
        world.getMainObjects().forEach(mainObject -> {
            if (mainObject.isDead()) {
                mainObject.stopAnimation();
                playExplSoundOf(mainObject);
                this.controlGame.incrScore(mainObject.getScore());
                world.removeMainObject(mainObject);
            }
        });
    }

    protected void checkSoundEffects() {
        final SpaceShipSingleton ship = this.controlGame.getShip();
        //soundQueue.add(ship.popEffect()); 
        final Optional<SoundPath> effect = ship.popEffect();
        if (!effect.equals(Optional.empty())) {
            soundQueue.add(effect.get());
        }

        soundQueue.forEach(this::playEffect);
        soundQueue.clear();
    }


    protected void checkEvents() {
        final World world = this.controlGame.getWorld();

        eventQueue.forEach(ev -> {
            if (ev instanceof HitMainGameObject) {
                final HitMainGameObject asteroidEvent = (HitMainGameObject) ev;
                final MainObject object = asteroidEvent.getObject();
                final MainObject collidedObject = asteroidEvent.getCollidedObject();
                this.controlGame.incrScore(Score.ASTEROID);

                damageObject(object, collidedObject.getImpactDamage(), Status.INVINCIBLE);
                damageObject(collidedObject, object.getImpactDamage(), Status.INVINCIBLE); 

                if (object instanceof ChaseEnemy) {
                    object.stopAnimation();
                    world.removeChaseEnemy(object);
                    playEffect(SoundPath.ENEMY_EXPL);
                }
                if (collidedObject instanceof ChaseEnemy) {
                    collidedObject.stopAnimation();
                    world.removeChaseEnemy(collidedObject);
                    playEffect(SoundPath.ENEMY_EXPL);
                }
            } else if (ev instanceof HitTakeableGameObject) {
                final HitTakeableGameObject takeableEvent = (HitTakeableGameObject) ev;
                final TakeableGameObject takeableGameObject = takeableEvent.getCollidedObject();
                playEffect(SoundPath.PERK);
                takeableGameObject.stopAnimation();

                if (takeableGameObject instanceof Ammo) {
                    final Ammo ammo = (Ammo) takeableGameObject;
                    world.getShip().take(ammo);
                } else if (takeableGameObject instanceof Heart) {
                    final HeartType heartType = ((Heart) takeableGameObject).getType();
                    if (heartType == HeartType.HEAL) {
                        this.controlGame.increaseLife(heartType.getAmount());
                    } else if (heartType == HeartType.LIFE_UP) {
                        this.controlGame.increaseLives(heartType.getAmount());
                    }
                }
                this.controlGame.getWorld().removeTakeableObject(takeableGameObject);
            } else if (ev instanceof HitBorderEvent) {
                final HitBorderEvent borderEvent = (HitBorderEvent) ev;
                final MovableObject object = borderEvent.getCollisionObj();
                final Edge edge = borderEvent.getEdge();

                // If a bullet reach a border
                if (object instanceof Bullet) {
                    final Bullet bullet = (Bullet) borderEvent.getCollisionObj();
                    bullet.stopAnimation();
                    System.out.println("Bullet ha toccato il muro, lo rimuovo");
                    world.removeBullet(bullet);
                } else {
                    pacmanEffect(object, edge);
                    if (object instanceof SpaceShipSingleton) {
                        playEffect(SoundPath.WALL_COLLISION);
                    }
                }
            } else if (ev instanceof HitBulletEvent) {
                final HitBulletEvent bulletEvent = (HitBulletEvent) ev;
                final Bullet bullet = bulletEvent.getBullet(); 
                final MainObject collidedObject = bulletEvent.getCollidedObject();

                if (!bullet.getShooter().equals(collidedObject)) {
                    System.out.println("Bullet ha preso al volo qualcosa, " + collidedObject.getClass() + " lo rimuovo");
                    bullet.stopAnimation();
                    world.removeBullet(bullet);
                    damageObject(collidedObject, bullet.getDamage(), bullet.getEffect().getStatus());
                }
            }
            this.controlGame.updateRoundState();
        });
        eventQueue.clear();
    }

    public void damageObject(final MainObject object, final int damage, final Status status) {
        //System.out.println("SONO INVINCIBILE ?  " + object.isInvincible());
        if (!object.isInvincible()) {
            if (object instanceof SpaceShipSingleton) {
                this.controlGame.decreaseLife(damage);
            } else {
                object.decreaseLife(damage);
                System.out.println("VITA DEL NEMICO:  " + object.getLife());
            }
            object.setStatus(status);
        }
    }

    public void playExplSoundOf(final MainObject object) {
        if (object instanceof Asteroid) {
            playEffect(SoundPath.ASTEROID_EXPL);
        } else if (object instanceof ChaseEnemy || object instanceof FireEnemy) {
            playEffect(SoundPath.ENEMY_EXPL);
        } else if (object instanceof Boss) {
            playEffect(SoundPath.BOSS_EXPL);
        }
    }

    public void pacmanEffect(final MovableObject object, final Edge edge) {
        AffineTransform newTransform = new AffineTransform();
        switch (edge) {
        case TOP:
            newTransform = new AffineTransform(object.getTransform().getScaleX(), 
                    object.getTransform().getShearY(), object.getTransform().getShearX(), 
                    object.getTransform().getScaleY(), object.getTransform().getTranslateX(), 
                    Screen.HEIGHT_FULL_SCREEN * SystemVariables.SCALE_Y - 100);
            break;
        case BOTTOM:
            newTransform = new AffineTransform(object.getTransform().getScaleX(), 
                    object.getTransform().getShearY(), object.getTransform().getShearX(), 
                    object.getTransform().getScaleY(), object.getTransform().getTranslateX(), 
                    100);
            break;
        case LEFT:
            newTransform = new AffineTransform(object.getTransform().getScaleX(), 
                    object.getTransform().getShearY(), object.getTransform().getShearX(), 
                    object.getTransform().getScaleY(), Screen.WIDTH_FULL_SCREEN * SystemVariables.SCALE_X - 100, 
                    object.getTransform().getTranslateY());
            break;
        case RIGHT: 
            newTransform = new AffineTransform(object.getTransform().getScaleX(), 
                    object.getTransform().getShearY(), object.getTransform().getShearX(), 
                    object.getTransform().getScaleY(), 100, 
                    object.getTransform().getTranslateY());
            break;
        default:
            break;
        }
        object.setTransform(newTransform);
    }

    protected final void render() {
        this.controlGame.repaintWorld();
    }

    private void renderMovement() {
        this.controlGame.getWorld().getMovableObjects().forEach(MovableObject::move);
    }

    public void assignTargetToEnemies() {
        this.controlGame.getWorld().getAllEnemies().forEach(enemy -> {
            final AffineTransform trans = new AffineTransform();
            trans.setTransform(this.controlGame.getShip().getTransform());
            trans.translate(this.controlGame.getShip().getWidth() / 2, this.controlGame.getShip().getHeight() / 2);
            final P2d target = new P2d(trans.getTranslateX(), trans.getTranslateY());
            enemy.setTarget(Optional.of(target));

            //enemy.setTarget(Optional.of(this.controlGame.getShip().getPosition()));
        });
    }

    protected void renderGameOver() {
        this.controlGUI.endGame();
        playEffect(SoundPath.GAME_OVER);
//        view.renderGameOver();
    }

    @Override
    public void notifyEvent(final WorldEvent ev) {
        eventQueue.add(ev);
    }

    private void playEffect(final SoundPath soundPath) {
        this.controlSound.getCallerAudioEffectFromSoundPath(soundPath).get().execute(CmdAudioType.RESET_TIMING);
        this.controlSound.getCallerAudioEffectFromSoundPath(soundPath).get().execute(CmdAudioType.AUDIO_ON);
    }

}

