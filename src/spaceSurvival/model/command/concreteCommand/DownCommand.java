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
//		V2d vel = object.getVelocity();
//
		if (object instanceof SpaceShipSingleton) {
//
			SpaceShipSingleton ship = (SpaceShipSingleton) object;
//			ship.setAcceleration(GameObjectUtils.SPACESHIP_ACCELERATION);	
//
//		}
//		
//		
//
//		if (vel.getY() <= GameObjectUtils.SPACESHIP_MAXVEL) {
//			object.setVelocity(vel.sum(new V2d(0, GameObjectUtils.SPACESHIP_ACCELERATION)));
//		}
		
		V2d vel = object.getVelocity();
		
		if(vel.getY() > -0.5 && vel.getY() < 0.5) {
			vel = new V2d(vel.getX(), 1);
			ship.setVelocity(vel);
		}
		
	//	if (object instanceof SpaceShipSingleton) {
//			SpaceShipSingleton ship = (SpaceShipSingleton) object;
			//new V2d(0, -GameObjectUtils.SPACESHIP_ACCELERATION);
			ship.setAcceleration(new V2d(ship.getAcceleration().getX(), GameObjectUtils.SPACESHIP_ACCELERATION));	

		}
		
		

		

	}


}
