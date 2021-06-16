package spacesurvival.model.gameObject.takeableGameObject;

import spacesurvival.model.common.P2d;
import spacesurvival.model.gameObject.GameObject;
import spacesurvival.model.gameObject.GameObjectUtils;

import java.util.List;

import spacesurvival.model.EngineImage;
import spacesurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spacesurvival.model.worldEcollisioni.physics.components.PhysicsComponent;

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
