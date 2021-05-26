package spaceSurvival.model.command.concreteCommand;

import spaceSurvival.model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;

public class DownReleaseCommand implements CommandGameObject {

	@Override
	public void execute(MainGameObject object) {
		System.out.println("Release Down");
		
		if (object instanceof SpaceShipSingleton) {
			//double acceleration = ((SpaceShipSingleton) object).getAcceleration();
			
			((SpaceShipSingleton) object).setAcceleration(0.9);
			
		}

	}

}
