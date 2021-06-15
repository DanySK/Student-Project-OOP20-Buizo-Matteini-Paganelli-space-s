package model.worldEcollisioni.hitEvents;

import model.gameObject.takeableGameObject.TakeableGameObject;
import model.worldEcollisioni.WorldEvent;

public class HitHeartEvent implements WorldEvent {
    private final TakeableGameObject heart;

    public HitHeartEvent(final TakeableGameObject obj) {
        this.heart = obj;
    }
	
    public TakeableGameObject getCollisionObj() {
        return this.heart;
    }	
}
