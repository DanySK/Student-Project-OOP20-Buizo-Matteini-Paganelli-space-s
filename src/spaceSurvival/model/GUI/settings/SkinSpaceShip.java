package spaceSurvival.model.GUI.settings;

import spaceSurvival.model.image.EngineImage;
import spaceSurvival.utilities.dimension.ScaleOf;
import spaceSurvival.utilities.pathImage.Skin;

public enum SkinSpaceShip {
    SPECIAL(new EngineImage(ScaleOf.ICON_SKIN, EngineSettings.DIMENSION.width, Skin.SPECIAL)),
    STANDARD(new EngineImage(ScaleOf.ICON_SKIN, EngineSettings.DIMENSION.width, Skin.STANDARD)),
    DELUXE(new EngineImage(ScaleOf.ICON_SKIN, EngineSettings.DIMENSION.width, Skin.DELUXE)),
    NORMAL(new EngineImage(ScaleOf.ICON_SKIN, EngineSettings.DIMENSION.width, Skin.NORMAL)),
    ATOMIC(new EngineImage(ScaleOf.ICON_SKIN, EngineSettings.DIMENSION.width, Skin.ATOMIC));

    private EngineImage engineImage;

    private SkinSpaceShip(final EngineImage engineImage){
        this.engineImage = engineImage;
    }

    public EngineImage getEngineImage() {
        return this.engineImage;
    }
}
