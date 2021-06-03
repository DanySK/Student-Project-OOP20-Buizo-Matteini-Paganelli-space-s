package spaceSurvival.model.worldEcollisioni.physics.components;

import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.gameObject.MainGameObject;

import java.util.Optional;

import spaceSurvival.model.World;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitBorderEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitBulletEvent;
import spaceSurvival.model.worldEcollisioni.physics.BoundaryCollision;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import spaceSurvival.model.gameObject.weapon.Bullet;

public class BulletPhysicsComponent implements PhysicsComponent {

	@Override
	public void update(int dt, GameObject abstractObj, World w) {
		Bullet bullet = (Bullet) abstractObj;
		RectBoundingBox boundingBox = w.getMainBBox();
		RectBoundingBox objectBoundingBox = (RectBoundingBox) abstractObj.getBoundingBox();
		
		Optional<BoundaryCollision> borderInfo = w.checkCollisionWithBoundaries(bullet.getPosition(), boundingBox);

		if (borderInfo.isPresent()) {
			w.notifyWorldEvent(new HitBorderEvent(borderInfo.get().getWhere(), borderInfo.get().getEdge(), bullet));
		}

		Optional<MainGameObject> asteroid = w.checkCollisionWithAsteroids(objectBoundingBox);
		System.out.println("STO CERCANDO DI PRENDERE UN ASTEROID " + asteroid);
		//collisioni con asteroidi
		if (asteroid.isPresent()) {
			w.notifyWorldEvent(new HitBulletEvent(bullet, asteroid.get()));
			System.out.println("Preso al volo un asteroid Fratellì");
		}
		
		Optional<MainGameObject> chaseEnemy = w.checkCollisionWithChaseEnemies(objectBoundingBox);
		//collisioni con chaseEnemy
		if (chaseEnemy.isPresent()) {
			w.notifyWorldEvent(new HitBulletEvent(bullet, chaseEnemy.get()));
			System.out.println("Preso al volo un chaseEnemy Fratellì");
		}
		
		Optional<MainGameObject> fireEnemy = w.checkCollisionWithFireEnemies(objectBoundingBox);
		//collisioni con chaseEnemy
		if (fireEnemy.isPresent()) {
			w.notifyWorldEvent(new HitBulletEvent(bullet, fireEnemy.get()));
			System.out.println("Preso al volo un fireEnemy Fratellì");
		}

//		Optional<MainGameObject> boss = w.checkCollisionWithBoss(objectBoundingBox);
//		//collisioni con boss
//		if (boss.isPresent()) {
//			w.notifyWorldEvent(new HitBossEvent(boss.get()));
//			//System.out.println("Preso il boss Fratellì");
//		}
	}

}
