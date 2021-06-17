package spacesurvival.model.gameobject.takeable.heart;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.utilities.path.skin.SkinPerk;


public enum HeartType {
	HEAL(GameObjectUtils.HEAL_AMOUNT, SkinPerk.LIST_LIFE),
	LIFE_UP(GameObjectUtils.LIFE_UP_AMOUNT, SkinPerk.LIST_HEART);
	
	private int amount;
	private List<String> animation;
	
	private static final List<HeartType> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	
	private HeartType(final int amount, final List<String> animation) {
		this.setAmount(amount);
		this.animation = animation;
	}
	
	public static HeartType random()  {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(final int amount) {
		this.amount = amount;
	}

	public List<String> getAnimation() {
		return this.animation;
	}
}
