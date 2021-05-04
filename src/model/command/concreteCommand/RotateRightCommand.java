package model.command.concreteCommand;

import model.command.commandInterfaces.CommandMovement;
import model.gameObject.AbstractGameObject;
import model.common.V2d;

public class RotateRightCommand implements CommandMovement{
	
	public RotateRightCommand() {}

	@Override
	public void execute(AbstractGameObject ship) {
		System.out.println("Rotate Right");
		
		


		
	}
	
}