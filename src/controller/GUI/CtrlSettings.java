package controller.GUI;

import model.GUI.settings.EngineSettings;
import view.GUI.settings.GUISettings;

import javax.swing.*;

public class CtrlSettings {
    private GUISettings GUISettings;
    private EngineSettings settingsEngine;

    public CtrlSettings(final GUISettings GUISettings, final EngineSettings settingsEngine){
        this.GUISettings = GUISettings;
        this.settingsEngine = settingsEngine;
        this.initSettings();
    }

    private void initSettings() {
        this.GUISettings.setId(this.settingsEngine.getId());
        this.GUISettings.setTitleGUI(this.settingsEngine.getTitleGUI());
        this.GUISettings.setNameButtons(this.settingsEngine.getListName());
        this.GUISettings.setBtnBackID(this.settingsEngine.getLink());
        this.GUISettings.setSkinSpaceShip(this.settingsEngine.getSkinSpaceShip());
        for (JButton button : this.GUISettings.getLinks()) {
            button.addActionListener(e -> {
                if(button.getText() == "<"){
                    this.settingsEngine.changeSkinSx();
                    this.GUISettings.setSkinSpaceShip(this.settingsEngine.getSkinSpaceShip());
                } else {
                    this.settingsEngine.changeSkinDx();
                    this.GUISettings.setSkinSpaceShip(this.settingsEngine.getSkinSpaceShip());
                }
            });
        }
        this.GUISettings.setDifficult(this.settingsEngine.getDifficult());
        this.GUISettings.setVisible(this.settingsEngine.getState());
    }
}
