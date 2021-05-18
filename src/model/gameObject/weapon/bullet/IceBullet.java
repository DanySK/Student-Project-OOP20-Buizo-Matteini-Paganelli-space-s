package model.gameObject.weapon.bullet;

import model.common.P2d;
import model.common.V2d;
import model.gameObject.Movement;
import model.image.EngineImage;
import model.worldEcollisioni.physics.boundingType.BoundingBox;
import model.worldEcollisioni.physics.components.PhysicsComponent;

public class IceBullet extends Bullet {
	
	public IceBullet() {
		// TODO Auto-generated constructor stub
	}
	
	public IceBullet(final EngineImage engineImage, final P2d position, final BoundingBox bb,
			final PhysicsComponent phys, final V2d velocity, final Movement movement, final int damage) {
		super(engineImage, position, bb, phys, velocity, movement, damage);
	}

}
