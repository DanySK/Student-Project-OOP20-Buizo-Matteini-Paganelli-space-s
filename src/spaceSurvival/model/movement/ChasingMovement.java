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
	int i = 0;
	//AffineTransform newTransform;
	
	@Override
	public void move(MovableGameObject object) {
		
		
		if(object instanceof ChaseEnemy) {
			ChaseEnemy chase = (ChaseEnemy) object;
			P2d target = chase.getTarget();
			
			//if(i == 0) {
			
			
			//mi devo trovare la nuova differenza di angolo.
				//CollisionChecker c = new CollisionChecker();
				double rightRotation = Math.toDegrees(Math.atan2(chase.getPosition().getY() - target.getY(), chase.getPosition().getX() - target.getX()));
				double complementary = 180 - (rightRotation * -1);
				double newAngle = 90 + complementary;
				
				
	//			AffineTransform oldTransform = chase.getTransform();
	//			//oldTransform.translate(chase.getVelocity().getX(),-3);
	//			oldTransform.setToRotation(0, chase.getSize().getWidth() / 2, chase.getSize().getHeight() / 2);
	//			oldTransform.rotate(Math.toRadians(newAngle), chase.getSize().getWidth() / 2, chase.getSize().getHeight() / 2);
	//			chase.setTransform(oldTransform);

				AffineTransform newTransform = new AffineTransform();
				//newTransform.setTransform(chase.getTransform());

			newTransform.setToRotation(0, chase.getSize().getWidth() / 2, chase.getSize().getHeight() / 2);
			newTransform.setToTranslation(chase.getTransform().getTranslateX(), chase.getTransform().getTranslateY());
			//newTransform.translate(newTransform.getTranslateX(),newTransform.getTranslateY());
			newTransform.rotate(Math.toRadians(newAngle), chase.getSize().getWidth() / 2, chase.getSize().getHeight() / 2);
				newTransform.translate(chase.getVelocity().getX(),chase.getVelocity().getY());
				chase.setTransform(newTransform);
		//		object = chase;
				//double oldAngle = c.getRotationAngleInDegrees(oldTransform);
				
				System.out.println("chase ->"  + chase);
		//		System.out.println("NEW ANGLEEEE ->"  + newAngle);
		//		System.out.println("DA RUOTAREEEEEE  ->"  + (oldAngle - newAngle));
				
				//double diffAngle = (oldAngle - newAngle);
				
				
				//AffineTransform newTransform = new AffineTransform();

			//oldTransform.translate(chase.getVelocity().getX(),-3);
			//oldTransform.setToRotation(0);
				
				//newTransform.translate(chase.getPosition().getX(), chase.getPosition().getY());
				
				//oldTransform.rotate(Math.toRadians(newAngle), chase.getSize().getWidth() / 2, chase.getSize().getHeight() / 2);
				//System.out.println("OLD TRANSFORM 1-> " + oldTransform);

				//System.out.println("OLD TRANSFORM 2-> " + oldTransform);

				System.out.println("VELOCITY -> " + chase.getVelocity());


				//newTransform.translate(100, 100);
				
				//chase.setTransform(oldTransform);
				//System.out.println(chase.getTransform());
				//System.out.println(newTransform);
				//System.out.println(chase.getVelocity());
				
				//System.out.println(Math.toDegrees(Math.atan2(chase.getPosition().getY() - target.getY(), chase.getPosition().getX() - target.getX())));
//			}
//			i++;
//			System.out.println(i);
			
//			CollisionChecker c = new CollisionChecker();
//			double oldRotation = c.getRotationAngleInDegrees(chase.getTransform());
//			System.out.println(Math.toDegrees(Math.atan2(chase.getPosition().getY() - target.getY(), chase.getPosition().getX() - target.getX())));
//			System.out.println(oldRotation);
			
			//AffineTransform at = chase.getTransform();
			//AffineTransform newTransform = new AffineTransform().;
//			AffineTransform newTransform = new AffineTransform();
//			AffineTransform oldTransform = chase.getTransform();
//			
//			
//			CollisionChecker c = new CollisionChecker();
//			double oldRotation = c.getRotationAngleInDegrees(oldTransform);
//			double RightDegRotation = Math.toDegrees(Math.atan2(target.getY() - chase.getPosition().getY(), target.getX() - chase.getPosition().getX()));
//			
			//System.out.println(Math.toDegrees(Math.atan2(chase.getPosition().getY() - target.getY(), chase.getPosition().getX() - target.getX())));
//			
//			if(oldRotation != RightDegRotation) {
//				newTransform.rotate(RightDegRotation, chase.getSize().getWidth() / 2, chase.getSize().getHeight() / 2);
//				newTransform.translate(oldTransform.getTranslateX(), oldTransform.getTranslateY());
//				newTransform.translate(chase.getVelocity().getX(), chase.getVelocity().getY());
//				chase.setTransform(newTransform);
//			}
			

			
		}	
		

	}
	
	@Override
	public String toString() {
		return "Chasing Movement";
	}

}
