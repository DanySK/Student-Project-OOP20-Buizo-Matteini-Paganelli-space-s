package view.GUI.sound.utilities;

import view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MixerSound extends JPanel{
    public static final int N_SOUND = 2;
    private final List<UnitSound> sdlSounds;

    public MixerSound(){
        super(new GridBagLayout());
        super.setOpaque(false);
        this.sdlSounds = Stream.generate(UnitSound::new)
                .limit(N_SOUND).collect(Collectors.toList());
        this.graphics();
    }

    private void graphics(){
        GridBagConstraints limit = FactoryGUIs.createGBConstraintsBase();
        super.add(FactoryGUIs.getJComponentEmpty());
        for (UnitSound unit : this.sdlSounds) {
            super.add(unit, limit);
            limit.gridy++;
        }
    }

    public void setFontTitleSound(final Font font){
        this.sdlSounds.forEach(sound -> sound.setFontTitleUnit(font));
    }

    public void setFontSliderSound(final Font font){
        this.sdlSounds.forEach(sound -> sound.setFontSlider(font));
    }

    public void setTitleSlider(final List<String> titleSlider){
        int i = 0;
        for (UnitSound unit : this.sdlSounds) {
           unit.setLbTitle(titleSlider.get(i++));
        }
    }

    public void setNameSlider(final List<String> nameSlider){
        int i = 0;
        for (UnitSound unit : this.sdlSounds) {
            unit.setName(nameSlider.get(i++));
        }
    }

    public void setAllForeground(final Color color){
        this.sdlSounds.forEach(sound -> sound.setForegroundUnit(color));
    }

    public List<JSlider> getSliders(){
        return this.sdlSounds.stream().map(UnitSound::getSliderSound)
                .collect(Collectors.toList());
    }

    public void setDefaultValueSlidersSound(final int value){
        this.sdlSounds.forEach(sound -> sound.setValueSliderSound(value));
    }

    public List<JButton> getBtnSwitchs(){
        return this.sdlSounds.stream().map(s -> s.getBtnSwitch()).collect(Collectors.toList());
    }
}
