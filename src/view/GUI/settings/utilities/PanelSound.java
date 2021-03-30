package view.GUI.settings.utilities;

import view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;

public class PanelSound extends JPanel{
    public static final int MIN_SOUND = 0;
    public static final int MAX_SOUND = 100;

    private JLabel lbTitle = new JLabel();
    private int valueSound = 50;
    private JSlider sliderSound = new JSlider(MIN_SOUND, MAX_SOUND, this.valueSound);

    public PanelSound(){
        super(new BorderLayout());
        this.setOpaque(false);
        this.add(FactoryGUIs.encapsulatesInPanel_Flow(this.lbTitle), BorderLayout.NORTH);
        this.add(this.sliderSound, BorderLayout.CENTER);
        this.sliderSound.setOpaque(false);

        this.sliderSound.setMajorTickSpacing(20);
        this.sliderSound.setMinorTickSpacing(5);
        this.sliderSound.setPaintTicks(true);
        this.sliderSound.setPaintLabels(true);

    }

    public void setFontTitleSound(final Font font){
        this.lbTitle.setFont(font);
    }

    public void setFontSliderSound(final Font font){
        this.sliderSound.setFont(font);
    }

    public void setTitle(final String title){
        this.lbTitle.setText(title);
    }

    public void setAllForeground(final Color color){
        this.lbTitle.setForeground(color);
        this.sliderSound.setForeground(color);
    }

}
