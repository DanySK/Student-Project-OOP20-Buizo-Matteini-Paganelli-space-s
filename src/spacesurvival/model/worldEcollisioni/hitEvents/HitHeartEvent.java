package spacesurvival.model.worldEcollisioni.hitEvents;

import spacesurvival.model.gameObject.takeableGameObject.TakeableGameObject;
import spacesurvival.model.worldEcollisioni.WorldEvent;

public class HitHeartEvent implements WorldEvent {
    private final TakeableGameObject heart;

    public HitHeartEvent(final TakeableGameObject obj) {
        this.heart = obj;
    }
	
    public TakeableGameObject getCollisionObj() {
        return this.heart;
    }	
}
