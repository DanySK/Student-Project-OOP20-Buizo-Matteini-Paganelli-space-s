package view.factoryGUI.factorySettingsGUI.settingsGUI;

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
import java.io.IOException;
import java.util.List;

public class ConcreteSettingsGUI extends AbstractGUI implements SettingsGUI {
    private JLabel lbTitle;
    private PanelSkin panelSkin;
    private PanelDifficult panelDifficult;
    private PanelSound panelSound;
    private ButtonID btnBack;

    public ConcreteSettingsGUI() {
        super();
        this.lbTitle = new JLabel();
        try {
            // manca la gestione dell'Exception
            this.panelSkin = new PanelSkin(150, 160);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.panelDifficult = new PanelDifficult();
        this.panelSound = new PanelSound();
        this.btnBack = new ButtonID();
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
        return null;
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
        this.panelDifficult.setTitle(listName.get(i++).getTitle());
        this.panelSound.setTitle(listName.get(i++).getTitle());
        this.btnBack.setText(listName.get(i++).getTitle());
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
