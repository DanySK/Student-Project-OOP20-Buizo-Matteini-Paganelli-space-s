
package spaceSurvival.model.gameObject.weapon;

import spaceSurvival.model.common.P2d;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.GameObjectUtils;
import spaceSurvival.model.gameObject.MovableGameObject;
import spaceSurvival.model.gameObject.Movement;
import spaceSurvival.model.ImageDesign;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.PhysicsComponent;

public abstract class Bullet extends MovableGameObject {
	private int damage;
	
	public Bullet() {
		// TODO Auto-generated constructor stub
	}
	
	public Bullet(final ImageDesign imageDesign, final P2d position, final BoundingBox bb, final PhysicsComponent phys,
				  final V2d velocity, final Movement movement, final int damage) {
		super(imageDesign, position, bb, phys, velocity, movement);
    	this.setBoundingBox(GameObjectUtils.createRectBoundingBox(position, imageDesign));
		this.damage = damage;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	
}
