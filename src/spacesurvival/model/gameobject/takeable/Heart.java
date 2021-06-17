package spacesurvival.model.gameobject.takeable;

import java.util.List;

import spacesurvival.model.EngineImage;
import spacesurvival.model.collision.physics.bounding.BoundingBox;
import spacesurvival.model.collision.physics.component.PhysicsComponent;
import spacesurvival.model.common.P2d;

public class Heart extends TakeableGameObject {

	private HeartType type;
	
	public Heart(final EngineImage engineImage, final P2d position, final BoundingBox bb,
			final PhysicsComponent phys, final HeartType type) {
		super(engineImage, position, bb, phys);
		this.type = type;
	}
	
	public Heart(final EngineImage engineImage, final P2d position, final BoundingBox bb,
			final PhysicsComponent phys, final List<String> animation, final HeartType type) {
		super(engineImage, position, bb, phys, animation);
		this.type = type;
	}

	public HeartType getType() {
		return type;
	}

	public void setType(HeartType type) {
		this.type = type;
	}

}
