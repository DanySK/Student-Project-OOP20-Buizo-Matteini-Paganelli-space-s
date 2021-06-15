package spaceSurvival.model.worldEcollisioni.hitEvents;

import spaceSurvival.model.gameObject.takeableGameObject.TakeableGameObject;
import spaceSurvival.model.worldEcollisioni.WorldEvent;

public class HitTakeableGameObject implements WorldEvent {

    private final TakeableGameObject collidedObject;

    public HitTakeableGameObject(final TakeableGameObject collidedObject) {
        this.collidedObject = collidedObject;
    }

    public TakeableGameObject getCollidedObject() {
        return this.collidedObject;
    }
}
