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
import spaceSurvival.utilities.dimension.Screen;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


public class EngineMalaLoop extends Thread implements WorldEventListener {
    private final CtrlGUI controlGUI;
    private final CtrlGame controlGame;
    private final CtrlSound controlSound;
    
    private final List<WorldEvent> eventQueue;

    public EngineMalaLoop() {
        this.controlGUI = new CtrlGUI();
        this.eventQueue = new LinkedList<>();
        this.controlGame = this.controlGUI.getCtrlGame();
        this.controlSound = this.controlGUI.getCtrlSound();
    }

    public void initGame() {
        this.controlGUI.initTimer();
        this.controlGUI.assignSoundLoop();

        this.controlGame.assignMovementListenerInShip();
        this.controlGame.setEventListenerInWorld(this);
        this.controlGame.addAllGameObjectsFromWorld();

        this.controlGame.getShip().getTransform()
                .setToTranslation(Screen.POINT_CENTER_FULLSCREEN.getX(), Screen.POINT_CENTER_FULLSCREEN.getY());

        this.controlSound.setSoundLoop(this.controlGUI.getCurrentGUI());
        this.controlSound.setCmdAudioLoop(CmdAudioType.AUDIO_ON);
        this.controlGUI.startGUI();
    }

    public void run() {
        long lastTime = System.currentTimeMillis();
        while (!this.controlGame.isGameOver()) {
            long current = System.currentTimeMillis();
            int elapsed = (int)(current - lastTime);

            processInput();
            renderMovement();
            render();

            waitForNextFrame(current);
            lastTime = current;
            updateGame(elapsed);

            System.out.println("LoopMala -> "+ elapsed +" FPS");
        }
        System.out.println("Sono fuori dal loop");
        renderGameOver();
    }
    
	protected void waitForNextFrame(final long current) {
        long dt = System.currentTimeMillis() - current;
        long period = 30L;
        if (dt < period){
            try {
                Thread.sleep(period - dt);
            } catch (Exception ignored){}
        }
    }

    protected void processInput() {
//        gameState.getWorld().getShip().updateInput(controller);
    }

    protected void updateGame(final int elapsed) {
        this.controlGame.updateStateWorld(elapsed);
        checkEvents();
    }

    protected void checkEvents() {
        final World scene = this.controlGame.getWord();
        final SpaceShipSingleton ship = this.controlGame.getShip();
        
        eventQueue.forEach(ev -> {
        	if (ev instanceof HitAsteroidEvent){
            	HitAsteroidEvent asteroidEvent = (HitAsteroidEvent) ev;
            	final Asteroid asteroidCollided = (Asteroid) asteroidEvent.getCollisionObj();
            	asteroidCollided.decreaseLife(ship.getImpactDamage());
            	if (isGameObjectDead(asteroidCollided)) {
                    scene.removeAsteroid(asteroidCollided);
				}
                this.controlGame.decrLifeShip(asteroidCollided.getImpactDamage());
            } else if (ev instanceof HitChaseEnemyEvent) {
            	HitChaseEnemyEvent chaseEnemyEvent = (HitChaseEnemyEvent) ev;
            	final ChaseEnemy chaseEnemyCollided = (ChaseEnemy) chaseEnemyEvent.getCollisionObj();
            	chaseEnemyCollided.decreaseLife(ship.getImpactDamage());
            	if (isGameObjectDead(chaseEnemyCollided)) {
            		System.out.println("ChaseEnemy morto e rimosso");
                	scene.removeChaseEnemy(chaseEnemyCollided);
                	this.controlGame.incrScore(Score.CHASE_ENEMY);
				}
                this.controlGame.decrLifeShip(chaseEnemyCollided.getImpactDamage());
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
                this.controlGame.decrLifeShip(fireEnemyCollided.getImpactDamage());
                // HitBorderEvent bEv = (HitBorderEvent) ev;
                //gameState.decreaseLives();
            } else if (ev instanceof HitBossEvent) {
            	HitBossEvent bossEvent = (HitBossEvent) ev;
            	final Boss bossCollided = (Boss) bossEvent.getCollisionObj();
            	bossCollided.decreaseLife(ship.getImpactDamage());
            	if (isGameObjectDead(bossCollided)) {
                	scene.setBoss(Optional.empty());
                    this.controlGame.incrScore(Score.BOSS);
				}
                this.controlGame.decrLifeShip(bossCollided.getImpactDamage());
                // HitBorderEvent bEv = (HitBorderEvent) ev;
                //gameState.decreaseLives();
            } else if (ev instanceof HitPickableEvent) {
                //HitPerkEvent pEv = (HitPerkEvent) ev;
                //stato = pEv.getCollisionObj().getType(???):
                //gameState.getSpaceship().setState(stato);
            } else if (ev instanceof HitBorderEvent) {
            	System.out.println("TOCCATO MURO E MANDATO EVENTO AL MONDO");
            	
                // HitBorderEvent bEv = (HitBorderEvent) ev;
                //gameState.decreaseLife();
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
    }

    protected void renderGameOver() {
//        view.renderGameOver();
    }

    public void notifyEvent(final WorldEvent ev) {
        eventQueue.add(ev);
    }
}

