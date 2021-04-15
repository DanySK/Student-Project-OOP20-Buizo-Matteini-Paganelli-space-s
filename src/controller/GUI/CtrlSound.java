package controller.GUI;

import model.GUI.EngineGUI;
import model.GUI.sound.EngineSound;
import view.GUI.GUI;
import view.GUI.sound.GUISound;
import view.utilities.FactoryGUIs;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;

public class CtrlSound implements ControlGUI{
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
        this.soundGUI.setBtnBackID(this.soundEngine.getBackLink());
        this.soundGUI.setVisible(this.soundEngine.getState());

        this.soundGUI.setDefaultValueSlidersSound(this.soundEngine.getDefaultValueSound());
        this.soundGUI.getSlidersSound().forEach(slider ->
                slider.addChangeListener(this.changeListenerSlider(slider)));

        this.soundGUI.getBtnSwitchs().forEach(btn -> btn.addActionListener(this.changeSwitchSound(btn)));
    }

    private ChangeListener changeListenerSlider(final JSlider slider){
        return e -> {
            int firstSlider = 0;
            if(slider.getName().contentEquals(soundEngine.getListNameSlider().get(firstSlider))
                    && soundEngine.getStateSoundMain()){
                soundEngine.setValueMainSound(slider.getValue());
            } else if(slider.getName().contentEquals(soundEngine.getListNameSlider().get(firstSlider + 1))
                    && soundEngine.getStateSoundEffect()) {
                soundEngine.setValueEffectSound(slider.getValue());
            }
        };
    }

    private ActionListener changeSwitchSound(final JButton btn){
        return e -> {
            int firstUnitSound = 0;
            if(btn.getName().contentEquals(soundEngine.getListNameSlider().get(firstUnitSound))){
                this.soundEngine.setStateSoundMain(!this.soundEngine.getStateSoundMain());
                FactoryGUIs.setIconInJButtonMini(btn, this.soundEngine.getStateSoundMain() ? "iconButton/volumeON.png" :
                        "iconButton/volumeOFF.png" );

                this.soundGUI.getSlidersSound().get(firstUnitSound).setValue(this.soundEngine.getStateSoundMain() ?
                        this.soundEngine.getValueMainSound() : 0);
            } else {
                this.soundEngine.setStateSoundEffect(!this.soundEngine.getStateSoundEffect());
                FactoryGUIs.setIconInJButtonMini(btn, this.soundEngine.getStateSoundEffect() ? "iconButton/volumeON.png" :
                        "iconButton/volumeOFF.png" );

                this.soundGUI.getSlidersSound().get(firstUnitSound + 1).setValue(this.soundEngine.getStateSoundEffect() ?
                        this.soundEngine.getValueEffectSound() : 0);
            }
        };
    }

    public GUI getGUI() {
        return this.soundGUI;
    }

    public EngineGUI getEngine() {
        return this.soundEngine;
    }
}
