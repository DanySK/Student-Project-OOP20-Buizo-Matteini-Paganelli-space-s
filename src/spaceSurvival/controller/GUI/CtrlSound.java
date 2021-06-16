package spacesurvival.controller.gui;

import java.util.*;
import javax.swing.JSlider;
import spacesurvival.controller.gui.command.SwitchGUI;
import spacesurvival.controller.sound.CallerAudio;
import spacesurvival.model.GUI.EngineGUI;
import spacesurvival.model.GUI.Visibility;
import spacesurvival.model.GUI.sound.EngineSound;
import spacesurvival.model.GUI.sound.StateSlider;
import spacesurvival.model.GUI.sound.TypeUnitSound;
import spacesurvival.model.sound.CmdAudioType;
import spacesurvival.model.sound.category.SoundEffect;
import spacesurvival.model.sound.category.SoundLoop;
import spacesurvival.utilities.DesignSound;
import spacesurvival.utilities.SoundPath;
import spacesurvival.utilities.SoundType;
import spacesurvival.utilities.ActionGUI;
import spacesurvival.view.GUI;
import spacesurvival.view.sound.GUISound;
import spacesurvival.view.sound.utilities.ButtonSliderType;
import spacesurvival.view.utilities.FactoryGUIs;

public class CtrlSound implements ControllerGUI{
    private final GUISound gui;
    private final EngineSound engine;

    private final SwitchGUI switchGUI;
    private final CallerAudio callerAudioLoop;
    private final List<CallerAudio> callerAudioEffect;

    public CtrlSound(final EngineSound engine, final GUISound gui){
        this.engine = engine;
        this.gui = gui;
        this.switchGUI = new SwitchGUI(this.engine, this.gui);

        this.callerAudioLoop = new CallerAudio(new SoundLoop());
        this.callerAudioEffect = new ArrayList<>();

        SoundType.EFFECT.getSoundPaths().forEach(path ->
        	this.callerAudioEffect.add(new CallerAudio(new SoundEffect(path)))
        );

        this.assignAction();
        this.assignStrings();
        this.assignRectangle();
        this.assignSound();

        this.linksCallerAudio();
        
        this.switchGUI.turn(this.engine.getVisibility());
    }

    @Override
    public void assignAction() {
        this.gui.setMainAction(this.engine.getMainAction());
        this.gui.setBtnBackID(this.engine.getMainAction(), this.engine.getBackLink());
    }

    @Override
    public void assignStrings() {
        this.gui.setTitleGUI(this.engine.getTitle());
        this.gui.setNameButtonBack(this.engine.getNameBack());
    }

    @Override
    public void assignRectangle() {
        this.gui.setBounds(this.engine.getRectangle());
    }

    private void assignSound(){
        this.gui.setTypeUnitSound(this.engine.getListTypeUnitSound());
        this.gui.setTitleUnitSound(this.engine.getListNameSlider());
        this.gui.setDefaultValueSlidersSound(this.engine.getDefaultValueSound());
        this.gui.setIconBtnSwitches(this.engine.getIconStateSounds());
    }

    public void setSoundLoop(final ActionGUI actionGUI){
        this.callerAudioLoop.setSound(new SoundLoop(actionGUI.getSound()));
    }

    public void setCmdAudioLoop(final CmdAudioType cmdAudioLoop){
        this.callerAudioLoop.execute(cmdAudioLoop);
    }

    public Optional<CallerAudio> getCallerAudioEffectFromSoundPath(final SoundPath soundPath){
        for (CallerAudio callerAudio : this.callerAudioEffect) {
            if (callerAudio.getSound().getSoundType().equals(soundPath)) {
                return Optional.of(callerAudio);
            }
        }
        return Optional.empty();
    }

    public int getLoopVolume(){
        return this.engine.getValueUnitSound(TypeUnitSound.SLIDER_BACKGROUND);
    }

    public boolean isActiveLoopUnitSound(){
        return this.engine.isActiveUnitSound(TypeUnitSound.SLIDER_BACKGROUND);
    }

    public void linksCallerAudio(){
        Arrays.stream(TypeUnitSound.values()).forEach(type -> {
            this.setChangeListenerSliderFromType(type);
            this.setActionListenerChangeSwitchSoundFromType(type);
        });
    }

    public void setChangeListenerSliderFromType(final TypeUnitSound type) {
        this.gui.getSliderTypeofMixer(type).addChangeListener(l -> {
            final ButtonSliderType btnType = this.gui.getBtnSwitch(type);
            final JSlider sld = (JSlider) l.getSource();

            this.engine.setValueUnitSound(type, sld.getValue());
            this.engine.setStateUnitSound(type, this.isVolumeZero(type) ? StateSlider.OFF : StateSlider.ON);
            FactoryGUIs.setIconJButtonFromRate(btnType, this.engine.getEngineImageUnitSound(type));

            if (type.equals(TypeUnitSound.SLIDER_BACKGROUND)) {
                this.callerAudioLoop.changeVolume(this.engine.getValueUnitSound(type));
            } else if (type.equals(TypeUnitSound.SLIDER_EFFECT)) {
                this.callerAudioEffect.forEach(callerAudioEffect -> callerAudioEffect.changeVolume(this.engine.getValueUnitSound(type)));
            }
        });
    }

    public void setActionListenerChangeSwitchSoundFromType(final TypeUnitSound type){
        this.gui.getBtnSwitch(type).addActionListener(btn -> {
            final ButtonSliderType btnType = (ButtonSliderType) btn.getSource();

            this.engine.changeStateUnitSound(type);
            FactoryGUIs.setIconJButtonFromRate(btnType, this.engine.getEngineImageUnitSound(type));

            if(type.equals(TypeUnitSound.SLIDER_BACKGROUND)) {
                this.callerAudioLoop.changeVolume(this.getValueIfActive(btnType.getTypeSlider()));
            } else if(type.equals(TypeUnitSound.SLIDER_EFFECT)){
                this.callerAudioEffect.forEach(callerAudioEffect -> callerAudioEffect.changeVolume(this.getValueIfActive(btnType.getTypeSlider())));
            }
        });
    }


    public boolean isVolumeZero(final TypeUnitSound type){
        return this.engine.getValueUnitSound(type) == DesignSound.SOUND_ZERO;
    }

    public int getValueIfActive(final TypeUnitSound typeUnitSound){
        return this.engine.isActiveUnitSound(typeUnitSound) ?
                this.engine.getValueUnitSound(typeUnitSound) : DesignSound.SOUND_ZERO;
    }

    public void checkChangeSoundLoop(final ActionGUI actionGUI){
        if(this.isNewLoopSound(actionGUI)) {
            this.changeNewLoopSound(actionGUI);
        }
    }

    public boolean isNewLoopSound(final ActionGUI actionGUI){
        return this.callerAudioLoop.isNewSound(actionGUI.getSound());
    }

    public void changeNewLoopSound(final ActionGUI actionGUI){
        this.callerAudioLoop.execute(CmdAudioType.AUDIO_OFF);
        this.callerAudioLoop.setSound(new SoundLoop(actionGUI.getSound()));
        this.callerAudioLoop.changeVolume(this.isActiveLoopUnitSound() ? this.getLoopVolume() : DesignSound.SOUND_ZERO);

        this.callerAudioLoop.execute(CmdAudioType.AUDIO_ON);
    }


    @Override
    public ActionGUI getMainAction() {
        return this.engine.getMainAction();
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

    @Override
    public void closeGUI() {
        this.gui.close();
    }
}
