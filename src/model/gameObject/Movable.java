package model.gameObject;

import model.common.P2d;
import model.common.V2d;

public abstract class Movable {
	private P2d position;
	private V2d velocity;
	private Movement movement;
	
	public Movable() {
		// TODO Auto-generated constructor stub
	}
	
	public Movable(final P2d position, final V2d velocity, final Movement movement) {
		this.position = position;
		this.velocity = velocity;
		this.movement = movement;
	}

	public P2d getPosition() {
		return position;
	}

	public void setPosition(P2d position) {
		this.position = position;
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
		return "Movable [position=" + position + ", velocity=" + velocity + ", movement=" + movement + "]";
	}
}
