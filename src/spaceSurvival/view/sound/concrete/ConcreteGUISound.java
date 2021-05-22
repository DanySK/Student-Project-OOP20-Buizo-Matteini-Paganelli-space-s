package spaceSurvival.view.sound.concrete;

import spaceSurvival.model.GUI.sound.TypeUnitSound;
import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.view.AbstractGUI;
import spaceSurvival.view.sound.GUISound;
import spaceSurvival.view.sound.utilities.ButtonSliderType;
import spaceSurvival.view.sound.utilities.MixerSound;
import spaceSurvival.view.utilities.BtnAction;
import spaceSurvival.view.sound.utilities.SliderType;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ConcreteGUISound extends AbstractGUI implements GUISound {
    private final JLabel lbTitle;
    private final MixerSound mixerSound;
    private final BtnAction btnBack;

    public ConcreteGUISound(){
        super();
        this.lbTitle = new JLabel();
        this.mixerSound = new MixerSound();
        this.btnBack = new BtnAction();
    }

    @Override
    public List<BtnAction> getBtnActionLinks() {
        return List.of(this.btnBack);
    }


    @Override
    public void setNameButtonBack(final String nameBtnBack) {
        this.btnBack.setText(nameBtnBack);
    }

    @Override
    public void setTypeUnitSound(final List<TypeUnitSound> listName) {
        this.mixerSound.setTypeUnitSound(listName);
    }

    @Override
    public void setTitleUnitSound(List<String> listTitle) {
        this.mixerSound.setTitleSlider(listTitle);
    }


    @Override
    public List<SliderType> getSlidersSound() {
        return this.mixerSound.getSliders();
    }

    @Override
    public SliderType getSliderTypeofMixer(final TypeUnitSound typeUnitSound){
        return this.mixerSound.getSliderType(typeUnitSound);
    }

    @Override
    public ButtonSliderType getBtnSwitch(final TypeUnitSound typeUnitSound) {
        return this.mixerSound.getBtnSwitch(typeUnitSound);
    }

    @Override
    public void setDefaultValueSlidersSound(final int value) {
        this.mixerSound.setDefaultValueSlidersSound(value);
    }

    @Override
    public void setBtnBackID(final ActionGUI actionMain, final ActionGUI action) {
        this.btnBack.setActionCurrent(actionMain);
        this.btnBack.setActionNext(action);
    }

    @Override
    public List<ButtonSliderType> getBtnSwitches() {
        return this.mixerSound.getBtnSwitches();
    }

    @Override
    public void setIconBtnSwitches(final List<String> paths) {
        this.mixerSound.setIconBtnSwitches(paths, super.getWidth());
    }


    @Override
    public void setForegroundGUI(final Color color) {
        this.lbTitle.setForeground(color);
        this.mixerSound.setAllForeground(color);
        this.btnBack.setForeground(color);
    }

    @Override
    public void setFontGUITitle(final Font font) {
        this.lbTitle.setFont(font);
    }

    @Override
    public void setFontGUI(final Font font) {
        this.mixerSound.setFontTitleSound(font);
        this.btnBack.setFont(font);
    }

    @Override
    public void setFontSpacingSlider(final Font font) {
        this.mixerSound.setFontSliderSound(font);
    }

    @Override
    public void setTitleGUI(final String title) {
        this.lbTitle.setText(title);
    }


    public JLabel getLbTitle(){
        return this.lbTitle;
    }

    public BtnAction getBtnBack(){
        return this.btnBack;
    }

    public MixerSound getMixerSound(){
        return this.mixerSound;
    }
}
