package model.game;

import controller.GUI.CtrlGUI;
import controller.sound.CallerAudio;
import model.input.MovementKeyListener;
import model.sound.CmdAudioType;
import model.sound.category.SoundLoop;
import model.world.World;
import model.worldEcollisioni.WorldEvent;
import model.worldEcollisioni.hitEvents.HitAsteroidEvent;
import model.worldEcollisioni.hitEvents.HitBorderEvent;
import model.worldEcollisioni.hitEvents.HitPerkEvent;
import utilities.DesignSound;
import view.GUI.game.GUIGame;

import java.util.ArrayList;
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

    public GameMalaLoop(){
        this.eventQueue = new LinkedList<>();
        this.gameState = new GameState();
        this.controlGUI = new CtrlGUI();
    }

    public void initGame(){
        this.panelGame = this.controlGUI.getPanelGame();
        this.controller = new MovementKeyListener(this.gameState.getSpaceship());

        this.callerAudioLoop = new CallerAudio(new SoundLoop(this.controlGUI.getCurrentSound()));

        this.controlGUI.linksCallerAudioLoopWith(this.callerAudioLoop);
        //this.controlGUI.linksCallerAudioEffectWith(this.callerAudioEffects);

        this.panelGame.addKeyListenerSpaceship(controller);
    }

    public void mainLoop(){
        long lastTime = System.currentTimeMillis();

        this.callerAudioLoop.execute(CmdAudioType.AUDIO_ON);

        while (!gameState.isGameOver()) {
            long current = System.currentTimeMillis();
            int elapsed = (int)(current - lastTime);

            this.updateSound();

            processInput();
            //updateGame(elapsed);
            render();

            waitForNextFrame(current);
            lastTime = current;
//            System.out.println("LoopMala -> "+ elapsed +" FPS");
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

    protected void processInput(){
//        gameState.getWorld().getShip().updateInput(controller);

    }

    protected void updateGame(int elapsed){
        //gameState.getWorld().updateState(elapsed);
        checkEvents();
    }

    protected void checkEvents(){
        World scene = gameState.getWorld();
        eventQueue.stream().forEach(ev -> {
            if (ev instanceof HitAsteroidEvent){
            	HitAsteroidEvent aEv = (HitAsteroidEvent) ev;
                scene.removeAsteroid(aEv.getCollisionObj());
                gameState.decreaseLife();
            } else if (ev instanceof HitPerkEvent){
                HitPerkEvent pEv = (HitPerkEvent) ev;
                //stato = pEv.getCollisionObj().getType(???):
                //gameState.getSpaceship().setState(stato);
            } else if (ev instanceof HitBorderEvent){
                // HitBorderEvent bEv = (HitBorderEvent) ev;
                gameState.decreaseLife();
            }
        });
        eventQueue.clear();
    }

    protected void render(){
        panelGame.repaintGameObjects();

    }

    protected void renderGameOver(){
//        view.renderGameOver();
    }

    protected void updateSound(){
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
