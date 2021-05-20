package spaceSurvival.model.game;

import spaceSurvival.controller.GUI.CtrlGUI;
import spaceSurvival.controller.sound.CallerAudio;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.mainGameObject.Asteroid;
import spaceSurvival.model.gameObject.mainGameObject.Boss;
import spaceSurvival.model.gameObject.mainGameObject.ChaseEnemy;
import spaceSurvival.model.gameObject.mainGameObject.FireEnemy;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spaceSurvival.model.input.MovementKeyListener;
import spaceSurvival.model.sound.CmdAudioType;
import spaceSurvival.model.sound.category.SoundLoop;
import spaceSurvival.model.world.World;
import spaceSurvival.model.worldEcollisioni.WorldEvent;
import spaceSurvival.model.worldEcollisioni.WorldEventListener;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitAsteroidEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitBorderEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitBossEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitChaseEnemyEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitFireEnemyEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitPickableEvent;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import spaceSurvival.utilities.DesignSound;
import spaceSurvival.utilities.IdGUI;
import spaceSurvival.utilities.Score;
import spaceSurvival.utilities.dimension.Screen;
import spaceSurvival.view.GUI.game.GUIGame;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


public class GameMalaLoop extends Thread implements WorldEventListener {
    private long period = 60L;

    private final TwoThread twoThread;
    private final CtrlGUI controlGUI;
    private final GameState gameState;
    private CallerAudio callerAudioLoop;
    private List<CallerAudio> callerAudioEffects;
    private GUIGame panelGame;

    private MovementKeyListener controller;
    
    private List<WorldEvent> eventQueue;

    public GameMalaLoop() {
        this.eventQueue = new LinkedList<>();
        this.gameState = new GameState();
        this.controlGUI = new CtrlGUI();
        this.twoThread = new TwoThread();
    }

    public void initGame() {
        this.panelGame = this.controlGUI.getPanelGame();
        this.controller = new MovementKeyListener(this.gameState.getSpaceship());

        this.callerAudioLoop = new CallerAudio(new SoundLoop(this.controlGUI.getCurrentSound()));

        this.controlGUI.initTimer();

        this.controlGUI.linksCallerAudioLoopWith(this.callerAudioLoop);
        //this.controlGUI.linksCallerAudioEffectWith(this.callerAudioEffects);

        this.panelGame.addKeyListenerSpaceShip(controller);
        //this.panelGame.getPanelGame().addGameObject(this.gameState.getSpaceship(), this.gameState.getSpaceship().getTransform());
        
        this.gameState.getWorld().getAllEnemies().forEach(enemy -> {
        	System.out.println(enemy);        	
            RectBoundingBox rbbEnemy = (RectBoundingBox) enemy.getBoundingBox();
            enemy.getTransform().translate(rbbEnemy.getULCorner().getX(), rbbEnemy.getULCorner().getY());
        	this.panelGame.getPanelGame().addGameObject(enemy, enemy.getTransform());
        });
        
        RectBoundingBox rbb = (RectBoundingBox) this.gameState.getSpaceship().getBoundingBox();

//        
        this.gameState.getSpaceship().getTransform().setToTranslation(Screen.POINT_CENTER_FULLSCREEN.getX(), Screen.POINT_CENTER_FULLSCREEN.getY());
        
        this.panelGame.getPanelGame().addGameObject(this.gameState.getSpaceship(), this.gameState.getSpaceship().getTransform());  

        this.gameState.getWorld().setEventListener(this);

        this.callerAudioLoop.execute(CmdAudioType.AUDIO_ON);
        this.controlGUI.startGUI();
        this.twoThread.start();
    }

    public void run() {
        long lastTime = System.currentTimeMillis();

        while (!gameState.isGameOver()) {
            long current = System.currentTimeMillis();
            int elapsed = (int)(current - lastTime);

//            System.out.println("Entro nel 1 thread");
//            this.startTimer();
//            this.controlGUI.renderTimer();
//            this.updateSound();

            synchronized (this) {
                inputSkin();
                processInput();

                render();
                renderMovement();
            }

            waitForNextFrame(current);
            lastTime = current;
            updateGame(elapsed);

            //System.out.println("LoopMala -> "+ elapsed +" FPS");
        }
        System.out.println("Sono fuori dal loop");
        renderGameOver();
    }
    
	protected void waitForNextFrame(long current) {
        long dt = System.currentTimeMillis() - current;
        if (dt < period){
            try {
                Thread.sleep(period - dt);
            } catch (Exception ignored){}
        }
    }

    protected void processInput() {
//        gameState.getWorld().getShip().updateInput(controller);		

    }

    protected void updateGame(int elapsed) {
        gameState.getWorld().updateState(elapsed);
        checkEvents();
    }

