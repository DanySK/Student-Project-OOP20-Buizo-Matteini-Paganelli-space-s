package spacesurvival.model.gameobject;

import spacesurvival.utilities.gameobject.BulletUtils;
import spacesurvival.utilities.path.AnimationEffect;

import java.util.List;

public enum Status {
    NORMAL(AnimationEffect.LIST_NORMAL),
    INVINCIBLE(AnimationEffect.LIST_INVINCIBLE, GameObjectUtils.INVINCIBLE_DURATION),
    ON_FIRE(AnimationEffect.LIST_BURN, GameObjectUtils.ON_FIRE_DURATION),
    FROZEN(AnimationEffect.LIST_ICE, GameObjectUtils.FROZEN_DURATION),
    PARALIZED(List.of(), GameObjectUtils.PARALIZED_DURATION),
    HEALED(AnimationEffect.LIST_LIFE_UP),
    LIVES_INCREASED(List.of());

    private final List<String> animation;
    private final int duration;

    Status(final List<String> animation) {
        this.animation = animation;
        this.duration = BulletUtils.INFINITY;
    }
	
    Status(final List<String> animation, final int duration) {
        this.animation = animation;
        this.duration = duration;
    }

    /**
     * @return the animation for game object when suffering from an effect
     */
    public List<String> getAnimation() {
        return this.animation;
    }

    /**
     * @return the effect duration
     */
    public int getDuration() {
        return duration;
    }



}
