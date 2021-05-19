package model.command.concreteCommand;

import java.awt.geom.AffineTransform;

import model.command.commandInterfaces.CommandMovement;
import model.gameObject.MainGameObject;
import model.gameObject.mainGameObject.SpaceShipSingleton;

public class RotateLeftCommand implements CommandMovement{
	
	public RotateLeftCommand() {}

	@Override
	public void execute(MainGameObject obj) {
		System.out.println("Rotate Left");
		
		SpaceShipSingleton ship = (SpaceShipSingleton) obj;
		AffineTransform transform = ship.getTransform();
		//transform.rotate(Math.toRadians(-15), ship.getPosition().getX(),ship.getPosition().getY());
		//ship.getSize().getSize();
		transform.rotate(Math.toRadians(-15), ship.getSize().getHeight(), ship.getSize().getWidth());

		//transform.rotate(Math.toRadians(-15), ship.getSize().getHeight() / 2, ship.getSize().getWidth() / 2);
		System.out.println(ship.getPosition());
		ship.setTransform(transform);
		//System.out.println(ship.toString());
	}
	
}