package spacesurvival.model.gameobject;

import spacesurvival.utilities.gameobject.BulletUtils;
import spacesurvival.utilities.gameobject.DurationUtils;
import spacesurvival.utilities.path.AnimationEffect;

import java.util.List;

public enum Status {
    NORMAL(AnimationEffect.LIST_NORMAL),
    INVINCIBLE(AnimationEffect.LIST_INVINCIBLE, DurationUtils.INVINCIBLE),
    ON_FIRE(AnimationEffect.LIST_BURN, DurationUtils.ON_FIRE),
    FROZEN(AnimationEffect.LIST_ICE, DurationUtils.FROZEN),
    PARALIZED(AnimationEffect.LIST_ELECTRIC, DurationUtils.PARALIZED),
    HEALED(AnimationEffect.LIST_LIFE_UP),
    LIVES_INCREASED(AnimationEffect.LIST_HEALED);

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
