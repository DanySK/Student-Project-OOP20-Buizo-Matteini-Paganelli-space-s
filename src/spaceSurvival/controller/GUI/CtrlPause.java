package spaceSurvival.controller.GUI;

import spaceSurvival.controller.GUI.command.SwitchGUI;
import spaceSurvival.model.GUI.EngineGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.model.GUI.pause.EnginePause;
import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.view.GUI;
import spaceSurvival.view.pause.GUIPause;

public class CtrlPause implements ControllerGUI{
    private final EnginePause engine;
    private final GUIPause gui;

    private final SwitchGUI switchGUI;

    public CtrlPause(final EnginePause engine, final GUIPause gui){
        this.engine = engine;
        this.gui = gui;

        this.switchGUI = new SwitchGUI(this.engine, this.gui);

        this.assignId();
        this.assignStrings();

        this.switchGUI.turn(this.engine.getVisibility());
    }

    private void assignId(){
        this.gui.setMainAction(this.engine.getActionGUI());
        this.gui.setIdButtons(this.engine.getActionGUI(), this.engine.getLinks());
    }

    private void assignStrings(){
        this.gui.setTitleGUI(this.engine.getTitleGUI());
        this.gui.setNameButtons(this.engine.getListName());
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
    public void turn(Visibility visibility) {
        this.switchGUI.turn(visibility);
    }

    @Override
    public void changeVisibility() {
        this.switchGUI.changeVisibility();
    }
}
