package model.gameObject;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum EffectType {
	FIRE_AMMO,
	ICE_AMMO,
	ELECTRIC_AMMO,
	LIFE_UP,
	HEAL;

	private static final List<EffectType> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	
	public static EffectType random()  {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
}
