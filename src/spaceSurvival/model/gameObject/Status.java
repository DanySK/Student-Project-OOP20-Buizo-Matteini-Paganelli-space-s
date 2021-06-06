package spaceSurvival.model.gameObject;

import spaceSurvival.utilities.pathImage.AnimationEffect;

import java.util.List;

public enum Status {
	NORMAL(List.of()),
	INVINCIBLE(AnimationEffect.LIST_INVINCIBLE, GameObjectUtils.INVINCIBLE_DURATION),
	ON_FIRE(AnimationEffect.LIST_BURN, GameObjectUtils.ON_FIRE_DURATION),
	FROZEN(AnimationEffect.LIST_ICE, GameObjectUtils.FROZEN_DURATION),
	PARALIZED(List.of(), GameObjectUtils.PARALIZED_DURATION),
	HEALED(AnimationEffect.LIST_LIFE_UP),
	LIVES_INCREASED(List.of());

	private final List<String> animation;
	private final int duration;

	private Status(final List<String> animation){
		this.animation = animation;
		this.duration = GameObjectUtils.INFINITY;
	}
	
	private Status(final List<String> animation, int duration){
		this.animation = animation;
		this.duration = duration;
	}

	public List<String> getAnimation() {
		return this.animation;
	}

	public int getDuration() {
		return duration;
	}

//	@Override
//	public String toString() {
//		return "Status { animation=" + animation +'}';
//	}
}
