package spacesurvival.controller.gui;

import java.util.*;
import javax.swing.JSlider;
import spacesurvival.controller.gui.command.SwitchGUI;
import spacesurvival.controller.sound.CallerAudio;
import spacesurvival.model.gui.EngineGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.model.gui.sound.EngineSound;
import spacesurvival.model.gui.sound.StateSlider;
import spacesurvival.model.gui.sound.TypeUnitSound;
import spacesurvival.model.sound.category.SoundEffect;
import spacesurvival.model.sound.category.SoundLoop;
import spacesurvival.utilities.SoundUtils;
import spacesurvival.utilities.path.SoundPath;
import spacesurvival.utilities.SoundType;
import spacesurvival.utilities.LinkActionGUI;
import spacesurvival.utilities.CommandAudioType;
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

        this.assignSound();
        this.linksCallerAudio();
        
        this.turn(this.engine.getVisibility());
    }

    @Override
    public void assignLinks() {
        this.gui.setMainAction(this.engine.getMainLink());
        this.gui.setBtnBackID(this.engine.getMainLink(), this.engine.getBackLink());
    }

    @Override
    public void assignTexts() {
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

    public void setSoundLoop(final LinkActionGUI linkActionGUI){
        this.callerAudioLoop.setSound(new SoundLoop(linkActionGUI.getSound()));
    }

    public void setCmdAudioLoop(final CommandAudioType cmdAudioLoop){
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

    public boolean isActiveLoopUnitSound() {
        return this.engine.isActiveUnitSound(TypeUnitSound.SLIDER_BACKGROUND);
    }

    public void linksCallerAudio() {
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
        return this.engine.getValueUnitSound(type) == SoundUtils.SOUND_ZERO;
    }

    public int getValueIfActive(final TypeUnitSound typeUnitSound){
        return this.engine.isActiveUnitSound(typeUnitSound) ?
                this.engine.getValueUnitSound(typeUnitSound) : SoundUtils.SOUND_ZERO;
    }

    public void checkChangeSoundLoop(final LinkActionGUI linkActionGUI){
        if(this.isNewLoopSound(linkActionGUI)) {
            this.changeNewLoopSound(linkActionGUI);
        }
    }

    public boolean isNewLoopSound(final LinkActionGUI linkActionGUI){
        return this.callerAudioLoop.isNewSound(linkActionGUI.getSound());
    }

    public void changeNewLoopSound(final LinkActionGUI linkActionGUI){
        this.callerAudioLoop.execute(CommandAudioType.AUDIO_OFF);
        this.callerAudioLoop.setSound(new SoundLoop(linkActionGUI.getSound()));
        this.callerAudioLoop.changeVolume(this.isActiveLoopUnitSound() ? this  .getLoopVolume() : SoundUtils.SOUND_ZERO);

        this.callerAudioLoop.execute(CommandAudioType.AUDIO_ON);
    }


    @Override
    public LinkActionGUI getMainLink() {
        return this.engine.getMainLink();
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
