package spaceSurvival.model.game;

import spaceSurvival.controller.GUI.CtrlGUI;
import spaceSurvival.controller.sound.CallerAudio;
import spaceSurvival.model.gameObject.mainGameObject.Asteroid;
import spaceSurvival.model.gameObject.mainGameObject.ChaseEnemy;
import spaceSurvival.model.input.MovementKeyListener;
import spaceSurvival.model.sound.CmdAudioType;
import spaceSurvival.model.sound.category.SoundLoop;
import spaceSurvival.model.world.World;
import spaceSurvival.model.worldEcollisioni.WorldEvent;
import spaceSurvival.model.worldEcollisioni.WorldEventListener;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitAsteroidEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitBorderEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitChaseEnemyEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitPickableEvent;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import spaceSurvival.utilities.DesignSound;
import spaceSurvival.utilities.IdGUI;
import spaceSurvival.utilities.dimension.Screen;
import spaceSurvival.view.GUI.game.GUIGame;

import java.awt.geom.AffineTransform;
import java.util.LinkedList;
import java.util.List;

public class GameMalaLoop extends Thread implements WorldEventListener {
    private long period = 60L;

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
    }

    public void initGame() {
        this.panelGame = this.controlGUI.getPanelGame();
        this.controller = new MovementKeyListener(this.gameState.getSpaceship());

        this.callerAudioLoop = new CallerAudio(new SoundLoop(this.controlGUI.getCurrentSound()));

        this.controlGUI.initTimer();

        this.controlGUI.linksCallerAudioLoopWith(this.callerAudioLoop);
        //this.controlGUI.linksCallerAudioEffectWith(this.callerAudioEffects);

        this.panelGame.addKeyListenerSpaceship(controller);
        //this.panelGame.getPanelGame().addGameObject(this.gameState.getSpaceship(), this.gameState.getSpaceship().getTransform());

//        this.gameState.getWorld().getAllEnemies().forEach(enemy -> {
//        	System.out.println(enemy);
//        	this.panelGame.getPanelGame().addGameObject(enemy, enemy.getTransform());
//        });

        
        RectBoundingBox rbb = (RectBoundingBox) this.gameState.getSpaceship().getBoundingBox();
        System.out.println("INIT -> " + rbb);

       // rbb.getTransform().translate(rbb.getULCorner().getX(), rbb.getULCorner().getY());
        this.gameState.getSpaceship().getTransform().translate(Screen.POINT_CENTER_FULLSCREEN.getX(), Screen.POINT_CENTER_FULLSCREEN.getY());
        //System.out.println("INIT -> " + this.gameState.getWorld().getShip().getTransform().toString());
        
        this.panelGame.getPanelGame().addGameObject(this.gameState.getSpaceship(), this.gameState.getSpaceship().getTransform());  

        this.gameState.getWorld().setEventListener(this);

        this.callerAudioLoop.execute(CmdAudioType.AUDIO_ON);
        this.controlGUI.startGUI();
    }

    public void run() {
        long lastTime = System.currentTimeMillis();

        while (!gameState.isGameOver()) {
            long current = System.currentTimeMillis();
            int elapsed = (int)(current - lastTime);

            this.startTimer();
            this.controlGUI.renderTimer();
            this.updateSound();

            inputSkin();
            processInput();

            render();
            renderMovement();

            waitForNextFrame(current);
            lastTime = current;
            updateGame(elapsed);

            System.out.println("LoopMala -> "+ elapsed +" FPS");

        }
        renderGameOver();
    }
    
	protected void waitForNextFrame(long current){
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

    protected void updateGame(int elapsed){
        gameState.getWorld().updateState(elapsed);
        checkEvents();
    }

    protected void checkEvents() {
        World scene = gameState.getWorld();
        eventQueue.stream().forEach(ev -> {
        	if (ev instanceof HitAsteroidEvent){
            	HitAsteroidEvent asteroidEvent = (HitAsteroidEvent) ev;
            	final Asteroid asteroidCollided = (Asteroid) asteroidEvent.getCollisionObj();
                scene.removeAsteroid(asteroidCollided);
                gameState.decreaseLife(asteroidCollided.getImpactDamage());
            } else if (ev instanceof HitChaseEnemyEvent){
            	HitChaseEnemyEvent chaseEnemyEvent = (HitChaseEnemyEvent) ev;
            	final ChaseEnemy chaseEnemyCollided = (ChaseEnemy) chaseEnemyEvent.getCollisionObj();
            	scene.removeChaseEnemy(chaseEnemyEvent.getCollisionObj());
                gameState.decreaseLife(chaseEnemyCollided.getImpactDamage());
                // HitBorderEvent bEv = (HitBorderEvent) ev;
                //gameState.decreaseLives();
            } else if (ev instanceof HitPickableEvent){
                //HitPerkEvent pEv = (HitPerkEvent) ev;
                //stato = pEv.getCollisionObj().getType(???):
                //gameState.getSpaceship().setState(stato);
            } else if (ev instanceof HitBorderEvent){
            	System.out.println("TOCCATO MURO E MANDATO EVENTO AL MONDO");
            	
                // HitBorderEvent bEv = (HitBorderEvent) ev;
                //gameState.decreaseLife();
            }
        });
        eventQueue.clear();
    }


    protected void render(){
        panelGame.repaintGameObjects();
    }

    private void inputSkin(){
        int i = 0;
        if(this.controlGUI.getCurrentGUI() == IdGUI.ID_GAME && i == 0){
            this.gameState.setSkin(this.controlGUI.getCurrentSkin());
            i = 1;
        }
    }
    
    private void renderMovement() {
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

    public void startTimer(){
        if(!this.controlGUI.isStartTimer() && this.controlGUI.getCurrentGUI() == IdGUI.ID_GAME){
            this.controlGUI.startTimer();
        }
    }

    public void notifyEvent(WorldEvent ev) {
        eventQueue.add(ev);
    }

}
