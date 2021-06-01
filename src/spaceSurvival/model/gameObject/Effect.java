package spaceSurvival.model.gameObject;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Effect {
	NONE,
	FIRE(Status.ON_FIRE),
	ICE(Status.FROZEN),
	ELECTRIC(Status.PARALIZED);
//	FIRE_AMMO(Status.ON_FIRE),
//	ICE_AMMO(Status.FROZEN),
//	ELECTRIC_AMMO(Status.PARALIZED),
//	HEAL(Status.HEALED),
//	LIFE_UP(Status.LIVES_INCREASED);

	private Status status;
	
	private static final List<Effect> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	
	private Effect(Status status) {
		this.status = status;
	}

	private Effect() {
	}
	
	public static Effect random()  {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
	
	public Status getStatus() {
		return this.status;
	}
}
