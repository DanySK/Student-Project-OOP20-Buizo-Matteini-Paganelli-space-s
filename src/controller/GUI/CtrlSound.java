package controller.GUI;

import model.GUI.sound.EngineSound;
import view.GUI.sound.GUISound;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.SliderUI;

public class CtrlSound {
    private GUISound soundGUI;
    private EngineSound soundEngine;

    public CtrlSound(final GUISound soundGUI, final EngineSound soundEngine){
        this.soundEngine = soundEngine;
        this.soundGUI = soundGUI;
        this.initSound();
    }

    private void initSound(){
        this.soundGUI.setId(this.soundEngine.getId());
        this.soundGUI.setTitleGUI(this.soundEngine.getTitle());
        this.soundGUI.setNameComponents(this.soundEngine.getListNameComponents());
        this.soundGUI.setNameTypeSlider(this.soundEngine.getListNameSlider());
        this.soundGUI.setBtnBackID(this.soundEngine.getLink());
        this.soundGUI.setVisible(this.soundEngine.getState());

        this.soundGUI.setDefaultValueSlidersSound(this.soundEngine.getDefaultValueSound());
        this.soundGUI.getSlidersSound().forEach(slider ->
                slider.addChangeListener(this.changeListenerSlider(slider)));
    }

    private ChangeListener changeListenerSlider(final JSlider slider){
        int firstSlider = 0;
        return e -> {
            if(slider.getName().contentEquals(soundEngine.getListNameSlider().get(firstSlider))){
                soundEngine.setValueMainSound(slider.getValue());
            } else {
                soundEngine.setValueEffectSound(slider.getValue());
            }
        };
    }

}
