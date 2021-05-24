package spaceSurvival.model.command.concreteCommand;

import spaceSurvival.model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.common.V2d;

public class UpCommand implements CommandGameObject{
	
	public UpCommand() {}

	@Override
	public void execute(MainGameObject object) {

		V2d vel = object.getVelocity();
		object.setVelocity(vel.sum(new V2d(0,-1)));
		
		System.out.println("Up " + object.toString());

		//ship.setVel(vel.sum(new V2d(0,2)));
		
//		double speed = ship.getCurrentVel().module();
//		ship.setVel(new V2d(0,1.5).mul(speed));
	}

}
