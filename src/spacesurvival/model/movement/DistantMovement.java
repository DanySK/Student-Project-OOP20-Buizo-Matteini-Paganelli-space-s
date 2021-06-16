package spacesurvival.model.movement;

import java.awt.geom.AffineTransform;

import spacesurvival.model.common.P2d;
import spacesurvival.model.gameobject.MovableGameObject;
import spacesurvival.model.gameobject.enemy.Enemy;

public class DistantMovement implements Movement {
	
    @Override
    public void move(final MovableGameObject object) {
        if (object instanceof Enemy) {
            final Enemy enemy = (Enemy) object;
            final P2d target = enemy.getTarget();

            final double rightRotation = Math.toDegrees(Math.atan2(enemy.getPosition().getY() - target.getY(), enemy.getPosition().getX() - target.getX()));
            final double complementary = 180 - (rightRotation * -1);
            final double newAngle = 90 + complementary;
            final AffineTransform newTransform = new AffineTransform();

            newTransform.translate(enemy.getTransform().getTranslateX(), enemy.getTransform().getTranslateY());
            newTransform.rotate(Math.toRadians(newAngle), 0, 0);
            newTransform.translate(enemy.getVelocity().getX(), enemy.getVelocity().getY());
            enemy.setTransform(newTransform);
        }
    }

    @Override
    public String toString() {
        return "Distant Movement";
    }
}
