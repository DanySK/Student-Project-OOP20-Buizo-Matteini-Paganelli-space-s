package spaceSurvival.view.GUI.settings.concrete;

import spaceSurvival.model.EngineImage;
import spaceSurvival.model.GUI.settings.Difficulty;
import spaceSurvival.utilities.IdGUI;
import spaceSurvival.view.GUI.AbstractGUI;
import spaceSurvival.view.GUI.settings.GUISettings;
import spaceSurvival.view.GUI.settings.utilities.PanelDifficult;
import spaceSurvival.view.GUI.settings.utilities.PanelSkin;
import spaceSurvival.view.utilities.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ConcreteGUISettings extends AbstractGUI implements GUISettings {
    private final JLabel lbTitle;
    private final PanelSkin panelSkin;
    private final PanelDifficult panelDifficult;
    private final ButtonID btnBack;

    public ConcreteGUISettings() {
        super();
        this.lbTitle = new JLabel();
        this.panelSkin = new PanelSkin();
        this.panelDifficult = new PanelDifficult();
        this.btnBack = new ButtonID();
    }

    @Override
    public List<ButtonID> getButtonLinks() {
        return List.of(this.btnBack);
    }


    @Override
    public void setNameUnits(final List<String> listName) {
        int i = 0;
        this.panelSkin.setLbTitle(listName.get(i++));
        this.panelDifficult.setTitle(listName.get(i));
    }

    @Override
    public void setNameBtnBack(final String nameBtnBack) {
        this.btnBack.setText(nameBtnBack);
    }

    @Override
    public void setSkinSpaceShip(final EngineImage imageEngine) {
        this.panelSkin.setPnImage(imageEngine.getPath());
        this.panelSkin.setRateImg(imageEngine.getScaleOf(), super.getWidth());
    }

    @Override
    public void setDifficult(final Difficulty difficulty) {
        this.panelDifficult.setDifficult(difficulty);
    }

    @Override
    public List<JButton> getUnitSkin() {
        return List.of(this.panelSkin.getBtSX(), this.panelSkin.getBtDX());
    }

    @Override
    public List<JRadioButton> getUnitDifficult() {
        return this.panelDifficult.getDifficult();
    }

    @Override
    public void setBtnBackID(final IdGUI intoID) {
        this.btnBack.setIdGUICurrent(this.getId());
        this.btnBack.setIdGUINext(intoID);
    }


    @Override
    public void setForegroundGUI(Color color) {
        this.lbTitle.setForeground(color);
        this.panelSkin.setAllForeground(color);
        this.panelDifficult.setAllForeground(color);
        this.btnBack.setForeground(color);
    }

    @Override
    public void setFontGUITitle(Font font) {
        this.lbTitle.setFont(font);
    }

    @Override
    public void setFontTitleUnit(Font font) {
        this.panelSkin.setFontLbTitle(font);
        this.panelDifficult.setFontTitleDifficult(font);
        this.btnBack.setFont(font);
    }

    @Override
    public void setFontUnit(Font font) {
        this.panelDifficult.setFontGroupRadioButton(font);
        this.panelSkin.setFontButtons(font);
    }

    @Override
    public void setTitleGUI(String title) {
        this.lbTitle.setText(title);
    }

    @Override
    public void setTransparentComponent() {
        this.panelSkin.setTransparentButton();
        FactoryGUIs.setTransparentDesignJButton(this.btnBack);
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



}
