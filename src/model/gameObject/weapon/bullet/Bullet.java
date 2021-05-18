package model.gameObject.weapon.bullet;

import model.common.P2d;
import model.common.V2d;
import model.gameObject.GameObjectUtils;
import model.gameObject.MovableGameObject;
import model.gameObject.Movement;
import model.image.EngineImage;
import model.worldEcollisioni.physics.boundingType.BoundingBox;
import model.worldEcollisioni.physics.components.PhysicsComponent;

public abstract class Bullet extends MovableGameObject {
	private int damage;
	
	public Bullet() {
		// TODO Auto-generated constructor stub
	}
	
	public Bullet(final EngineImage engineImage, final P2d position, final BoundingBox bb, final PhysicsComponent phys,
			final V2d velocity, final Movement movement, final int damage) {
		super(engineImage, position, bb, phys, velocity, movement);
    	this.setBoundingBox(GameObjectUtils.createRectBoundingBox(position, engineImage));
		this.damage = damage;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	
}
