package spaceSurvival.controller.GUI;

import spaceSurvival.controller.GUI.command.SwitchGUI;
import spaceSurvival.model.GUI.EngineGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.model.GUI.settings.Difficulty;
import spaceSurvival.model.GUI.settings.EngineSettings;
import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.view.GUI;
import spaceSurvival.view.settings.GUISettings;

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
        this.gui.setMainAction(this.engine.getMainAction());
        this.gui.setBtnBackID(this.engine.getMainAction(), this.engine.getBackLink());
    }

    private void assignStrings() {
        this.gui.setTitleGUI(this.engine.getTitleGUI());
        this.gui.setUnitNames(this.engine.getListNameUnit());
        this.gui.setNameBtnBack(this.engine.getNameBtnBack());
    }

    private void assignSettings() {
        this.gui.setSkinSpaceShip(this.engine.getSkinSpaceShip());
        this.gui.getBtnUnitSkin().forEach(btn -> btn.addActionListener(this.changeSkin(btn)));
        this.gui.getRadioBtnUnitDifficult().forEach(radio -> radio.addActionListener(this.changeDifficult(radio)));
        this.gui.setDifficult(this.engine.getDifficultActivate());
    }

    private ActionListener changeSkin(JButton btn){
        return e -> {
            if(btn.getText().equals("<")){
                CtrlSettings.this.engine.changeSkinSx();
                System.out.println("vado a sinitraaaaaaa");
            } else {
                CtrlSettings.this.engine.changeSkinDx();
                System.out.println("vado a destraaaaa");
            }
            System.out.println(this.engine.getChooseSkin());
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

    public String getCurrentSkin(){
        return this.engine.getSkinSpaceShip().getPath();
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
}


