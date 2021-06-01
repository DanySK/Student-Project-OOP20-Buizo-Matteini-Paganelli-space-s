package spaceSurvival.controller.GUI;

import spaceSurvival.controller.GUI.command.SwitchGUI;
import spaceSurvival.model.GUI.EngineGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.model.GUI.settings.EngineSettings;
import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.view.GUI;
import spaceSurvival.view.settings.GUISettings;
import spaceSurvival.view.settings.utilities.JRadioDifficult;

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

        this.assignAction();
        this.assignStrings();
        this.assignRectangle();
        this.assignSettings();
    }

    @Override
    public void assignAction() {
        this.gui.setMainAction(this.engine.getMainAction());
        this.gui.setBtnBackID(this.engine.getMainAction(), this.engine.getBackLink());
    }

    @Override
    public void assignStrings() {
        this.gui.setTitleGUI(this.engine.getTitleGUI());
        this.gui.setUnitNames(this.engine.getListNameUnit());
        this.gui.setNameBtnBack(this.engine.getNameBtnBack());
        this.gui.setDifficultNames(this.engine.getListDifficult());
    }

    @Override
    public void assignRectangle() {
        this.gui.setBounds(this.engine.getRectangle());
    }

    private void assignSettings() {
        this.gui.setSkinSpaceShip(this.engine.getSkinSpaceShip());
        this.gui.getBtnUnitSkin().forEach(btn -> btn.addActionListener(this.changeSkin()));
        this.gui.getRadioBtnUnitDifficult().forEach(radio -> radio.addActionListener(this.changeDifficult()));
        this.gui.setDifficult(this.engine.getDifficultActivate());
    }

    private ActionListener changeSkin(){
        return e -> {
            final JButton btn = (JButton)e.getSource();
            CtrlSettings.this.changeSkinWithDir(btn.getText());
            CtrlSettings.this.gui.setSkinSpaceShip(CtrlSettings.this.engine.getSkinSpaceShip());
        };
    }

    private ActionListener changeDifficult(){
        return e -> {
            JRadioDifficult radio = (JRadioDifficult)e.getSource();
            CtrlSettings.this.engine.setDifficult(radio.getDifficulty());
        };
    }

    public void changeSkinWithDir(final String dir){
        if(dir.contentEquals(EngineSettings.DIR_SX)){
            this.engine.changeSkinSx();
        } else {
            this.engine.changeSkinDx();
        }
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

    @Override
    public void closeGUI() {
        this.gui.close();
    }
}


