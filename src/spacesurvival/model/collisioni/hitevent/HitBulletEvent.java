package spacesurvival.model.collisioni.hitevent;

import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.gameobject.weapon.Bullet;
import spacesurvival.model.worldevent.WorldEvent;

public class HitBulletEvent implements WorldEvent {
    private final Bullet bullet;
    private final MainGameObject collidedObject;

    /**
     * Constructor for new HitBulletEvent, generated after the collision to notify the world.
     * 
     * @param bullet Bullet representing the bullet.
     * @param collidedObject MainGameObject represents the object that collided with the bullet.
     */
    public HitBulletEvent(final Bullet bullet, final MainGameObject collidedObject) {
        this.bullet = bullet;
        this.collidedObject = collidedObject;
    }

    /**
     * Returns the collided MainGameObject.
     * 
     * @return the specified MainGameObject.
     */
    public MainGameObject getCollidedObject() {
        return this.collidedObject;
    }

    /**
     * Returns the Bullet that collided.
     * 
     * @return the specified Bullet.
     */
    public Bullet getBullet() {
        return this.bullet;
    }

}
