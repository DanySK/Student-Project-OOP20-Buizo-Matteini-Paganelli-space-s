package spaceSurvival.model;

import spaceSurvival.controller.GUI.CtrlGUI;
import spaceSurvival.controller.GUI.CtrlGame;
import spaceSurvival.controller.GUI.CtrlSound;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.mainGameObject.Asteroid;
import spaceSurvival.model.gameObject.mainGameObject.Boss;
import spaceSurvival.model.gameObject.mainGameObject.ChaseEnemy;
import spaceSurvival.model.gameObject.mainGameObject.FireEnemy;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spaceSurvival.model.gameObject.weapon.Bullet;
import spaceSurvival.model.sound.CmdAudioType;
import spaceSurvival.model.worldEcollisioni.WorldEvent;
import spaceSurvival.model.worldEcollisioni.WorldEventListener;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitAsteroidEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitBorderEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitBossEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitChaseEnemyEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitFireEnemyEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitPickableEvent;
import spaceSurvival.utilities.Score;
import spaceSurvival.utilities.SoundPath;
import spaceSurvival.utilities.dimension.Screen;

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
        this.controlGame.addAllGameObjectsFromWorld();
        
        //double scale = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().getDefaultTransform().getScaleX();      
        System.out.println("centerrrr" + Screen.POINT_CENTER_FULLSCREEN);
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

            if(this.controlGUI.isStateInGame()){
                if(!this.controlGUI.isStateInPause()){
                    //processInput();
                    renderMovement();
                    render();

                    waitForNextFrame(current);
                    lastTime = current;

                    updateGame(elapsed);
                }
            }

            if(this.controlGUI.isStateInGame() || !this.controlGUI.isStateInPause()) {
                waitForNextFrame(current);
                lastTime = current;
            }
        }
        System.out.println("Sono fuori dal loop");
        render();
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
        this.controlGame.updateStateWorld(elapsed);
        checkEvents();
        checkSoundEffects();
    }
    
    protected void checkSoundEffects() {
        final World scene = this.controlGame.getWord();
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
        final World scene = this.controlGame.getWord();
        final SpaceShipSingleton ship = this.controlGame.getShip();
        
        eventQueue.forEach(ev -> {
        	
        	if (ev instanceof HitAsteroidEvent){
            	HitAsteroidEvent asteroidEvent = (HitAsteroidEvent) ev;
            	final Asteroid asteroidCollided = (Asteroid) asteroidEvent.getCollisionObj();
            	if (!asteroidCollided.isInvincible()) {
            		asteroidCollided.decreaseLife(ship.getImpactDamage());
            		
            		if (isGameObjectDead(asteroidCollided)) {
            			scene.removeAsteroid(asteroidCollided);
            			playEffect(SoundPath.ASTEROID_EXPL);
					}
            	}
                this.controlGame.controlDecrLife(asteroidCollided.getImpactDamage());
            } else if (ev instanceof HitChaseEnemyEvent) {
            	HitChaseEnemyEvent chaseEnemyEvent = (HitChaseEnemyEvent) ev;
            	final ChaseEnemy chaseEnemyCollided = (ChaseEnemy) chaseEnemyEvent.getCollisionObj();
            	chaseEnemyCollided.decreaseLife(ship.getImpactDamage());
            	if (isGameObjectDead(chaseEnemyCollided)) {
            		System.out.println("ChaseEnemy morto e rimosso");
                	scene.removeChaseEnemy(chaseEnemyCollided);
                	playEffect(SoundPath.ENEMY_EXPL);
                	this.controlGame.incrScore(Score.CHASE_ENEMY);
				}
                this.controlGame.controlDecrLife(chaseEnemyCollided.getImpactDamage());
                // HitBorderEvent bEv = (HitBorderEvent) ev;
                //gameState.decreaseLives();
            } else if (ev instanceof HitFireEnemyEvent) {
            	HitFireEnemyEvent fireEnemyEvent = (HitFireEnemyEvent) ev;
            	final FireEnemy fireEnemyCollided = (FireEnemy) fireEnemyEvent.getCollisionObj();
            	fireEnemyCollided.decreaseLife(ship.getImpactDamage());
            	if (isGameObjectDead(fireEnemyCollided)) {
            		System.out.println("FireEnemy morto e rimosso");
                	scene.removeFireEnemy(fireEnemyCollided);
                	this.controlGame.incrScore(Score.FIRE_ENEMY);
				}
                this.controlGame.controlDecrLife(fireEnemyCollided.getImpactDamage());
                // HitBorderEvent bEv = (HitBorderEvent) ev;
                //gameState.decreaseLives();
            } else if (ev instanceof HitBossEvent) {
            	HitBossEvent bossEvent = (HitBossEvent) ev;
            	final Boss bossCollided = (Boss) bossEvent.getCollisionObj();
            	bossCollided.decreaseLife(ship.getImpactDamage());
            	if (isGameObjectDead(bossCollided)) {
                	scene.setBoss(Optional.empty());
                    this.controlGame.incrScore(Score.BOSS);
//                    playEffect(SoundPath.BOSS_EXPL);
//                	BOSS_EXPL	("sounds/enemyExpl.wav"),
				}
                this.controlGame.controlDecrLife(bossCollided.getImpactDamage());
                // HitBorderEvent bEv = (HitBorderEvent) ev;
                //gameState.decreaseLives();
            } else if (ev instanceof HitPickableEvent) {
            	playEffect(SoundPath.PERK);
            	//playEffect(SoundPath.);
                //HitPerkEvent pEv = (HitPerkEvent) ev;
                //stato = pEv.getCollisionObj().getType(???):
                //gameState.getSpaceship().setState(stato);
            } else if (ev instanceof HitBorderEvent) {
                HitBorderEvent borderEvent = (HitBorderEvent) ev;

            	if (borderEvent.getCollisionObj() instanceof SpaceShipSingleton) {
                	playEffect(SoundPath.WALL_COLLISION);
				}
            	
                // If a bullet reach a border
                if (borderEvent.getCollisionObj() instanceof Bullet) {
                	Bullet bullet = (Bullet) borderEvent.getCollisionObj();
                	if (ship.getWeapon().isPresent()) {
                		System.out.println("Bullet ha toccato il muro, lo rimuovo");
                    	ship.getWeapon().get().getShootedBullets().remove(bullet);
					}
				}
            }
        });
        eventQueue.clear();
    }

    private boolean isGameObjectDead(final MainGameObject gameObjectCollided) {
    	return gameObjectCollided.getLife() <= 0;
    }
    
    protected void render() {
        this.controlGame.repaintWorld();
        this.controlGame.updateHUD();
    }
    
    private void renderMovement() {
    	this.controlGame.moveShip();

//    	this.controlGame.getWord().getMovableEntities().forEach(entity -> {
//    		entity.move();
//    	});
    	
    	SpaceShipSingleton ship = this.controlGame.getShip();
    	if (ship.getWeapon().isPresent()) {
        	ship.getWeapon().get().getShootedBullets().forEach(bullet -> {
        		bullet.move();
        	});
		}
    }

    protected void renderGameOver() {
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

