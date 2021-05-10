package controller.GUI;

import controller.GUI.command.SwitchGUI;
import model.GUI.EngineGUI;
import model.GUI.Visibility;
import model.GUI.help.EngineHelp;
import utilities.IdGUI;
import view.GUI.GUI;
import view.GUI.help.GUIHelp;

public class CtrlHelp implements ControllerGUI {
    private final GUIHelp gui;
    private final EngineHelp engine;

    private final SwitchGUI switchGUI;

    public CtrlHelp(final EngineHelp engine, final GUIHelp gui){
        this.engine = engine;
        this.gui = gui;
        this.switchGUI = new SwitchGUI(this.engine, this.gui);

        this.assignId();
        this.assignStrings();
        this.switchGUI.turn(this.engine.getVisibility());
    }

    private void assignId() {
        this.gui.setId(this.engine.getId());
        this.gui.setIdBtnBack(this.engine.getBackLink());
    }

    private void assignStrings() {
        this.gui.setTitleGUI(this.engine.getTitle());
        this.gui.setNameUnitHelps(this.engine.getListNameHelpUnits());
        this.gui.setNameButtons(this.engine.getListNameButtons());
        this.engine.getListNameHelpUnits().forEach(nameUnit ->
                this.gui.addIconInUnitHelp(nameUnit, this.engine.getPathIconUnit(nameUnit)));
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

    @Override
    public String toString() {
        return "CtrlHelp{" +
                "gui=" + gui +
                ", engine=" + engine +
                ", switchGUI=" + switchGUI +
                '}';
    }
}
