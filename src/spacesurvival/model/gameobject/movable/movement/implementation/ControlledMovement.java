package spacesurvival.model.gameobject.movable.movement.implementation;

import java.awt.geom.AffineTransform;

import spacesurvival.model.common.V2d;
import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;
import spacesurvival.model.gameobject.movable.MovableObject;
import spacesurvival.model.gameobject.movable.movement.MovementLogic;

public class ControlledMovement implements MovementLogic {

    @Override
    public void move(final MovableObject object) {
        if (object instanceof SpaceShipSingleton) {
            final SpaceShipSingleton ship = (SpaceShipSingleton) object;
            final V2d vel = ship.getVelocity();
            //final V2d newVel = new V2d(vel.getX() * ship.getAcceleration().getX(), vel.getY() * ship.getAcceleration().getY());
            final V2d newVel = vel.mul(ship.getAcceleration());
            final AffineTransform at = ship.getTransform();
            if (Math.abs(newVel.getY()) < GameObjectUtils.SPACESHIP_MAXVEL) {
                ship.setVelocity(newVel);
            }
            at.translate(ship.getVelocity().getX(), ship.getVelocity().getY());
            ship.setTransform(ship.getTransform());
        }
    }

    @Override
    public String toString() {
        return "Controlled Movement";
    }

}
