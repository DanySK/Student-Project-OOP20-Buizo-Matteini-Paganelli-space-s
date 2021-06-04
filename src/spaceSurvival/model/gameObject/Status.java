package spaceSurvival.model.gameObject;

import spaceSurvival.utilities.pathImage.AnimationEffect;

import java.util.List;

public enum Status {
	NORMAL(List.of()),
	INVINCIBLE(AnimationEffect.LIST_INVINCIBLE),
	ON_FIRE(AnimationEffect.LIST_BURN),
	FROZEN(AnimationEffect.LIST_ICE),
	PARALIZED(List.of()),
	HEALED(AnimationEffect.LIST_LIFE_UP),
	LIVES_INCREASED(List.of());

	private final List<String> animation;

	private Status(final List<String> animation){
		this.animation = animation;
	}

	public List<String> getAnimation() {
		return this.animation;
	}

//	@Override
//	public String toString() {
//		return "Status { animation=" + animation +'}';
//	}
}
