package spacesurvival.model.collision.event.hit;

import spacesurvival.model.World;
import spacesurvival.model.collision.event.EventType;
import spacesurvival.model.gameobject.takeable.TakeableGameObject;
import spacesurvival.model.worldevent.WorldEvent;

public class HitTakeableGameObject implements WorldEvent {
    private final TakeableGameObject collidedObject;
    private final EventType type = EventType.TAKEABLE_OBJECT_EVENT;

    /**
     * Constructor for new HitTakeableGameObject, generated after the collision with TakeableGameObject to notify the world.
     * 
     * @param collidedObject the TakeableGameObject representing the takeable game object
     */
    public HitTakeableGameObject(final TakeableGameObject collidedObject) {
        this.collidedObject = collidedObject;
    }

    /**
     * Returns the collided TakeableGameObject.
     * 
     * @return the specified TakeableGameObject
     */
    public TakeableGameObject getCollidedObject() {
        return this.collidedObject;
    }

    /**
     * Returns a takeable game object event type.
     * 
     * @return an EventType for the specified event
     */
    @Override
    public EventType getType() {
        return this.type;
    }

    /**
     * Manage the takeable game object event.
     * 
     * @param world the current world
     */
    @Override
    public void manage(final World world) {
        this.getCollidedObject().collided(world, this);
    }
}
