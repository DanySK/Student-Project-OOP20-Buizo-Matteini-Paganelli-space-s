package spacesurvival.model.collision.eventgenerator;

import spacesurvival.model.gameobject.GameObject;
import spacesurvival.model.gameobject.fireable.FireableObject;
import spacesurvival.model.gameobject.fireable.weapon.Bullet;
import spacesurvival.model.gameobject.main.MainObject;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;

import java.util.Optional;

import spacesurvival.model.World;
import spacesurvival.model.collision.bounding.BoundaryCollision;
import spacesurvival.model.collision.bounding.RectBoundingBox;
import spacesurvival.model.collision.event.hit.HitBorderEvent;
import spacesurvival.model.collision.event.hit.HitBulletEvent;

public class BulletComponent implements PhysicsComponent {

    /**
     * Update the physics of the bullet.
     * 
     * @param abstractObj the bullet
     * @param w represent the current world
     */
    @Override
    public void update(final GameObject abstractObj, final World w) {
        final Bullet bullet = (Bullet) abstractObj;
        final RectBoundingBox boundingBox = w.getMainBBox();
        final RectBoundingBox bulletBoundingBox = (RectBoundingBox) bullet.getBoundingBox();

        final Optional<BoundaryCollision> borderInfo = w.checkCollisionWithBoundaries(bullet.getPosition(), boundingBox);
        if (borderInfo.isPresent()) {
            w.notifyWorldEvent(new HitBorderEvent(borderInfo.get().getWhere(), borderInfo.get().getEdge(), bullet));
        }

        final Optional<SpaceShipSingleton> ship = w.checkCollisionWithShip(bulletBoundingBox);
        if (ship.isPresent()) {
            w.notifyWorldEvent(new HitBulletEvent(bullet, ship.get()));
        }

        final Optional<MainObject> asteroid = w.checkCollisionWithAsteroids(bulletBoundingBox);
        if (asteroid.isPresent()) {
            w.notifyWorldEvent(new HitBulletEvent(bullet, asteroid.get()));
        }

        final Optional<MainObject> chaseEnemy = w.checkCollisionWithChaseEnemies(bulletBoundingBox);
        if (chaseEnemy.isPresent()) {
            w.notifyWorldEvent(new HitBulletEvent(bullet, chaseEnemy.get()));
        }

        final Optional<FireableObject> fireEnemy = w.checkCollisionWithFireEnemies(bulletBoundingBox);
        if (fireEnemy.isPresent()) {
            w.notifyWorldEvent(new HitBulletEvent(bullet, fireEnemy.get()));
        }

        final Optional<FireableObject> boss = w.checkCollisionWithBoss(bulletBoundingBox);
        if (boss.isPresent()) {
            w.notifyWorldEvent(new HitBulletEvent(bullet, boss.get()));
        }
    }

}
