package spaceSurvival.model.gameObject.takeableGameObject;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public enum HealthType {
	HEAL,
	LIFE_UP;
	
	private static final List<HealthType> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	
	public static HealthType random()  {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
}
