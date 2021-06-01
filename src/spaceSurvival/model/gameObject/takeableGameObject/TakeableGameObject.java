package spaceSurvival.model.gameObject.takeableGameObject;

import spaceSurvival.model.common.P2d;
import spaceSurvival.model.gameObject.Effect;
import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.gameObject.GameObjectUtils;

import java.awt.geom.AffineTransform;
import java.util.List;

import spaceSurvival.model.EngineImage;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.PhysicsComponent;

public abstract class TakeableGameObject extends GameObject {
	
	public TakeableGameObject(final EngineImage engineImage, final P2d position, final BoundingBox bb,
                              final PhysicsComponent phys) {
		super(engineImage, position, bb, phys);
		this.setBoundingBox(GameObjectUtils.createCircleBoundingBox(position, engineImage, this.getTransform()));
	}

	public TakeableGameObject(final EngineImage engineImage, final P2d position, final BoundingBox bb,
							  final PhysicsComponent phys, final List<String> animation) {
		super(engineImage, position, bb, phys);
		this.setBoundingBox(GameObjectUtils.createCircleBoundingBox(position, engineImage, this.getTransform()));
		super.setAnimation(animation);
	}

}
