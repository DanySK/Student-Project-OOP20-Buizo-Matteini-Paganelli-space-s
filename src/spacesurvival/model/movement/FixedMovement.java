package spacesurvival.model.movement;

import spacesurvival.model.gameobject.MovableGameObject;

import java.awt.geom.AffineTransform;


public class FixedMovement implements Movement {

    @Override
    public final void move(final MovableGameObject object) {
        final AffineTransform at = object.getTransform();


        object.setTransform(object.getTransform());
        at.translate(object.getVelocity().getX(), object.getVelocity().getY());

    }

    @Override
    public final String toString() {
        return "Fixed Movement";
    }
}
