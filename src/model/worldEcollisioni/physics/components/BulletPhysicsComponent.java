package model.worldEcollisioni.physics.components;

import model.gameObject.GameObject;
import model.gameObject.MainGameObject;

import java.util.Optional;

import model.World;
import model.worldEcollisioni.hitEvents.HitBorderEvent;
import model.worldEcollisioni.hitEvents.HitBulletEvent;
import model.worldEcollisioni.physics.BoundaryCollision;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import model.gameObject.weapon.Bullet;

public class BulletPhysicsComponent implements PhysicsComponent {

    @Override
    public void update(final int dt, final GameObject abstractObj, final World w) {
        final Bullet bullet = (Bullet) abstractObj;
        final RectBoundingBox boundingBox = w.getMainBBox();
        final RectBoundingBox objectBoundingBox = (RectBoundingBox) abstractObj.getBoundingBox();
        final Optional<BoundaryCollision> borderInfo = w.checkCollisionWithBoundaries(bullet.getPosition(), boundingBox);

        if (borderInfo.isPresent()) {
            w.notifyWorldEvent(new HitBorderEvent(borderInfo.get().getWhere(), borderInfo.get().getEdge(), bullet));
        }

        final Optional<MainGameObject> asteroid = w.checkCollisionWithAsteroids(objectBoundingBox);
        //collisioni con asteroidi
        if (asteroid.isPresent()) {
            w.notifyWorldEvent(new HitBulletEvent(bullet, asteroid.get()));
        }
	
        final Optional<MainGameObject> chaseEnemy = w.checkCollisionWithChaseEnemies(objectBoundingBox);
        //collisioni con chaseEnemy
        if (chaseEnemy.isPresent()) {
            w.notifyWorldEvent(new HitBulletEvent(bullet, chaseEnemy.get()));
        }

        final Optional<MainGameObject> fireEnemy = w.checkCollisionWithFireEnemies(objectBoundingBox);
        //collisioni con chaseEnemy
        if (fireEnemy.isPresent()) {
            w.notifyWorldEvent(new HitBulletEvent(bullet, fireEnemy.get()));
        }

        final Optional<MainGameObject> boss = w.checkCollisionWithBoss(objectBoundingBox);
        //collisioni con boss
        if (boss.isPresent()) {
            w.notifyWorldEvent(new HitBulletEvent(bullet, boss.get()));
        }
    }

}
