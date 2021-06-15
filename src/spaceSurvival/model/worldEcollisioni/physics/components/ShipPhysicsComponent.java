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

        final Optional<MainGameObject> boss = w.checkCollisionWithBoss(shipBoundingBox);
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