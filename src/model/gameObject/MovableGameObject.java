package model.gameObject;

import model.common.P2d;
import model.common.V2d;
import model.image.EngineImage;
import model.worldEcollisioni.physics.boundingType.BoundingBox;
import model.worldEcollisioni.physics.components.PhysicsComponent;

public abstract class MovableGameObject extends AbstractGameObject {
	private V2d velocity;
	private Movement movement;
	
	public MovableGameObject() {
		super(new EngineImage(), new P2d(0, 0), null, null);
		this.velocity = new V2d();
		this.movement = null;
	}
	
	public MovableGameObject(final EngineImage engineImage, final P2d position, final BoundingBox bb,
			final PhysicsComponent phys, final V2d velocity, final Movement movement) {
		super(engineImage, position, bb, phys);
		this.velocity = velocity;
		this.movement = movement;
	}

	public V2d getVelocity() {
		return velocity;
	}

	public void setVelocity(V2d velocity) {
		this.velocity = velocity;
	}

	public Movement getMovement() {
		return movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}
	
	
	@Override
	public String toString() {
		return "Movable [velocity=" + velocity + ", movement=" + movement + "]";
	}
}