package spacesurvival.model.collisioni.hitevent;

import spacesurvival.model.gameobject.takeable.TakeableGameObject;
import spacesurvival.model.worldevent.WorldEvent;

public class HitTakeableGameObject implements WorldEvent {
    private final TakeableGameObject collidedObject;

    /**
     * Constructor for new TakeableGameObject, generated after the collision with MainGameObject to notify the world.
     * 
     * @param collidedObject the MainGameObject representing the second main game object.
     */
    public HitTakeableGameObject(final TakeableGameObject collidedObject) {
        this.collidedObject = collidedObject;
    }

    public TakeableGameObject getCollidedObject() {
        return this.collidedObject;
    }
}
