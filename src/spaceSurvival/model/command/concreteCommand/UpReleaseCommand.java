package spaceSurvival.model.command.concreteCommand;

import spaceSurvival.model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;

public class UpReleaseCommand implements CommandGameObject {

	@Override
	public void execute(MainGameObject object) {
		System.out.println("Release Up");
		
		if (object instanceof SpaceShipSingleton) {
			//((SpaceShipSingleton) object).setAccelerating(false);
			((SpaceShipSingleton) object).setAcceleration(0.9);
		}

	}
}
