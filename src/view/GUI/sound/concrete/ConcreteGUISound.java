package view.GUI.sound.concrete;

import utilities.IdGUI;
import view.GUI.AbstractGUI;
import view.GUI.sound.GUISound;
import view.GUI.sound.utilities.MixerSound;
import view.utilities.ButtonID;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ConcreteGUISound extends AbstractGUI implements GUISound {
    private JLabel lbTitle;
    private MixerSound mixerSound;
    private ButtonID btnBack;

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
    public void setForegroundGUI(Color color) {
        this.lbTitle.setForeground(color);
        this.mixerSound.setAllForeground(color);
        this.btnBack.setForeground(color);
    }

    @Override
    public void setFontGUITitle(Font font) {
        this.lbTitle.setFont(font);
    }

    @Override
    public void setFontGUI(Font font) {
        this.mixerSound.setFontTitleSound(font);
        this.btnBack.setFont(font);
    }

    @Override
    public void setFontSpacingSlider(Font font) {
        this.mixerSound.setFontSliderSound(font);
    }


    @Override
    public void setTitleGUI(String title) {
        this.lbTitle.setText(title);
    }


    @Override
    public void setNameComponents(List<String> listName) {
        int i = MixerSound.N_SOUND;
        this.mixerSound.setTitleSlider(listName);
        this.btnBack.setText(listName.get(i++));
    }

    @Override
    public void setNameTypeSlider(List<String> listName) {
        this.mixerSound.setNameSlider(listName);
    }

    @Override
    public List<JSlider> getSlidersSound() {
        return this.mixerSound.getSliders();
    }

    @Override
    public void setDefaultValueSlidersSound(final int value) {
        this.mixerSound.setDefaultValueSlidersSound(value);
    }

    @Override
    public void setBtnBackID(IdGUI idGUI) {
        this.btnBack.setIdGUICurrent(this.getId());
        this.btnBack.setIdGUINext(idGUI);
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
