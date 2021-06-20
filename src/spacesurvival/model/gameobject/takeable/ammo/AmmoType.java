package spacesurvival.model.gameobject.takeable.ammo;

import java.util.List;

import spacesurvival.model.gameobject.Effect;
import spacesurvival.utilities.path.bullet.BulletFire;
import spacesurvival.utilities.path.bullet.BulletHUD;
import spacesurvival.utilities.RandomUtils;
import spacesurvival.utilities.path.Weapon;
import spacesurvival.utilities.path.animation.AnimationPerk;

public enum AmmoType {
    /**
     * It has no effect on the harmed object.
     */
    NORMAL(Effect.NONE, List.of(), Weapon.NORMAL, BulletHUD.NORMAL, BulletFire.NORMAL, ""),
    /**
     * Causes fire effect on the harmed object.
     */
    FIRE(Effect.FIRE, AnimationPerk.LIST_FIRE, Weapon.FIRE, BulletHUD.FIRE, BulletFire.FIRE, AnimationPerk.FIRE0),
    /**
     * Causes electric effect on the harmed object.
     */
    ELECTRIC(Effect.ELECTRIC, AnimationPerk.LIST_ELECTRIC, Weapon.ELECTRIC, BulletHUD.ELECTRIC, BulletFire.ELECTRIC, AnimationPerk.ELECTRIC0),
    /**
     * Causes ice effect on the harmed object.
     */
    ICE(Effect.ICE, AnimationPerk.LIST_ICE, Weapon.ICE, BulletHUD.ICE, BulletFire.ICE, AnimationPerk.ICE0);

    private final Effect effect;
    private final List<String> animation;
    private final String imagePath;
    private final String bulletHud;
    private final String bulletFire;
    private final String bulletInit;

    private static final List<AmmoType> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();

    AmmoType(final Effect effect, final List<String> animation, final String imagePath, final String bulletHUD,
            final String bulletFire, final String bulletInit) {
        this.effect = effect;
        this.animation = animation;
        this.imagePath = imagePath;
        this.bulletHud = bulletHUD;
        this.bulletFire = bulletFire;
        this.bulletInit = bulletInit;
    }

    /**
     * @return the effect caused by 
     */
    public Effect getEffect() {
        return this.effect;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    /**
     * @return the list of paths for the ammo type animation
     */
    public List<String> getAnimation() {
        return animation;
    }

    public String getBulletHud() {
        return this.bulletHud;
    }

    public String getBulletFire() {
        return this.bulletFire;
    }

    public String getBulletInit() {
        return bulletInit;
    }

    /**
     * @return a random ammo type
     */
    public static AmmoType random()  {
        return VALUES.get(RandomUtils.RANDOM.nextInt(SIZE));
    }

}
