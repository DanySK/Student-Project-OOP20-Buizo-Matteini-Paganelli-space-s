package model.GUI.sound;

import utilities.DesignSound;

public class EngineUnitSound {
    private int valueSound;
    private StateSlider stateSlider;

    public EngineUnitSound() {
        this.valueSound = DesignSound.DEFAULT_VALUE_SOUND;
        this.stateSlider = StateSlider.ON;
    }

    public int getValueSound() {
        return this.valueSound;
    }

    public void setValueSound(final int valueSound) {
        this.valueSound = valueSound;
    }

    public StateSlider getStateSlider() {
        return this.stateSlider;
    }

    public void setStateSlider(final StateSlider stateSlider) {
        this.stateSlider = stateSlider;
    }

    public String getPathIconState() {
        return this.stateSlider.getPath();
    }

    public boolean isActiveSlider(){
        return this.stateSlider.isActive();
    }
}
