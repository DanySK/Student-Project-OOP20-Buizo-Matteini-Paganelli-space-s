package spacesurvival.model.gameObject.takeableGameObject;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import spacesurvival.model.gameObject.Effect;

public enum AmmoType {
	NORMAL(Effect.NONE),
	FIRE(Effect.FIRE),
	ELECTRIC(Effect.ELECTRIC),
	ICE(Effect.ICE);
	
	private Effect effect;
	
	private static final List<AmmoType> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	
	private AmmoType() {
	}
	
	private AmmoType(Effect effect) {
		this.effect = effect;
	}
	
	public Effect getEffect() {
		return this.effect;
	}
	
	public static AmmoType random()  {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
}
