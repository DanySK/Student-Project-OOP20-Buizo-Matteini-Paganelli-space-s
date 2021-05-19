package model.command.concreteCommand;

import java.awt.geom.AffineTransform;

import model.command.commandInterfaces.CommandMovement;
import model.gameObject.MovableGameObject;
import model.gameObject.mainGameObject.SpaceShipSingleton;
import utilities.dimension.Screen;


public class RotateRightCommand implements CommandMovement{
	
	public RotateRightCommand() {}

	@Override
	public void execute(MovableGameObject obj) {
		System.out.println("Rotate Right");
		
		SpaceShipSingleton ship = (SpaceShipSingleton) obj;
		AffineTransform transform = ship.getTransform();
		//transform.rotate(Math.toRadians(15));
		//transform.rotate(Math.toRadians(15), ship.getSize().getHeight() / 2, ship.getSize().getWidth() / 2);
		System.out.println("POSIZIONE NAVICELLA PORCO " + ship.getPosition());
				//, ship.getSize().getHeight() / 2, ship.getSize().getWidth() / 2);
		transform.rotate(Math.toRadians(15), ship.getPosition().getX(),ship.getPosition().getY());
		System.out.println("POSIZIONE NAVICELLA PORCO " + ship.getPosition());
//		transform.rotate
//		transform.rotate(Math.toRadians(-15));
		ship.setTransform(transform);
		
		System.out.println(ship.toString());	
	}
}