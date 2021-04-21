package view.GUI.sound;

import utilities.IdGUI;
import view.GUI.GUI;

import javax.swing.*;
import java.util.List;

public interface GUISound extends GUI, GraphicsGUISound {
    public void setNameButtonBack(final String nameBtnBack);

    public void setNameTypeSlider(final List<String> listName);

    public List<JSlider> getSlidersSound();

    public void setDefaultValueSlidersSound(final int value);

    public void setBtnBackID(final IdGUI idGUI);

    public List<JButton> getBtnSwitches();

    public void setIconBtnSwitches(final List<String> path);
}
