package view.GUI.sound;

import model.GUI.sound.TypeUnitSound;
import utilities.IdGUI;
import view.GUI.GUI;
import view.GUI.sound.utilities.ButtonSliderType;
import view.GUI.sound.utilities.SliderType;

import java.util.List;

public interface GUISound extends GUI, GraphicsGUISound {
    public void setNameButtonBack(final String nameBtnBack);

    public void setTypeUnitSound(final List<TypeUnitSound> listName);

    public void setTitleUnitSound(final List<String> listTitle);

    public List<SliderType> getSlidersSound();

    public SliderType getSliderTypeofMixer(final TypeUnitSound typeUnitSound);

    public void setDefaultValueSlidersSound(final int value);

    public void setBtnBackID(final IdGUI idGUI);

    public List<ButtonSliderType> getBtnSwitches();

    public void setIconBtnSwitches(final List<String> path);
}
