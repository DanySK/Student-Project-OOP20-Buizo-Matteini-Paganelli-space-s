package CommandProva.ConcreteCommandMovement;

import CommandProva.CommandInterfaces.CommandMovement;
import CommandProva.model.GameObject;
import common.V2d;

public class LeftReleaseCommand implements CommandMovement {

	@Override
	public void execute(GameObject ship) {
		System.out.println("Release Left");
//		V2d vel = ship.getCurrentVel();
//
//		ship.setVel(vel.sum(new V2d(0,0)));	
		
//		V2d vel = ship.getCurrentVel();
////
//		ship.setVel(vel.sum(new V2d(30,0)));
		//ship.setVel(new V2d(0,0));

	}

}
