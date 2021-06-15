package spaceSurvival.model;

import spaceSurvival.controller.GUI.CtrlGUI;
import spaceSurvival.controller.GUI.CtrlGame;
import spaceSurvival.controller.GUI.CtrlSound;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.MovableGameObject;
import spaceSurvival.model.gameObject.Status;
import spaceSurvival.model.gameObject.enemy.Boss;
import spaceSurvival.model.gameObject.enemy.ChaseEnemy;
import spaceSurvival.model.gameObject.enemy.Enemy;
import spaceSurvival.model.gameObject.enemy.FireEnemy;
import spaceSurvival.model.gameObject.mainGameObject.Asteroid;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spaceSurvival.model.gameObject.takeableGameObject.Ammo;
import spaceSurvival.model.gameObject.takeableGameObject.AmmoType;
import spaceSurvival.model.gameObject.takeableGameObject.Heart;
import spaceSurvival.model.gameObject.takeableGameObject.HeartType;
import spaceSurvival.model.gameObject.takeableGameObject.TakeableGameObject;
import spaceSurvival.model.gameObject.weapon.Bullet;
import spaceSurvival.model.sound.CmdAudioType;
import spaceSurvival.model.worldEcollisioni.WorldEvent;
import spaceSurvival.model.worldEcollisioni.WorldEventListener;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitBorderEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitBulletEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitMainGameObject;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitTakeableGameObject;
import spaceSurvival.model.worldEcollisioni.physics.BoundaryCollision.CollisionEdge;
import spaceSurvival.utilities.Score;
import spaceSurvival.utilities.SoundPath;
import spaceSurvival.utilities.SystemVariables;
import spaceSurvival.utilities.dimension.Screen;

