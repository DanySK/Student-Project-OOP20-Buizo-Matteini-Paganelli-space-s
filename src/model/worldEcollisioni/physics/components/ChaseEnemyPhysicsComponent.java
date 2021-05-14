package model.worldEcollisioni.physics.components;

import java.util.Optional;

import model.common.P2d;
import model.common.V2d;
import model.gameObject.AbstractGameObject;
import model.gameObject.chaseEnemy.ChaseEnemy;
import model.world.World;
import model.worldEcollisioni.hitEvents.HitAsteroidEvent;
import model.worldEcollisioni.hitEvents.HitChaseEnemyEvent;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;

public class ChaseEnemyPhysicsComponent implements PhysicsComponent {

	@Override
	public void update(int dt, AbstractGameObject abstractObj, World w) {
		ChaseEnemy obj = (ChaseEnemy) abstractObj;
		P2d position = obj.getPosition();
		V2d velocity = obj.getVelocity();
		obj.setPosition(position.sum(velocity.mul(0.001 * dt)));
		
		RectBoundingBox bbox = (RectBoundingBox) obj.getBoundingBox();
		
		Optional<AbstractGameObject> chaseEnemy = w.checkCollisionWithChaseEnemies(obj.getPosition(), bbox);
		//collisioni con asteroidi
		if (chaseEnemy.isPresent()){
			w.notifyWorldEvent(new HitChaseEnemyEvent(chaseEnemy.get()));
			System.out.println("Preso il asteroid Fratellì");
		}	
	}

}
