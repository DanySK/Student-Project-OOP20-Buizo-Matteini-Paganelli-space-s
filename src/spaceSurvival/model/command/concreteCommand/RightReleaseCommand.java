package spaceSurvival.model.command.concreteCommand;

import spaceSurvival.model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.GameObjectUtils;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;

public class RightReleaseCommand implements CommandGameObject {

	@Override
	public void execute(SpaceShipSingleton object) {
		System.out.println("Release Right");
		
		if (object instanceof SpaceShipSingleton) {
			SpaceShipSingleton ship = (SpaceShipSingleton) object;
			ship.setAcceleration(new V2d(GameObjectUtils.SPACESHIP_DECELERATION, 0));	

		}
	}

}
