package spaceSurvival.model.gameObject.takeableGameObject;

import java.util.List;

import spaceSurvival.model.EngineImage;
import spaceSurvival.model.common.P2d;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.PhysicsComponent;

public class Health extends TakeableGameObject {

	private HealthType type;
	
	public Health(final EngineImage engineImage, final P2d position, final BoundingBox bb,
			final PhysicsComponent phys, final HealthType type) {
		super(engineImage, position, bb, phys);
		this.type = type;
	}
	
	public Health(final EngineImage engineImage, final P2d position, final BoundingBox bb,
			final PhysicsComponent phys, final List<String> animation, final HealthType type) {
		super(engineImage, position, bb, phys, animation);
		this.type = type;
	}

	public HealthType getType() {
		return type;
	}

	public void setType(HealthType type) {
		this.type = type;
	}

}
