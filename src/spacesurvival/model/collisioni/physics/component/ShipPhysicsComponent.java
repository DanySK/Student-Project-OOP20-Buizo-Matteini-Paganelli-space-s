package spacesurvival.model.collisioni.physics.component;

import java.util.Optional;

import spacesurvival.model.gameobject.GameObject;
import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.gameobject.enemy.FireableObject;

import spacesurvival.model.gameobject.main.SpaceShipSingleton;
import spacesurvival.model.gameobject.takeable.TakeableGameObject;
import spacesurvival.model.World;
import spacesurvival.model.collisioni.hitevent.HitBorderEvent;
import spacesurvival.model.collisioni.hitevent.HitMainGameObject;
import spacesurvival.model.collisioni.hitevent.HitTakeableGameObject;
import spacesurvival.model.collisioni.physics.BoundaryCollision;
import spacesurvival.model.collisioni.physics.bounding.RectBoundingBox;


public class ShipPhysicsComponent implements PhysicsComponent {

    @Override
    public void update(final int dt, final GameObject abstractObj, final World w) {
        //System.out.println("Sono nell'update");
        final SpaceShipSingleton ship = (SpaceShipSingleton) abstractObj;

        final RectBoundingBox boundingBox = w.getMainBBox();
        final RectBoundingBox shipBoundingBox = (RectBoundingBox) abstractObj.getBoundingBox();

        final Optional<BoundaryCollision> borderInfo = w.checkCollisionWithBoundaries(ship.getPosition(), boundingBox);
        if (borderInfo.isPresent()) {
            final BoundaryCollision info = borderInfo.get();
            w.notifyWorldEvent(new HitBorderEvent(info.getWhere(), info.getEdge(), ship));
        }

        final Optional<MainGameObject> asteroid = w.checkCollisionWithAsteroids(shipBoundingBox);
        //collisioni con asteroidi
        if (asteroid.isPresent()) {
            w.notifyWorldEvent(new HitMainGameObject(ship, asteroid.get()));
        }

        final Optional<MainGameObject> chaseEnemy = w.checkCollisionWithChaseEnemies(shipBoundingBox);
        //collisioni con chaseEnemy
        if (chaseEnemy.isPresent()) {
            w.notifyWorldEvent(new HitMainGameObject(ship, chaseEnemy.get()));
        }

        final Optional<MainGameObject> fireEnemy = w.checkCollisionWithFireEnemies(shipBoundingBox);
        //collisioni con chaseEnemy
        if (fireEnemy.isPresent()) {
            w.notifyWorldEvent(new HitMainGameObject(ship, fireEnemy.get()));
        }

        final Optional<FireableObject> boss = w.checkCollisionWithBoss(shipBoundingBox);
        //collisioni con chaseEnemy
        if (boss.isPresent()) {
            w.notifyWorldEvent(new HitMainGameObject(ship, boss.get()));
        }

        final Optional<TakeableGameObject> ammo = w.checkCollisionWithAmmo(shipBoundingBox);
        //collisioni con pickable
        if (ammo.isPresent()) {
            w.notifyWorldEvent(new HitTakeableGameObject(ammo.get()));
        }

        final Optional<TakeableGameObject> heart = w.checkCollisionWithHearts(shipBoundingBox);
        //collisioni con pickable
        if (heart.isPresent()) {
            w.notifyWorldEvent(new HitTakeableGameObject(heart.get()));
        }
    }

}