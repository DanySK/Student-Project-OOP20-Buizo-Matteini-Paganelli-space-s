package spaceSurvival.model.worldEcollisioni.physics.components;

import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.World;

public class ChaseEnemyPhysicsComponent implements PhysicsComponent {

	@Override
	public void update(int dt, GameObject abstractObj, World w) {
//		ChaseEnemy obj = (ChaseEnemy) abstractObj;
//		P2d position = obj.getPosition();
//		V2d velocity = obj.getVelocity();
//		obj.setPosition(position.sum(velocity.mul(0.001 * dt)));
//		
//		RectBoundingBox bbox = (RectBoundingBox) obj.getBoundingBox();
		
//		Optional<MainGameObject> chaseEnemy = w.checkCollisionWithChaseEnemies(obj.getPosition(), bbox);
//		//collisioni con asteroidi
//		if (chaseEnemy.isPresent()){
//			w.notifyWorldEvent(new HitChaseEnemyEvent(chaseEnemy.get()));
//			System.out.println("Preso il asteroid Fratellì");
//		}	
	}

}
