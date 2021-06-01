package spaceSurvival.model.gameObject.takeableGameObject;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import spaceSurvival.model.gameObject.Effect;
import spaceSurvival.utilities.pathImage.Skin.SkinPerk;

public enum AmmoType {
	NORMAL(Effect.NONE, SkinPerk.NORMAL),
	FIRE(Effect.FIRE),
	ELECTRIC(Effect.ELECTRIC),
	ICE(Effect.ICE);
	
	private Effect effect;
	private SkinPerk skin;
	
	private static final List<AmmoType> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	
	private AmmoType() {
	}
	
	private AmmoType(Effect effect, SkinPerk skin) {
		this.effect = effect;
		this.skin = skin;
		SkinPerk.
	}
	
	public Effect getEffect() {
		return this.effect;
	}
	
	public static AmmoType random()  {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
}
