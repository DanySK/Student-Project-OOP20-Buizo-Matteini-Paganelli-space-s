package spaceSurvival.model.movement;

import java.awt.geom.AffineTransform;

import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.MovableGameObject;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;

public class ControlledMovement implements Movement {

	@Override
	public void move(MovableGameObject object) {
		if (object instanceof SpaceShipSingleton) {
			SpaceShipSingleton ship = (SpaceShipSingleton) object;
			
			V2d vel = ship.getVelocity();
			//if (ship.getAcceleration() < 1) {
			V2d newVel = new V2d(vel.getX() * ship.getAcceleration().getX(), vel.getY() * ship.getAcceleration().getY());
			
			
			ship.setVelocity(newVel);
			
			//DA CONTROLLARE MAX VEL
			
			
			//}


			AffineTransform at = ship.getTransform();
			at.translate(ship.getVelocity().getX(), ship.getVelocity().getY());
			ship.setTransform(ship.getTransform());
		}

	}
	
	@Override
	public String toString() {
		return "Controlled Movement";
	}

}
