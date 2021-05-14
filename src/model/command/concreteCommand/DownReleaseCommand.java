package model.command.concreteCommand;

import model.command.commandInterfaces.CommandMovement;
import model.gameObject.MovableGameObject;

public class DownReleaseCommand implements CommandMovement {

	@Override
	public void execute(MovableGameObject ship) {
		System.out.println("Release Down");
		
//		V2d vel = ship.getCurrentVel();
//		ship.setVel(vel.sum(new V2d(0,30)));
		
		//V2d vel = ship.getCurrentVel();
		//ship.setVel(new V2d(0,0));
		

	}

}
