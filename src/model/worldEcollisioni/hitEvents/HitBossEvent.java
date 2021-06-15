package model.worldEcollisioni.hitEvents;

import model.gameObject.MainGameObject;
import model.worldEcollisioni.WorldEvent;

public class HitBossEvent implements WorldEvent {
    private final MainGameObject boss;

    public HitBossEvent(final MainGameObject obj) {
        this.boss = obj;
    }
	
    public MainGameObject getCollisionObj() {
        return this.boss;
    }
}
