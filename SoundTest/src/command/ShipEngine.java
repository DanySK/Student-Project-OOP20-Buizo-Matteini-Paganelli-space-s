package command;

import OLD_movement.Physics;

public class ShipEngine {
	
	Physics physics;
	
	public ShipEngine(Physics physics) {
		this.physics = physics;
	}
	

	public void moveUp() {
		physics.decreaseYSpeed();
		
		System.out.println("Moving the ship UP");		
	}
	public void moveDown() {
		physics.increaseYSpeed();

		System.out.println("Moving the ship DOWN");
	}
	public void moveLeft() {
		physics.decreaseXSpeed();

		System.out.println("Moving the ship LEFT");		
	}
	public void moveRight() {
		physics.increaseXSpeed();
	
		System.out.println("Moving the ship RIGHT");		
	}
	
	public void releaseUp() {
		physics.resetYSpeed();
		
		System.out.println("Decreasing the ship UP");		
	}
	public void releaseDown() {
		physics.resetYSpeed();

		System.out.println("Decreasing the ship DOWN");
	}
	public void releaseLeft() {
		physics.resetXSpeed();

		System.out.println("Decreasing the ship LEFT");		
	}
	public void releaseRight() {
		physics.resetXSpeed();
	
		System.out.println("Decreasing the ship RIGHT");		
	}
	
	

}
