package spaceSurvival.model.gameObject.takeableGameObject;

import java.util.List;

import spaceSurvival.model.EngineImage;
import spaceSurvival.model.common.P2d;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.PhysicsComponent;

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
