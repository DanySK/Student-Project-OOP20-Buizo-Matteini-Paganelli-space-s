package spacesurvival.model.collisioni.hitevent;

import spacesurvival.model.gameobject.takeable.TakeableGameObject;
import spacesurvival.model.worldevent.WorldEvent;

public class HitHeartEvent implements WorldEvent {
    private final TakeableGameObject heart;

    public HitHeartEvent(final TakeableGameObject obj) {
        this.heart = obj;
    }
	
    public TakeableGameObject getCollisionObj() {
        return this.heart;
    }	
}
