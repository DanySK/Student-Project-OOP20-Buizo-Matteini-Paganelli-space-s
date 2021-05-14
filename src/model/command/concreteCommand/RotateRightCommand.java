package model.command.concreteCommand;

import java.awt.geom.AffineTransform;

import model.command.commandInterfaces.CommandMovement;
import model.gameObject.MovableGameObject;
import model.gameObject.spaceShip.SpaceShipSingleton;

public class RotateRightCommand implements CommandMovement{
	
	public RotateRightCommand() {}

	@Override
	public void execute(MovableGameObject obj) {
		System.out.println("Rotate Right");
		
		SpaceShipSingleton ship = (SpaceShipSingleton) obj;
		AffineTransform transform = ship.getTransform();
		transform.rotate(Math.toRadians(-15), ship.getSize().getHeight() / 2, ship.getSize().getWidth() / 2);
		ship.setTransform(transform);
		
		System.out.println(ship.toString());	
	}
}