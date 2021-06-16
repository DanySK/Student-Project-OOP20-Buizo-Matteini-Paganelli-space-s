package spacesurvival.model.collisioni.hitevent;

import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.worldevent.WorldEvent;

public class HitBossEvent implements WorldEvent {
    private final MainGameObject boss;

    public HitBossEvent(final MainGameObject obj) {
        this.boss = obj;
    }
	
    public MainGameObject getCollisionObj() {
        return this.boss;
    }
}
