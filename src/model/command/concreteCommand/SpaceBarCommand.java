package model.command.concreteCommand;

import model.command.commandInterfaces.CommandMovement;
import model.gameObject.MainGameObject;

public class SpaceBarCommand implements CommandMovement{
	
	public SpaceBarCommand() {}

	@Override
	public void execute(MainGameObject ship) {
		
		if (ship.getWeapon().isPresent()) {
			ship.getWeapon().get().shot();
		}		
		
		//double speed = ship.getCurrentVel().module();
		//ship.setVel(new V2d(0,-1.5).mul(speed));
	}
	
}
