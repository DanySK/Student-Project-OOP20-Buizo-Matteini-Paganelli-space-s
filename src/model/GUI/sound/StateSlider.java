package model.GUI.sound;

import model.image.EngineImage;
import utilities.DimensionScreen;

public enum StateSlider {
    ON(true, new EngineImage(100, EngineSound.GUI_WIDTH, "icon/volumeON.png")),
    OFF(false, new EngineImage(100,  EngineSound.GUI_WIDTH, "icon/volumeOFF.png"));

    private final boolean state;
    private final EngineImage engineImage;

    private StateSlider(final boolean state, final EngineImage engineImage){
        this.state = state;
        this.engineImage = engineImage;
    }

    public boolean isActive() {
        return this.state;
    }

    public EngineImage getEngineImage(){
        return this.engineImage;
    }

    @Override
    public String toString() {
        return "StateSlider{" +
                "state=" + state +
                ", engineImage=" + engineImage + '}';
    }
}
