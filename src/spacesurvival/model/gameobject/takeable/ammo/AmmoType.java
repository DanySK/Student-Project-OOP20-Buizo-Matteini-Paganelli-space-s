package spacesurvival.model.gameobject.takeable.ammo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import spacesurvival.model.gameobject.Effect;
import spacesurvival.utilities.path.BulletFire;
import spacesurvival.utilities.path.BulletHUD;
import spacesurvival.utilities.path.Weapon;
import spacesurvival.utilities.path.skin.SkinPerk;

public enum AmmoType {

    NORMAL(Effect.NONE, List.of(), Weapon.NORMAL, BulletHUD.NORMAL, BulletFire.NORMAL, ""),
    FIRE(Effect.FIRE, SkinPerk.LIST_FIRE, Weapon.FIRE, BulletHUD.FIRE, BulletFire.FIRE, SkinPerk.FIRE0),
    ELECTRIC(Effect.ELECTRIC, SkinPerk.LIST_ELECTRIC, Weapon.ELECTRIC, BulletHUD.ELECTRIC, BulletFire.ELECTRIC, SkinPerk.ELECTRIC0),
    ICE(Effect.ICE, SkinPerk.LIST_ICE, Weapon.ICE, BulletHUD.ICE, BulletFire.ICE, SkinPerk.ICE0);

    private final Effect effect;
    private List<String> animation;
    private final String weapon;
    private final String bulletHud;
    private final String bulletFire;
    private final String initBullet;

    private static final List<AmmoType> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    AmmoType(final Effect effect, final List<String> animation, final String weapon, final String bulletHUD,
            final String bulletFire, final String initBullet) {
        this.effect = effect;
        this.animation = animation;
        this.weapon = weapon;
        this.bulletHud = bulletHUD;
        this.bulletFire = bulletFire;
        this.initBullet = initBullet;
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
