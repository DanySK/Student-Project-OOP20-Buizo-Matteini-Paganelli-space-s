package spaceSurvival.model.GUI.sound;

import spaceSurvival.model.image.EngineImage;
import spaceSurvival.utilities.dimension.ScaleOf;
import spaceSurvival.utilities.pathImage.Icon;

public enum StateSlider {
    ON(true, new EngineImage(ScaleOf.ICON_MEDIUM, EngineSound.DIMENSION.width, Icon.SOUND_ON)),
    OFF(false, new EngineImage(ScaleOf.ICON_MEDIUM,  EngineSound.DIMENSION.width, Icon.SOUND_OFF));

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
