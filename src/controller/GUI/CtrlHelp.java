package controller.GUI;

import model.GUI.help.EngineHelp;
import view.GUI.help.GUIHelp;

public class CtrlHelp {
    private GUIHelp GUIHelp;
    private EngineHelp engineHelp;

    public CtrlHelp(final GUIHelp GUIHelp, final EngineHelp engineHelp){
        this.engineHelp = engineHelp;
        this.GUIHelp = GUIHelp;
        this.initHelp();
    }

    private void initHelp() {
        this.GUIHelp.setId(this.engineHelp.getId());
        this.GUIHelp.setBtnBackID(this.engineHelp.getLink());
        this.GUIHelp.setTitleGUI(this.engineHelp.getTitleGUI());
        this.GUIHelp.setHelpPanelsName(this.engineHelp.getListHelpPanelsName());
        this.GUIHelp.setButtonsName(this.engineHelp.getListButtonsName());
        this.engineHelp.getListHelpPanelsName().forEach(panel ->
                this.GUIHelp.setImageInPanelHelp(panel, this.engineHelp.getPathImagePanel(panel)));

        this.GUIHelp.setVisible(this.engineHelp.getState());
    }
}
