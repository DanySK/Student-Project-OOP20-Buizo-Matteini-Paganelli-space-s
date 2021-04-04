package view.GUI.settings.utilities;

import view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;

public class PanelSound extends JPanel{
    public static final int MIN_SOUND = 0;
    public static final int MAX_SOUND = 100;

    private JLabel lbTitle = new JLabel();
    private int valueMainSound = 80;
    private JSlider sliderMainSound = new JSlider(JSlider.VERTICAL, MIN_SOUND, MAX_SOUND, this.valueMainSound);

    private int valueEffectSound = 50;
    private JSlider sliderEffectSound = new JSlider(JSlider.VERTICAL, MIN_SOUND, MAX_SOUND, this.valueEffectSound);

    public PanelSound(){
        super(new BorderLayout());
        this.setOpaque(false);
        this.add(FactoryGUIs.encapsulatesInPanel_Flow(this.lbTitle), BorderLayout.NORTH);

        this.add(FactoryGUIs.encapsulatesHorizontal(java.util.List.of(this.sliderMainSound, this.sliderEffectSound), 50),
                BorderLayout.CENTER);

        this.sliderMainSound.setOpaque(false);

        this.sliderEffectSound.setOpaque(false);

        this.sliderMainSound.setMajorTickSpacing(20);
        this.sliderMainSound.setMinorTickSpacing(5);
        this.sliderMainSound.setPaintTicks(true);
        this.sliderMainSound.setPaintLabels(true);

        this.sliderEffectSound.setMajorTickSpacing(20);
        this.sliderEffectSound.setMinorTickSpacing(5);
        this.sliderEffectSound.setPaintTicks(true);
        this.sliderEffectSound.setPaintLabels(true);

    }

    public void setFontTitleSound(final Font font){
        this.lbTitle.setFont(font);
    }

    public void setFontSliderSound(final Font font){
        this.sliderMainSound.setFont(font);
        this.sliderEffectSound.setFont(font);
    }

    public void setTitle(final String title){
        this.lbTitle.setText(title);
    }

    public void setAllForeground(final Color color){
        this.lbTitle.setForeground(color);
        this.sliderMainSound.setForeground(color);
        this.sliderEffectSound.setForeground(color);
    }

}
