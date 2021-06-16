package spacesurvival.model.worldEcollisioni.hitEvents;

import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.worldEcollisioni.WorldEvent;

public class HitMainGameObject implements WorldEvent {
    private final MainGameObject object;
    private final MainGameObject collidedObject;

    public HitMainGameObject(final MainGameObject object, final MainGameObject collidedObject) {
        this.object = object;
        this.collidedObject = collidedObject;
    }
	
    public MainGameObject getObject() {
        return this.object;
    }
	
    public MainGameObject getCollidedObject() {
        return this.collidedObject;
    }
}
