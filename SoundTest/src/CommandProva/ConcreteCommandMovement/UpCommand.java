package CommandProva.ConcreteCommandMovement;

import CommandProva.CommandInterfaces.CommandMovement;
import CommandProva.model.GameObject;
import common.V2d;

public class UpCommand implements CommandMovement{
	
	public UpCommand() {}

	@Override
	public void execute(GameObject ship) {
		System.out.println("Up");
		V2d vel = ship.getCurrentVel();
		ship.setVel(vel.sum(new V2d(0,30)));

		//ship.setVel(vel.sum(new V2d(0,2)));
		
//		double speed = ship.getCurrentVel().module();
//		ship.setVel(new V2d(0,1.5).mul(speed));
	}

}
