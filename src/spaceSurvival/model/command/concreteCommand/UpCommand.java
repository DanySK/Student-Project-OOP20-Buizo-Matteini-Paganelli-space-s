package spaceSurvival.model.command.concreteCommand;

import spaceSurvival.model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.utilities.VelocityUtils;
import spaceSurvival.model.common.V2d;

public class UpCommand implements CommandGameObject{
	
	public UpCommand() {}

	@Override
	public void execute(MainGameObject object) {
		V2d vel = object.getVelocity();
	
		if (vel.getY() >= -VelocityUtils.SPACESHIP_MAX_VELOCITY) {
			object.setVelocity(vel.sum(new V2d(0, -VelocityUtils.SPACESHIP_VELOCITY)));
		}
	}

}
