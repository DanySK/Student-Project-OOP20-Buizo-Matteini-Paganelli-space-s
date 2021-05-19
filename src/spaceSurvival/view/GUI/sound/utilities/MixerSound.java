package spaceSurvival.view.GUI.sound.utilities;

import spaceSurvival.model.GUI.sound.EngineSound;
import spaceSurvival.model.GUI.sound.TypeUnitSound;
import spaceSurvival.view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MixerSound extends JPanel{
    private final List<UnitSound> sdlSounds;

    public MixerSound(){
        super(new GridBagLayout());
        super.setOpaque(false);
        this.sdlSounds = Stream.generate(UnitSound::new)
                .limit(EngineSound.N_UNIT_SOUND).collect(Collectors.toList());
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

    public void setTypeUnitSound(final List<TypeUnitSound> nameSlider){
        int i = 0;
        for (final UnitSound unit : this.sdlSounds) {
            unit.setType(nameSlider.get(i++));
        }
    }

    public void setAllForeground(final Color color){
        this.sdlSounds.forEach(sound -> sound.setForegroundUnit(color));
    }

    public List<SliderType> getSliders(){
        return this.sdlSounds.stream().map(UnitSound::getSliderSound)
                .collect(Collectors.toList());
    }

    public void setDefaultValueSlidersSound(final int value){
        this.sdlSounds.forEach(sound -> sound.setValueSliderSound(value));
    }

    public List<ButtonSliderType> getBtnSwitches(){
        return this.sdlSounds.stream().map(UnitSound::getBtnSwitch).collect(Collectors.toList());
    }

    public void setIconBtnSwitches(final List<String> paths, final int widthScreen){
        AtomicInteger i = new AtomicInteger();
        this.sdlSounds.forEach(sound -> sound.setIconBtnSwitch(paths.get(i.getAndIncrement()), widthScreen));
    }

    public SliderType getSliderType(final TypeUnitSound typeUnitSound){
        for (UnitSound unit : this.sdlSounds) {
            if(typeUnitSound == unit.getType()){
                return unit.getSliderSound();
            }
        }
        return null;
    }

    public ButtonSliderType getBtnSwitch(final TypeUnitSound typeUnitSound){
        for (UnitSound unit : this.sdlSounds) {
            if(typeUnitSound == unit.getType()){
                return unit.getBtnSwitch();
            }
        }
        return null;
    }
}
