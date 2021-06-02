package spaceSurvival.model.movement;

import java.awt.geom.AffineTransform;

import spaceSurvival.model.common.P2d;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.MovableGameObject;
import spaceSurvival.model.gameObject.enemy.ChaseEnemy;
import spaceSurvival.model.worldEcollisioni.physics.components.CollisionChecker;

public class ChasingMovement implements Movement {
//	V2d vel = chase.getVelocity();
//	//if (ship.getAcceleration() < 1) {
//	int xMultiplier;
//	int yMultiplier;
//	
//	if(chase.getPosition().getX() <= target.getX())
//	{
//		xMultiplier = 1;
//	}
//	else {
//		xMultiplier = -1;
//	}
//	if(chase.getPosition().getY() <= target.getY())
//	{
//		yMultiplier = 1;
//	}
//	else {
//		yMultiplier = -1;
//	}
	@Override
	public void move(MovableGameObject object) {
		
		if(object instanceof ChaseEnemy) {
			ChaseEnemy chase = (ChaseEnemy) object;
			P2d target = chase.getTarget();
			
			
			System.out.println(Math.toDegrees(Math.atan2(target.getY() - chase.getPosition().getY(), target.getX() - chase.getPosition().getX())));
			double degRotation = Math.toDegrees(Math.atan2(target.getY() - chase.getPosition().getY(), target.getX() - chase.getPosition().getX()));
			//AffineTransform at = chase.getTransform();
			//AffineTransform newTransform = new AffineTransform().;
			AffineTransform newTransform = new AffineTransform();
			CollisionChecker c = new CollisionChecker();
			double oldRotation = c.getRotationAngleInDegrees(chase.getTransform());
			
			
			
			newTransform.rotate(oldRotation - degRotation, chase.getSize().getWidth() / 2, chase.getSize().getHeight() / 2);
			newTransform.translate(chase.getVelocity().getX(), chase.getVelocity().getY());
			chase.setTransform(newTransform);
			
			
		}	
		

	}
	
	@Override
	public String toString() {
		return "Chasing Movement";
	}

}
