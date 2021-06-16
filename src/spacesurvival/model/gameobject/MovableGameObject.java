package spacesurvival.model.gameobject;

import spacesurvival.controller.CallerCommand;
import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;
import spacesurvival.model.movement.Movement;
import spacesurvival.model.EngineImage;
import spacesurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spacesurvival.model.worldEcollisioni.physics.components.PhysicsComponent;


public abstract class MovableGameObject extends GameObject {
	private V2d velocity;
	private Movement movement;
	private CallerCommand caller;
	
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
	
	public void move() {
		this.movement.move(this);
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
	

	public CallerCommand getCaller() {
		return caller;
	}

	public void setCaller(CallerCommand caller) {
		this.caller = caller;
	}
	
	@Override
	public String toString() {
		return "MovableGameObject [velocity=" + velocity + ", movement=" + movement + ", "
				+ "transform=" + super.getTransform() + ", " + super.toString() +  "]";
	}
}
