package spacesurvival.model.gameobject.movable.movement.implementation;

import spacesurvival.model.gameobject.movable.MovableObject;
import spacesurvival.model.gameobject.movable.movement.MovementLogic;

import java.awt.geom.AffineTransform;


public class FixedMovement implements MovementLogic {

    @Override
    public final void move(final MovableObject object) {
        if (object.isMoving()) {
            final AffineTransform at = object.getTransform();
            object.setTransform(object.getTransform());
            at.translate(object.getVelocity().getX(), object.getVelocity().getY());   
        }
    }

    @Override
    public final String toString() {
        return "Fixed Movement";
    }

}
