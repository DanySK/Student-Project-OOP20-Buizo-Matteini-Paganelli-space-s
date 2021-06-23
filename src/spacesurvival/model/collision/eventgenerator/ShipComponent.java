package spacesurvival.model.collision.eventgenerator;

import java.util.Optional;
import spacesurvival.model.gameobject.GameObject;
import spacesurvival.model.gameobject.fireable.FireableObject;
import spacesurvival.model.gameobject.fireable.SpaceShipSingleton;
import spacesurvival.model.gameobject.main.MainObject;
import spacesurvival.model.gameobject.takeable.TakeableGameObject;
import spacesurvival.model.World;
import spacesurvival.model.collision.bounding.BoundaryCollision;
import spacesurvival.model.collision.bounding.RectBoundingBox;
import spacesurvival.model.collision.event.hit.HitBorderEvent;
import spacesurvival.model.collision.event.hit.HitMainObject;
import spacesurvival.model.collision.event.hit.HitTakeableObject;


public class ShipComponent implements EventComponent {

    /**
     * Update the physics of the ship, check also the collision between ship and other game object.
     * 
     * @param abstractObj the ship
     * @param w represent the current world
     */
    @Override
    public void update(final GameObject abstractObj, final World w) {
        final SpaceShipSingleton ship = (SpaceShipSingleton) abstractObj;

        final RectBoundingBox boundingBox = w.getMainBBox();
        final RectBoundingBox shipBoundingBox = (RectBoundingBox) abstractObj.getBoundingBox();

        final Optional<BoundaryCollision> borderInfo = w.getCollisionController().checkCollisionWithBoundaries(ship.getPosition(), boundingBox);
        if (borderInfo.isPresent()) {
            final BoundaryCollision info = borderInfo.get();
            w.notifyWorldEvent(new HitBorderEvent(info.getWhere(), info.getEdge(), ship));
        }

        final Optional<MainObject> asteroid = w.getCollisionController().checkCollisionWithAsteroids(w.getAsteroids(), shipBoundingBox);
        if (asteroid.isPresent()) {
            w.notifyWorldEvent(new HitMainObject(ship, asteroid.get()));
        }

        final Optional<MainObject> chaseEnemy = w.getCollisionController().checkCollisionWithChaseEnemies(w.getChaseEnemies(), shipBoundingBox);
        if (chaseEnemy.isPresent()) {
            w.notifyWorldEvent(new HitMainObject(ship, chaseEnemy.get()));
        }

        final Optional<FireableObject> fireEnemy = w.getCollisionController().checkCollisionWithFireEnemies(w.getFireEnemies(), shipBoundingBox);
        if (fireEnemy.isPresent()) {
            w.notifyWorldEvent(new HitMainObject(ship, fireEnemy.get()));
        }

        final Optional<FireableObject> boss = w.getCollisionController().checkCollisionWithBoss(w.getBoss(), shipBoundingBox);
        if (boss.isPresent()) {
            w.notifyWorldEvent(new HitMainObject(ship, boss.get()));
        }

        final Optional<TakeableGameObject> ammo = w.getCollisionController().checkCollisionWithAmmo(w.getAmmo(), shipBoundingBox);
        if (ammo.isPresent()) {
            w.notifyWorldEvent(new HitTakeableObject(ammo.get()));
        }

        final Optional<TakeableGameObject> heart = w.getCollisionController().checkCollisionWithHearts(w.getHearts(), shipBoundingBox);
        if (heart.isPresent()) {
            w.notifyWorldEvent(new HitTakeableObject(heart.get()));
        }
    }
}
