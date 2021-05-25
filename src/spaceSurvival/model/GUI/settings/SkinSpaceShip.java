package spaceSurvival.model.GUI.settings;

import spaceSurvival.utilities.pathImage.Skin;

public enum SkinSpaceShip {
    SPECIAL(Skin.SPECIAL0),
    STANDARD(Skin.STANDARD0),
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
