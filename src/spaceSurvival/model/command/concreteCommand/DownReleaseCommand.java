package spaceSurvival.model.command.concreteCommand;

import spaceSurvival.model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.gameObject.MainGameObject;

public class DownReleaseCommand implements CommandGameObject {

	@Override
	public void execute(MainGameObject object) {
		System.out.println("Release Down");
		
//		V2d vel = ship.getCurrentVel();
//		ship.setVel(vel.sum(new V2d(0,30)));
		
		//V2d vel = ship.getCurrentVel();
		//ship.setVel(new V2d(0,0));
		

	}

}
