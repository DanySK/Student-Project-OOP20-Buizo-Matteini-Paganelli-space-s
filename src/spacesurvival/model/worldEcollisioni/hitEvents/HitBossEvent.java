package spacesurvival.model.worldEcollisioni.hitEvents;

import spacesurvival.model.gameObject.MainGameObject;
import spacesurvival.model.worldEcollisioni.WorldEvent;

public class HitBossEvent implements WorldEvent {
    private final MainGameObject boss;

    public HitBossEvent(final MainGameObject obj) {
        this.boss = obj;
    }
	
    public MainGameObject getCollisionObj() {
        return this.boss;
    }
}
