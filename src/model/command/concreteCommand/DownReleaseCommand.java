package model.command.concreteCommand;

import model.command.commandInterfaces.CommandGameObject;
import model.common.V2d;
import model.gameObject.GameObjectUtils;
import model.gameObject.MainGameObject;
import model.gameObject.mainGameObject.SpaceShipSingleton;

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
