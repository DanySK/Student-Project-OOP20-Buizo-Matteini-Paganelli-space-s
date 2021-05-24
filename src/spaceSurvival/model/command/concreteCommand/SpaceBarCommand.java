package spaceSurvival.model.command.concreteCommand;

import spaceSurvival.model.command.commandInterfaces.CommandMovement;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.MovableGameObject;

public class SpaceBarCommand implements CommandMovement{
	
	public SpaceBarCommand() {}

	@Override
	public void execute(MovableGameObject ship) {
		
		if (ship.getWeapon().isPresent()) {
			ship.getWeapon().get().shot();
		}	
		
		//double speed = ship.getCurrentVel().module();
		//ship.setVel(new V2d(0,-1.5).mul(speed));
	}
	
}
