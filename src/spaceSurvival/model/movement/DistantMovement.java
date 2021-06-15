package spaceSurvival.model.movement;

import java.awt.geom.AffineTransform;

import spaceSurvival.model.common.P2d;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.MovableGameObject;
import spaceSurvival.model.gameObject.enemy.Enemy;

public class DistantMovement implements Movement {
	
    @Override
    public void move(final MovableGameObject object) {
        if (object instanceof MainGameObject) {
            final MainGameObject enemy = (MainGameObject) object;
            if (enemy.getTarget().isPresent()) {
                final P2d target = enemy.getTarget().get();

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
    }

    @Override
    public String toString() {
        return "Distant Movement";
    }
}
