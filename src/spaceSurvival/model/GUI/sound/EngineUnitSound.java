package spaceSurvival.model.GUI.sound;

import spaceSurvival.utilities.DesignSound;

public class EngineUnitSound {
    private int valueBackup;
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
        this.valueBackup = valueSound != DesignSound.SOUND_ZERO ? this.valueSound : this.valueBackup;
    }

    public StateSlider getStateSlider() {
        return this.stateSlider;
    }

    public void setStateSlider(final StateSlider stateSlider) {
        this.stateSlider = stateSlider;
    }

    public String getPathIconState() {
        return this.stateSlider.getEngineImage().getPath();
    }

    public boolean isActiveSlider(){
        return this.stateSlider.isActive();
    }

    public int getValueBackup(){
        return this.valueBackup;
    }
}
