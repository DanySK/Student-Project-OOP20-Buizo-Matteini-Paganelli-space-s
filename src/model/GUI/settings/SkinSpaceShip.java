package model.GUI.settings;

import model.image.EngineImage;
import utilities.dimension.ScaleOf;
import utilities.pathImage.Skin;

public enum SkinSpaceShip {
    SPECIAL(new EngineImage(ScaleOf.ICON_SKIN, EngineSettings.DIMENSION_GUI.width, Skin.SPECIAL)),
    STANDARD(new EngineImage(ScaleOf.ICON_SKIN, EngineSettings.DIMENSION_GUI.width, Skin.STANDARD)),
    DELUXE(new EngineImage(ScaleOf.ICON_SKIN, EngineSettings.DIMENSION_GUI.width, Skin.DELUXE)),
    NORMAL(new EngineImage(ScaleOf.ICON_SKIN, EngineSettings.DIMENSION_GUI.width, Skin.NORMAL));

    private EngineImage engineImage;

    private SkinSpaceShip(final EngineImage engineImage){
        this.engineImage = engineImage;
    }

    public EngineImage getEngineImage() {
        return this.engineImage;
    }
}
