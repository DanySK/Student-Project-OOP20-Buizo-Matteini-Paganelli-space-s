package CommandProva.ConcreteCommandMovement;

import CommandProva.CommandInterfaces.CommandMovement;
import CommandProva.model.GameObject;
import common.V2d;

public class DownCommand implements CommandMovement{
	
	public DownCommand() {}

	@Override
	public void execute(GameObject ship) {
		System.out.println("Down");
		V2d vel = ship.getCurrentVel();
		ship.setVel(vel.sum(new V2d(0,-30)));
		
		//double speed = ship.getCurrentVel().module();
		//ship.setVel(new V2d(0,-1.5).mul(speed));
		

	}


}
