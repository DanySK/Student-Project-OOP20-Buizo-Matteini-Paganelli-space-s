package controller;

import model.factoryGUI.settingsGUI.SettingsEngine;
import view.factoryGUI.factorySettingsGUI.intefaceSettings.SettingsGUI;

public class ControllerSettings {
    private SettingsGUI settingsGUI;
    private SettingsEngine settingsEngine;

    public ControllerSettings(final SettingsGUI settingsGUI, final SettingsEngine settingsEngine){
        this.settingsGUI = settingsGUI;
        this.settingsEngine = settingsEngine;
        this.initSettings();
    }

    private void initSettings() {
        this.settingsGUI.setId(this.settingsEngine.getId());
        this.settingsGUI.setTitleGUI(this.settingsEngine.getTitleGUI());
        this.settingsGUI.setNameButtons(this.settingsEngine.getListName());
        this.settingsGUI.setBtnBackID(this.settingsEngine.getLink());
        this.settingsGUI.setVisible(this.settingsEngine.getState());
    }
}
