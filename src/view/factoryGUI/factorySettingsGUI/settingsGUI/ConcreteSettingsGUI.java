package view.factoryGUI.factorySettingsGUI.settingsGUI;

import model.MyJImage.MyJImageEngine;
import utilities.IdGUI;
import model.factoryGUI.settingsGUI.NameSettigsGUI;
import view.factoryGUI.AbstractGUI;
import view.factoryGUI.factorySettingsGUI.intefaceSettings.SettingsGUI;
import view.factoryGUI.factorySettingsGUI.utilities.PanelDifficult;
import view.factoryGUI.factorySettingsGUI.utilities.PanelSkin;
import view.factoryGUI.factorySettingsGUI.utilities.PanelSound;
import view.utilities.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ConcreteSettingsGUI extends AbstractGUI implements SettingsGUI {
    private final JLabel lbTitle = new JLabel();
    private final PanelSkin panelSkin = new PanelSkin();
    private final PanelDifficult panelDifficult = new PanelDifficult();
    private final PanelSound panelSound = new PanelSound();
    private final ButtonID btnBack = new ButtonID();

    public ConcreteSettingsGUI() {
        super();
    }

    @Override
    public void setAllFontNotLbTitle(Font font) {
        this.panelSound.setFontSliderSound(font);
        this.panelDifficult.setFontGroupRadioButton(font);
        this.panelSkin.setFontButtons(font);
    }

    @Override
    public void setAllForeground(Color color) {
        this.lbTitle.setForeground(color);
        this.panelSkin.setAllForeground(color);
        this.panelDifficult.setAllForeground(color);
        this.panelSound.setAllForeground(color);
        this.btnBack.setForeground(color);
    }

    @Override
    public void setFontLbTitle(Font font) {
        this.lbTitle.setFont(font);
    }

    @Override
    public List<? extends JButton> getButtons() {
        return List.of(this.panelSkin.getBtSX(), this.panelSkin.getBtDX());
    }

    @Override
    public List<ButtonID> getLinksButtons() {
        return List.of(this.btnBack);
    }

    @Override
    public void setTitleGUI(String title) {
        this.lbTitle.setText(title);
    }

    @Override
    public void setFontTitlePanel(Font font) {
        this.panelSkin.setFontLbTitle(font);
        this.panelDifficult.setFontTitleDifficult(font);
        this.panelSound.setFontTitleSound(font);
        this.btnBack.setFont(font);
    }

    @Override
    public void setBtnBackID(IdGUI intoID) {
        this.btnBack.setCurrentGUIID(this.getId());
        this.btnBack.setCommandIdGUI(intoID);
    }

    @Override
    public void setNameButtons(List<NameSettigsGUI> listName) {
        int i = 0;
        this.panelSkin.setLbTitle(listName.get(i++).getTitle());
        this.panelDifficult.setTitle(listName.get(i++).getTitle());
        this.panelSound.setTitle(listName.get(i++).getTitle());
        this.btnBack.setText(listName.get(i).getTitle());
    }

    @Override
    public void setSkinSpaceShip(MyJImageEngine imageEngine) {
        this.panelSkin.setPnImage(imageEngine.getPath());
        this.panelSkin.setDimensionImg(imageEngine.getWidth(), imageEngine.getHeight());
    }

    public JLabel getLbTitle(){
        return this.lbTitle;
    }

    public JButton getBtnBack(){
        return this.btnBack;
    }

    public PanelSkin getPanelSkin() {
        return this.panelSkin;
    }

    public PanelDifficult getPanelDifficult(){
        return this.panelDifficult;
    }

    public PanelSound getPanelSound() {
        return this.panelSound;
    }
}
