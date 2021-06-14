package spaceSurvival.model.movement;

import java.awt.geom.AffineTransform;

import spaceSurvival.model.common.P2d;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.MovableGameObject;
import spaceSurvival.model.gameObject.enemy.ChaseEnemy;
import spaceSurvival.model.worldEcollisioni.physics.components.CollisionChecker;

public class ChasingMovement implements Movement {

	@Override
	public void move(MovableGameObject object) {
		
		
		if(object instanceof ChaseEnemy) {
			ChaseEnemy chase = (ChaseEnemy) object;
			P2d target = chase.getTarget();

			double rightRotation = Math.toDegrees(Math.atan2(chase.getPosition().getY() - target.getY(), chase.getPosition().getX() - target.getX()));
			double complementary = 180 - (rightRotation * -1);
			double newAngle = 90 + complementary;

			AffineTransform newTransform = new AffineTransform();
			newTransform.translate(chase.getTransform().getTranslateX(), chase.getTransform().getTranslateY());
			newTransform.rotate(Math.toRadians(newAngle), 0, 0);

			newTransform.translate(chase.getVelocity().getX(), chase.getVelocity().getY());
			chase.setTransform(newTransform);

		}
	}
	
	@Override
	public String toString() {
		return "Chasing Movement";
	}

}
