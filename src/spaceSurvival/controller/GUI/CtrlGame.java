package spaceSurvival.controller.GUI;

import spaceSurvival.controller.GUI.command.SwitchGUI;
import spaceSurvival.model.GUI.EngineGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.model.GUI.game.EngineGame;
import spaceSurvival.utilities.IdGUI;
import spaceSurvival.view.GUI.GUI;
import spaceSurvival.view.GUI.game.GUIGame;

public class CtrlGame implements ControllerGUI{
    private final EngineGame engine;
    private final GUIGame gui;

    private final SwitchGUI switchGUI;

    public CtrlGame(final EngineGame engine, final GUIGame gui){
        this.engine = engine;
        this.gui = gui;
        this.switchGUI = new SwitchGUI(this.engine, this.gui);

        this.init();
        this.switchGUI.turn(this.engine.getVisibility());
    }

    private void init(){
        this.gui.setId(this.engine.getId());
        this.gui.setIdButtons(this.engine.getLinks());
    }

    public boolean isStartTimer(){
        return this.engine.isStartTimer();
    }

    public void initTimer(){
        this.engine.initTimer();
    }

    public void startTimer(){
        this.engine.startTimer();
    }

    public void assignTimer(){
        this.gui.setTimer(this.engine.getTimer());
    }

    @Override
    public IdGUI getId() {
        return this.engine.getId();
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
