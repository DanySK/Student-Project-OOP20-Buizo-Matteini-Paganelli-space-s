package model.worldEcollisioni.physics.components;

import java.util.Optional;

import model.gameObject.GameObject;
import model.gameObject.MainGameObject;
import model.gameObject.mainGameObject.SpaceShipSingleton;
import model.gameObject.takeableGameObject.TakeableGameObject;
import model.World;
import model.worldEcollisioni.hitEvents.HitBorderEvent;
import model.worldEcollisioni.hitEvents.HitMainGameObject;
import model.worldEcollisioni.hitEvents.HitTakeableGameObject;
import model.worldEcollisioni.physics.BoundaryCollision;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;

public class ShipPhysicsComponent implements PhysicsComponent {

    private static final int TOLLERANCE = 10;

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
        
        final Optional<MainGameObject> boss = w.checkCollisionWithBoss(shipBoundingBox);
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