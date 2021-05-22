package spaceSurvival.model.gameObject;

import spaceSurvival.model.common.P2d;
import spaceSurvival.model.ImageDesign;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.PhysicsComponent;

public class PickableGameObject extends GameObject {
	
	private EffectType effectType;

	public PickableGameObject(final ImageDesign imageDesign, final P2d position, final BoundingBox bb,
							  final PhysicsComponent phys, final EffectType effectType) {
		super(imageDesign, position, bb, phys);
		this.setBoundingBox(GameObjectUtils.createCircleBoundingBox(position, imageDesign));
		this.effectType = effectType;
	}

	public EffectType getEffectType() {
		return effectType;
	}

	public void setEffectType(EffectType effectType) {
		this.effectType = effectType;
	}
}
