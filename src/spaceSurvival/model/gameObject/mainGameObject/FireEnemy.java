package spaceSurvival.model.gameObject.mainGameObject;

import java.util.Optional;

import spaceSurvival.model.gameObject.GameObjectUtils;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.Movement;
import spaceSurvival.model.common.P2d;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.weapon.Weapon;
import spaceSurvival.model.ImageDesign;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.PhysicsComponent;

public class FireEnemy extends MainGameObject {

	public FireEnemy(final ImageDesign imageDesign, final P2d position, final BoundingBox bb,
					 final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
					 final int impactDamage, final Optional<Weapon> weapon) {
		
		super(imageDesign, position, bb, phys, velocity, movement, life, impactDamage, weapon);
    	this.setBoundingBox(GameObjectUtils.createRectBoundingBox(position, imageDesign));
	}

	@Override
	public String toString() {
		return "FireEnemy { " + super.toString() + " }";
	}

}
