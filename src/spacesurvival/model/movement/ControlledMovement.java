package spacesurvival.model.movement;

import java.awt.geom.AffineTransform;

import spacesurvival.model.common.V2d;
import spacesurvival.model.gameobject.MovableGameObject;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;

public class ControlledMovement implements Movement {

    @Override
    public void move(final MovableGameObject object) {
        if (object instanceof SpaceShipSingleton) {
            final SpaceShipSingleton ship = (SpaceShipSingleton) object;
            final V2d vel = ship.getVelocity();
            final V2d newVel = new V2d(vel.getX() * ship.getAcceleration().getX(), vel.getY() * ship.getAcceleration().getY());
            final AffineTransform at = ship.getTransform();

            ship.setVelocity(newVel);
            at.translate(ship.getVelocity().getX(), ship.getVelocity().getY());
            ship.setTransform(ship.getTransform());
        }

    }
	
    @Override
    public String toString() {
        return "Controlled Movement";
    }

}
