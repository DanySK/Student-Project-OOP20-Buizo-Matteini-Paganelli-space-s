package spaceSurvival.model.GUI.settings;

import spaceSurvival.utilities.pathImage.Skin.SkinShip;

import java.util.List;

public enum SkinSpaceShip {
    SPECIAL(SkinShip.SPECIAL0, SkinShip.LIST_SHIP1),
    STANDARD(SkinShip.STANDARD0, SkinShip.LIST_SHIP2),
    DELUXE(SkinShip.DELUXE0, SkinShip.LIST_SHIP1),
    NORMAL(SkinShip.NORMAL0, SkinShip.LIST_SHIP1),
    ATOMIC(SkinShip.ATOMIC0, SkinShip.LIST_SHIP1);

    private final String skin;

    private final List<String> animation;
    private SkinSpaceShip(final String skin, final List<String> animation){
        this.skin = skin;
        this.animation = animation;
    }

    public String getSkin() {
        return this.skin;
    }
}
