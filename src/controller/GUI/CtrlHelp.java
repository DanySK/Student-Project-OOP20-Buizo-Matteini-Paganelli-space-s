package controller.GUI;

import model.GUI.EngineGUI;
import model.GUI.help.EngineHelp;
import view.GUI.GUI;
import view.GUI.help.GUIHelp;

public class CtrlHelp implements ControlGUI{
    private final GUIHelp GUIHelp;
    private final EngineHelp engineHelp;

    public CtrlHelp(final GUIHelp GUIHelp, final EngineHelp engineHelp){
        this.engineHelp = engineHelp;
        this.GUIHelp = GUIHelp;
        this.assignmentsId();
        this.assignmentTitle();
        this.assignmentsName();
        this.assignmentVisibility();
    }

    private void assignmentTitle(){
        this.GUIHelp.setTitleGUI(this.engineHelp.getTitleGUI());
    }

    private void assignmentsName() {
        this.GUIHelp.setNameUnitHelps(this.engineHelp.getListNameHelpUnits());
        this.GUIHelp.setNameButtons(this.engineHelp.getListNameButtons());
        this.engineHelp.getListNameHelpUnits().forEach(nameUnit ->
                this.GUIHelp.addIconInUnitHelp(nameUnit, this.engineHelp.getPathIconUnit(nameUnit)));
    }

    private void assignmentsId(){
        this.GUIHelp.setId(this.engineHelp.getId());
        this.GUIHelp.setIdBtnBack(this.engineHelp.getBackLink());
    }

    private void assignmentVisibility(){
        this.GUIHelp.setVisible(this.engineHelp.getState());
    }

    public GUI getGUI() {
        return this.GUIHelp;
    }

    public EngineGUI getEngine() {
        return this.engineHelp;
    }
}
