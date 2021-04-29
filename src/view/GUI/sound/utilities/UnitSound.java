package view.GUI.sound.utilities;

import model.GUI.sound.TypeUnitSound;
import utilities.DimensionScreen;
import view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;

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

    private void graphics(){
        FactoryGUIs.setTransparentDesignJButton(this.btnSwitch);
        FactoryGUIs.setDefaultJSlider(this.sliderSound);
        super.add(FactoryGUIs.encapsulatesInPanel_Flow(this.lbTitle), BorderLayout.NORTH);
        super.add(FactoryGUIs.getUnionComponents(java.util.List.of(this.btnSwitch, this.sliderSound)), BorderLayout.CENTER);
    }

    public SliderType getSliderSound(){
        return this.sliderSound;
    }

    public void setForegroundUnit(final Color color){
        this.lbTitle.setForeground(color);
        this.sliderSound.setForeground(color);
    }

    public void setFontTitleUnit(final Font font) {
        this.lbTitle.setFont(font);
    }

    public void setFontSlider(final Font font) {
        this.sliderSound.setFont(font);
    }

    public void setLbTitle(final String lbTitle){
        this.lbTitle.setText(lbTitle);
    }

    public void setType(final TypeUnitSound typeUnitSound){
        this.sliderSound.setType(typeUnitSound);
        this.btnSwitch.setTypeSlider(typeUnitSound);
    }

    public void setValueSliderSound(final int value){
        this.sliderSound.setValue(value);
    }

    public ButtonSliderType getBtnSwitch(){
        return this.btnSwitch;
    }

    public void setIconBtnSwitch(final String path, final int widthScreen){
        FactoryGUIs.setIconJButtonFromRate(this.btnSwitch, path, 30, widthScreen);
    }

    public TypeUnitSound getType(){
        return this.sliderSound.getType();
    }
}
