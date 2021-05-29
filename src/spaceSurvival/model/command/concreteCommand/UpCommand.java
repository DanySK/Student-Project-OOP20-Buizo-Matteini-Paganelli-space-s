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
			SpaceShipSingleton ship = (SpaceShipSingleton) object;
			V2d vel = ship.getVelocity();
			
			if(vel.getY() > -0.5 && vel.getY() < 0.5) {
				vel = new V2d(vel.getX(), -1);
				ship.setVelocity(vel);
			}
			
			//new V2d(0, -GameObjectUtils.SPACESHIP_ACCELERATION);
			ship.setAcceleration(new V2d(ship.getAcceleration().getX(), GameObjectUtils.SPACESHIP_ACCELERATION));	

		}
		
		//ship.setVelocity(new V2d(0, 1));
		
		
//		if (vel.getY() >= -GameObjectUtils.SPACESHIP_MAXVEL) {
//		object.setVelocity(vel.sum(new V2d(0, vel.getY() * ship.getAcceleration())));
//		//object.setVelocity(vel.sum(new V2d(0, -0.8)));
//
//		}
//		else {
//		ship.setAcceleration(1);
//		//(SpaceShipSingleton) object.setAcceleration(1);
//		}
		
//		if (vel.getY() >= -GameObjectUtils.SPACESHIP_MAXVEL) {
//			object.setVelocity(vel.sum(new V2d(0, vel.getY() * ship.getAcceleration())));
//			//object.setVelocity(vel.sum(new V2d(0, -0.8)));
//
//		}
//		else {
//			ship.setAcceleration(1);
//			//(SpaceShipSingleton) object.setAcceleration(1);
//		}
		
	}

}
