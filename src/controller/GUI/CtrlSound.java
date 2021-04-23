package controller.GUI;

import model.GUI.EngineGUI;
import model.GUI.sound.EngineSound;
import utilities.DesignSound;
import view.GUI.GUI;
import view.GUI.sound.GUISound;
import view.GUI.sound.utilities.ButtonSliderType;
import view.utilities.FactoryGUIs;
import view.GUI.sound.utilities.SliderType;

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
        this.soundGUI.setTypeUnitSound(this.soundEngine.getListTypeUnitSound());
        this.soundGUI.setTitleUnitSound(this.soundEngine.getListNameSlider());
        this.soundGUI.setDefaultValueSlidersSound(this.soundEngine.getDefaultValueSound());
        this.soundGUI.setIconBtnSwitches(this.soundEngine.getIconStateSounds());
        this.soundGUI.setBtnBackID(this.soundEngine.getBackLink());
        this.soundGUI.setVisible(this.soundEngine.isVisible());

        this.soundGUI.getSlidersSound().forEach(slider ->slider.addChangeListener(this.changeListenerSlider()));

        this.soundGUI.getBtnSwitches().forEach(btn -> btn.addActionListener(this.changeSwitchSound()));
    }

    private ChangeListener changeListenerSlider(){
        return e -> {
            final SliderType slider = (SliderType)e.getSource();
            this.soundEngine.setValueUnitSound(slider.getType(), slider.getValue());
        };
    }

    private ActionListener changeSwitchSound(){
        return e -> {
            final ButtonSliderType btnSlider = (ButtonSliderType)e.getSource();

            this.soundEngine.changeStateUnitSound(btnSlider.getTypeSlider());
            FactoryGUIs.setIconInJButtonMini(btnSlider,
                    this.soundEngine.getPathIconUnitSound((btnSlider.getTypeSlider())));

            this.soundGUI.getSliderTypeofMixer(btnSlider.getTypeSlider()).setValue(
                    this.soundEngine.isActiveUnitSound(btnSlider.getTypeSlider()) ?
                            this.soundEngine.getValueUnitSound(btnSlider.getTypeSlider()) : DesignSound.SOUND_ZERO);
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
