package controller.GUI;

import controller.GUI.command.SwitchGUI;
import model.GUI.EngineGUI;
import model.GUI.Visibility;
import model.GUI.sound.EngineSound;
import utilities.IdGUI;
import view.GUI.GUI;
import view.GUI.sound.GUISound;
import view.GUI.sound.utilities.SliderType;
import javax.swing.event.ChangeListener;

public class CtrlSound implements ControllerGUI{
    private final GUISound gui;
    private final EngineSound engine;

    private final SwitchGUI switchGUI;

    public CtrlSound(final EngineSound engine, final GUISound gui){
        this.engine = engine;
        this.gui = gui;
        this.switchGUI = new SwitchGUI(this.engine, this.gui);

        this.assignId();
        this.assignStrings();
        this.assignSound();
        this.switchGUI.turn(this.engine.getVisibility());
    }

    private void assignId() {
        this.gui.setId(this.engine.getId());
        this.gui.setBtnBackID(this.engine.getBackLink());
    }

    private void assignStrings() {
        this.gui.setTitleGUI(this.engine.getTitle());
        this.gui.setNameButtonBack(this.engine.getNameBack());
    }

    private void assignSound(){
        this.gui.setTypeUnitSound(this.engine.getListTypeUnitSound());
        this.gui.setTitleUnitSound(this.engine.getListNameSlider());
        this.gui.setDefaultValueSlidersSound(this.engine.getDefaultValueSound());
        this.gui.setIconBtnSwitches(this.engine.getIconStateSounds());
        this.gui.getSlidersSound().forEach(slider ->slider.addChangeListener(this.changeListenerSlider()));
    }

    private ChangeListener changeListenerSlider(){
        return e -> {
            final SliderType slider = (SliderType)e.getSource();
            this.engine.setValueUnitSound(slider.getType(), slider.getValue());
        };
    }

//    public void setChangeListenerSlider(final CallerAudio remoteControlAudio){
//        this.gui.getSlidersSound().forEach(slider ->{
//            remoteControlAudio.changeVolume(slider.getValue());
//        });
//    }
//
//    public void setActionListenerChangeSwitchSound(final CallerAudio remoteControlAudio){
//        this.gui.getBtnSwitches().forEach(btn -> {
//            this.engine.changeStateUnitSound(btn.getTypeSlider());
//            FactoryGUIs.setIconJButtonFromRate(btn,
//                    this.engine.getPathIconUnitSound((btn.getTypeSlider())), 30, DimensionScreen.WIDTH_MEDIUM);
//
//            this.gui.getSliderTypeofMixer(btn.getTypeSlider()).setValue(
//                    this.engine.isActiveUnitSound(btn.getTypeSlider()) ?
//                            this.engine.getValueUnitSound(btn.getTypeSlider()) : DesignSound.SOUND_ZERO);
//
//            remoteControlAudio.execute(this.engine.isActiveUnitSound(btn.getTypeSlider()) ?
//                    CmdAudioType.AUDIO_ON : CmdAudioType.AUDIO_OFF);
//        });
//    }

    @Override
    public IdGUI getId() {
        return this.engine.getId();
    }

    @Override
    public GUI getGUI() {
        return this.gui;
    }

    @Override
    public EngineGUI getEngine() {
        return this.engine;
    }

    @Override
    public void turn(final Visibility visibility) {
        this.switchGUI.turn(visibility);
    }
}
