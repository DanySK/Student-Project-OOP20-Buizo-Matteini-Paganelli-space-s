package spaceSurvival.view.sound;

import spaceSurvival.model.GUI.sound.TypeUnitSound;
import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.view.GUI;
import spaceSurvival.view.sound.utilities.ButtonSliderType;
import spaceSurvival.view.sound.utilities.SliderType;

import java.util.List;

public interface GUISound extends GUI, GraphicsGUISound {

    public void setNameButtonBack(final String nameBtnBack);

    public void setTypeUnitSound(final List<TypeUnitSound> listName);

    public void setTitleUnitSound(final List<String> listTitle);

    public List<SliderType> getSlidersSound();

    public SliderType getSliderTypeofMixer(final TypeUnitSound typeUnitSound);

    public ButtonSliderType getBtnSwitch(final TypeUnitSound typeUnitSound);

    public void setDefaultValueSlidersSound(final int value);

    public void setBtnBackID(final ActionGUI actionMain, final ActionGUI action);

    public List<ButtonSliderType> getBtnSwitches();

    public void setIconBtnSwitches(final List<String> path);
}
