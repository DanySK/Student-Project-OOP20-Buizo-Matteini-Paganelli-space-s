package spacesurvival.model.collisioni.hitevent;

import spacesurvival.model.gameobject.takeable.TakeableGameObject;
import spacesurvival.model.worldevent.WorldEvent;

public class HitTakeableGameObject implements WorldEvent {
    private final TakeableGameObject collidedObject;

    public HitTakeableGameObject(final TakeableGameObject collidedObject) {
        this.collidedObject = collidedObject;
    }

    public TakeableGameObject getCollidedObject() {
        return this.collidedObject;
    }
}
