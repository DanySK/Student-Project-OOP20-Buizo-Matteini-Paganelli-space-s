package spaceSurvival.model;

import spaceSurvival.controller.GUI.CtrlGUI;
import spaceSurvival.controller.GUI.CtrlGame;
import spaceSurvival.controller.GUI.CtrlSound;
import spaceSurvival.model.gameObject.Effect;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.MovableGameObject;
import spaceSurvival.model.gameObject.Status;
import spaceSurvival.model.gameObject.mainGameObject.Asteroid;
import spaceSurvival.model.gameObject.mainGameObject.Boss;
import spaceSurvival.model.gameObject.mainGameObject.ChaseEnemy;
import spaceSurvival.model.gameObject.mainGameObject.FireEnemy;
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
import spaceSurvival.model.worldEcollisioni.hitEvents.HitAsteroidEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitBorderEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitBossEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitBulletEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitChaseEnemyEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitFireEnemyEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitHeartEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitMainGameObject;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitTakeableGameObject;
import spaceSurvival.model.worldEcollisioni.physics.BoundaryCollision.CollisionEdge;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitAmmoEvent;
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
        this.controlGUI.initTimer();
        this.controlGUI.assignSoundLoop();

        this.controlGame.assignMovementListenerInShip();
        this.controlGame.setEventListenerInWorld(this);
        this.controlGame.assignWorld();
        this.controlGame.addAllGameObjectsFromWorld();
        
        //double scale = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().getDefaultTransform().getScaleX();      
        //System.out.println("centerrrr" + Screen.POINT_CENTER_FULLSCREEN);
        //this.controlGame.getShip().setPosition(new P2d(Screen.POINT_CENTER_FULLSCREEN.getX(), Screen.POINT_CENTER_FULLSCREEN.getY()));
        
        
        this.controlSound.setSoundLoop(this.controlGUI.getCurrentGUI());
        this.controlSound.setCmdAudioLoop(CmdAudioType.AUDIO_ON);
        
        this.controlGUI.startGUI();
    }

    public void run() {
        long lastTime = System.currentTimeMillis();
        while (!this.controlGame.isGameOver()) {
            long current = System.currentTimeMillis();
            int elapsed = (int)(current - lastTime);

            if(this.controlGUI.isInGame()){
                if(!this.controlGUI.isInPause()){
                    //processInput();
                    renderMovement();
                    //render();

                    waitForNextFrame(current);
                    lastTime = current;

                    //this.controlGame.controlDecrLife(1);
                    updateGame(elapsed);
                }
            }

            if(this.controlGUI.isInGame() || !this.controlGUI.isInPause()) {
                waitForNextFrame(current);
                lastTime = current;
            }
        }
        System.out.println("Sono fuori dal loop");
        renderGameOver();
    }
    
	protected void waitForNextFrame(final long current) {
        long dt = System.currentTimeMillis() - current;
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
        final World scene = this.controlGame.getWorld();
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
        final SpaceShipSingleton ship = this.controlGame.getShip();
        
        eventQueue.forEach(ev -> {
        	if (ev instanceof HitMainGameObject) {
        		HitMainGameObject asteroidEvent = (HitMainGameObject) ev;
            	final MainGameObject object = asteroidEvent.getObject();
            	final MainGameObject collidedObject = asteroidEvent.getCollidedObject();
            	this.controlGame.incrScore(Score.ASTEROID);
            	
            	collisionDamageObject(object, collidedObject.getImpactDamage());
            	collisionDamageObject(collidedObject, object.getImpactDamage());

        	} else if (ev instanceof HitTakeableGameObject) {
        		HitTakeableGameObject takeableEvent = (HitTakeableGameObject) ev;
        		TakeableGameObject takeableGameObject = takeableEvent.getCollidedObject();
    			playEffect(SoundPath.PERK);

        		if (takeableGameObject instanceof Ammo) {
        			final AmmoType ammoType = ((Ammo) takeableGameObject).getType();
        			world.getShip().getWeapon().get().setAmmoType(ammoType);
        			System.out.println("PRENDO MUNIZIONI DI TIPO " + ammoType);
        			
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
//        	else if (ev instanceof HitAsteroidEvent){
//            	HitAsteroidEvent asteroidEvent = (HitAsteroidEvent) ev;
//            	final Asteroid asteroidCollided = (Asteroid) asteroidEvent.getCollisionObj();
//            	if (!asteroidCollided.isInvincible()) {
//            		asteroidCollided.decreaseLife(ship.getImpactDamage());
//            		if (isGameObjectDead(asteroidCollided)) {
//            			world.removeAsteroid(asteroidCollided);
//            			playEffect(SoundPath.ASTEROID_EXPL);
//                    	this.controlGame.incrScore(Score.ASTEROID);
//					}
//            	}
//                this.controlGame.decreaseLife(asteroidCollided.getImpactDamage());
//            } else if (ev instanceof HitChaseEnemyEvent) {
//            	HitChaseEnemyEvent chaseEnemyEvent = (HitChaseEnemyEvent) ev;
//            	final ChaseEnemy chaseEnemyCollided = (ChaseEnemy) chaseEnemyEvent.getCollisionObj();
//            	chaseEnemyCollided.decreaseLife(ship.getImpactDamage());
//            	System.out.println(ship.getImpactDamage());
//            	if (isGameObjectDead(chaseEnemyCollided)) {
//            		System.out.println("ChaseEnemy morto e rimosso");
//                	world.removeChaseEnemy(chaseEnemyCollided);
//                	playEffect(SoundPath.ENEMY_EXPL);
//                	this.controlGame.incrScore(Score.CHASE_ENEMY);
//                	this.controlGame.updateRoundState();
//				}
//                this.controlGame.decreaseLife(chaseEnemyCollided.getImpactDamage());
//                //gameState.decreaseLives();
//            } else if (ev instanceof HitFireEnemyEvent) {
//            	HitFireEnemyEvent fireEnemyEvent = (HitFireEnemyEvent) ev;
//            	final FireEnemy fireEnemyCollided = (FireEnemy) fireEnemyEvent.getCollisionObj();
//            	fireEnemyCollided.decreaseLife(ship.getImpactDamage());
//            	if (isGameObjectDead(fireEnemyCollided)) {
//            		System.out.println("FireEnemy morto e rimosso");
//                	world.removeFireEnemy(fireEnemyCollided);
//                	this.controlGame.incrScore(Score.FIRE_ENEMY);
//                	//this.controlGame.updateRoundState();
//				}
//                this.controlGame.decreaseLife(fireEnemyCollided.getImpactDamage());
//                //gameState.decreaseLives();
//            } else if (ev instanceof HitBossEvent) {
//            	HitBossEvent bossEvent = (HitBossEvent) ev;
//            	final Boss bossCollided = (Boss) bossEvent.getCollisionObj();
//            	bossCollided.decreaseLife(ship.getImpactDamage());
//            	if (isGameObjectDead(bossCollided)) {
//                	world.setBoss(Optional.empty());
//                    this.controlGame.incrScore(Score.BOSS);
//                	this.controlGame.updateRoundState();
////                    playEffect(SoundPath.BOSS_EXPL);
////                	BOSS_EXPL	("sounds/enemyExpl.wav"),
//				}
//                this.controlGame.decreaseLife(bossCollided.getImpactDamage());
//                //gameState.decreaseLives();
//            } else if (ev instanceof HitAmmoEvent) {
//            	playEffect(SoundPath.PERK);
//            	HitAmmoEvent ammoEvent = (HitAmmoEvent) ev;
//            	final AmmoType ammoType = ((Ammo) ammoEvent.getCollisionObj()).getType();
//                world.getShip().getWeapon().get().setAmmoType(ammoType);
//                System.out.println("PRENDO MUNIZIONI DI TIPO " + ammoType);
//            } else if (ev instanceof HitHeartEvent) {
//            	playEffect(SoundPath.PERK);
//            	HitHeartEvent heartEvent = (HitHeartEvent) ev;
//            	final HeartType heartType = ((Heart) heartEvent.getCollisionObj()).getType();
//            	if (heartType == HeartType.HEAL) {
//					this.controlGame.increaseLife(heartType.getAmount());
//				} else if (heartType == HeartType.LIFE_UP) {
//					this.controlGame.increaseLives(heartType.getAmount());
//				}

                //Effect effect = pickableEvent.getCollisionObj().getEffectType();
                //world.getShip().setStatus(effect.getStatus());
             else if (ev instanceof HitBorderEvent) {
                HitBorderEvent borderEvent = (HitBorderEvent) ev;
                MovableGameObject object = (MovableGameObject) borderEvent.getCollisionObj();
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
            	
           		fireDamageObject(object, bullet.getDamage(), bullet.getEffect().getStatus());
//              if (gameObj instanceof Asteroid) {
//               		System.out.println("Bullet ha preso al volo un asteroid, lo rimuovo");
//               		world.removeAsteroid(gameObj);
//               		world.removeBullet(bullet);
//				}
//                if (gameObj instanceof ChaseEnemy) {
//               		System.out.println("Bullet ha preso al volo un chase enemy, lo rimuovo");
//               		world.removeChaseEnemy(gameObj);
//               		world.removeBullet(bullet);
//				}
//                if (gameObj instanceof FireEnemy) {
//               		System.out.println("Bullet ha preso al volo un fire enemy, lo rimuovo");
//               		world.removeFireEnemy(gameObj);
//               		world.removeBullet(bullet);
//				}
//                if (gameObj instanceof Boss) {
//               		System.out.println("Bullet ha preso al volo il boss, lo rimuovo");
//               		//world.removeBoss(gameObj);
//                   	//ship.getWeapon().get().getShootedBullets().remove(bullet);
//				}
//                if (gameObj instanceof SpaceShipSingleton) {
//               		System.out.println("Oh nooooo! Un bullet ha preso al volo la ship!");
//					this.controlGame.decreaseLife(bullet.getDamage());
//               		world.removeBullet(bullet);
//				}
                
            }
        	this.controlGame.updateRoundState();
        });
        eventQueue.clear();
    }
    
    public void collisionDamageObject(MainGameObject object, final int damage) {
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
        	object.setStatus(Status.INVINCIBLE);
		}
	}
    
    public void fireDamageObject(MainGameObject object, final int damage, final Status status) {
    	System.out.println("COLPISCO UN : " + object.getClass());
    	collisionDamageObject(object, damage);
    	object.setStatus(status);
	}
    
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
    	
//    	SpaceShipSingleton ship = this.controlGame.getShip();
//    	if (ship.getWeapon().isPresent()) {
//        	ship.getWeapon().get().getShootedBullets().forEach(bullet -> {
//        		bullet.move();
//        	});
//		}
    }

    protected void renderGameOver() {
        this.controlGUI.EndGame();
    	//playEffect(SoundPath.GAME_OVER);
//        view.renderGameOver();
    }

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

