package spaceSurvival.model.command.concreteCommand;

import spaceSurvival.model.command.commandInterfaces.CommandMovement;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.MovableGameObject;
import spaceSurvival.model.common.V2d;

public class DownCommand implements CommandMovement{
	
	public DownCommand() {}

	@Override
	public void execute(MovableGameObject ship) {
		
		V2d vel = ship.getVelocity();
		ship.setVelocity(vel.sum(new V2d(0,+1)));
		
		//ship.getTransform()
		

		
		System.out.println("Down ");
		System.out.println("Position in concrete command " + ship.getPosition());
		
		
		//double speed = ship.getCurrentVel().module();
		//ship.setVel(new V2d(0,-1.5).mul(speed));
		

	}


}
