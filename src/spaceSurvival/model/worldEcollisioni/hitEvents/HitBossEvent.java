package spaceSurvival.model.worldEcollisioni.hitEvents;

import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.worldEcollisioni.WorldEvent;

public class HitBossEvent implements WorldEvent {

    private final MainGameObject boss;

    public HitBossEvent(final MainGameObject obj) {
        this.boss = obj;
    }
	
    public MainGameObject getCollisionObj() {
        return this.boss;
    }
}
