package spaceSurvival.controller.GUI;

import java.util.List;

import javax.swing.JSlider;

import spaceSurvival.controller.GUI.command.SwitchGUI;
import spaceSurvival.controller.sound.CallerAudio;
import spaceSurvival.model.GUI.EngineGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.model.GUI.sound.EngineSound;
import spaceSurvival.model.GUI.sound.StateSlider;
import spaceSurvival.model.GUI.sound.TypeUnitSound;
import spaceSurvival.model.sound.CmdAudioType;
import spaceSurvival.model.sound.category.SoundLoop;
import spaceSurvival.utilities.DesignSound;
import spaceSurvival.utilities.dimension.Screen;
import spaceSurvival.utilities.IdGUI;
import spaceSurvival.view.GUI.GUI;
import spaceSurvival.view.GUI.sound.GUISound;
import spaceSurvival.view.GUI.sound.utilities.ButtonSliderType;
import spaceSurvival.view.utilities.FactoryGUIs;

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
        this.callerAudioLoop = new CallerAudio();

        this.assignId();
        this.assignStrings();
        this.assignSound();
        this.linksCallerAudioLoopWithListener();
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

    public void setSoundLoop(final IdGUI idGUI){
        this.callerAudioLoop.setSound(new SoundLoop(idGUI.getSound()));
    }

    public void setCmdAudioLoop(final CmdAudioType cmdAudioLoop){
        this.callerAudioLoop.execute(cmdAudioLoop);
    }

    public List<CallerAudio> getCallerAudioEffect(){
        return this.callerAudioEffect;
    }
    
    public void setCallerAudioEffect(final List<CallerAudio> callerAudioEffect){
        this.callerAudioEffect = callerAudioEffect;
    }


    public int getLoopVolume(){
        return this.engine.getValueUnitSound(TypeUnitSound.SLIDER_BACKGROUND);
    }

    public boolean isActiveLoopUnitSound(){
        return this.engine.isActiveUnitSound(TypeUnitSound.SLIDER_BACKGROUND);
    }


    public void linksCallerAudioLoopWithListener(){
        final TypeUnitSound type = TypeUnitSound.SLIDER_BACKGROUND;
        this.setChangeListenerSliderLoop(type);
        this.setActionListenerChangeSwitchSoundLoop(type);
    }
    
    public void linksCallerAudioEffectWithListener(){
        this.setChangeListenerSliderEffect();
        this.setActionListenerChangeSwitchSoundEffect();
    }

    public boolean isVolumeZero(final TypeUnitSound type){
        return this.engine.getValueUnitSound(type) == DesignSound.SOUND_ZERO;
    }

    public int getValueIfActive(final TypeUnitSound typeUnitSound){
        return this.engine.isActiveUnitSound(typeUnitSound) ?
                this.engine.getValueUnitSound(typeUnitSound) : DesignSound.SOUND_ZERO;
    }

    public void setChangeListenerSliderLoop(final TypeUnitSound type){
        this.gui.getSliderTypeofMixer(type).addChangeListener(l -> {
            final ButtonSliderType btnType = this.gui.getBtnSwitch(type);
            final JSlider sld = (JSlider)l.getSource();

            this.engine.setValueUnitSound(type, sld.getValue());
            this.engine.setStateUnitSound(type, this.isVolumeZero(type) ? StateSlider.OFF : StateSlider.ON);
            FactoryGUIs.setIconJButtonFromRate(btnType,this.engine.getEngineImageUnitSound(type));
            this.callerAudioLoop.changeVolume(this.engine.getValueUnitSound(type));
        });
    }

    public void checkChangeSoundLoop(final IdGUI idGUI){
        if(this.isNewLoopSound(idGUI)) {
            this.changeNewLoopSound(idGUI);
        }
    }

    public boolean isNewLoopSound(final IdGUI idGUI){
        return this.callerAudioLoop.isNewSound(idGUI.getSound());
    }

    public void changeNewLoopSound(final IdGUI idGUI){
        this.callerAudioLoop.execute(CmdAudioType.AUDIO_OFF);
        this.callerAudioLoop.setSound(new SoundLoop(idGUI.getSound()));

        this.callerAudioLoop.changeVolume(this.isActiveLoopUnitSound() ?
                this.getLoopVolume() : DesignSound.SOUND_ZERO);

        this.callerAudioLoop.execute(CmdAudioType.AUDIO_ON);
    }

    public void setActionListenerChangeSwitchSoundLoop(final TypeUnitSound type){
        this.gui.getBtnSwitch(type).addActionListener(btn -> {
            final ButtonSliderType btnType = (ButtonSliderType) btn.getSource();

            this.engine.changeStateUnitSound(type);
            FactoryGUIs.setIconJButtonFromRate(btnType, this.engine.getEngineImageUnitSound(type));
            this.callerAudioLoop.changeVolume(this.getValueIfActive(btnType.getTypeSlider()));
        });
    }


    public void setChangeListenerSliderEffect(){
    	this.gui.getSliderTypeofMixer(TypeUnitSound.SLIDER_EFFECT).addChangeListener(ce -> {
            System.out.println(((JSlider) ce.getSource()).getValue());
            getCallerAudioEffect().forEach(callerAudioEffect -> callerAudioEffect.changeVolume(((JSlider) ce.getSource()).getValue()));

        });
    }

    public void setActionListenerChangeSwitchSoundEffect(){
    	ButtonSliderType btn = this.gui.getBtnSwitches().get(1);
    	
        this.engine.changeStateUnitSound(btn.getTypeSlider());
        FactoryGUIs.setIconJButtonFromRate(btn, this.engine.getPathIconUnitSound((btn.getTypeSlider())), 50, Screen.WIDTH_MEDIUM);
        getCallerAudioEffect().forEach(callerAudioEffect -> callerAudioEffect.execute((callerAudioEffect.getSound().isPlaying()) ? CmdAudioType.AUDIO_OFF : CmdAudioType.AUDIO_ON));
    }

    @Override
    public IdGUI getIdGUI() {
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
