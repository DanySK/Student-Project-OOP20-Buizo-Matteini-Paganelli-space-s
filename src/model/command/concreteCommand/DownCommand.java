package model.command.concreteCommand;

import model.command.commandInterfaces.CommandMovement;
import model.gameObject.AbstractGameObject;
import model.common.V2d;

public class DownCommand implements CommandMovement{
	
	public DownCommand() {}

	@Override
	public void execute(AbstractGameObject ship) {
		
		V2d vel = ship.getVelocity();
		ship.setVelocity(vel.sum(new V2d(0,-30)));
		
		System.out.println("Down " + ship.toString());
		
		//double speed = ship.getCurrentVel().module();
		//ship.setVel(new V2d(0,-1.5).mul(speed));
		

	}


}
