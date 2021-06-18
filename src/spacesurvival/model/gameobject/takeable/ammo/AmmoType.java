package spacesurvival.model.gameobject.takeable.ammo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import spacesurvival.model.gameobject.Effect;
import spacesurvival.utilities.path.skin.SkinPerk;

public enum AmmoType {

	NORMAL(Effect.NONE, List.of()),
	FIRE(Effect.FIRE, SkinPerk.LIST_FIRE),
	ELECTRIC(Effect.ELECTRIC, SkinPerk.LIST_ELECTRIC),
	ICE(Effect.ICE, SkinPerk.LIST_ICE);
	
	private Effect effect;
	private List<String> animation;

	private static final List<AmmoType> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	
	AmmoType(final Effect effect, final List<String> animation) {
		this.effect = effect;
		this.setAnimation(animation);
	}
	
	public Effect getEffect() {
		return this.effect;
	}
	
	public static AmmoType random()  {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}

    public List<String> getAnimation() {
        return animation;
    }

    public void setAnimation(final List<String> animation) {
        this.animation = animation;
    }
}
