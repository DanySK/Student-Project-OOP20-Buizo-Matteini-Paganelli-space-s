package spacesurvival.view.sound;

import spacesurvival.model.gui.sound.TypeUnitSound;
import spacesurvival.utilities.ActionGUI;
import spacesurvival.view.GUI;
import spacesurvival.view.sound.utilities.ButtonSliderType;
import spacesurvival.view.sound.utilities.SliderType;
import java.util.List;

public interface GUISound extends GUI, GraphicsGUISound {

    void setNameButtonBack(String nameBtnBack);

    void setTypeUnitSound(List<TypeUnitSound> listName);

    void setTitleUnitSound(List<String> listTitle);

    List<SliderType> getSlidersSound();

    SliderType getSliderTypeofMixer(TypeUnitSound typeUnitSound);

    ButtonSliderType getBtnSwitch(TypeUnitSound typeUnitSound);

    void setDefaultValueSlidersSound(int value);

    void setBtnBackID(ActionGUI actionMain, ActionGUI action);

    List<ButtonSliderType> getBtnSwitches();

    void setIconBtnSwitches(List<String> path);
}
