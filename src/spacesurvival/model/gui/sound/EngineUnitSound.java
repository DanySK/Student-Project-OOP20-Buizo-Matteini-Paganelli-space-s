package spacesurvival.model.gui.sound;

import spacesurvival.utilities.SoundUtils;

/**
 * Implements the model for the unit sound.
 */
public class EngineUnitSound {
    private int valueSound;
    private StateSlider stateSlider;

    /**
     * 
     */
    public EngineUnitSound() {
        this.valueSound = SoundUtils.DEFAULT_VALUE_SOUND;
        this.stateSlider = StateSlider.ON;
    }

    /**
     * 
     * @return
     */
    public int getValueSound() {
        return this.valueSound;
    }

    /**
     * 
     * @param valueSound
     */
    public void setValueSound(final int valueSound) {
        this.valueSound = valueSound;
    }

    /**
     * 
     * @return
     */
    public StateSlider getStateSlider() {
        return this.stateSlider;
    }

    /**
     * 
     * @param stateSlider
     */
    public void setStateSlider(final StateSlider stateSlider) {
        this.stateSlider = stateSlider;
    }

    /**
     * 
     * @return
     */
    public String getPathIconState() {
        return this.stateSlider.getEngineImage().getPath();
    }

    /**
     * 
     * @return
     */
    public boolean isActiveSlider(){
        return this.stateSlider.isActive();
    }

}
