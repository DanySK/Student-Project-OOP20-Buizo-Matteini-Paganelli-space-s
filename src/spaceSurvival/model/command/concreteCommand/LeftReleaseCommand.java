package spaceSurvival.model.command.concreteCommand;


import spaceSurvival.model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.MainGameObject;

public class LeftReleaseCommand implements CommandGameObject {

	@Override
	public void execute(MainGameObject object) {
		System.out.println("Release Left");
		V2d vel = object.getVelocity();
		object.setVelocity(vel.mul(0.5));	
		
//		V2d vel = ship.getCurrentVel();
////
//		ship.setVel(vel.sum(new V2d(30,0)));
		//ship.setVel(new V2d(0,0));

	}

}
