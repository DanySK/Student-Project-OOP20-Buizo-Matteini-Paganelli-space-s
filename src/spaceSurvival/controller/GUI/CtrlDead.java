package spacesurvival.controller.gui;

import spacesurvival.controller.gui.command.SwitchGUI;
import spacesurvival.model.GUI.EngineGUI;
import spacesurvival.model.GUI.Visibility;
import spacesurvival.model.GUI.dead.EngineDead;
import spacesurvival.utilities.ActionGUI;
import spacesurvival.view.GUI;
import spacesurvival.view.dead.GUIDead;

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
        this.gui.setBtnActions(this.engine.getMainAction(), this.engine.getLinks());
    }

    @Override
    public void assignStrings() {
        this.gui.setTitleGUI(this.engine.getTitleGUI());
        this.gui.setNameButtons(this.engine.getListNameLinks());
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
