package view.GUI.sound.concrete;

import model.GUI.sound.TypeUnitSound;
import utilities.IdGUI;
import view.GUI.AbstractGUI;
import view.GUI.sound.GUISound;
import view.GUI.sound.utilities.ButtonSliderType;
import view.GUI.sound.utilities.MixerSound;
import view.utilities.ButtonID;
import view.GUI.sound.utilities.SliderType;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ConcreteGUISound extends AbstractGUI implements GUISound {
    private final JLabel lbTitle;
    private final MixerSound mixerSound;
    private final ButtonID btnBack;

    public ConcreteGUISound(){
        super();
        this.lbTitle = new JLabel();
        this.mixerSound = new MixerSound();
        this.btnBack = new ButtonID();
    }

    @Override
    public List<ButtonID> getButtonLinks() {
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
    public void setDefaultValueSlidersSound(final int value) {
        this.mixerSound.setDefaultValueSlidersSound(value);
    }

    @Override
    public void setBtnBackID(final IdGUI idGUI) {
        this.btnBack.setIdGUICurrent(this.getId());
        this.btnBack.setIdGUINext(idGUI);
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

    public ButtonID getBtnBack(){
        return this.btnBack;
    }

    public MixerSound getMixerSound(){
        return this.mixerSound;
    }
}
