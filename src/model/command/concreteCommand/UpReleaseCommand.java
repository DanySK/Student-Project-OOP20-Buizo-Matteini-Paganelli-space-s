package model.command.concreteCommand;

import model.command.commandInterfaces.CommandMovement;
import model.gameObject.MainGameObject;

public class UpReleaseCommand implements CommandMovement {

	@Override
	public void execute(MainGameObject ship) {
		System.out.println("Release Up");
		
//		V2d vel = ship.getCurrentVel();
//		ship.setVel(vel.sum(new V2d(0,-30)));
//		//ship.setVel(new V2d(0,0));

	}
}
