package spaceSurvival.model.worldEcollisioni.physics.components;

import java.awt.geom.AffineTransform;
import java.util.Optional;

import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.PickableGameObject;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spaceSurvival.model.World;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitAsteroidEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitBorderEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitBossEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitChaseEnemyEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitFireEnemyEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitPickableEvent;
import spaceSurvival.model.worldEcollisioni.physics.BoundaryCollision;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import spaceSurvival.utilities.SystemVariables;
import spaceSurvival.utilities.dimension.Screen;
import spaceSurvival.model.common.P2d;

public class ShipPhysicsComponent implements PhysicsComponent {
	
	@Override
	public void update(int dt, GameObject abstractObj, World w) {
		SpaceShipSingleton ship = (SpaceShipSingleton) abstractObj;

		RectBoundingBox boundingBox = w.getMainBBox();

		Optional<BoundaryCollision> binfo = w.checkCollisionWithBoundaries(ship.getPosition(), boundingBox);
		System.out.println(binfo);
		//ship.setPosition(position.sum(velocity.mul(0.001 * dt)));		
//		//super.update(dt, obj, w);
//		
//		//w.checkBoundaries(obj);
//		RectBoundingBox bbox = (RectBoundingBox) obj.getBoundingBox();
		//Optional<BoundaryCollision> binfo = w.checkCollisionWithBoundaries(ship.getPosition(), boundingBox);
		if (binfo.isPresent()) {
			BoundaryCollision info = binfo.get();
			P2d pos = ship.getPosition();
			
			switch (info.getEdge()) {
			case TOP: 
				//EFFETTO SPACESHIP
//				P2d center =  Screen.POINT_CENTER_FULLSCREEN;
//				System.out.println(Screen.POINT_CENTER_FULLSCREEN);
//				P2d centerTop = new P2d(1680, 1050);
//				double xAxesDiffTop = centerTop.getX() - info.getWhere().getX();
//				double xAxesSpawnTop = centerTop.getX() + xAxesDiffTop;
//				
//				
//				P2d p2Top = new P2d(xAxesSpawnTop, centerTop.getX() * SystemVariables.SCALE_X);
//				///P2d p2Top = new P2d(ship.getTransform().getTranslateX(), centerTop.getX() * SystemVariables.SCALE_X);
//				double disTop = Math.sqrt(Math.pow(p2Top.getX()-pos.getX(), 2) + Math.pow(p2Top.getY()-pos.getY(), 2));
//				//double dis=Math.sqrt( * (p2.getX()-pos.getX() + (p2.getY()-pos.getY()*(p2.getY()-pos.getY()));
//				
//				
//				//ship.getTransform().translate(0, Screen.HEIGHT_FULL_SCREEN * SystemVariables.SCALE_Y);
//				
//				ship.getTransform().translate(0, disTop);	
				AffineTransform newTransTop = new AffineTransform(ship.getTransform().getScaleX(), 
						ship.getTransform().getShearY(), ship.getTransform().getShearX(), 
						ship.getTransform().getScaleY(), ship.getTransform().getTranslateX(), 
						Screen.HEIGHT_FULL_SCREEN * SystemVariables.SCALE_Y - 100);
				
				w.notifyWorldEvent(new HitBorderEvent(info.getWhere()));
				ship.setTransform(newTransTop);
				break;
			case BOTTOM:		
				AffineTransform newTransBottom = new AffineTransform(ship.getTransform().getScaleX(), 
						ship.getTransform().getShearY(), ship.getTransform().getShearX(), 
						ship.getTransform().getScaleY(), ship.getTransform().getTranslateX(), 
						100);
			 			
				w.notifyWorldEvent(new HitBorderEvent(info.getWhere()));
				ship.setTransform(newTransBottom);
				break;
			case LEFT: 			
				AffineTransform newTransLeft = new AffineTransform(ship.getTransform().getScaleX(), 
						ship.getTransform().getShearY(), ship.getTransform().getShearX(), 
						ship.getTransform().getScaleY(), Screen.WIDTH_FULL_SCREEN * SystemVariables.SCALE_X - 100, 
						ship.getTransform().getTranslateY());
			 			
				ship.setTransform(newTransLeft);
				break;
			case RIGHT: 
				AffineTransform newTransRight = new AffineTransform(ship.getTransform().getScaleX(), 
						ship.getTransform().getShearY(), ship.getTransform().getShearX(), 
						ship.getTransform().getScaleY(), 100, 
						ship.getTransform().getTranslateY());
			 			
				ship.setTransform(newTransRight);
				break;
			}
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