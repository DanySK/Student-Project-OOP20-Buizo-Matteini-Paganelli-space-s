package model.command.concreteCommand;

import model.command.commandInterfaces.CommandGameObject;
import model.gameObject.GameObjectUtils;
import model.gameObject.MainGameObject;
import model.gameObject.mainGameObject.SpaceShipSingleton;
import model.common.V2d;

public class DownCommand implements CommandGameObject{
	
	public DownCommand() {}

	@Override
	public void execute(MainGameObject object) {

		if (object instanceof SpaceShipSingleton) {
			
		SpaceShipSingleton ship = (SpaceShipSingleton) object;

		V2d vel = object.getVelocity();// && ship.getAcceleration().getY() == 0
		
		if(vel.getY() > -0.5 && vel.getY() < 0.5) {
			vel = new V2d(vel.getX(), 1);
			ship.setVelocity(vel);
		}
			ship.setAcceleration(new V2d(ship.getAcceleration().getX(), GameObjectUtils.SPACESHIP_ACCELERATION));	
		}
	}


}
