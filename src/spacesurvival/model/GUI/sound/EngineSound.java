package spacesurvival.model.GUI.sound;

import spacesurvival.model.GUI.EngineGUI;
import spacesurvival.model.GUI.Visibility;
import spacesurvival.model.EngineImage;
import spacesurvival.utilities.DesignSound;

import spacesurvival.utilities.dimension.Screen;
import spacesurvival.utilities.ActionGUI;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class EngineSound implements EngineGUI {
    public static final Rectangle RECTANGLE = Screen.RECTANGLE_MEDIUM;
    public static final String TITLE = "SOUND";

    public static int N_UNIT_SOUND = 2;

    private final ActionGUI id;
    private final ActionGUI idBack;

    private final EngineMixerSound mixerSound;

    private Visibility visibility;

    public EngineSound(){
        this.id = ActionGUI.ID_SOUND;
        this.idBack = ActionGUI.ID_BACK;
        this.mixerSound = new EngineMixerSound(Arrays.asList(TypeUnitSound.values()));

        this.visibility = Visibility.HIDDEN;
    }

    @Override
    public ActionGUI getMainAction() {
        return id;
    }

    @Override
    public Rectangle getRectangle() {
        return RECTANGLE;
    }

    @Override
    public Visibility getVisibility() {
        return this.visibility;
    }

    @Override
    public void setVisibility(final Visibility visibility) {
        this.visibility = visibility;
    }

    @Override
    public boolean isVisible() {
        return this.visibility.isVisible();
    }

    @Override
    public List<ActionGUI> getLinks() {
        return List.of(this.idBack);
    }


    public String getTitle() {
        return TITLE;
    }

    public ActionGUI getBackLink(){
        return this.idBack;
    }

    public String getNameBack() {
        return this.idBack.getIdName();
    }

    public List<String> getListNameSlider(){
        return this.mixerSound.getNameUnitsSound();
    }

    public List<TypeUnitSound> getListTypeUnitSound(){
        return this.mixerSound.getListTypeUnitsSound();
    }

    public int getDefaultValueSound(){
        return DesignSound.DEFAULT_VALUE_SOUND;
    }

    public int getValueUnitSound(final TypeUnitSound typeUnitSound){
        return this.mixerSound.getValueSound(typeUnitSound);
    }

    public void setValueUnitSound(final TypeUnitSound typeUnitSound, final int value){
        this.mixerSound.setValueSound(typeUnitSound, value);
    }

    public StateSlider getStateUnitSound(final TypeUnitSound typeUnitSound){
        return this.mixerSound.getStateSound(typeUnitSound);
    }

    public void setStateUnitSound(final TypeUnitSound typeUnitSound, final StateSlider stateUnitSound){
        this.mixerSound.setStateSound(typeUnitSound, stateUnitSound);
    }

    public boolean isActiveUnitSound(final TypeUnitSound typeUnitSound){
        return this.mixerSound.isActiveSound(typeUnitSound);
    }

    public EngineImage getEngineImageUnitSound(final TypeUnitSound typeUnitSound){
        return this.mixerSound.getStateSound(typeUnitSound).getEngineImage();
    }

    public void changeStateUnitSound(final TypeUnitSound typeUnitSound){
        this.mixerSound.changeStateSound(typeUnitSound);
    }

    public String getPathIconUnitSound(final TypeUnitSound typeUnitSound){
        return this.mixerSound.getPathIconState(typeUnitSound);
    }

    public List<String> getIconStateSounds(){
        return this.mixerSound.getPathsIconState();
    }
}
