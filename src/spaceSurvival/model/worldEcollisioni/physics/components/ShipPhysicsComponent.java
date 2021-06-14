package spaceSurvival.model.worldEcollisioni.physics.components;

import java.util.Optional;

import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spaceSurvival.model.gameObject.takeableGameObject.TakeableGameObject;
import spaceSurvival.model.World;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitBorderEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitMainGameObject;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitTakeableGameObject;
import spaceSurvival.model.worldEcollisioni.physics.BoundaryCollision;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;

public class ShipPhysicsComponent implements PhysicsComponent {
	
	@Override
	public void update(int dt, GameObject abstractObj, World w) {
		//System.out.println("Sono nell'update");
		final SpaceShipSingleton ship = (SpaceShipSingleton) abstractObj;

		final RectBoundingBox boundingBox = w.getMainBBox();
		final RectBoundingBox shipBoundingBox = (RectBoundingBox) abstractObj.getBoundingBox();

		final Optional<BoundaryCollision> borderInfo = w.checkCollisionWithBoundaries(ship.getPosition(), boundingBox);
		if (borderInfo.isPresent()) {
			BoundaryCollision info = borderInfo.get();
			w.notifyWorldEvent(new HitBorderEvent(info.getWhere(), info.getEdge(), ship));
		}
//=======
//			
//			switch (info.getEdge()) {
//			case TOP: 
//				//EFFETTO SPACESHIP
//				AffineTransform newTransTop = new AffineTransform(ship.getTransform().getScaleX(), 
//						ship.getTransform().getShearY(), ship.getTransform().getShearX(), 
//						ship.getTransform().getScaleY(), ship.getTransform().getTranslateX(), 
//						Screen.HEIGHT_FULL_SCREEN * SystemVariables.SCALE_Y - 100);
//				
//				w.notifyWorldEvent(new HitBorderEvent(info.getWhere(), ship));
//				ship.setTransform(newTransTop);
//				break;
//			case BOTTOM:		
//				AffineTransform newTransBottom = new AffineTransform(ship.getTransform().getScaleX(), 
//						ship.getTransform().getShearY(), ship.getTransform().getShearX(), 
//						ship.getTransform().getScaleY(), ship.getTransform().getTranslateX(), 
//						100);
//			 			
//				w.notifyWorldEvent(new HitBorderEvent(info.getWhere(), ship));
//				ship.setTransform(newTransBottom);
//				break;
//			case LEFT: 			
//				AffineTransform newTransLeft = new AffineTransform(ship.getTransform().getScaleX(), 
//						ship.getTransform().getShearY(), ship.getTransform().getShearX(), 
//						ship.getTransform().getScaleY(), Screen.WIDTH_FULL_SCREEN * SystemVariables.SCALE_X - 100, 
//						ship.getTransform().getTranslateY());
//			 			
//				ship.setTransform(newTransLeft);
//				break;
//			case RIGHT: 
//				AffineTransform newTransRight = new AffineTransform(ship.getTransform().getScaleX(), 
//						ship.getTransform().getShearY(), ship.getTransform().getShearX(), 
//						ship.getTransform().getScaleY(), 100, 
//						ship.getTransform().getTranslateY());
//			 			
//				ship.setTransform(newTransRight);
//				break;
//			}
//>>>>>>> paganelli
		
		
		final Optional<MainGameObject> asteroid = w.checkCollisionWithAsteroids(shipBoundingBox);
		//collisioni con asteroidi
		if (asteroid.isPresent()) {
			w.notifyWorldEvent(new HitMainGameObject(ship, asteroid.get()));
			System.out.println("Preso un asteroid Fratellì");
		}
		
		final Optional<MainGameObject> chaseEnemy = w.checkCollisionWithChaseEnemies(shipBoundingBox);
		//collisioni con chaseEnemy
		if (chaseEnemy.isPresent()) {
			w.notifyWorldEvent(new HitMainGameObject(ship, chaseEnemy.get()));
			System.out.println("Preso un chaseEnemy Fratellì");
		}
		
		final Optional<MainGameObject> fireEnemy = w.checkCollisionWithFireEnemies(shipBoundingBox);
		//collisioni con chaseEnemy
		if (fireEnemy.isPresent()) {
			w.notifyWorldEvent(new HitMainGameObject(ship, fireEnemy.get()));
			System.out.println("Preso un fireEnemy Fratellì");
		}
		
		final Optional<MainGameObject> boss = w.checkCollisionWithFireEnemies(shipBoundingBox);
        //collisioni con chaseEnemy
        if (boss.isPresent()) {
            w.notifyWorldEvent(new HitMainGameObject(ship, boss.get()));
            System.out.println("Preso il boss Fratellì");
        }
		
		final Optional<TakeableGameObject> ammo = w.checkCollisionWithAmmo(shipBoundingBox);
		//collisioni con pickable
		if (ammo.isPresent()) {
			w.notifyWorldEvent(new HitTakeableGameObject(ammo.get()));
			System.out.println("Preso un ammo Fratellì");
		}
		
		final Optional<TakeableGameObject> heart = w.checkCollisionWithHearts(shipBoundingBox);
		//collisioni con pickable
		if (heart.isPresent()) {
			w.notifyWorldEvent(new HitTakeableGameObject(heart.get()));
			System.out.println("Preso un heart Fratellì");
		}
	}
	
}