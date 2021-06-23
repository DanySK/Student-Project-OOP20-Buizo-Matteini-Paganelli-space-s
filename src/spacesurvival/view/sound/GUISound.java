package spacesurvival.view.sound;

import spacesurvival.model.gui.sound.TypeUnitSound;
import spacesurvival.utilities.LinkActionGUI;
import spacesurvival.view.GUI;
import spacesurvival.view.sound.utilities.ButtonSliderType;
import spacesurvival.view.sound.utilities.SliderType;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.Optional;

/**
 * Interface that implements the sound functionalities.
 */
public interface GUISound extends GUI {

    /**
     * Set text a back button.
     * @param textBtnBack for button.
     */
    void setTextButtonBack(String textBtnBack);

    /**
     * Set text a list of TypeUnitSound.
     * @param listText for list of TypeUnitSound.
     */
    void setTypeUnitSound(List<TypeUnitSound> listText);

    /**
     * Set title a all TypeUnitSound.
     * @param listTitle for all TypeUnitSound.
     */
    void setTitleUnitSound(List<String> listTitle);

    /**
     * Get a list of TypeUnitSound.
     * @return SliderType is unit sound.
     */
    List<SliderType> getSlidersSound();

    /**
     * Get slider from the mixer from the unit type if present.
     * @param typeUnitSound is type of unit sound.
     * @return SliderType is unit sound.
     */
    Optional<SliderType> getSliderTypeofMixer(TypeUnitSound typeUnitSound);

    /**
     * Get button from the mixer from the unit type if present.
     * @param typeUnitSound is type of unit sound.
     * @return ButtonSliderType is button switch for unit sound.
     */
    Optional<ButtonSliderType> getBtnSwitch(TypeUnitSound typeUnitSound);

    /**
     * Set value a mixer sound, set value all unit sound.
     * @param value for set.
     */
    void setValueMixerSound(int value);

    /**
     * Set linkAction a back buttonLink.
     * @param actionMain is linkAction a current GUI.
     * @param linkAction for link previous GUI.
     */
    void setBtnBackID(LinkActionGUI actionMain, LinkActionGUI linkAction);

    /**
     * Get a list of switches button.
     * @return List<ButtonSliderType>
     */
    List<ButtonSliderType> getBtnSwitches();

    /**
     * Set iconImage for buttons switches sound.
     * @param path for iconImage.
     */
    void setIconBtnSwitches(List<String> path);

    /**
     * Set color foreground GUI.
     * @param color for foreground.
     */
    void setForegroundGUI(Color color);

    /**
     * Set font title GUI.
     * @param font for title.
     */
    void setFontGUITitle(Font font);

    /**
     * Set font GUI, all unit sound. 
     * @param font for GUI.
     */
    void setFontGUI(Font font);

    /**
     * Set font spacing slider.
     * @param font for spacing slider.
     */
    void setFontSpacingSlider(Font font);

    /**
     * Set title GUI.
     * @param title for GUI.
     */
    void setTitleGUI(String title);
}
