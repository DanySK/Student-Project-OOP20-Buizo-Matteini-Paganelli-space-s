package model.worldEcollisioni.physics.components;

import java.util.Optional;

import model.gameObject.GameObject;
import model.gameObject.MainGameObject;
import model.gameObject.PickableGameObject;
import model.gameObject.mainGameObject.SpaceShipSingleton;
import model.world.World;
import model.worldEcollisioni.hitEvents.HitAsteroidEvent;
import model.worldEcollisioni.hitEvents.HitBorderEvent;
import model.worldEcollisioni.hitEvents.HitBossEvent;
import model.worldEcollisioni.hitEvents.HitChaseEnemyEvent;
import model.worldEcollisioni.hitEvents.HitFireEnemyEvent;
import model.worldEcollisioni.hitEvents.HitPickableEvent;
import model.worldEcollisioni.physics.BoundaryCollision;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import model.common.P2d;
import model.common.V2d;

public class ShipPhysicsComponent implements PhysicsComponent {
	
	@Override
	public void update(int dt, GameObject abstractObj, World w) {
		SpaceShipSingleton obj = (SpaceShipSingleton) abstractObj;
		P2d position = obj.getPosition();
		V2d velocity = obj.getVelocity();
		obj.setPosition(position.sum(velocity.mul(0.001 * dt)));		
		//super.update(dt, obj, w);
		
		//w.checkBoundaries(obj);
		RectBoundingBox bbox = (RectBoundingBox) obj.getBoundingBox();
		Optional<BoundaryCollision> binfo = w.checkCollisionWithBoundaries(obj.getPosition(), bbox);
		if (binfo.isPresent()){
			BoundaryCollision info = binfo.get();
			P2d pos = obj.getPosition();
			
			switch (info.getEdge()){
			case TOP: 
				obj.setPosition(new P2d(pos.x, info.getWhere().y - bbox.getWidth()));
				w.notifyWorldEvent(new HitBorderEvent(info.getWhere()));
				System.out.println("toccato il muro TOP fratellì");
				break;
			case BOTTOM: 
				obj.setPosition(new P2d(pos.x, info.getWhere().y + bbox.getWidth()));
				w.notifyWorldEvent(new HitBorderEvent(info.getWhere()));
				System.out.println("toccato il muro BOTTOM fratellì");
				break;
			case LEFT: 
				obj.setPosition(new P2d(info.getWhere().x + bbox.getWidth(), pos.y));
				w.notifyWorldEvent(new HitBorderEvent(info.getWhere()));
				System.out.println("toccato il muro LEFT fratellì");
				break;
			case RIGHT: 
				obj.setPosition(new P2d(info.getWhere().x - bbox.getWidth(), pos.y));
				w.notifyWorldEvent(new HitBorderEvent(info.getWhere()));
				System.out.println("toccato il muro RIGHT fratellì");
				break;
			}
		}
		
		Optional<MainGameObject> asteroid = w.checkCollisionWithAsteroids(obj.getPosition(), bbox);
		//collisioni con asteroidi
		if (asteroid.isPresent()) {
			w.notifyWorldEvent(new HitAsteroidEvent(asteroid.get()));
			System.out.println("Preso un asteroid Fratellì");
		}
		
		Optional<MainGameObject> chaseEnemy = w.checkCollisionWithChaseEnemies(obj.getPosition(), bbox);
		//collisioni con chaseEnemy
		if (chaseEnemy.isPresent()) {
			w.notifyWorldEvent(new HitChaseEnemyEvent(chaseEnemy.get()));
			System.out.println("Preso un chaseEnemy Fratellì");
		}
		
		Optional<MainGameObject> fireEnemy = w.checkCollisionWithFireEnemies(obj.getPosition(), bbox);
		//collisioni con chaseEnemy
		if (fireEnemy.isPresent()) {
			w.notifyWorldEvent(new HitFireEnemyEvent(fireEnemy.get()));
			System.out.println("Preso un fireEnemy Fratellì");
		}
		
		Optional<MainGameObject> boss = w.checkCollisionWithBoss(obj.getPosition(), bbox);
		//collisioni con chaseEnemy
		if (boss.isPresent()) {
			w.notifyWorldEvent(new HitBossEvent(boss.get()));
			System.out.println("Preso il boss Fratellì");
		}
		
		Optional<PickableGameObject> pickable = w.checkCollisionWithPickables(obj.getPosition(), bbox);
		//collisioni con chaseEnemy
		if (pickable.isPresent()) {
			w.notifyWorldEvent(new HitPickableEvent(pickable.get()));
			System.out.println("Preso un pickable Fratellì");
		}
	}

}