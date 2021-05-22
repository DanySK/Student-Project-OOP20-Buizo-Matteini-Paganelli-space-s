package spaceSurvival.model.GUI.settings;

import spaceSurvival.model.ImageDesign;
import spaceSurvival.utilities.dimension.ScaleOf;
import spaceSurvival.utilities.pathImage.Skin;

public enum SkinSpaceShip {
    SPECIAL(new ImageDesign(ScaleOf.ICON_SKIN, EngineSettings.DIMENSION.width, Skin.SPECIAL)),
    STANDARD(new ImageDesign(ScaleOf.ICON_SKIN, EngineSettings.DIMENSION.width, Skin.STANDARD)),
    DELUXE(new ImageDesign(ScaleOf.ICON_SKIN, EngineSettings.DIMENSION.width, Skin.DELUXE)),
    NORMAL(new ImageDesign(ScaleOf.ICON_SKIN, EngineSettings.DIMENSION.width, Skin.NORMAL)),
    ATOMIC(new ImageDesign(ScaleOf.ICON_SKIN, EngineSettings.DIMENSION.width, Skin.ATOMIC));

    private ImageDesign imageDesign;

    private SkinSpaceShip(final ImageDesign imageDesign){
        this.imageDesign = imageDesign;
    }

    public ImageDesign getEngineImage() {
        return this.imageDesign;
    }
}
