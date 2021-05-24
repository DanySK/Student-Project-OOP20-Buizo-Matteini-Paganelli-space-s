package spaceSurvival.model.command.concreteCommand;

import spaceSurvival.model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.common.V2d;

public class DownCommand implements CommandGameObject{
	
	public DownCommand() {}

	@Override
	public void execute(MainGameObject object) {
		
		V2d vel = object.getVelocity();
		object.setVelocity(vel.sum(new V2d(0,+1)));
		
		//ship.getTransform()
		

		
		System.out.println("Down ");
		System.out.println("Position in concrete command " + object.getPosition());
		
		
		//double speed = ship.getCurrentVel().module();
		//ship.setVel(new V2d(0,-1.5).mul(speed));
		

	}


}
