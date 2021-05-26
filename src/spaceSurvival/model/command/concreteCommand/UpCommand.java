package spaceSurvival.model.command.concreteCommand;

import spaceSurvival.model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.gameObject.GameObjectUtils;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.utilities.VelocityUtils;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spaceSurvival.model.common.V2d;

public class UpCommand implements CommandGameObject{
	
	public UpCommand() {}

	@Override
	public void execute(MainGameObject object) {
		if (object instanceof SpaceShipSingleton) {
			((SpaceShipSingleton) object).setAccelerating(true);
		}
		V2d vel = object.getVelocity();
	
		if (vel.getY() >= -VelocityUtils.SPACESHIP_MAX_VELOCITY) {
			object.setVelocity(vel.sum(new V2d(0, -GameObjectUtils.SPACESHIP_ACCELERATION)));

		}
	}

}
