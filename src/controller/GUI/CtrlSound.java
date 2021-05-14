package controller.GUI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import controller.GUI.command.SwitchGUI;
import controller.sound.CallerAudio;
import model.GUI.EngineGUI;
import model.GUI.Visibility;
import model.GUI.sound.EngineSound;
import model.GUI.sound.StateSlider;
import model.GUI.sound.TypeUnitSound;
import model.image.EngineImage;
import model.sound.CmdAudioType;
import utilities.DesignSound;
import utilities.dimension.Screen;
import utilities.IdGUI;
import view.GUI.GUI;
import view.GUI.sound.GUISound;
import view.GUI.sound.utilities.ButtonSliderType;
import view.GUI.sound.utilities.SliderType;
import view.utilities.FactoryGUIs;

public class CtrlSound implements ControllerGUI{
    private final GUISound gui;
    private final EngineSound engine;

    private final SwitchGUI switchGUI;
    private CallerAudio callerAudioLoop;
    private List<CallerAudio> callerAudioEffect;

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
    }

    public CallerAudio getCallerAudioLoop(){
        return this.callerAudioLoop;
    }

    public void setCallerAudioLoop(final CallerAudio callerAudioLoop){
        this.callerAudioLoop = callerAudioLoop;
    }


    public List<CallerAudio> getCallerAudioEffect(){
        return this.callerAudioEffect;
    }
    
    public void setCallerAudioEffect(final List<CallerAudio> callerAudioEffect){
        this.callerAudioEffect = callerAudioEffect;
    }


    public int getBackgroundVolume(){
        return this.engine.getValueUnitSound(TypeUnitSound.SLIDER_BACKGROUND);
    }

    public int getEffectVolume(){
        return this.engine.getValueUnitSound(TypeUnitSound.SLIDER_EFFECT);
    }

    public boolean isActiveLoopUnitSound(){
        return this.engine.isActiveUnitSound(TypeUnitSound.SLIDER_BACKGROUND);
    }


    public void linksCallerAudioLoopWithListener(){
        this.setChangeListenerSliderLoop();
        this.setActionListenerChangeSwitchSoundLoop();
    }
    
    public void linksCallerAudioEffectWithListener(){
        this.setChangeListenerSliderEffect();
        this.setActionListenerChangeSwitchSoundEffect();
    }
    
    public void setChangeListenerSliderLoop(){
        this.gui.getSliderTypeofMixer(TypeUnitSound.SLIDER_BACKGROUND).addChangeListener(l -> {
            final TypeUnitSound type = TypeUnitSound.SLIDER_BACKGROUND;
            final ButtonSliderType btnType = this.gui.getBtnSwitch(type);
            final JSlider sld = (JSlider)l.getSource();

            this.engine.setValueUnitSound(type, sld.getValue());

            this.engine.setStateUnitSound(type, this.engine.getValueUnitSound(type) == DesignSound.SOUND_ZERO ?
                            StateSlider.OFF : StateSlider.ON);

            FactoryGUIs.setIconJButtonFromRate(btnType,this.engine.getEngineImageUnitSound(type));

            this.callerAudioLoop.changeVolume(this.engine.getValueUnitSound(type));
        });
    }

    public int getValueIfActive(final TypeUnitSound typeUnitSound){
        return this.engine.isActiveUnitSound(typeUnitSound) ?
                this.engine.getValueUnitSound(typeUnitSound) : DesignSound.SOUND_ZERO;
    }

    public void setActionListenerChangeSwitchSoundLoop(){
        this.gui.getBtnSwitch(TypeUnitSound.SLIDER_BACKGROUND).addActionListener(btn -> {
            final TypeUnitSound type = TypeUnitSound.SLIDER_BACKGROUND;
            final SliderType sld = this.gui.getSliderTypeofMixer(type);
            final ButtonSliderType btnType = (ButtonSliderType) btn.getSource();

            this.engine.changeStateUnitSound(type);

            FactoryGUIs.setIconJButtonFromRate(btnType, this.engine.getEngineImageUnitSound(type));

            this.gui.getSliderTypeofMixer(TypeUnitSound.SLIDER_BACKGROUND)
                    .setValue(this.getValueIfActive(TypeUnitSound.SLIDER_BACKGROUND));

            this.callerAudioLoop.changeVolume(this.getValueIfActive(btnType.getTypeSlider()));
        });
    }


    public void setChangeListenerSliderEffect(){
    	this.gui.getSliderTypeofMixer(TypeUnitSound.SLIDER_EFFECT).addChangeListener(ce -> {
            System.out.println(((JSlider) ce.getSource()).getValue());
            getCallerAudioEffect().forEach(callerAudioEffect -> {
                callerAudioEffect.changeVolume(((JSlider) ce.getSource()).getValue());
            });

        });
    }

    public void setActionListenerChangeSwitchSoundEffect(){
    		
    		ButtonSliderType btn = this.gui.getBtnSwitches().get(1);
    	
            this.engine.changeStateUnitSound(btn.getTypeSlider());
            FactoryGUIs.setIconJButtonFromRate(btn, this.engine.getPathIconUnitSound((btn.getTypeSlider())), 50, Screen.WIDTH_MEDIUM);

//            this.gui.getSliderTypeofMixer(btn.getTypeSlider()).setValue(
//                    this.engine.isActiveUnitSound(btn.getTypeSlider()) ?
//                            this.engine.getValueUnitSound(btn.getTypeSlider()) : DesignSound.SOUND_ZERO);

            getCallerAudioEffect().forEach(callerAudioEffect -> {        	
            	callerAudioEffect.execute((callerAudioEffect.getSound().isPlaying()) ? CmdAudioType.AUDIO_OFF : CmdAudioType.AUDIO_ON);
            });
    }

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
    public boolean isVisibility() {
        return this.engine.isVisible();
    }

    @Override
    public void turn(final Visibility visibility) {
        this.switchGUI.turn(visibility);
    }

    @Override
    public void changeVisibility() {
        this.switchGUI.changeVisibility();
    }
}
