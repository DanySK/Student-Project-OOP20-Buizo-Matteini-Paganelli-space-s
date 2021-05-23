package spaceSurvival.controller.GUI;

import spaceSurvival.controller.GUI.command.SwitchGUI;
import spaceSurvival.model.GUI.EngineGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.model.GUI.help.EngineHelp;
import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.view.GUI;
import spaceSurvival.view.help.GUIHelp;

public class CtrlHelp implements ControllerGUI {
    private final GUIHelp gui;
    private final EngineHelp engine;

    private final SwitchGUI switchGUI;

    public CtrlHelp(final EngineHelp engine, final GUIHelp gui){
        this.engine = engine;
        this.gui = gui;
        this.switchGUI = new SwitchGUI(this.engine, this.gui);

        this.assignAction();
        this.assignStrings();
        this.assignRectangle();

        this.switchGUI.turn(this.engine.getVisibility());
    }

    @Override
    public void assignAction() {
        this.gui.setMainAction(this.engine.getMainAction());
        this.gui.setActionBtnBack(this.engine.getMainAction(), this.engine.getBackLink());
    }

    @Override
    public void assignStrings() {
        this.gui.setTitleGUI(this.engine.getTitle());
        this.gui.setNameUnit(this.engine.getListNameUnits());
        this.gui.setBtnNames(this.engine.getListNameButtons());
        this.engine.getListNameUnits().forEach(nameUnit ->
                this.gui.addNameAndIconInUnit(nameUnit, this.engine.getPathIconUnit(nameUnit)));
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
    public String toString() {
        return "CtrlHelp{" +
                "gui=" + gui +
                ", engine=" + engine +
                ", switchGUI=" + switchGUI +
                '}';
    }
}
