package spaceSurvival.controller.GUI;

import spaceSurvival.controller.GUI.command.SwitchGUI;
import spaceSurvival.model.GUI.EngineGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.model.GUI.game.EngineGame;
import spaceSurvival.model.World;
import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spaceSurvival.model.MovementKeyListener;
import spaceSurvival.model.worldEcollisioni.WorldEventListener;
import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.view.GUI;
import spaceSurvival.view.game.GUIGame;

import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;

public class CtrlGame implements ControllerGUI{
    private final EngineGame engine;
    private final GUIGame gui;

    private final SwitchGUI switchGUI;

    public CtrlGame(final EngineGame engine, final GUIGame gui){
        this.engine = engine;
        this.gui = gui;
        this.switchGUI = new SwitchGUI(this.engine, this.gui);

        this.init();
        this.updateHUD();
        this.switchGUI.turn(this.engine.getVisibility());
    }

    private void init(){
        this.gui.setMainAction(this.engine.getActionGUI());
        this.gui.setIdButtons(this.engine.getLinks());
    }

    public void updateHUD(){
        this.gui.setTimer(this.engine.getTimer());
        this.gui.setScore(this.engine.getScore());
        this.gui.setRound(this.engine.getRound());
        this.gui.setNEnemies(this.engine.getCountEnemies());
        this.gui.setNHeart(this.engine.getHeartShip());
        this.gui.setLifeShip(this.engine.getLifeShip());
        this.gui.setLifeBoss(this.engine.getLifeBoss());
    }

    public void initTimer(){
        this.engine.initTimer();
    }

    public void startTimer(){
        this.engine.startTimer();
    }

    public World getWord(){
        return this.engine.getWorld();
    }

    public SpaceShipSingleton getShip(){
        return this.engine.getShip();
    }

    public void setEventListenerInWorld(final WorldEventListener worldEventListener){
        this.engine.setEventListenerInWorld(worldEventListener);
    }

    private MovementKeyListener getMovementKeyListener(){
        return new MovementKeyListener(this.engine.getShip());
    }

    public void assignMovementListenerInShip(){
        this.addKeyListenerShip(this.getMovementKeyListener());
    }

    public boolean isGameOver(){
        return this.engine.isGameOver();
    }

    public void decrLifeShip(final int damage){
        this.engine.decrLifeShip(damage);
    }

    public void incrScore(final long score){
        this.engine.incrScore(score);
    }

    public void repaintWorld(){
        this.gui.repaintGameObjects();
    }

    public void updateStateWorld(final int elapsed){
        this.engine.updateStateWorld(elapsed);
    }

    private void addKeyListenerShip(final KeyListener keyListener){
        this.gui.addKeyListenerSpaceShip(keyListener);
    }

    public void addAllGameObjectsFromWorld(){
        this.engine.getAllGameObject().forEach(objGame -> CtrlGame.this.gui.addGameObject(objGame, objGame.getTransform()));
    }

    public void addGameObject(final GameObject gameObject, final AffineTransform transform){
        this.gui.addGameObject(gameObject, transform);
    }

    public void moveShip(){
        this.engine.moveShip();
    }

    @Override
    public ActionGUI getIdGUI() {
        return this.engine.getActionGUI();
    }

    @Override
    public GUI getGUI() {
        return this.gui;
    }

    @Override
    public EngineGUI getEngine() {
        return this.engine;
    }

    @Override
    public boolean isVisibility() {
        return this.engine.isVisible();
    }

    @Override
    public void turn(final Visibility visibility) {
        this.switchGUI.turn(visibility);
    }

    @Override
    public void changeVisibility() {
        this.switchGUI.changeVisibility();
    }
}
