package spacesurvival.model.gameobject.takeable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import spacesurvival.utilities.path.Weapon;
import spacesurvival.utilities.path.BulletHUD;
import spacesurvival.utilities.path.BulletFire;
import spacesurvival.model.gameobject.Effect;

public enum AmmoType {
    NORMAL(Effect.NONE, Weapon.NORMAL, BulletHUD.NORMAL, BulletFire.NORMAL),
    FIRE(Effect.FIRE, Weapon.FIRE, BulletHUD.FIRE, BulletFire.FIRE),
    ELECTRIC(Effect.ELECTRIC, Weapon.ELECTRIC, BulletHUD.ELECTRIC, BulletFire.FIRE),
    ICE(Effect.ICE, Weapon.ICE, BulletHUD.ICE, BulletFire.FIRE);
	
    private final Effect effect;
    private final String weapon;
    private final String bulletHud;
    private final String bulletFire;
	
    private static final List<AmmoType> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	
	private AmmoType (final Effect effect, final String weapon, final String bulletHUD, final String bulletFire) {
		this.effect = effect;
		this.weapon = weapon;
		this.bulletHud = bulletHUD;
		this.bulletFire = bulletFire;
	}

	public String getWeapon() {
		return this.weapon;
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
