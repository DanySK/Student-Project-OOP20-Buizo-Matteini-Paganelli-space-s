package spacesurvival.model.collision.hitevent;

import spacesurvival.model.World;
import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.worldevent.WorldEvent;

public class HitMainGameObject implements WorldEvent {
    private final MainGameObject object;
    private final MainGameObject collidedObject;
    private final EventType type = EventType.MAIN_GAME_OBJECT_EVENT;

    /**
     * Constructor for new HitMainGameObject, generated after the collision with MainGameObject to notify the world.
     * 
     * @param object the MainGameObject representing the first main game object.
     * @param collidedObject the MainGameObject representing the second main game object.
     */
    public HitMainGameObject(final MainGameObject object, final MainGameObject collidedObject) {
        this.object = object;
        this.collidedObject = collidedObject;
    }

    /**
     * Returns the first collided MainGameObject.
     * 
     * @return the specified MainGameObject.
     */
    public MainGameObject getObject() {
        return this.object;
    }

    /**
     * Returns the second collided MainGameObject.
     * 
     * @return the specified MainGameObject.
     */
    public MainGameObject getCollidedObject() {
        return this.collidedObject;
    }

    @Override
    public EventType getType() {
        return this.type;
    }

    @Override
    public void manage(final World world) {
        this.getCollidedObject().manageEvent(world, this);
    }
}
