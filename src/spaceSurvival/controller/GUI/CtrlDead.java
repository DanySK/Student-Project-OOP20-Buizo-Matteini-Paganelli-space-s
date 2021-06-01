package spaceSurvival.controller.GUI;

import spaceSurvival.controller.GUI.command.SwitchGUI;
import spaceSurvival.model.GUI.EngineGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.model.GUI.dead.EngineDead;
import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.view.GUI;
import spaceSurvival.view.dead.GUIDead;

public class CtrlDead implements ControllerGUI{
    private final EngineDead engine;
    private final GUIDead gui;

    private final SwitchGUI switchGUI;

    public CtrlDead(final EngineDead engine, final GUIDead gui){
        this.engine = engine;
        this.gui = gui;

        this.switchGUI = new SwitchGUI(engine, gui);

        this.assignAction();
        this.assignStrings();
        this.assignRectangle();
        this.switchGUI.turn(this.engine.getVisibility());
    }


    @Override
    public void assignAction() {
        this.gui.setMainAction(this.engine.getMainAction());
    }

    @Override
    public void assignStrings() {
        this.gui.setTitleGUI(this.engine.getTitleGUI());
    }

    @Override
    public void assignRectangle() {
        this.gui.setBounds(this.engine.getRectangle());
    }

    @Override
    public ActionGUI getMainAction() {
        return this.engine.getMainAction();
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

    @Override
    public void closeGUI() {
        this.gui.close();
    }
}
