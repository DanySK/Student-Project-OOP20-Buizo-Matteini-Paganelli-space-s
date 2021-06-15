package spaceSurvival.model.gameObject;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Effect {
    NONE(Status.NORMAL),
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
	
    Effect(final Status status) {
        this.status = status;
    }

    /**
     * @return a random effect
     */
    public static Effect random()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    /**
     * @return the status caused by the effect
     */
    public Status getStatus() {
        return this.status;
    }
}
