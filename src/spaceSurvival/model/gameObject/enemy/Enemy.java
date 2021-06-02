package spaceSurvival.model.gameObject.enemy;

import java.util.Optional;

import spaceSurvival.model.EngineImage;
import spaceSurvival.model.common.P2d;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.weapon.Weapon;
import spaceSurvival.model.movement.Movement;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.PhysicsComponent;

public class Enemy extends MainGameObject {
	
	P2d target = new P2d(0,0);

	public Enemy(EngineImage engineImage, P2d position, BoundingBox bb, PhysicsComponent phys, V2d velocity,
			Movement movement, int life, int impactDamage, Optional<Weapon> weapon, P2d target) {
		super(engineImage, position, bb, phys, velocity, movement, life, impactDamage, weapon);
		this.target = target;
	}
	
	public P2d getTarget() {
		return this.target;
	}

	public void setTarget(P2d target) {
		this.target = target;
	}

}
