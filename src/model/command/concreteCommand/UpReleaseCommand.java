package model.command.concreteCommand;

import model.command.commandInterfaces.CommandGameObject;
import model.common.V2d;
import model.gameObject.GameObjectUtils;
import model.gameObject.MainGameObject;
import model.gameObject.mainGameObject.SpaceShipSingleton;

public class UpReleaseCommand implements CommandGameObject {

	@Override
	public void execute(MainGameObject object) {
		System.out.println("Release Up");
		
		if (object instanceof SpaceShipSingleton) {
			SpaceShipSingleton ship = (SpaceShipSingleton) object;
			ship.setAcceleration(new V2d(0, GameObjectUtils.SPACESHIP_DECELERATION));	

		}

	}
}
