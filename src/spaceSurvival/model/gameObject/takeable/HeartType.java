package spacesurvival.model.gameobject.takeable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import spacesurvival.model.gameobject.GameObjectUtils;


public enum HeartType {
	HEAL(GameObjectUtils.HEAL_AMOUNT),
	LIFE_UP(GameObjectUtils.LIFE_UP_AMOUNT);
	
	private int amount;
	
	private static final List<HeartType> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	
	private HeartType(int amount) {
		this.setAmount(amount);
	}
	
	public static HeartType random()  {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
