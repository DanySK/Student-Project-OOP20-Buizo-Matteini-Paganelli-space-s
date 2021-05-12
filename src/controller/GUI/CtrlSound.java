package controller.GUI;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.GUI.command.SwitchGUI;
import controller.sound.CallerAudio;
import model.GUI.EngineGUI;
import model.GUI.Visibility;
import model.GUI.sound.EngineSound;
import model.GUI.sound.TypeUnitSound;
import utilities.DesignSound;
import utilities.DimensionScreen;
import utilities.IdGUI;
import view.GUI.GUI;
import view.GUI.sound.GUISound;
import view.utilities.FactoryGUIs;

public class CtrlSound implements ControllerGUI{
    private final GUISound gui;
    private final EngineSound engine;

    private final SwitchGUI switchGUI;
    private CallerAudio callerAudio;

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
    
    

    public void setCallerAudio(final CallerAudio callerAudio){
        this.callerAudio = callerAudio;
    }
    
    public CallerAudio getCallerAudio(){
        return this.callerAudio;
    }

    public void linksCallerWithListener(){
        this.setChangeListenerSlider();
        this.setActionListenerChangeSwitchSound();
    }

    public void setChangeListenerSlider(){
        this.gui.getSlidersSound().forEach(slider -> {
            //this.engine.setValueUnitSound(slider.getType(), slider.getValue());
        	if(this.engine.isActiveUnitSound(TypeUnitSound.SLIDER_BACKGROUND)){
           	slider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent ce) {
                    System.out.println(((JSlider) ce.getSource()).getValue());
                    getCallerAudio().changeVolume(((JSlider) ce.getSource()).getValue());
                }
            });
          }
        });

    }

    public void setActionListenerChangeSwitchSound(){
        this.gui.getBtnSwitches().forEach(btn -> {
            this.engine.changeStateUnitSound(btn.getTypeSlider());
            FactoryGUIs.setIconJButtonFromRate(btn, this.engine.getPathIconUnitSound((btn.getTypeSlider())), 50, DimensionScreen.WIDTH_MEDIUM);

            this.gui.getSliderTypeofMixer(btn.getTypeSlider()).setValue(
                    this.engine.isActiveUnitSound(btn.getTypeSlider()) ?
                            this.engine.getValueUnitSound(btn.getTypeSlider()) : DesignSound.SOUND_ZERO);

//            this.callerAudio.execute(this.engine.isActiveUnitSound(btn.getTypeSlider()) ?
//                    CmdAudioType.AUDIO_ON : CmdAudioType.AUDIO_OFF);
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
