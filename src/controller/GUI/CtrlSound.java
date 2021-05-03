package controller.GUI;

import controller.sound.CallerAudio;
import model.GUI.EngineGUI;
import model.GUI.sound.EngineSound;
import model.sound.CmdAudioType;
import utilities.DesignSound;
import utilities.DimensionScreen;
import utilities.SoundPath;
import view.GUI.GUI;
import view.GUI.sound.GUISound;
import view.GUI.sound.utilities.ButtonSliderType;
import view.utilities.FactoryGUIs;
import view.GUI.sound.utilities.SliderType;

import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;
import java.util.stream.Collectors;

public class CtrlSound implements ControllerGUI{
    private final GUISound soundGUI;
    private final EngineSound soundEngine;

    public CtrlSound(final GUISound soundGUI, final EngineSound soundEngine){
        this.soundEngine = soundEngine;
        this.soundGUI = soundGUI;
        this.initSound();
    }

    private void initSound(){
        this.soundGUI.setId(this.soundEngine.getId());
        this.soundGUI.setTitleGUI(this.soundEngine.getTitle());
        this.soundGUI.setNameButtonBack(this.soundEngine.getNameBack());
        this.soundGUI.setTypeUnitSound(this.soundEngine.getListTypeUnitSound());
        this.soundGUI.setTitleUnitSound(this.soundEngine.getListNameSlider());
        this.soundGUI.setDefaultValueSlidersSound(this.soundEngine.getDefaultValueSound());
        this.soundGUI.setIconBtnSwitches(this.soundEngine.getIconStateSounds());
        this.soundGUI.setBtnBackID(this.soundEngine.getBackLink());
        this.soundGUI.setVisible(this.soundEngine.isVisible());

        this.soundGUI.getSlidersSound().forEach(slider ->slider.addChangeListener(this.changeListenerSlider()));
    }

    private ChangeListener changeListenerSlider(){
        return e -> {
            final SliderType slider = (SliderType)e.getSource();
            this.soundEngine.setValueUnitSound(slider.getType(), slider.getValue());
        };
    }

    public void setChangeListenerSlider(final CallerAudio remoteControlAudio){
        this.soundGUI.getSlidersSound().forEach(slider ->{
            remoteControlAudio.changeVolume(slider.getValue());
        });
    }

    public void setActionListenerChangeSwitchSound(final CallerAudio remoteControlAudio){
        this.soundGUI.getBtnSwitches().forEach(btn -> {
            this.soundEngine.changeStateUnitSound(btn.getTypeSlider());
            FactoryGUIs.setIconJButtonFromRate(btn,
                    this.soundEngine.getPathIconUnitSound((btn.getTypeSlider())), 30, DimensionScreen.WIDTH_MEDIUM);

            this.soundGUI.getSliderTypeofMixer(btn.getTypeSlider()).setValue(
                    this.soundEngine.isActiveUnitSound(btn.getTypeSlider()) ?
                            this.soundEngine.getValueUnitSound(btn.getTypeSlider()) : DesignSound.SOUND_ZERO);

            remoteControlAudio.execute(this.soundEngine.isActiveUnitSound(btn.getTypeSlider()) ?
                    CmdAudioType.AUDIO_ON : CmdAudioType.AUDIO_OFF);
        });
    }

    @Override
    public GUI getGUI() {
        return this.soundGUI;
    }

    @Override
    public EngineGUI getEngine() {
        return this.soundEngine;
    }
}
