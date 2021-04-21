package model.GUI.sound;

import utilities.DesignSound;

public class EngineUnitSound {
    private int valueSound;
    private StateSlider stateSlider;

    public EngineUnitSound(){
        this.valueSound = DesignSound.DEFAULT_VALUE_SOUND;
        this.stateSlider = StateSlider.ON;
    }

    public int getValueSound() {
        return this.valueSound;
    }

    public void setValueSound(int valueSound) {
        this.valueSound = valueSound;
    }

    public StateSlider getStateSlider() {
        return this.stateSlider;
    }

    public void setStateSlider(StateSlider stateSlider) {
        this.stateSlider = stateSlider;
    }
}
