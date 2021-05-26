package spaceSurvival.model.command.concreteCommand;

import spaceSurvival.model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spaceSurvival.model.common.V2d;

public class DownCommand implements CommandGameObject{
	
	public DownCommand() {}

	@Override
	public void execute(MainGameObject object) {
		if (object instanceof SpaceShipSingleton) {
			//((SpaceShipSingleton) object).setAccelerating(true);
			((SpaceShipSingleton) object).setAcceleration(1.1);
		}
		
		V2d vel = object.getVelocity();
		
		if (vel.getY() <= 15) {
			object.setVelocity(new V2d(vel.getX(), 15));
			
		}
		

	}


}
