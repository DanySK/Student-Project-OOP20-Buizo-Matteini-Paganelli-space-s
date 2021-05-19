package model.command.concreteCommand;

import model.command.commandInterfaces.CommandMovement;
import model.gameObject.MainGameObject;
import model.common.V2d;

public class UpCommand implements CommandMovement{
	
	public UpCommand() {}

	@Override
	public void execute(MainGameObject ship) {

		V2d vel = ship.getVelocity();
		ship.setVelocity(vel.sum(new V2d(0,-1)));
		
		System.out.println("Up " + ship.toString());

		//ship.setVel(vel.sum(new V2d(0,2)));
		
//		double speed = ship.getCurrentVel().module();
//		ship.setVel(new V2d(0,1.5).mul(speed));
	}

}
