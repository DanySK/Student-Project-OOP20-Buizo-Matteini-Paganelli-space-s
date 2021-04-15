package controller.GUI;

import model.GUI.EngineGUI;
import model.GUI.sound.EngineSound;
import utilities.DesignSound;
import utilities.Engines;
import view.GUI.GUI;
import view.GUI.sound.GUISound;
import view.utilities.FactoryGUIs;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;

public class CtrlSound implements ControllerGUI {
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
        this.soundGUI.setNameTypeSlider(this.soundEngine.getListNameSlider());
        this.soundGUI.setBtnBackID(this.soundEngine.getBackLink());
        this.soundGUI.setVisible(this.soundEngine.isVisible());

        this.soundGUI.setDefaultValueSlidersSound(this.soundEngine.getDefaultValueSound());
        this.soundGUI.getSlidersSound().forEach(slider ->
                slider.addChangeListener(this.changeListenerSlider(slider)));

        this.soundGUI.getBtnSwitchs().forEach(btn -> btn.addActionListener(this.changeSwitchSound(btn)));
    }

    private ChangeListener changeListenerSlider(final JSlider slider){
        return e -> {
            int firstSlider = 0;
            if(slider.getName().contentEquals(soundEngine.getListNameSlider().get(firstSlider))
                    && soundEngine.isActiveSoundMain()){
                soundEngine.setValueMainSound(slider.getValue());
            } else if(slider.getName().contentEquals(soundEngine.getListNameSlider().get(firstSlider + 1))
                    && soundEngine.isActiveSoundEffect()) {
                soundEngine.setValueEffectSound(slider.getValue());
            }
        };
    }

    private ActionListener changeSwitchSound(final JButton btn){
        return e -> {
            int firstUnitSound = 0;
            int secondUnitSound = 1;
            if(btn.getName().contentEquals(soundEngine.getListNameSlider().get(firstUnitSound))){
                this.soundEngine.setStateSoundMain(Engines.inverseStateSlider(this.soundEngine.getStateSoundMain()));
                FactoryGUIs.setIconInJButtonMini(btn, this.soundEngine.isActiveSoundMain() ?
                        this.soundEngine.actualPathStateSoundMain() :
                        Engines.getInversePathStateSlider(this.soundEngine.getStateSoundMain()));

                this.soundGUI.getSlidersSound().get(firstUnitSound).setValue(this.soundEngine.isActiveSoundMain() ?
                        this.soundEngine.getValueMainSound() : DesignSound.SOUND_ZERO);
            } else {
                this.soundEngine.setStateSoundEffect(Engines.inverseStateSlider(this.soundEngine.getStateSoundEffect()));
                FactoryGUIs.setIconInJButtonMini(btn, this.soundEngine.isActiveSoundEffect() ?
                        this.soundEngine.actualPathStateSoundEffect() :
                        Engines.getInversePathStateSlider(this.soundEngine.getStateSoundEffect()));

                this.soundGUI.getSlidersSound().get(secondUnitSound).setValue(this.soundEngine.isActiveSoundEffect() ?
                        this.soundEngine.getValueEffectSound() : DesignSound.SOUND_ZERO);
            }
        };
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
