package model.command.concreteCommand;

import model.command.commandInterfaces.CommandMovement;
import model.gameObject.MovableGameObject;
import model.common.V2d;

public class RightCommand implements CommandMovement{
	
	public RightCommand() {}

	@Override
	public void execute(MovableGameObject ship) {
		
		V2d vel = ship.getVelocity();
		ship.setVelocity(vel.sum(new V2d(30,0)));
		
		System.out.println("Right " + ship.toString());

		//ship.setVel(vel.sum(new V2d(2,0)));
		
//		double speed = ship.getCurrentVel().module();
//		ship.setVel(new V2d(1.5,0).mul(speed));	
		
		
		

	}

}
