package spaceSurvival.model.command.concreteCommand;

import spaceSurvival.model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.GameObjectUtils;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;

public class DownReleaseCommand implements CommandGameObject {

	@Override
	public void execute(SpaceShipSingleton object) {
		System.out.println("Release Down");
		
		if (object instanceof SpaceShipSingleton) {
			SpaceShipSingleton ship = (SpaceShipSingleton) object;
			ship.setAcceleration(new V2d(0, GameObjectUtils.SPACESHIP_DECELERATION));	

		}
		

	}

}
