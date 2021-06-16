package spacesurvival.view.sound;

import spacesurvival.model.gui.sound.TypeUnitSound;
import spacesurvival.utilities.ActionGUI;
import spacesurvival.view.GUI;
import spacesurvival.view.sound.utilities.ButtonSliderType;
import spacesurvival.view.sound.utilities.SliderType;
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
