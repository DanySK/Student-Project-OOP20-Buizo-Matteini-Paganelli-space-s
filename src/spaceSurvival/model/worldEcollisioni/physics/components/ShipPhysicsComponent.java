package spaceSurvival.model.worldEcollisioni.physics.components;

import java.util.Optional;

import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.PickableGameObject;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spaceSurvival.model.World;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitAsteroidEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitBossEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitChaseEnemyEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitFireEnemyEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitPickableEvent;
import spaceSurvival.model.worldEcollisioni.physics.BoundaryCollision;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import spaceSurvival.model.common.P2d;

public class ShipPhysicsComponent implements PhysicsComponent {
	
	@Override
	public void update(int dt, GameObject abstractObj, World w) {
		SpaceShipSingleton ship = (SpaceShipSingleton) abstractObj;

		//System.out.println("Velocità: " + velocity);
		
		//w.checkBoundaries(ship);
		
		RectBoundingBox boundingBox = w.getMainBBox();
		System.out.println(boundingBox.toString());
		System.out.println(ship.getPosition());
		
		//System.out.println("Altezza Bounding Box:" + boundingBox.getHeight() + "Larghezza Bounding Box:" + boundingBox.getWidth() + 
				//"UL:" + boundingBox.getULCorner() + "BR:" + boundingBox.getBRCorner());
		Optional<BoundaryCollision> binfo = w.checkCollisionWithBoundaries(ship.getPosition(), boundingBox);
		//System.out.println(binfo);
		//ship.setPosition(position.sum(velocity.mul(0.001 * dt)));		
//		//super.update(dt, obj, w);
//		
//		//w.checkBoundaries(obj);
//		RectBoundingBox bbox = (RectBoundingBox) obj.getBoundingBox();
		//Optional<BoundaryCollision> binfo = w.checkCollisionWithBoundaries(ship.getPosition(), boundingBox);qqeeeeqqqqqqqq
		if (binfo.isPresent()) {
			BoundaryCollision info = binfo.get();
			P2d pos = ship.getPosition();
			
//			switch (info.getEdge()) {
//			case TOP: 
//				//ship.setPosition(new P2d(60, 60));
//				ship.setVelocity(new V2d(ship.getVelocity().getX(), -ship.getVelocity().getY()));
//				ship.getTransform().translate(ship.getVelocity().getX(), ship.getVelocity().getY());
//				ship.setPosition(ship.getPosition().sum(ship.getVelocity()));
//			
//				//ship.getTransform()
//				w.notifyWorldEvent(new HitBorderEvent(info.getWhere()));
//				System.out.println("toccato il muro TOP fratellì");
//				break;
//			case BOTTOM: 
//				ship.setPosition(new P2d(pos.x, info.getWhere().y + boundingBox.getWidth()));
//				w.notifyWorldEvent(new HitBorderEvent(info.getWhere()));
//				System.out.println("toccato il muro BOTTOM fratellì");
//				break;
//			case LEFT: 
//				ship.setPosition(new P2d(info.getWhere().x + boundingBox.getWidth(), pos.y));
//				w.notifyWorldEvent(new HitBorderEvent(info.getWhere()));
//				System.out.println("toccato il muro LEFT fratellì");
//				break;
//			case RIGHT: 
//				ship.setPosition(new P2d(info.getWhere().x - boundingBox.getWidth(), pos.y));
//				w.notifyWorldEvent(new HitBorderEvent(info.getWhere()));
//				System.out.println("toccato il muro RIGHT fratellì");
//				break;
//			}
		}
		
//		Optional<MainGameObject> asteroid = w.checkCollisionWithAsteroids(ship.getPosition(), boundingBox);
//		//collisioni con asteroidi
//		if (asteroid.isPresent()) {
//			w.notifyWorldEvent(new HitAsteroidEvent(asteroid.get()));
//			System.out.println("Preso un asteroid Fratellì");
//		}
//		
//		Optional<MainGameObject> chaseEnemy = w.checkCollisionWithChaseEnemies(ship.getPosition(), boundingBox);
//		//collisioni con chaseEnemy
//		if (chaseEnemy.isPresent()) {
//			w.notifyWorldEvent(new HitChaseEnemyEvent(chaseEnemy.get()));
//			System.out.println("Preso un chaseEnemy Fratellì");
//		}
//		
//		Optional<MainGameObject> fireEnemy = w.checkCollisionWithFireEnemies(ship.getPosition(), boundingBox);
//		//collisioni con fireEnemy
//		if (fireEnemy.isPresent()) {
//			w.notifyWorldEvent(new HitFireEnemyEvent(fireEnemy.get()));
////			try {
////				TimeUnit.SECONDS.sleep(5);
////			} catch (InterruptedException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
//			System.out.println("Preso un fireEnemy Fratellì");
//		}
//		
//		Optional<MainGameObject> boss = w.checkCollisionWithBoss(ship.getPosition(), boundingBox);
//		//collisioni con boss
//		if (boss.isPresent()) {
//			w.notifyWorldEvent(new HitBossEvent(boss.get()));
//			//System.out.println("Preso il boss Fratellì");
//		}
//		
//		Optional<PickableGameObject> pickable = w.checkCollisionWithPickables(ship.getPosition(), boundingBox);
//		//collisioni con pickable
//		if (pickable.isPresent()) {
//			w.notifyWorldEvent(new HitPickableEvent(pickable.get()));
//			System.out.println("Preso un pickable Fratellì");
//		}
	}

}