package spaceSurvival.model.command.concreteCommand;

import spaceSurvival.model.command.commandInterfaces.CommandMovement;
import spaceSurvival.model.gameObject.MovableGameObject;

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
