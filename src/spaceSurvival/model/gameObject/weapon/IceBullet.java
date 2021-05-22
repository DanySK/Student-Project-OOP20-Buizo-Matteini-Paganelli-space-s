package spaceSurvival.model.gameObject.weapon;

import spaceSurvival.model.common.P2d;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.movement.Movement;
import spaceSurvival.model.ImageDesign;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.PhysicsComponent;

public class IceBullet extends Bullet {
	
	public IceBullet() {
		// TODO Auto-generated constructor stub
	}
	
	public IceBullet(final ImageDesign imageDesign, final P2d position, final BoundingBox bb,
					 final PhysicsComponent phys, final V2d velocity, final Movement movement, final int damage) {
		super(imageDesign, position, bb, phys, velocity, movement, damage);
	}

}
