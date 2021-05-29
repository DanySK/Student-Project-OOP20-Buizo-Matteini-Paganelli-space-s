package spaceSurvival.model.gameObject.mainGameObject;

import java.util.List;
import java.util.Optional;

import spaceSurvival.model.gameObject.GameObjectUtils;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.movement.Movement;
import spaceSurvival.model.common.P2d;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.weapon.Weapon;
import spaceSurvival.model.EngineImage;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.PhysicsComponent;

public class ChaseEnemy extends MainGameObject {
	
	public ChaseEnemy(final EngineImage engineImage, final P2d position, final BoundingBox bb,
                      final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
                      final int impactDamage, final Optional<Weapon> weapon) {
		
		super(engineImage, position, bb, phys, velocity, movement, life, impactDamage, weapon);
    	this.setBoundingBox(GameObjectUtils.createRectBoundingBox(position, engineImage, this.getTransform()));
	}

	public ChaseEnemy(final EngineImage engineImage, final P2d position, final BoundingBox bb,
					  final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
					  final int impactDamage, final Optional<Weapon> weapon, final List<String> animation) {

		super(engineImage, position, bb, phys, velocity, movement, life, impactDamage, weapon);
		this.setBoundingBox(GameObjectUtils.createRectBoundingBox(position, engineImage, this.getTransform()));
		this.setAnimation(animation);
	}
	
	@Override
	public String toString() {
		return "ChaseEnemy { " + super.toString() + " }";
	}
	

}
