package spacesurvival.model.collision.hitevent;

import spacesurvival.model.World;
import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.gameobject.weapon.Bullet;
import spacesurvival.model.worldevent.WorldEvent;

public class HitBulletEvent implements WorldEvent {
    private final Bullet bullet;
    private final MainGameObject collidedObject;
    private final EventType type = EventType.BULLET_EVENT;

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

    /**
     * Returns a bullet event type.
     * 
     * @return an EventType for the specified event
     */
    @Override
    public EventType getType() {
        return this.type;
    }

    /**
     * Manage the bulled game object event.
     * 
     *@param world the current world
     */
    @Override
    public void manage(final World world) {
        this.getCollidedObject().manageEvent(world, this);
    }

}
