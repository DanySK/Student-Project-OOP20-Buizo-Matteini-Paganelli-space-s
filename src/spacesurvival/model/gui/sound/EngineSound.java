package spacesurvival.model.gui.sound;

import spacesurvival.model.gui.EngineGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.model.EngineImage;
import spacesurvival.utilities.SoundUtils;
import spacesurvival.utilities.dimension.Screen;
import spacesurvival.utilities.LinkActionGUI;

import java.awt.Rectangle;
import java.util.Arrays;
import java.util.List;

/**
 * Implements the model for the sound GUI.
 */
public class EngineSound implements EngineGUI {

    /**
     * Dimension of the rectangle for the GUI.
     */
    public static final Rectangle RECTANGLE = Screen.RECTANGLE_MEDIUM;

    /**
     * Title of the GUI.
     */
    public static final String TITLE = "SOUND";

    /**
     * Number of unit of sound of the GUI.
     */
    public static final int N_UNIT_SOUND = 2;

    private final LinkActionGUI id;
    private final LinkActionGUI idBack;

    private final EngineMixerSound mixerSound;

    
    private Visibility visibility;

    /**
     * 
     */
    public EngineSound() {
        this.id = LinkActionGUI.ID_SOUND;
        this.idBack = LinkActionGUI.ID_BACK;
        this.mixerSound = new EngineMixerSound(Arrays.asList(TypeUnitSound.values()));

        this.visibility = Visibility.HIDDEN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LinkActionGUI getMainLink() {
        return id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Rectangle getRectangle() {
        return RECTANGLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Visibility getVisibility() {
        return this.visibility;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setVisibility(final Visibility visibility) {
        this.visibility = visibility;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isVisible() {
        return this.visibility.isVisible();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<LinkActionGUI> getLinks() {
        return List.of(this.idBack);
    }

    /**
     * Return the title of the gui.
     * 
     * @return the title
     */
    public String getTitle() {
        return TITLE;
    }

    /**
     * Return the back link of this gui.
     * 
     * @return an ActionGUI to go back from this gui
     */
    public LinkActionGUI getBackLink() {
        return this.idBack;
    }

    public String getNameBack() {
        return this.idBack.getIdName();
    }

    public List<String> getListNameSlider() {
        return this.mixerSound.getNameUnitsSound();
    }

    public List<TypeUnitSound> getListTypeUnitSound() {
        return this.mixerSound.getListTypeUnitsSound();
    }

    public int getDefaultValueSound(){
        return SoundUtils.DEFAULT_VALUE_SOUND;
    }

    public int getValueUnitSound(final TypeUnitSound typeUnitSound) {
        return this.mixerSound.getValueSound(typeUnitSound);
    }

    public void setValueUnitSound(final TypeUnitSound typeUnitSound, final int value) {
        this.mixerSound.setValueSound(typeUnitSound, value);
    }

    public StateSlider getStateUnitSound(final TypeUnitSound typeUnitSound) {
        return this.mixerSound.getStateSound(typeUnitSound);
    }

    public void setStateUnitSound(final TypeUnitSound typeUnitSound, final StateSlider stateUnitSound) {
        this.mixerSound.setStateSound(typeUnitSound, stateUnitSound);
    }

    public boolean isActiveUnitSound(final TypeUnitSound typeUnitSound) {
        return this.mixerSound.isActiveSound(typeUnitSound);
    }

    public EngineImage getEngineImageUnitSound(final TypeUnitSound typeUnitSound) {
        return this.mixerSound.getStateSound(typeUnitSound).getEngineImage();
    }

    public void changeStateUnitSound(final TypeUnitSound typeUnitSound) {
        this.mixerSound.changeStateSound(typeUnitSound);
    }

    public String getPathIconUnitSound(final TypeUnitSound typeUnitSound) {
        return this.mixerSound.getPathIconState(typeUnitSound);
    }

    public List<String> getIconStateSounds() {
        return this.mixerSound.getPathsIconState();
    }
}
