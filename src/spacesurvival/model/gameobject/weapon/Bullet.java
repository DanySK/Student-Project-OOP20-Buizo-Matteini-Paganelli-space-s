
package spacesurvival.model.gameobject.weapon;

import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;
import spacesurvival.model.gameobject.Effect;
import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.MovableGameObject;
import spacesurvival.model.movement.FixedMovement;
import spacesurvival.model.EngineImage;
import spacesurvival.model.collisioni.physics.bounding.BoundingBox;
import spacesurvival.model.collisioni.physics.component.PhysicsComponent;

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
