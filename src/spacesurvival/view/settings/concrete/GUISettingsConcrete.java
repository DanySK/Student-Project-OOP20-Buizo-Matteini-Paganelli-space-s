package spacesurvival.view.settings.concrete;

import spacesurvival.model.EngineImage;
import spacesurvival.model.gui.settings.Difficulty;
import spacesurvival.utilities.ActionGUI;
import spacesurvival.view.AbstractGUI;
import spacesurvival.view.settings.GUISettings;
import spacesurvival.view.settings.utilities.JRadioDifficult;
import spacesurvival.view.settings.utilities.PanelDifficult;
import spacesurvival.view.settings.utilities.PanelSkin;
import spacesurvival.view.utilities.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GUISettingsConcrete extends AbstractGUI implements GUISettings {
    private final JLabel lbTitle;
    private final PanelSkin panelSkin;
    private final PanelDifficult panelDifficult;
    private final BtnAction btnBack;

    public GUISettingsConcrete() {
        super();
        this.lbTitle = new JLabel();
        this.panelSkin = new PanelSkin();
        this.panelDifficult = new PanelDifficult();
        this.btnBack = new BtnAction();
    }

    @Override
    public List<BtnAction> getBtnActionLinks() {
        return List.of(this.btnBack);
    }


    @Override
    public List<JButton> getBtnUnitSkin() {
        return List.of(this.panelSkin.getBtSX(), this.panelSkin.getBtDX());
    }

    @Override
    public List<JRadioDifficult> getRadioBtnUnitDifficult() {
        return this.panelDifficult.getDifficult();
    }

    @Override
    public void setUnitNames(final List<String> listName) {
        int i = 0;
        this.panelSkin.setLbTitle(listName.get(i++));
        this.panelDifficult.setTitle(listName.get(i));
    }

    @Override
    public void setDifficultNames(List<Difficulty> listDifficult) {
        this.panelDifficult.setDifficultNames(listDifficult);
    }

    @Override
    public void setNameBtnBack(final String nameBtnBack) {
        this.btnBack.setText(nameBtnBack);
    }

    @Override
    public void setSkinSpaceShip(final EngineImage imageEngine) {
        this.panelSkin.setPnImage(imageEngine.getPath());
        this.panelSkin.setRateImg(imageEngine.getScaleOf(), imageEngine.getRespectTo());
    }

    @Override
    public void setDifficult(final Difficulty difficulty) {
        this.panelDifficult.setDifficult(difficulty);
    }

    @Override
    public void setBtnBackID(final ActionGUI mainAction, final ActionGUI action) {
        this.btnBack.setActionCurrent(mainAction);
        this.btnBack.setActionNext(action);
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
