package controller.GUI;

import controller.GUI.command.SwitchGUI;
import model.GUI.EngineGUI;
import model.GUI.Visibility;
import model.GUI.settings.Difficulty;
import model.GUI.settings.EngineSettings;
import utilities.IdGUI;
import view.GUI.GUI;
import view.GUI.settings.GUISettings;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CtrlSettings implements ControllerGUI {
    private final GUISettings gui;
    private final EngineSettings engine;

    private final SwitchGUI switchGUI;

    public CtrlSettings(final EngineSettings engine, final GUISettings gui){
        this.gui = gui;
        this.engine = engine;
        this.switchGUI = new SwitchGUI(this.engine, this.gui);

        this.assignId();
        this.assignStrings();
        this.assignSettings();

    }

    private void assignId() {
        this.gui.setId(this.engine.getId());
        this.gui.setBtnBackID(this.engine.getBackLink());
    }

    private void assignStrings() {
        this.gui.setTitleGUI(this.engine.getTitleGUI());
        this.gui.setNameUnits(this.engine.getListNameUnit());
        this.gui.setNameBtnBack(this.engine.getNameBtnBack());
    }

    private void assignSettings() {
        this.gui.setSkinSpaceShip(this.engine.getSkinSpaceShip());
        this.gui.getUnitSkin().forEach(btn -> btn.addActionListener(this.changeSkin(btn)));
        this.gui.getUnitDifficult().forEach(radio -> radio.addActionListener(this.changeDifficult(radio)));
        this.gui.setDifficult(this.engine.getDifficultActivate());
    }

    private ActionListener changeSkin(JButton btn){
        return e -> {
            if(btn.getText().equals("<")){
                CtrlSettings.this.engine.changeSkinSx();
            } else {
                CtrlSettings.this.engine.changeSkinDx();
            }
            CtrlSettings.this.gui.setSkinSpaceShip(CtrlSettings.this.engine.getSkinSpaceShip());
        };
    }

    private ActionListener changeDifficult(JRadioButton rBtn){
        return e -> {
            switch (rBtn.getText()) {
                case "Easy":
                    CtrlSettings.this.engine.setDifficult(Difficulty.EASY); break;
                case "Medium":
                    CtrlSettings.this.engine.setDifficult(Difficulty.MEDIUM); break;
                case "Hard":
                    CtrlSettings.this.engine.setDifficult(Difficulty.HARD); break;
            }
        };
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
    public void turn(final Visibility visibility) {
        this.switchGUI.turn(visibility);
    }
}


