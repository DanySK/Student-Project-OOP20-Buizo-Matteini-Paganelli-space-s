package spaceSurvival.model.command.concreteCommand;

import spaceSurvival.model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.GameObjectUtils;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;

public class LeftReleaseCommand implements CommandGameObject {

	@Override
	public void execute(MainGameObject object) {
		System.out.println("Release Left");

		if (object instanceof SpaceShipSingleton) {
			SpaceShipSingleton ship = (SpaceShipSingleton) object;
			//new V2d(0, -GameObjectUtils.SPACESHIP_ACCELERATION);
			ship.setAcceleration(new V2d(GameObjectUtils.SPACESHIP_DECELERATION, 0));	

		}
	}

}
