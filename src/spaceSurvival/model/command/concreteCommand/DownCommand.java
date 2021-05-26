package spaceSurvival.model.command.concreteCommand;

import spaceSurvival.model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.gameObject.GameObjectUtils;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spaceSurvival.model.common.V2d;

public class DownCommand implements CommandGameObject{
	
	public DownCommand() {}

	@Override
	public void execute(MainGameObject object) {
		V2d vel = object.getVelocity();

		if (object instanceof SpaceShipSingleton) {
			SpaceShipSingleton ship = (SpaceShipSingleton) object;
			ship.setAcceleration(GameObjectUtils.SPACESHIP_ACCELERATION);	
		}
		
		
		if (vel.getY() <= GameObjectUtils.SPACESHIP_MAXVEL) {
			object.setVelocity(vel.sum(new V2d(0, GameObjectUtils.SPACESHIP_ACCELERATION)));
		}
		

		
		//System.out.println("Down ");
		//System.out.println("Position in concrete command " + object.getPosition());
		
		
		//double speed = ship.getCurrentVel().module();
		//ship.setVel(new V2d(0,-1.5).mul(speed));
		

	}


}
