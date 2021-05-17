package model.game;

import controller.GUI.CtrlGUI;
import controller.sound.CallerAudio;
import model.gameObject.mainGameObject.Asteroid;
import model.gameObject.mainGameObject.ChaseEnemy;
import model.input.MovementKeyListener;
import model.sound.CmdAudioType;
import model.sound.category.SoundLoop;
import model.world.World;
import model.worldEcollisioni.WorldEvent;
import model.worldEcollisioni.hitEvents.HitAsteroidEvent;
import model.worldEcollisioni.hitEvents.HitBorderEvent;
import model.worldEcollisioni.hitEvents.HitChaseEnemyEvent;
import model.worldEcollisioni.hitEvents.HitPickableEvent;
import utilities.DesignSound;
import utilities.IdGUI;
import view.GUI.game.GUIGame;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GameMalaLoop {
    private long period = 20L;
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

        this.controlGUI.linksCallerAudioLoopWith(this.callerAudioLoop);
        //this.controlGUI.linksCallerAudioEffectWith(this.callerAudioEffects);

        this.panelGame.addKeyListenerSpaceship(controller);
        this.panelGame.getPanelGame().addGameObject(this.gameState.getSpaceship(), this.gameState.getSpaceship().getTransform());
        
        this.gameState.getWorld().getAllEnemies().forEach(enemy -> {
        	System.out.println(enemy);
        	this.panelGame.getPanelGame().addGameObject(enemy, enemy.getTransform());
        });
        
        System.out.println(this.panelGame.getPanelGame());
    }

    public void mainLoop() {
        long lastTime = System.currentTimeMillis();

        this.callerAudioLoop.execute(CmdAudioType.AUDIO_ON);

        while (!gameState.isGameOver()) {
            long current = System.currentTimeMillis();
            int elapsed = (int)(current - lastTime);

            this.updateSound();

            inputSkin();

            processInput();
            //updateGame(elapsed);
            render();
            renderMovement();

            waitForNextFrame(current);
            lastTime = current;
            System.out.println("LoopMala -> "+ elapsed +" FPS");

        }
        renderGameOver();
    }

    
	protected void waitForNextFrame(long current){

        long dt = System.currentTimeMillis() - current;
        if (dt < period){
            try {
                Thread.sleep(period-dt);
            } catch (Exception ex){}
        }
    }

    protected void processInput() {
//        gameState.getWorld().getShip().updateInput(controller);

    }

    protected void updateGame(int elapsed){
        //gameState.getWorld().updateState(elapsed);
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
		System.out.println("render movimento");
		
		//this.ship.setPosition(ship.getPosition().sum(new V2d(0,3)));
		System.out.println(this.gameState.getWorld().getShip().getVelocity().getX() + "Y: " +  this.gameState.getWorld().getShip().getVelocity().getY());
		
		this.gameState.getSpaceship().move();
//		this.gameState.getWorld().getShip().getTransform().translate(this.gameState.getWorld().getShip().getVelocity().getX(), this.gameState.getWorld().getShip().getVelocity().getY());
//		this.gameState.getWorld().getShip().setPosition(this.gameState.getWorld().getShip().getPosition().sum(this.gameState.getWorld().getShip().getVelocity()));
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

    public void notifyEvent(WorldEvent ev) {
        eventQueue.add(ev);
    }

}
