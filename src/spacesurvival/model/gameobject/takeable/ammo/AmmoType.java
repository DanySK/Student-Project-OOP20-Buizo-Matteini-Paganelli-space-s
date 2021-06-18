package spacesurvival.model.gameobject.takeable.ammo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import spacesurvival.model.gameobject.Effect;
import spacesurvival.utilities.path.bullet.BulletFire;
import spacesurvival.utilities.path.bullet.BulletHUD;
import spacesurvival.utilities.path.Weapon;
import spacesurvival.utilities.path.animation.AnimationPerk;

public enum AmmoType {

    NORMAL(Effect.NONE, List.of(), Weapon.NORMAL, BulletHUD.NORMAL, BulletFire.NORMAL, ""),
    FIRE(Effect.FIRE, AnimationPerk.LIST_FIRE, Weapon.FIRE, BulletHUD.FIRE, BulletFire.FIRE, AnimationPerk.FIRE0),
    ELECTRIC(Effect.ELECTRIC, AnimationPerk.LIST_ELECTRIC, Weapon.ELECTRIC, BulletHUD.ELECTRIC, BulletFire.ELECTRIC, AnimationPerk.ELECTRIC0),
    ICE(Effect.ICE, AnimationPerk.LIST_ICE, Weapon.ICE, BulletHUD.ICE, BulletFire.ICE, AnimationPerk.ICE0);

    private final Effect effect;
    private List<String> animation;
    private final String weapon;
    private final String bulletHud;
    private final String bulletFire;
    private final String bulletInit;

    private static final List<AmmoType> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    AmmoType(final Effect effect, final List<String> animation, final String weapon, final String bulletHUD,
            final String bulletFire, final String bulletInit) {
        this.effect = effect;
        this.animation = animation;
        this.weapon = weapon;
        this.bulletHud = bulletHUD;
        this.bulletFire = bulletFire;
        this.bulletInit = bulletInit;
    }

    public String getWeapon() {
        return this.weapon;
    }

    public List<String> getAnimation() {
        return animation;
    }

    public void setAnimation(final List<String> animation) {
        this.animation = animation;
    }

    public String getBulletHud() {
        return this.bulletHud;
    }

    public String getBulletFire() {
        return this.bulletFire;
    }

    public Effect getEffect() {
        return this.effect;
    }

    public static AmmoType random()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

}
