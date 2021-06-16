package spacesurvival.model.collisioni.hitevent;

import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.worldevent.WorldEvent;

public class HitChaseEnemyEvent implements WorldEvent {
    private final MainGameObject chaseEnemy;

    public HitChaseEnemyEvent(final MainGameObject obj) {
        this.chaseEnemy = obj;
    }
	
    public MainGameObject getCollisionObj() {
        return this.chaseEnemy;
    }	
}
