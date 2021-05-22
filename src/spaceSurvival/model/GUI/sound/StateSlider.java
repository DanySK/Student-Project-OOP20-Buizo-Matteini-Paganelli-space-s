package spaceSurvival.model.GUI.sound;

import spaceSurvival.model.ImageDesign;
import spaceSurvival.utilities.dimension.ScaleOf;
import spaceSurvival.utilities.pathImage.Icon;

public enum StateSlider {
    ON(true, new ImageDesign(ScaleOf.ICON_MEDIUM, EngineSound.DIMENSION.width, Icon.SOUND_ON)),
    OFF(false, new ImageDesign(ScaleOf.ICON_MEDIUM,  EngineSound.DIMENSION.width, Icon.SOUND_OFF));

    private final boolean state;
    private final ImageDesign imageDesign;

    private StateSlider(final boolean state, final ImageDesign imageDesign){
        this.state = state;
        this.imageDesign = imageDesign;
    }

    public boolean isActive() {
        return this.state;
    }

    public ImageDesign getEngineImage(){
        return this.imageDesign;
    }

    @Override
    public String toString() {
        return "StateSlider{" +
                "state=" + state +
                ", engineImage=" + imageDesign + '}';
    }
}
