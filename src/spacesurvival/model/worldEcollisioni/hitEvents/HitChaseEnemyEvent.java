package spacesurvival.model.worldEcollisioni.hitEvents;

import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.worldEcollisioni.WorldEvent;

public class HitChaseEnemyEvent implements WorldEvent {
    private final MainGameObject chaseEnemy;

    public HitChaseEnemyEvent(final MainGameObject obj) {
        this.chaseEnemy = obj;
    }
	
    public MainGameObject getCollisionObj() {
        return this.chaseEnemy;
    }	
}
