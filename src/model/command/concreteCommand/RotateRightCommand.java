package model.command.concreteCommand;

import java.awt.geom.AffineTransform;

import model.command.commandInterfaces.CommandMovement;
import model.gameObject.MainGameObject;
import model.gameObject.mainGameObject.SpaceShipSingleton;


public class RotateRightCommand implements CommandMovement{
	
	public RotateRightCommand() {}

	@Override
	public void execute(MainGameObject obj) {
		System.out.println("Rotate Right");
		
		SpaceShipSingleton ship = (SpaceShipSingleton) obj;
		AffineTransform transform = ship.getTransform();
		//transform.rotate(Math.toRadians(15));
		//transform.rotate(Math.toRadians(15), ship.getSize().getHeight() / 2, ship.getSize().getWidth() / 2);
				//, ship.getSize().getHeight() / 2, ship.getSize().getWidth() / 2);
		
		transform.rotate(Math.toRadians(15), ship.getSize().getHeight(), ship.getSize().getWidth());
		//transform.rotate
		//transform.rotate(Math.toRadians(-15));
		ship.setTransform(transform);
		
		System.out.println(ship.toString());	
	}
}