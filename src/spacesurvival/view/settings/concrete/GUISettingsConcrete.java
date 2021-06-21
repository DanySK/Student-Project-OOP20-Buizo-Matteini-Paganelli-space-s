package spacesurvival.view.settings.concrete;

import spacesurvival.model.EngineImage;
import spacesurvival.model.gui.settings.Difficulty;
import spacesurvival.utilities.LinkActionGUI;
import spacesurvival.view.AbstractGUI;
import spacesurvival.view.settings.GUISettings;
import spacesurvival.view.settings.utilities.JRadioDifficult;
import spacesurvival.view.settings.utilities.PanelDifficult;
import spacesurvival.view.settings.utilities.PanelSkin;
import spacesurvival.view.utilities.BtnAction;
import spacesurvival.view.utilities.FactoryGUIs;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

public class GUISettingsConcrete extends AbstractGUI implements GUISettings {
    private static final long serialVersionUID = 1L;

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
    public final List<BtnAction> getBtnActionLinks() {
        return List.of(this.btnBack);
    }


    @Override
    public final List<JButton> getBtnUnitSkin() {
        return List.of(this.panelSkin.getBtSX(), this.panelSkin.getBtDX());
    }

    @Override
    public final List<JRadioDifficult> getRadioBtnUnitDifficult() {
        return this.panelDifficult.getDifficult();
    }

    @Override
    public final void setUnitNames(final List<String> listName) {
        int i = 0;
        this.panelSkin.setLbTitle(listName.get(i++));
        this.panelDifficult.setTitle(listName.get(i));
    }

    @Override
    public final void setDifficultNames(final List<Difficulty> listDifficult) {
        this.panelDifficult.setDifficultNames(listDifficult);
    }

    @Override
    public final void setNameBtnBack(final String nameBtnBack) {
        this.btnBack.setText(nameBtnBack);
    }

    @Override
    public final void setSkinSpaceShip(final EngineImage imageEngine) {
        this.panelSkin.setPnImage(imageEngine.getPath());
        this.panelSkin.setRateImg(imageEngine.getScaleOf(), imageEngine.getRespectTo());
    }

    @Override
    public final void setDifficult(final Difficulty difficulty) {
        this.panelDifficult.setDifficult(difficulty);
    }

    @Override
    public final void setBtnBackID(final LinkActionGUI mainAction, final LinkActionGUI action) {
        this.btnBack.setActionCurrent(mainAction);
        this.btnBack.setActionNext(action);
    }


    @Override
    public final void setForegroundGUI(final Color color) {
        this.lbTitle.setForeground(color);
        this.panelSkin.setAllForeground(color);
        this.panelDifficult.setAllForeground(color);
        this.btnBack.setForeground(color);
    }

    @Override
    public final void setFontGUITitle(final Font font) {
        this.lbTitle.setFont(font);
    }

    @Override
    public final void setFontTitleUnit(final Font font) {
        this.panelSkin.setFontLbTitle(font);
        this.panelDifficult.setFontTitleDifficult(font);
        this.btnBack.setFont(font);
    }

    @Override
    public final void setFontUnit(final Font font) {
        this.panelDifficult.setFontGroupRadioButton(font);
        this.panelSkin.setFontButtons(font);
    }

    @Override
    public final void setTitleGUI(final String title) {
        this.lbTitle.setText(title);
    }

    @Override
    public final void setTransparentComponent() {
        this.panelSkin.setTransparentButton();
        FactoryGUIs.setTransparentDesignJButton(this.btnBack);
    }


    public final JLabel getLbTitle() {
        return this.lbTitle;
    }

    public final BtnAction getBtnBack() {
        return this.btnBack;
    }

    public final PanelSkin getPanelSkin() {
        return this.panelSkin;
    }

    public final PanelDifficult getPanelDifficult() {
        return this.panelDifficult;
    }



}
