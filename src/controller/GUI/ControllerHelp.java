package controller.GUI;

import model.factoryGUI.helpGUI.HelpEngine;
import view.factoryGUI.factoryHelpGUI.interfaceHelp.HelpGUI;

public class ControllerHelp {
    private HelpGUI helpGUI;
    private HelpEngine helpEngine;

    public ControllerHelp(final HelpGUI helpGUI, final HelpEngine helpEngine){
        this.helpEngine = helpEngine;
        this.helpGUI = helpGUI;
        this.initHelp();
    }

    private void initHelp() {
        this.helpGUI.setId(this.helpEngine.getId());
        this.helpGUI.setBtnBackID(this.helpEngine.getLink());
        this.helpGUI.setTitleGUI(this.helpEngine.getTitleGUI());
        this.helpGUI.setHelpPanelsName(this.helpEngine.getListHelpPanelsName());
        this.helpGUI.setButtonsName(this.helpEngine.getListButtonsName());
        this.helpEngine.getListHelpPanelsName().forEach(panel ->
                this.helpGUI.setImageInPanelHelp(panel, this.helpEngine.getPathImagePanel(panel)));

        this.helpGUI.setVisible(this.helpEngine.getState());
    }
}
