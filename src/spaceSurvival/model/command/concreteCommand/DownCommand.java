package spaceSurvival.model.command.concreteCommand;

import spaceSurvival.model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.gameObject.GameObjectUtils;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spaceSurvival.model.common.V2d;

public class DownCommand implements CommandGameObject{
	
	public DownCommand() {}

	@Override
	public void execute(SpaceShipSingleton object) {

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
