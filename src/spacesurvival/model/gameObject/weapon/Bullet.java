
package spacesurvival.model.gameObject.weapon;

import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;
import spacesurvival.model.gameObject.Effect;
import spacesurvival.model.gameObject.GameObjectUtils;
import spacesurvival.model.gameObject.MovableGameObject;
import spacesurvival.model.movement.FixedMovement;
import spacesurvival.model.EngineImage;
import spacesurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spacesurvival.model.worldEcollisioni.physics.components.PhysicsComponent;

public class Bullet extends MovableGameObject {
	private int damage;
	private Effect effect;
	
	public Bullet() {
		// TODO Auto-generated constructor stub
	}
	
	public Bullet(final EngineImage engineImage, final P2d position, final BoundingBox bb, final PhysicsComponent phys,
                  final V2d velocity, final int damage, final Effect effect) {
		super(engineImage, position, bb, phys, velocity, new FixedMovement());
    	this.setBoundingBox(GameObjectUtils.createRectBoundingBox(position, engineImage, this.getTransform()));
		this.damage = damage;
		this.setEffect(effect);
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public Effect getEffect() {
		return effect;
	}

	public void setEffect(Effect effect) {
		this.effect = effect;
	}
	
}
