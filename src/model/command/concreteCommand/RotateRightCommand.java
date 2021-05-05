package model.command.concreteCommand;

import java.awt.geom.AffineTransform;

import model.command.commandInterfaces.CommandMovement;
import model.gameObject.AbstractGameObject;
import model.common.V2d;

public class RotateRightCommand implements CommandMovement{
	
	public RotateRightCommand() {}

	@Override
	public void execute(AbstractGameObject ship) {
		System.out.println("Rotate Right");
		AffineTransform transform = ship.getTransform();
		transform.rotate(Math.toRadians(-15), ship.getSize().height/2, ship.getSize().width/2);
		ship.setTransform(transform);
		
		System.out.println(ship.toString());
		


		
	}
	
}