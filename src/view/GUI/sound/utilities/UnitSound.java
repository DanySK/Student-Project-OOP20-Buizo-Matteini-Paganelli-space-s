package view.GUI.sound.utilities;

import view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;

public class UnitSound extends JPanel {
    private final JLabel lbTitle;
    private final JSlider sliderSound;
    private final JButton btnSwitch;

    public UnitSound() {
        super(new BorderLayout());
        super.setOpaque(false);
        this.lbTitle = new JLabel();
        this.sliderSound = new JSlider();
        this.btnSwitch = new JButton();
        this.graphics();
    }

    private void graphics(){
        FactoryGUIs.setTransparentDesignJButton(this.btnSwitch);
        FactoryGUIs.setIconInJButtonMini(this.btnSwitch, "iconButton/volumeON.png");
        FactoryGUIs.setDefaultJSlider(this.sliderSound);
        super.add(FactoryGUIs.encapsulatesInPanel_Flow(this.lbTitle), BorderLayout.NORTH);
        super.add(FactoryGUIs.getUnionComponents(java.util.List.of(this.btnSwitch, this.sliderSound)), BorderLayout.CENTER);
    }

    public JSlider getSliderSound(){
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

    public void setOrientation(final int direction){
        this.sliderSound.setOrientation(direction);
    }

    public void setName(final String name){
        this.sliderSound.setName(name);
        this.btnSwitch.setName(name);
    }

    public void setValueSliderSound(final int value){
        this.sliderSound.setValue(value);
    }

    public JButton getBtnSwitch(){
        return this.btnSwitch;
    }
}