    protected void checkEvents() {
        World scene = gameState.getWorld();
        SpaceShipSingleton ship = this.gameState.getSpaceship();
        
        eventQueue.stream().forEach(ev -> {
        	if (ev instanceof HitAsteroidEvent){
            	HitAsteroidEvent asteroidEvent = (HitAsteroidEvent) ev;
            	final Asteroid asteroidCollided = (Asteroid) asteroidEvent.getCollisionObj();
            	asteroidCollided.decreaseLife(ship.getImpactDamage());
            	if (isGameObjectDead(asteroidCollided)) {
                    scene.removeAsteroid(asteroidCollided);
				}
                gameState.decreaseLife(asteroidCollided.getImpactDamage());
            } else if (ev instanceof HitChaseEnemyEvent) {
            	HitChaseEnemyEvent chaseEnemyEvent = (HitChaseEnemyEvent) ev;
            	final ChaseEnemy chaseEnemyCollided = (ChaseEnemy) chaseEnemyEvent.getCollisionObj();
            	chaseEnemyCollided.decreaseLife(ship.getImpactDamage());
            	if (isGameObjectDead(chaseEnemyCollided)) {
            		System.out.println("ChaseEnemy morto e rimosso");
                	scene.removeChaseEnemy(chaseEnemyCollided);
                	gameState.increaseScore(Score.CHASE_ENEMY);
				}
                gameState.decreaseLife(chaseEnemyCollided.getImpactDamage());
                // HitBorderEvent bEv = (HitBorderEvent) ev;
                //gameState.decreaseLives();
            } else if (ev instanceof HitFireEnemyEvent) {
            	HitFireEnemyEvent fireEnemyEvent = (HitFireEnemyEvent) ev;
            	final FireEnemy fireEnemyCollided = (FireEnemy) fireEnemyEvent.getCollisionObj();
            	fireEnemyCollided.decreaseLife(ship.getImpactDamage());
            	if (isGameObjectDead(fireEnemyCollided)) {
            		System.out.println("FireEnemy morto e rimosso");
                	scene.removeFireEnemy(fireEnemyCollided);
                	gameState.increaseScore(Score.FIRE_ENEMY);
				}
                gameState.decreaseLife(fireEnemyCollided.getImpactDamage());
                // HitBorderEvent bEv = (HitBorderEvent) ev;
                //gameState.decreaseLives();
            } else if (ev instanceof HitBossEvent) {
            	HitBossEvent bossEvent = (HitBossEvent) ev;
            	final Boss bossCollided = (Boss) bossEvent.getCollisionObj();
            	bossCollided.decreaseLife(ship.getImpactDamage());
            	if (isGameObjectDead(bossCollided)) {
                	scene.setBoss(Optional.empty());
                	gameState.increaseScore(Score.BOSS);
				}
                gameState.decreaseLife(bossCollided.getImpactDamage());
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

    private boolean isGameObjectDead(MainGameObject gameObjectCollided) {
    	return gameObjectCollided.getLife() <= 0;
    }
    
	private void inputSkin() {
        int i = 0;
        if(this.controlGUI.getCurrentGUI() == IdGUI.ID_GAME && i == 0){
            this.gameState.setSkin(this.controlGUI.getCurrentSkin());
            i = 1;
        }
    }
    
    protected void render() {
        panelGame.repaintGameObjects();
    }
    
    private void renderMovement() {
//    	this.gameState.getWorld().getMovableEntities().forEach(gameObject -> {
//    		gameObject.move();
//    	});
    	this.gameState.getSpaceship().move();
    }

    protected void renderGameOver() {
//        view.renderGameOver();
    }

    protected void updateSound() {
        if(this.callerAudioLoop.isNewSound(this.controlGUI.getCurrentSound())) {
            this.callerAudioLoop.execute(CmdAudioType.AUDIO_OFF);
            this.callerAudioLoop.setSound(new SoundLoop(this.controlGUI.getCurrentSound()));

            this.callerAudioLoop.changeVolume(this.controlGUI.isActiveLoopUnitSound() ?
                    this.controlGUI.getCurrentLoopVolume() : DesignSound.SOUND_ZERO);

            this.callerAudioLoop.execute(CmdAudioType.AUDIO_ON);
        }
    }

    public void startTimer() {
        if(!this.controlGUI.isStartTimer() && this.controlGUI.getCurrentGUI() == IdGUI.ID_GAME){
            this.controlGUI.startTimer();
        }
    }

    public void notifyEvent(WorldEvent ev) {
        eventQueue.add(ev);
    }

    private class TwoThread extends Thread{

        public void run(){
            super.run();

            while(!GameMalaLoop.this.gameState.isGameOver()){
                long lastTime = System.currentTimeMillis();

                while (!gameState.isGameOver()) {
                    long current = System.currentTimeMillis();
                    int elapsed = (int)(current - lastTime);

                    //System.out.println("Entro nel 2 thread");

                    synchronized (GameMalaLoop.this) {
                        GameMalaLoop.this.startTimer();
                        GameMalaLoop.this.controlGUI.renderTimer();
                        GameMalaLoop.this.updateSound();
                    }


//                    inputSkin();
//                    processInput();
//
//                    render();
//                    renderMovement();

                    waitForNextFrame(current);
                    lastTime = current;
//                    updateGame(elapsed);
                    //System.out.println("LoopMala -> "+ elapsed +" FPS");
                }
            }
        }

        protected void waitForNextFrame(long current) {
            long dt = System.currentTimeMillis() - current;
            if (dt < period){
                try {
                    Thread.sleep(period - dt);
                } catch (Exception ignored){}
            }
        }
    }
}

