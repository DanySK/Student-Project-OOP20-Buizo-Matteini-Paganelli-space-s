package spaceSurvival.model.gameObject.weapon;

import spaceSurvival.model.common.P2d;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.MovableGameObject;
import spaceSurvival.model.gameObject.Movement;
import spaceSurvival.model.image.EngineImage;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.PhysicsComponent;

public class Bullet extends MovableGameObject {
	private AmmoType type;
	private int damage;
	
	public Bullet() {
		// TODO Auto-generated constructor stub
	}
	
	public Bullet(final EngineImage engineImage, final P2d position, final BoundingBox bb, final PhysicsComponent phys,
			final V2d velocity, final Movement movement, final AmmoType type, final int damage) {
		super(engineImage, position, bb, phys, velocity, movement);
		this.type = type;
		this.damage = damage;
	}
	
	public AmmoType getType() {
		return type;
	}

	public void setType(AmmoType type) {
		this.type = type;
	}


	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	
}
