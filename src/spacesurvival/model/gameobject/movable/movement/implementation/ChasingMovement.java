package spacesurvival.model.gameobject.movable.movement.implementation;

import java.awt.geom.AffineTransform;

import spacesurvival.model.common.P2d;
import spacesurvival.model.gameobject.movable.MovableObject;
import spacesurvival.model.gameobject.movable.movement.MovementLogic;

public class ChasingMovement implements MovementLogic {

    /**
     * {@inheritDoc}
     */
    @Override
    public void move(final MovableObject object) {
        if (object.isMoving() && object.getTarget().isPresent()) {
            final P2d target = object.getTarget().get();
            final double rightRotation = Math.toDegrees(Math.atan2(object.getPosition().getY() - target.getY(), object.getPosition().getX() - target.getX()));
            final double complementary = 180 - (rightRotation * -1);
            final double newAngle = 90 + complementary;
            final AffineTransform newTransform = new AffineTransform();

            newTransform.translate(object.getTransform().getTranslateX(), object.getTransform().getTranslateY());
            newTransform.rotate(Math.toRadians(newAngle), 0, 0);
            newTransform.translate(object.getVelocity().getX(), object.getVelocity().getY());
            object.setTransform(newTransform);
        }
    }

    @Override
    public String toString() {
        return "ChasingMovement";
    }

}
