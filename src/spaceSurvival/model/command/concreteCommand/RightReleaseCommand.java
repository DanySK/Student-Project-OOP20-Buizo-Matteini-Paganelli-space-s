package spaceSurvival.model.command.concreteCommand;

import spaceSurvival.model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.MainGameObject;

public class RightReleaseCommand implements CommandGameObject {

	@Override
	public void execute(MainGameObject object) {
		System.out.println("Release Right");
		
		V2d vel = object.getVelocity();
		System.out.println(vel);
		object.setVelocity(object.getVelocity().mul(0.5));
//		V2d vel = ship.getCurrentVel();
//		ship.setVel(vel.sum(new V2d(-30,0)));
		//ship.setVel(new V2d(0,0));

	}

}
