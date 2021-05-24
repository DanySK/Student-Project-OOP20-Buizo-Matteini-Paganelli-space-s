package spaceSurvival.model.command.concreteCommand;


import spaceSurvival.model.command.commandInterfaces.CommandMovement;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.MovableGameObject;

public class LeftReleaseCommand implements CommandMovement {

	@Override
	public void execute(MovableGameObject ship) {
		System.out.println("Release Left");
		V2d vel = ship.getVelocity();
		ship.setVelocity(vel.mul(0.5));	
		
//		V2d vel = ship.getCurrentVel();
////
//		ship.setVel(vel.sum(new V2d(30,0)));
		//ship.setVel(new V2d(0,0));

	}

}
