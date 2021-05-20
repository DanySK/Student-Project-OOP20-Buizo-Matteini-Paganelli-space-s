package spaceSurvival.model.command.concreteCommand;

import spaceSurvival.model.command.commandInterfaces.CommandMovement;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.MainGameObject;

public class RightReleaseCommand implements CommandMovement {

	@Override
	public void execute(MainGameObject ship) {
		System.out.println("Release Right");
		
		V2d vel = ship.getVelocity();
		System.out.println(vel);
		ship.setVelocity(ship.getVelocity().mul(0.5));
//		V2d vel = ship.getCurrentVel();
//		ship.setVel(vel.sum(new V2d(-30,0)));
		//ship.setVel(new V2d(0,0));

	}

}
