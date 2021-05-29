package spaceSurvival.model.command.concreteCommand;


import spaceSurvival.model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.gameObject.GameObjectUtils;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spaceSurvival.model.common.V2d;

public class LeftCommand implements CommandGameObject{
	
	public LeftCommand() {}

	@Override
	public void execute(MainGameObject object) {
		V2d vel = object.getVelocity();
		
		if (object instanceof SpaceShipSingleton) {
		SpaceShipSingleton ship = (SpaceShipSingleton) object;
		if(vel.getX() > -0.5 && vel.getX() < 0.5) {
			vel = new V2d(-1, vel.getY());
			ship.setVelocity(vel);
		}			
		ship.setAcceleration(new V2d(GameObjectUtils.SPACESHIP_ACCELERATION, ship.getAcceleration().getY()));	
		}
		

	}


}
