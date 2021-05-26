package spaceSurvival.model.GUI.settings;

import spaceSurvival.utilities.pathImage.Skin.SkinShip;

public enum SkinSpaceShip {
    SPECIAL(SkinShip.SPECIAL0),
    STANDARD(SkinShip.STANDARD0),
    DELUXE(SkinShip.DELUXE0),
    NORMAL(SkinShip.NORMAL0),
    ATOMIC(SkinShip.ATOMIC0);

    private String skin;

    private SkinSpaceShip(final String skin){
        this.skin = skin;
    }

    public String getSkin() {
        return this.skin;
    }
}
