package controller.GUI;

import model.GUI.help.EngineHelp;
import view.GUI.help.GUIHelp;

public class CtrlHelp {
    private final GUIHelp GUIHelp;
    private final EngineHelp engineHelp;

    public CtrlHelp(final GUIHelp GUIHelp, final EngineHelp engineHelp){
        this.engineHelp = engineHelp;
        this.GUIHelp = GUIHelp;
        this.initHelp();
    }

    private void initHelp() {
        this.GUIHelp.setId(this.engineHelp.getId());
        this.GUIHelp.setIdBtnBack(this.engineHelp.getBackLink());
        this.GUIHelp.setTitleGUI(this.engineHelp.getTitleGUI());
        this.GUIHelp.setNameUnitHelps(this.engineHelp.getListNameHelpUnits());
        this.GUIHelp.setNameButtons(this.engineHelp.getListNameButtons());
        this.engineHelp.getListNameHelpUnits().forEach(nameUnit ->
                this.GUIHelp.addIconInUnitHelp(nameUnit, this.engineHelp.getPathIconUnit(nameUnit)));

        this.GUIHelp.setVisible(this.engineHelp.getState());
    }
}
