package model.command.concreteCommand;

import model.command.commandInterfaces.CommandGameObject;
import model.gameObject.GameObjectUtils;
import model.gameObject.MainGameObject;
import model.gameObject.mainGameObject.SpaceShipSingleton;
import model.common.V2d;

public class RightCommand implements CommandGameObject{
	
	public RightCommand() {}

	@Override
	public void execute(SpaceShipSingleton object) {
		V2d vel = object.getVelocity();
		
		if (object instanceof SpaceShipSingleton) {

		SpaceShipSingleton ship = (SpaceShipSingleton) object;

		if(vel.getX() > -0.5 && vel.getX() < 0.5) {
			vel = new V2d(1, vel.getY());
			ship.setVelocity(vel);
		}
		
		ship.setAcceleration(new V2d(GameObjectUtils.SPACESHIP_ACCELERATION, ship.getAcceleration().getY()));	

		}

	}

}
