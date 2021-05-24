package spaceSurvival.model.GUI.settings;

import spaceSurvival.model.EngineImage;
import spaceSurvival.utilities.dimension.ScaleOf;
import spaceSurvival.utilities.pathImage.Skin;

public enum SkinSpaceShip {
    SPECIAL(Skin.SPECIAL),
    STANDARD(Skin.STANDARD),
    DELUXE(Skin.DELUXE),
    NORMAL(Skin.NORMAL),
    ATOMIC(Skin.ATOMIC);

    private String skin;

    private SkinSpaceShip(final String skin){
        this.skin = skin;
    }

    public String getSkin() {
        return this.skin;
    }
}
