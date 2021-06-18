package spacesurvival.model;

import spacesurvival.controller.gui.CtrlGUI;
import spacesurvival.controller.gui.CtrlGame;
import spacesurvival.controller.gui.CtrlSound;
import spacesurvival.model.collision.hitevent.HitBorderEvent;
import spacesurvival.model.collision.hitevent.HitBulletEvent;
import spacesurvival.model.collision.hitevent.HitMainGameObject;
import spacesurvival.model.collision.hitevent.HitTakeableGameObject;
import spacesurvival.model.common.P2d;
import spacesurvival.model.gameobject.GameObject;
import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.gameobject.MovableGameObject;
import spacesurvival.model.gameobject.enemy.Boss;
import spacesurvival.model.gameobject.enemy.ChaseEnemy;
import spacesurvival.model.gameobject.enemy.FireEnemy;
import spacesurvival.model.gameobject.main.Asteroid;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;
import spacesurvival.model.sound.CmdAudioType;
import spacesurvival.model.worldevent.WorldEvent;
import spacesurvival.model.worldevent.WorldEventListener;
import spacesurvival.utilities.path.SoundPath;
import spacesurvival.utilities.ThreadUtils;
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

                if (this.controlGUI.isInGame()){
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
        this.assignTargetToEnemies();
        this.checkScore();
        this.controlGame.updateHUD();
    }

    protected void checkSoundEffects() {
        final SpaceShipSingleton ship = this.controlGame.getShip();
        final Optional<SoundPath> effect = ship.popEffect();
        if (!effect.equals(Optional.empty())) {
            soundQueue.add(effect.get());
        }

        soundQueue.forEach(this::playEffect);
        soundQueue.clear();
    }

    protected void checkScore() {
        final List<Integer> scoreUpdate = this.controlGame.getWorld().getQueueScore();
        scoreUpdate.forEach(this.controlGame::incrScore);
        scoreUpdate.clear();
    }
    
    protected void checkIncrUp() {
        final List<Integer> lifeUpdate = this.controlGame.getWorld().getQueueIncreaseLife();
        lifeUpdate.forEach(this.controlGame::increaseLife);
        lifeUpdate.clear();
    }


    protected void checkEvents() {
        final World world = this.controlGame.getWorld();

        eventQueue.forEach(ev -> {
            //distinctEvent(world, ev);
            ev.manage(world);

            if (ev instanceof HitMainGameObject) {
                final HitMainGameObject asteroidEvent = (HitMainGameObject) ev;
                final MainGameObject object = asteroidEvent.getObject();
                final MainGameObject collidedObject = asteroidEvent.getCollidedObject();
                //this.controlGame.incrScore(Score.ASTEROID);

  //damageObject(object, collidedObject.getImpactDamage(), Status.INVINCIBLE);
  //damageObject(collidedObject, object.getImpactDamage(), Status.INVINCIBLE); 

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
//                final HitTakeableGameObject takeableEvent = (HitTakeableGameObject) ev;
//                final TakeableGameObject takeableGameObject = takeableEvent.getCollidedObject();
//                //playEffect(SoundPath.PERK);
//                takeableGameObject.stopAnimation();
//
//                if (takeableGameObject instanceof Ammo) {
//                    final Ammo ammo = (Ammo) takeableGameObject;
//                    world.getShip().take(ammo);
//                } else if (takeableGameObject instanceof Heart) {
//                    final HeartType heartType = ((Heart) takeableGameObject).getType();
//                    if (heartType == HeartType.HEAL) {
//                        this.controlGame.increaseLife(heartType.getAmount());
//                    } else if (heartType == HeartType.LIFE_UP) {
//                        this.controlGame.increaseLives(heartType.getAmount());
//                    }
//                }
//                this.controlGame.getWorld().removeTakeableObject(takeableGameObject);
            } else if (ev instanceof HitBorderEvent) {
//                final HitBorderEvent borderEvent = (HitBorderEvent) ev;
//                final MovableGameObject object = borderEvent.getCollisionObj();
//                final Edge edge = borderEvent.getEdge();
//
//                // If a bullet reach a border
//                if (object instanceof Bullet) {
//                    final Bullet bullet = (Bullet) borderEvent.getCollisionObj();
//                    bullet.stopAnimation();
//                    System.out.println("Bullet ha toccato il muro, lo rimuovo");
//                    world.removeBullet(bullet);
//                } else {
//                    //pacmanEffect(object, edge);
//                    if (object instanceof SpaceShipSingleton) {
//                        playEffect(SoundPath.WALL_COLLISION);
//                    }
//                }
            } else if (ev instanceof HitBulletEvent) {

//                final HitBulletEvent bulletEvent = (HitBulletEvent) ev;
//                final Bullet bullet = bulletEvent.getBullet(); 
//                final MainGameObject collidedObject = bulletEvent.getCollidedObject();
//
//                if (!bullet.getShooter().equals(collidedObject)) {
//                    System.out.println("Bullet ha preso al volo qualcosa, " + collidedObject.getClass() + " lo rimuovo");
//                    bullet.stopAnimation();
//                    world.removeBullet(bullet);
//                    damageObject(collidedObject, bullet.getDamage(), bullet.getEffect().getStatus());
//                }

            }
            this.controlGame.updateRoundState();
        });
        eventQueue.clear();
    }


//	}

    public void playExplSoundOf(final MainGameObject object) {
        if (object instanceof Asteroid) {
            //playEffect(SoundPath.ASTEROID_EXPL);
        } else if (object instanceof ChaseEnemy || object instanceof FireEnemy) {
            //playEffect(SoundPath.ENEMY_EXPL);
        } else if (object instanceof Boss) {
            //playEffect(SoundPath.BOSS_EXPL);
        }
    }






    protected final void render() {
        this.controlGame.repaintWorld();
    }

    private void renderMovement() {
    	this.controlGame.getWorld().getMovableEntities().forEach(MovableGameObject::move);
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
    
    private GameObject distinctGameObject(GameObject obj) {
        
        return null;
    }
    
    private void distinctEvent(final World world, final WorldEvent ev) {
//        switch () {
//        case HitBorderEvent:
//            cmdUp.execute(ship);
//            break;
//        default:
//            break;
//        }
        ev.manage(world);
    }
    
//    interface I {
//        void do();
//      }
//
//      class A implements I { void do() { doA() } ... }
//      class B implements I { void do() { doB() } ... }
//      class C implements I { void do() { doC() } ... }
    
    
    
//    private void manageHitBorderEvent(HitBorderEvent ev) {
//        final HitBorderEvent borderEvent = (HitBorderEvent) ev;
//        final MovableGameObject object = borderEvent.getCollisionObj();
//        final Edge edge = borderEvent.getEdge();
//
//        // If a bullet reach a border
//        if (object instanceof Bullet) {
//            final Bullet bullet = (Bullet) borderEvent.getCollisionObj();
//            bullet.stopAnimation();
//            System.out.println("Bullet ha toccato il muro, lo rimuovo");
//            this.controlGame.getWorld().removeBullet(bullet);
//        } else {
//            //pacmanEffect(object, edge);
//            if (object instanceof SpaceShipSingleton) {
//                playEffect(SoundPath.WALL_COLLISION);
//            }
//        }
//
//    }

}

