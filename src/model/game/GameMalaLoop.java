package model.game;

import controller.GUI.CtrlGUI;
import controller.sound.CallerAudio;
import model.input.MovementKeyListener;
import model.worldEcollisioni.WorldEvent;
import view.GUI.game.GUIGame;

import java.util.LinkedList;

public class GameMalaLoop {
    private long period = 20L;
    private CtrlGUI controlGUI;
    private GameState gameState;
    private CallerAudio callerAudio;
    private GUIGame panelGame;
    private LinkedList<WorldEvent> eventQueue;
    private MovementKeyListener controller;

    public GameMalaLoop(){
        this.eventQueue = new LinkedList<>();
        this.initGame();
    }

    public void initGame(){
        this.gameState = new GameState();
        this.controlGUI = new CtrlGUI();
        this.panelGame = this.controlGUI.getPanelGame();
        this.controller = new MovementKeyListener(this.gameState.getSpaceship());
        this.panelGame.addKeyListenerSpaceship(controller);
    }

    public void mainLoop(){
        long lastTime = System.currentTimeMillis();
        while (!gameState.isGameOver()) {
            long current = System.currentTimeMillis();
            int elapsed = (int)(current - lastTime);
            processInput();
            updateGame(elapsed);
            render();
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

    protected void processInput(){
//        gameState.getWorld().getShip().updateInput(controller);
    }

    protected void updateGame(int elapsed){
        gameState.getWorld().updateState(elapsed);
        checkEvents();
    }

    protected void checkEvents(){
//        World scene = gameState.getWorld();
//        eventQueue.stream().forEach(ev -> {
//            if (ev instanceof HitPickUpEvent){
//                HitPickUpEvent cev = (HitPickUpEvent) ev;
//                scene.removePickUp(cev.getCollisionObj());
//                gameState.incScore();
//            } else if (ev instanceof HitBorderEvent){
//                // HitBorderEvent bev = (HitBorderEvent) ev;
//                gameState.decScore();
//            }
//        });
//        eventQueue.clear();
    }

    protected void render(){
        panelGame.repaintGameObjects();

    }

    protected void renderGameOver(){
//        view.renderGameOver();
    }

    public void notifyEvent(WorldEvent ev) {
        eventQueue.add(ev);
    }

}
