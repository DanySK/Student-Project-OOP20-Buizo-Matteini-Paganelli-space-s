package spacesurvival.model.collision.physics.component;

import spacesurvival.model.gameobject.GameObject;
import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.gameobject.enemy.FireableObject;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;

import java.util.Optional;

import spacesurvival.model.World;
import spacesurvival.model.collision.hitevent.HitBorderEvent;
import spacesurvival.model.collision.hitevent.HitBulletEvent;
import spacesurvival.model.collision.physics.BoundaryCollision;
import spacesurvival.model.collision.physics.bounding.RectBoundingBox;
import spacesurvival.model.gameobject.weapon.Bullet;

public class BulletPhysicsComponent implements PhysicsComponent {

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
        final RectBoundingBox objectBoundingBox = (RectBoundingBox) bullet.getBoundingBox();
        System.out.println("UPDATE");
        System.out.println(objectBoundingBox);
        System.out.println(bullet.getPosition());

        final Optional<BoundaryCollision> borderInfo = w.checkCollisionWithBoundaries(bullet.getPosition(), boundingBox);

        if (borderInfo.isPresent()) {
            w.notifyWorldEvent(new HitBorderEvent(borderInfo.get().getWhere(), borderInfo.get().getEdge(), bullet));
        }

        final Optional<SpaceShipSingleton> ship = w.checkCollisionWithShip(objectBoundingBox);
        //collisioni con asteroidi
        if (ship.isPresent()) {
            w.notifyWorldEvent(new HitBulletEvent(bullet, ship.get()));
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

        final Optional<FireableObject> fireEnemy = w.checkCollisionWithFireEnemies(objectBoundingBox);
        //collisioni con chaseEnemy
        if (fireEnemy.isPresent()) {
            w.notifyWorldEvent(new HitBulletEvent(bullet, fireEnemy.get()));
        }

        final Optional<FireableObject> boss = w.checkCollisionWithBoss(objectBoundingBox);
        //collisioni con boss
        if (boss.isPresent()) {
            System.out.println("COLLISIONE BULLET COL BOSSSSS");
            System.out.println("BOSS  " + boss.get().getPosition());
            System.out.println("BULLET  " + bullet.getPosition());
            w.notifyWorldEvent(new HitBulletEvent(bullet, boss.get()));
        }
    }

}
