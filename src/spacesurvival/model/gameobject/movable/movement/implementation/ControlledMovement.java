package spacesurvival.model.gameobject.movable.movement.implementation;

import java.awt.geom.AffineTransform;

import spacesurvival.model.common.V2d;
import spacesurvival.model.gameobject.movable.MovableObject;
import spacesurvival.model.gameobject.movable.movement.MovementLogic;
import spacesurvival.utilities.gameobject.VelocityUtils;

public class ControlledMovement implements MovementLogic {

    @Override
    public void move(final MovableObject object) {
        if (object.isMoving()) {
            final V2d vel = object.getVelocity();
            final V2d newVel = vel.mul(object.getAcceleration());
            final AffineTransform at = object.getTransform();
            if (Math.abs(newVel.getY()) < VelocityUtils.SPACESHIP_MAX_VELOCITY) {
                object.setVelocity(newVel);
            }
            at.translate(object.getVelocity().getX(), object.getVelocity().getY());
            object.setTransform(object.getTransform());   
        }
    }

    @Override
    public String toString() {
        return "Controlled Movement";
    }

}
