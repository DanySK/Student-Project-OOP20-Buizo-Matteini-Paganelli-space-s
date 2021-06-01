package spaceSurvival.model.worldEcollisioni.physics.components;

import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.gameObject.MainGameObject;

import java.util.Optional;

import spaceSurvival.model.World;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitBorderEvent;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitBulletEvent;
import spaceSurvival.model.worldEcollisioni.physics.BoundaryCollision;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import spaceSurvival.model.gameObject.weapon.NormalBullet;

public class NormalBulletPhysicsComponent implements PhysicsComponent {

	@Override
	public void update(int dt, GameObject abstractObj, World w) {
		NormalBullet normalBullet = (NormalBullet) abstractObj;
		RectBoundingBox boundingBox = w.getMainBBox();

		Optional<BoundaryCollision> borderInfo = w.checkCollisionWithBoundaries(normalBullet.getPosition(), boundingBox);

		if (borderInfo.isPresent()) {
			w.notifyWorldEvent(new HitBorderEvent(borderInfo.get().getWhere(), normalBullet));
		}
			
		Optional<MainGameObject> asteroid = w.checkCollisionWithAsteroids((RectBoundingBox)abstractObj.getBoundingBox());
		//collisioni con asteroidi
		if (asteroid.isPresent()) {
			w.notifyWorldEvent(new HitBulletEvent(normalBullet, asteroid.get()));
			System.out.println("Preso al volo un asteroid Fratellì");
		}
		
		Optional<MainGameObject> chaseEnemy = w.checkCollisionWithChaseEnemies((RectBoundingBox)abstractObj.getBoundingBox());
		//collisioni con chaseEnemy
		if (chaseEnemy.isPresent()) {
			w.notifyWorldEvent(new HitBulletEvent(normalBullet, chaseEnemy.get()));
			System.out.println("Preso al volo un chaseEnemy Fratellì");
		}
		
		Optional<MainGameObject> fireEnemy = w.checkCollisionWithFireEnemies((RectBoundingBox)abstractObj.getBoundingBox());
		//collisioni con chaseEnemy
		if (fireEnemy.isPresent()) {
			w.notifyWorldEvent(new HitBulletEvent(normalBullet, fireEnemy.get()));
			System.out.println("Preso al volo un chaseEnemy Fratellì");
		}
//		
//		Optional<MainGameObject> fireEnemy = w.checkCollisionWithFireEnemies(ship.getPosition(), shipBoundingBox);
//		//collisioni con fireEnemy
//		if (fireEnemy.isPresent()) {
//			w.notifyWorldEvent(new HitFireEnemyEvent(fireEnemy.get()));
//			System.out.println("Preso un fireEnemy Fratellì");
//		}
//		
//		Optional<MainGameObject> boss = w.checkCollisionWithBoss(ship.getPosition(), shipBoundingBox);
//		//collisioni con boss
//		if (boss.isPresent()) {
//			w.notifyWorldEvent(new HitBossEvent(boss.get()));
//			//System.out.println("Preso il boss Fratellì");
//		}
	}

}
