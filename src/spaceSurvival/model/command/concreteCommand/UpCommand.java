package spaceSurvival.model.command.concreteCommand;

import spaceSurvival.model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.gameObject.GameObjectUtils;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spaceSurvival.model.common.V2d;

public class UpCommand implements CommandGameObject{
	
	public UpCommand() {}

	@Override
	public void execute(MainGameObject object) {
		V2d vel = object.getVelocity();
	
		if (object instanceof SpaceShipSingleton) {
			SpaceShipSingleton ship = (SpaceShipSingleton) object;
			ship.setAcceleration(GameObjectUtils.SPACESHIP_ACCELERATION);	
		}
		
		if (vel.getY() >= -GameObjectUtils.SPACESHIP_MAXVEL) {
			object.setVelocity(vel.sum(new V2d(0, -GameObjectUtils.SPACESHIP_ACCELERATION)));
		}
	}

}
