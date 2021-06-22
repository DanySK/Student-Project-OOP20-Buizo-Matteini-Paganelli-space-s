package spacesurvival.model.gui.settings;

import spacesurvival.utilities.path.animation.AnimationShip;


import java.util.List;

public enum SkinSpaceShip {
    SPECIAL(AnimationShip.SPECIAL0, AnimationShip.LIST_SHIP1),
    STANDARD(AnimationShip.STANDARD0, AnimationShip.LIST_SHIP2),
    DELUXE(AnimationShip.DELUXE0, AnimationShip.LIST_SHIP3),
    NORMAL(AnimationShip.NORMAL0, AnimationShip.LIST_SHIP4),
    ATOMIC(AnimationShip.ATOMIC0, AnimationShip.LIST_SHIP5);

    private final String skin;

    private final List<String> animation;

    private SkinSpaceShip(final String skin, final List<String> animation){
        this.skin = skin;
        this.animation = animation;
    }

    public String getSkin() {
        return this.skin;
    }

    public List<String> getAnimation() {
        return this.animation;
    }
}
