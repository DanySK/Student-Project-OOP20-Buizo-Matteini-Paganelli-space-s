package spaceSurvival.model.gameObject.weapon;

import spaceSurvival.model.common.P2d;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.Movement;
import spaceSurvival.model.EngineImage;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.PhysicsComponent;

public class ElectricBullet extends Bullet {
	
	public ElectricBullet() {
		// TODO Auto-generated constructor stub
	}
	
	public ElectricBullet(final EngineImage engineImage, final P2d position, final BoundingBox bb,
                          final PhysicsComponent phys, final V2d velocity, final Movement movement, final int damage) {
		super(engineImage, position, bb, phys, velocity, movement, damage);
	}

}
