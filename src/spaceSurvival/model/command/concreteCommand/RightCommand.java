package spaceSurvival.model.command.concreteCommand;

import spaceSurvival.model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.gameObject.GameObjectUtils;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spaceSurvival.model.common.V2d;

public class RightCommand implements CommandGameObject{
	
	public RightCommand() {}

	@Override
	public void execute(MainGameObject object) {
		V2d vel = object.getVelocity();
//		
		if (object instanceof SpaceShipSingleton) {
//
			SpaceShipSingleton ship = (SpaceShipSingleton) object;
//			ship.setAcceleration(GameObjectUtils.SPACESHIP_ACCELERATION);	
//		}
//		
//		if (vel.getX() <= GameObjectUtils.SPACESHIP_MAXVEL) {
//			object.setVelocity(vel.sum(new V2d(GameObjectUtils.SPACESHIP_ACCELERATION, 0)));
//		}
		//System.out.println("Right " + object.toString());
		
		if(vel.getX() > -0.5 && vel.getX() < 0.5) {
			vel = new V2d(1, vel.getY());
			ship.setVelocity(vel);
		}
		
//		if (object instanceof SpaceShipSingleton) {
	//		SpaceShipSingleton ship = (SpaceShipSingleton) object;
			//new V2d(0, -GameObjectUtils.SPACESHIP_ACCELERATION);
			ship.setAcceleration(new V2d(GameObjectUtils.SPACESHIP_ACCELERATION, ship.getAcceleration().getY()));	

		}

	}

}
