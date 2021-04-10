package view.GUI.sound.utilities;

import utilities.DesignSound;
import view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;

public class UnitSound extends JPanel {
    private JLabel lbTitle;
    private JSlider sliderSound;

    public UnitSound() {
        super(new BorderLayout());
        super.setOpaque(false);
        this.lbTitle = new JLabel();
        this.sliderSound = new JSlider();
        this.graphics();
    }

    private void graphics(){
        this.sliderSound.setOpaque(false);
        this.sliderSound.setMajorTickSpacing(DesignSound.DEFAULT_MAJOR_TICK_SPACING);
        this.sliderSound.setMinorTickSpacing(DesignSound.DEFAULT_MINOR_TICK_SPACING);
        this.sliderSound.setPaintTicks(true);
        this.sliderSound.setPaintLabels(true);
        super.add(FactoryGUIs.encapsulatesInPanel_Flow(this.lbTitle), BorderLayout.NORTH);
        super.add(this.sliderSound, BorderLayout.CENTER);
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
    }

    public void setValueSliderSound(final int value){
        this.sliderSound.setValue(value);
    }
}
