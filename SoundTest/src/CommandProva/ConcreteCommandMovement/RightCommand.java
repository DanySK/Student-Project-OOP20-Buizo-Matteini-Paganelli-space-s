package CommandProva.ConcreteCommandMovement;

import CommandProva.CommandInterfaces.CommandMovement;
import CommandProva.model.GameObject;
import common.V2d;

public class RightCommand implements CommandMovement{
	
	public RightCommand() {}

	@Override
	public void execute(GameObject ship) {
		System.out.println("Right");
		V2d vel = ship.getCurrentVel();
		ship.setVel(vel.sum(new V2d(30,0)));

		//ship.setVel(vel.sum(new V2d(2,0)));
		
//		double speed = ship.getCurrentVel().module();
//		ship.setVel(new V2d(1.5,0).mul(speed));	
		
		
		

	}

}
