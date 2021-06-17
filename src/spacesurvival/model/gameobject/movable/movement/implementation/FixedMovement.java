package spacesurvival.model.gameobject.movable.movement.implementation;

import spacesurvival.model.gameobject.movable.MovableObject;
import spacesurvival.model.gameobject.movable.movement.Movement;

import java.awt.geom.AffineTransform;


public class FixedMovement implements Movement {

    @Override
    public final void move(final MovableObject object) {
        final AffineTransform at = object.getTransform();


        object.setTransform(object.getTransform());
        at.translate(object.getVelocity().getX(), object.getVelocity().getY());

    }

    @Override
    public final String toString() {
        return "Fixed Movement";
    }
}
