package controller.GUI;

import model.GUI.settings.Difficult;
import model.GUI.settings.EngineSettings;
import view.GUI.settings.GUISettings;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlSettings {
    private GUISettings settingsGUI;
    private EngineSettings settingsEngine;

    public CtrlSettings(final GUISettings GUISettings, final EngineSettings settingsEngine){
        this.settingsGUI = GUISettings;
        this.settingsEngine = settingsEngine;
        this.initSettings();
    }

    private void initSettings() {
        this.settingsGUI.setId(this.settingsEngine.getId());
        this.settingsGUI.setTitleGUI(this.settingsEngine.getTitleGUI());
        this.settingsGUI.setNameComponent(this.settingsEngine.getListName());
        this.settingsGUI.setBtnBackID(this.settingsEngine.getLink());
        this.settingsGUI.setSkinSpaceShip(this.settingsEngine.getSkinSpaceShip());

        this.settingsGUI.getUnitSkin().forEach(btn -> btn.addActionListener(this.changeSkin(btn)));
        this.settingsGUI.getUnitDifficult().forEach(radio -> radio.addActionListener(this.changeDifficult(radio)));

        this.settingsGUI.setDifficult(this.settingsEngine.getDifficultActivate());
        this.settingsGUI.setVisible(this.settingsEngine.getState());
    }

    private ActionListener changeSkin(JButton btn){
        return e -> {
            if(btn.getText() == "<"){
                CtrlSettings.this.settingsEngine.changeSkinSx();
            } else {
                CtrlSettings.this.settingsEngine.changeSkinDx();
            }
            CtrlSettings.this.settingsGUI.setSkinSpaceShip(CtrlSettings.this.settingsEngine.getSkinSpaceShip());
        };
    }

    private ActionListener changeDifficult(JRadioButton rBtn){
        return e -> {
            if(rBtn.getText() == "Easy"){
                CtrlSettings.this.settingsEngine.setDifficult(Difficult.EASY);
            } else if(rBtn.getText() == "Medium") {
                CtrlSettings.this.settingsEngine.setDifficult(Difficult.MEDIUM);
            } else if(rBtn.getText() == "Hard") {
                CtrlSettings.this.settingsEngine.setDifficult(Difficult.HARD);
            }
        };
    }


}


