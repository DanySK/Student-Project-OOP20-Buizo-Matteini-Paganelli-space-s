package model.command.concreteCommand;

import model.command.commandInterfaces.CommandMovement;
import model.gameObject.MovableGameObject;

public class RightReleaseCommand implements CommandMovement {

	@Override
	public void execute(MovableGameObject ship) {
		System.out.println("Release Right");
		
		V2d vel = ship.getVelocity();
		System.out.println(vel);
		ship.setVelocity(ship.getVelocity().mul(0.5));
//		V2d vel = ship.getCurrentVel();
//		ship.setVel(vel.sum(new V2d(-30,0)));
		//ship.setVel(new V2d(0,0));

	}

}
