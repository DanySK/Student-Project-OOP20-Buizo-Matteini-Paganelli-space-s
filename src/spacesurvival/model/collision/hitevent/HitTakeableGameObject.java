package spacesurvival.model.collision.hitevent;

import spacesurvival.model.gameobject.takeable.TakeableGameObject;
import spacesurvival.model.worldevent.WorldEvent;

public class HitTakeableGameObject implements WorldEvent {
    private final TakeableGameObject collidedObject;

    /**
     * Constructor for new HitTakeableGameObject, generated after the collision with TakeableGameObject to notify the world.
     * 
     * @param collidedObject the TakeableGameObject representing the takeable game object.
     */
    public HitTakeableGameObject(final TakeableGameObject collidedObject) {
        this.collidedObject = collidedObject;
    }

    /**
     * Returns the collided TakeableGameObject.
     * 
     * @return the specified TakeableGameObject.
     */
    public TakeableGameObject getCollidedObject() {
        return this.collidedObject;
    }
}
