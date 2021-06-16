package spacesurvival.model.movement;

import spacesurvival.model.gameobject.MovableGameObject;

import java.awt.geom.AffineTransform;


public class FixedMovement implements Movement {

    @Override
    public void move(final MovableGameObject object) {
        final AffineTransform at = object.getTransform();
        at.translate(object.getVelocity().getX(), object.getVelocity().getY());
        object.setTransform(object.getTransform());
    }

    @Override
    public String toString() {
        return "Fixed Movement";
    }
}
