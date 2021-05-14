package model.gameObject;

import model.common.P2d;
import model.image.EngineImage;
import model.worldEcollisioni.physics.boundingType.BoundingBox;
import model.worldEcollisioni.physics.components.PhysicsComponent;

public abstract class PickableGameObject extends AbstractGameObject {

	public PickableGameObject(final EngineImage engineImage, final P2d position, final BoundingBox bb,
			final PhysicsComponent phys) {
		super(engineImage, position, bb, phys);
	}

}
