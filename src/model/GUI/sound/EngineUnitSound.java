package model.GUI.sound;

import utilities.DesignSound;

public class EngineUnitSound {
    private int valueSound;
    private StateSlider stateSlider;
    private NameUnitSound nameUnitSound;

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

    public NameUnitSound getNameUnitSound() {
        return this.nameUnitSound;
    }

    public void setNameUnitSound(NameUnitSound nameUnitSound) {
        this.nameUnitSound = nameUnitSound;
    }
}