import java.awt.geom.AffineTransform;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class EngineMalaLoop extends Thread implements WorldEventListener {
    public static final int FPS = 60;

    private final CtrlGUI controlGUI;
    private final CtrlGame controlGame;
    private final CtrlSound controlSound;

    private final List<WorldEvent> eventQueue;
    private final List<SoundPath> soundQueue;

    public EngineMalaLoop() {
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
        int nbThreadsss =  Thread.getAllStackTraces().keySet().size();

        System.out.println("Numero dei thread current init -> " + nbThreadsss);

        while (true) {
            if (!this.controlGame.isGameOver()) {
                current = System.currentTimeMillis();
                final int elapsed = (int) (current - lastTime);

                if (this.controlGUI.isInGame()){
                    int nbThreads =  Thread.getAllStackTraces().keySet().size();

                    if (!this.controlGUI.isInPause()) {
                        //processInput();
                        renderMovement();
                        //render();
                        waitForNextFrame(current);
                        lastTime = current;
                        updateGame(elapsed);
                        nbThreads =  Thread.getAllStackTraces().keySet().size();

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
        if (dt < FPS){
            try {
                Thread.sleep(FPS - dt);
            } catch (Exception ignored){}
        }
    }

    protected void processInput() {
//        gameState.getWorld().getShip().updateInput(controller);
    }

    protected void updateGame(final int elapsed) {
        this.controlGame.updateHUD();
        this.controlGame.updateStateWorld(elapsed);
        checkEvents();
        checkSoundEffects();
    }

    protected void checkSoundEffects() {
        final SpaceShipSingleton ship = this.controlGame.getShip();
        //soundQueue.add(ship.popEffect()); 
        Optional<SoundPath> effect = ship.popEffect();
        if(!effect.equals(Optional.empty())) {
        	soundQueue.add(effect.get());       	
        }

        soundQueue.forEach(this::playEffect);
        
        soundQueue.clear();
    }
    

    protected void checkEvents() {
        final World world = this.controlGame.getWorld();
        
        eventQueue.forEach(ev -> {
        	if (ev instanceof HitMainGameObject) {
        		HitMainGameObject asteroidEvent = (HitMainGameObject) ev;
            	final MainGameObject object = asteroidEvent.getObject();
            	final MainGameObject collidedObject = asteroidEvent.getCollidedObject();
            	this.controlGame.incrScore(Score.ASTEROID);

            	damageObject(object, collidedObject.getImpactDamage(), Status.INVINCIBLE);
                damageObject(collidedObject, object.getImpactDamage(), Status.INVINCIBLE); 

            	if (object instanceof ChaseEnemy) {
                    world.removeChaseEnemy(object);
                    playEffect(SoundPath.ENEMY_EXPL);
                }
            	if (collidedObject instanceof ChaseEnemy) {
                    world.removeChaseEnemy(collidedObject);
                    playEffect(SoundPath.ENEMY_EXPL);
            	}
        	} else if (ev instanceof HitTakeableGameObject) {
        		HitTakeableGameObject takeableEvent = (HitTakeableGameObject) ev;
        		TakeableGameObject takeableGameObject = takeableEvent.getCollidedObject();
    			playEffect(SoundPath.PERK);

        		if (takeableGameObject instanceof Ammo) {
        			final AmmoType ammoType = ((Ammo) takeableGameObject).getType();
        			System.out.println("PRENDO MUNIZIONI DI TIPO " + ammoType);
        			if (world.getShip().getWeapon().isPresent()) {
            			world.getShip().getWeapon().get().setAmmoType(ammoType);
					}
        			
        		} else if (takeableGameObject instanceof Heart) {
        			final HeartType heartType = ((Heart) takeableGameObject).getType();
        			if (heartType == HeartType.HEAL) {
        				this.controlGame.increaseLife(heartType.getAmount());
        			} else if (heartType == HeartType.LIFE_UP) {
        				this.controlGame.increaseLives(heartType.getAmount());
        			}
        		}
        		this.controlGame.getWorld().removeTakeableObject(takeableGameObject);
			}
            else if (ev instanceof HitBorderEvent) {
                HitBorderEvent borderEvent = (HitBorderEvent) ev;
                MovableGameObject object = borderEvent.getCollisionObj();
                CollisionEdge edge = borderEvent.getEdge();
                
                // If a bullet reach a border
                if (object instanceof Bullet) {
                	Bullet bullet = (Bullet) borderEvent.getCollisionObj();
               		System.out.println("Bullet ha toccato il muro, lo rimuovo");
               		world.removeBullet(bullet);
				} else {
	                pacmanEffect(object, edge);
	                if (object instanceof SpaceShipSingleton) {
	                	playEffect(SoundPath.WALL_COLLISION);
					}
				}
                
            } else if (ev instanceof HitBulletEvent) {
            	HitBulletEvent bulletEvent = (HitBulletEvent) ev;
            	
            	Bullet bullet = bulletEvent.getBullet();
           		System.out.println("Bullet ha preso al volo qualcosa, lo rimuovo");
           		world.removeBullet(bullet);
           		MainGameObject object = bulletEvent.getCollidedObject();
           		System.out.println(object);
           		damageObject(object, bullet.getDamage(), bullet.getEffect().getStatus());
            }
        	this.controlGame.updateRoundState();
        });
        eventQueue.clear();
    }
    
    public void damageObject(MainGameObject object, final int damage, final Status status) {
    	System.out.println("SONO INVINCIBILE ?  " + object.isInvincible());
    	if (!object.isInvincible()) {
    		if (object instanceof SpaceShipSingleton) {
            	this.controlGame.decreaseLife(damage);
			} else {
				object.decreaseLife(damage);
           		System.out.println("VITA DEL NEMICO:  " + object.getLife());
				if (isGameObjectDead(object)) {
	    			playSoundOf(object);
	            	this.controlGame.incrScore(object.getScore());
	    			this.controlGame.getWorld().removeMainObject(object);
				}
			}
    		System.out.println("DURATA INVINCIBILITA " + status.getDuration());
        	object.setStatus(status);
		}
	}
    
//    public void fireDamageObject(MainGameObject object, final int damage, final Status status) {
//    	System.out.println("COLPISCO UN : " + object.getClass());
//    	damageObject(object, damage);
//    	object.setStatus(status);
//	}
    
    public void playSoundOf(MainGameObject object) {
		if (object instanceof Asteroid) {
			playEffect(SoundPath.ASTEROID_EXPL);
		} else if (object instanceof ChaseEnemy || object instanceof FireEnemy) {
			playEffect(SoundPath.ENEMY_EXPL);
		} else if (object instanceof Boss) {
			playEffect(SoundPath.BOSS_EXPL);
		}
	}

    private boolean isGameObjectDead(final MainGameObject gameObject) {
    	return gameObject.getLife() <= 0;
    }
    
    public void pacmanEffect(MovableGameObject object, CollisionEdge edge) {
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
		}
		object.setTransform(newTransform);

	}
    
//    protected void render() {
//        this.controlGame.repaintWorld();
//    }
    
    private void renderMovement() {
    	//this.controlGame.moveShip();

    	this.controlGame.getWorld().getMovableEntities().forEach(entity -> {
    		entity.move();
    	});

    	this.controlGame.getWorld().getAllEnemies().forEach(enemy -> {

    	    //DA CAMBIARE MAIN IN ENEMY IN GET ALL ENEMIES
            Enemy enemy2 = (Enemy) enemy;
            enemy2.setTarget(this.controlGame.getShip().getPosition());
        });
    	
//    	SpaceShipSingleton ship = this.controlGame.getShip();
//    	if (ship.getWeapon().isPresent()) {
//        	ship.getWeapon().get().getShootedBullets().forEach(bullet -> {
//        		bullet.move();
//        	});
//		}
    }

    protected void renderGameOver() {
        this.controlGUI.endGame();
    	//playEffect(SoundPath.GAME_OVER);
//        view.renderGameOver();
    }

    @Override
    public void notifyEvent(final WorldEvent ev) {
        eventQueue.add(ev);
    }
    
    private void playEffect(SoundPath soundPath) {
    	this.controlSound.getCallerAudioEffectFromSoundPath(soundPath).get().execute(CmdAudioType.RESET_TIMING);
        this.controlSound.getCallerAudioEffectFromSoundPath(soundPath).get().execute(CmdAudioType.AUDIO_ON);
    	
    }
    
//    public void notifySoundEvent(final SoundPath ev) {
//        soundQueue.add(ev);
//    }
}

