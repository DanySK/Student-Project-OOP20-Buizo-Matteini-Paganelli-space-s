package controller.GUI;

import model.GUI.EngineGUI;
import model.GUI.help.EngineHelp;
import view.GUI.GUI;
import view.GUI.help.GUIHelp;

public class CtrlHelp implements ControllerGUI {
    private final GUIHelp gui;
    private final EngineHelp engine;

    public CtrlHelp(final GUIHelp GUIHelp, final EngineHelp engineHelp){
        this.engine = engineHelp;
        this.gui = GUIHelp;
        this.assignmentsId();
        this.assignmentTitle();
        this.assignmentsName();
        this.assignmentVisibility();
    }

    private void assignmentTitle(){
        this.gui.setTitleGUI(this.engine.getTitle());
    }

    private void assignmentsName() {
        this.gui.setNameUnitHelps(this.engine.getListNameHelpUnits());
        this.gui.setNameButtons(this.engine.getListNameButtons());
        this.engine.getListNameHelpUnits().forEach(nameUnit ->
                this.gui.addIconInUnitHelp(nameUnit, this.engine.getPathIconUnit(nameUnit)));
    }

    private void assignmentsId(){
        this.gui.setId(this.engine.getId());
        this.gui.setIdBtnBack(this.engine.getBackLink());
    }

    private void assignmentVisibility(){
        this.gui.setVisible(this.engine.isVisible());
    }

    public GUI getGUI() {
        return this.gui;
    }

    public EngineGUI getEngine() {
        return this.engine;
    }
}
