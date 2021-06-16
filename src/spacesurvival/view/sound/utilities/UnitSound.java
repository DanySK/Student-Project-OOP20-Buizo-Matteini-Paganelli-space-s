package spacesurvival.view.sound.utilities;


import spacesurvival.model.gui.sound.TypeUnitSound;
import spacesurvival.utilities.dimension.ScaleOf;
import spacesurvival.view.utilities.FactoryGUIs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import spacesurvival.model.gui.sound.TypeUnitSound;
import spacesurvival.utilities.dimension.ScaleOf;
import spacesurvival.view.utilities.FactoryGUIs;


public class UnitSound extends JPanel {
    private final JLabel lbTitle;
    private final SliderType sliderSound;
    private final ButtonSliderType btnSwitch;

    public UnitSound() {
        super(new BorderLayout());
        super.setOpaque(false);
        this.lbTitle = new JLabel();
        this.sliderSound = new SliderType();
        this.btnSwitch = new ButtonSliderType();
        this.graphics();
    }

    private void graphics() {
        FactoryGUIs.setTransparentDesignJButton(this.btnSwitch);
        FactoryGUIs.setDefaultJSlider(this.sliderSound);
        super.add(FactoryGUIs.encapsulatesInPanelFlow(this.lbTitle), BorderLayout.NORTH);
        super.add(FactoryGUIs.createPanelFlowUnionComponents(java.util.List.of(this.btnSwitch, this.sliderSound)), BorderLayout.CENTER);
    }

    public SliderType getSliderSound() {
        return this.sliderSound;
    }

    public void setForegroundUnit(final Color color) {
        this.lbTitle.setForeground(color);
        this.sliderSound.setForeground(color);
    }

    public void setFontTitleUnit(final Font font) {
        this.lbTitle.setFont(font);
    }

    public void setFontSlider(final Font font) {
        this.sliderSound.setFont(font);
    }

    public void setLbTitle(final String lbTitle) {
        this.lbTitle.setText(lbTitle);
    }

    public void setType(final TypeUnitSound typeUnitSound) {
        this.sliderSound.setType(typeUnitSound);
        this.btnSwitch.setTypeSlider(typeUnitSound);
    }

    public void setValueSliderSound(final int value) {
        this.sliderSound.setValue(value);
    }

    public ButtonSliderType getBtnSwitch() {
        return this.btnSwitch;
    }

    public void setIconBtnSwitch(final String path, final int widthScreen) {
        FactoryGUIs.setIconJButtonFromRate(this.btnSwitch, path, ScaleOf.ICON_MEDIUM, widthScreen);
    }

    public TypeUnitSound getType() {
        return this.sliderSound.getType();
    }
}
