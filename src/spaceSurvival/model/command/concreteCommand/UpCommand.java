package spaceSurvival.model.command.concreteCommand;

import spaceSurvival.model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.common.V2d;

public class UpCommand implements CommandGameObject{
	
	public UpCommand() {}

	@Override
	public void execute(MainGameObject object) {
		V2d vel = object.getVelocity();
	
		if (vel.getY() >= -15) {
			object.setVelocity(vel.sum(new V2d(0, -1)));
		}
	}

}
