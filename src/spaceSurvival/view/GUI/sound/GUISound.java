package spaceSurvival.view.GUI.sound;

import spaceSurvival.model.GUI.sound.TypeUnitSound;
import spaceSurvival.utilities.IdGUI;
import spaceSurvival.view.GUI.GUI;
import spaceSurvival.view.GUI.sound.utilities.ButtonSliderType;
import spaceSurvival.view.GUI.sound.utilities.SliderType;

import java.util.List;

public interface GUISound extends GUI, GraphicsGUISound {
    public void setNameButtonBack(final String nameBtnBack);

    public void setTypeUnitSound(final List<TypeUnitSound> listName);

    public void setTitleUnitSound(final List<String> listTitle);

    public List<SliderType> getSlidersSound();

    public SliderType getSliderTypeofMixer(final TypeUnitSound typeUnitSound);

    public ButtonSliderType getBtnSwitch(final TypeUnitSound typeUnitSound);

    public void setDefaultValueSlidersSound(final int value);

    public void setBtnBackID(final IdGUI idGUI);

    public List<ButtonSliderType> getBtnSwitches();

    public void setIconBtnSwitches(final List<String> path);
}
