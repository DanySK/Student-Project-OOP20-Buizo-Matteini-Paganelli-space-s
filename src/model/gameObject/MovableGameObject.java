package model.gameObject;

import java.awt.geom.AffineTransform;

import model.common.P2d;
import model.common.V2d;
import model.image.EngineImage;
import model.worldEcollisioni.physics.boundingType.BoundingBox;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import model.worldEcollisioni.physics.components.PhysicsComponent;

public abstract class MovableGameObject extends GameObject {
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
	
	public void move() {
		//this.getTransform().translate(this.getVelocity().getX(), this.getVelocity().getY());
		//this.setPosition(this.getPosition().sum(this.getVelocity()));
		
		this.getTransform().translate(this.getVelocity().getX(), this.getVelocity().getY());
		double x = this.getTransform().getTranslateX();
		double y = this.getTransform().getTranslateY();
		
		//P2d newPos = new P2d(x + 42,y + 44);
		//P2d newPos = new P2d(x,y);
		//System.out.println(this.getVelocity());
		//this.gameState.getWorld().getShip().setPosition(this.gameState.getWorld().getShip().getPosition().sum(this.gameState.getWorld().getShip().getVelocity()));
		//this.gameState.getWorld().getShip().setPosition(newPos);
		//this.gameState.getWorld().getShip().setPosition(newPos);
		
		this.setBoundingBox(new RectBoundingBox(new P2d(x - 44,y - 44), new P2d(x + 44,y + 44)));
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
		return "MovableGameObject [velocity=" + velocity + ", movement=" + movement + ", "
				+ "transform=" + super.getTransform() + ", " + super.toString() +  "]";
	}
	
}
