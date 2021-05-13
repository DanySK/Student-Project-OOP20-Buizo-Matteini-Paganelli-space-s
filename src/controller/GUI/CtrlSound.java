package controller.GUI;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import controller.GUI.command.SwitchGUI;
import controller.sound.CallerAudio;
import model.GUI.EngineGUI;
import model.GUI.Visibility;
import model.GUI.sound.EngineSound;
import model.GUI.sound.TypeUnitSound;
import model.sound.CmdAudioType;
import utilities.DesignSound;
import utilities.DimensionScreen;
import utilities.IdGUI;
import view.GUI.GUI;
import view.GUI.sound.GUISound;
import view.GUI.sound.utilities.ButtonSliderType;
import view.utilities.FactoryGUIs;

public class CtrlSound implements ControllerGUI{
    private final GUISound gui;
    private final EngineSound engine;

    private final SwitchGUI switchGUI;
    private CallerAudio callerAudioLoop;
    private ArrayList<CallerAudio> callerAudioEffect;

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
    
    

    public void setCallerAudioLoop(final CallerAudio callerAudioLoop){
        this.callerAudioLoop = callerAudioLoop;
    }
    
    public CallerAudio getCallerAudioLoop(){
        return this.callerAudioLoop;
    }
    
    public void setCallerAudioEffect(final ArrayList<CallerAudio> callerAudioEffect){
        this.callerAudioEffect = callerAudioEffect;
    }
    
    public ArrayList<CallerAudio> getCallerAudioEffect(){
        return this.callerAudioEffect;
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

    	this.gui.getSlidersSound().get(0).addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
            	
                System.out.println(((JSlider) ce.getSource()).getValue());
                getCallerAudioLoop().changeVolume(((JSlider) ce.getSource()).getValue());
            }
        });

    }
    
    public void setChangeListenerSliderEffect(){
        
    	this.gui.getSlidersSound().get(1).addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
            	
                System.out.println(((JSlider) ce.getSource()).getValue());
                getCallerAudioEffect().forEach(callerAudioEffect -> {     	
                	callerAudioEffect.changeVolume(((JSlider) ce.getSource()).getValue());     	
                });
            }
        });
    }


    public void setActionListenerChangeSwitchSoundLoop(){
        
    		ButtonSliderType btn = this.gui.getBtnSwitches().get(0);
    		//AtomicInteger i = new AtomicInteger(0);
    		btn.addActionListener(l -> {
    			if(getCallerAudioLoop().getSound().isPlaying()) {
    				getCallerAudioLoop().execute(CmdAudioType.AUDIO_OFF);
    				getCallerAudioLoop().changeVolume(0);
    				System.out.println(getCallerAudioLoop().getSound());
    				//getCallerAudioLoop().execute(CmdAudioType.AUDIO_OFF);
    			}
    			else {
    				//getCallerAudioLoop().execute(CmdAudioType.AUDIO_ON);
    				getCallerAudioLoop().changeVolume(50);
    			}
    			//this.engine.changeStateUnitSound(btn.getTypeSlider());
    			//this.engine.setValueUnitSound(TypeUnitSound.SLIDER_BACKGROUND, DesignSound.SOUND_ZERO);
    			//i.incrementAndGet();
    			
    			
    			//getCallerAudioLoop().execute((getCallerAudioLoop().getSound().isPlaying()) ? CmdAudioType.AUDIO_OFF : CmdAudioType.AUDIO_ON);
    		});
    	
           // this.engine.changeStateUnitSound(btn.getTypeSlider());
            //FactoryGUIs.setIconJButtonFromRate(btn, this.engine.getPathIconUnitSound((btn.getTypeSlider())), 50, DimensionScreen.WIDTH_MEDIUM);

            
//            this.gui.getSliderTypeofMixer(btn.getTypeSlider()).setValue(
//            		this.engine.isActiveUnitSound(btn.getTypeSlider()) ?
//            				this.engine.getValueUnitSound(btn.getTypeSlider()) : DesignSound.SOUND_ZERO);
          
           //System.out.println(getCallerAudioLoop().getSound().isPlaying());
           
           //getCallerAudioLoop().execute(CmdAudioType.AUDIO_ON);

    }
    
    public void setActionListenerChangeSwitchSoundEffect(){
    		
    		ButtonSliderType btn = this.gui.getBtnSwitches().get(1);
    	
            this.engine.changeStateUnitSound(btn.getTypeSlider());
            FactoryGUIs.setIconJButtonFromRate(btn, this.engine.getPathIconUnitSound((btn.getTypeSlider())), 50, DimensionScreen.WIDTH_MEDIUM);

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
