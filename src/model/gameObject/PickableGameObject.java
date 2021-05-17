package model.gameObject;

import model.common.P2d;
import model.image.EngineImage;
import model.worldEcollisioni.physics.boundingType.BoundingBox;
import model.worldEcollisioni.physics.components.PhysicsComponent;

public class PickableGameObject extends GameObject {
	
	private EffectType effectType;

	public PickableGameObject(final EngineImage engineImage, final P2d position, final BoundingBox bb,
			final PhysicsComponent phys, final EffectType effectType) {
		super(engineImage, position, bb, phys);
		this.setBoundingBox(GameObjectUtils.createCircleBoundingBox(position, engineImage));
		this.effectType = effectType;
	}

	public EffectType getEffectType() {
		return effectType;
	}

	public void setEffectType(EffectType effectType) {
		this.effectType = effectType;
	}
}
