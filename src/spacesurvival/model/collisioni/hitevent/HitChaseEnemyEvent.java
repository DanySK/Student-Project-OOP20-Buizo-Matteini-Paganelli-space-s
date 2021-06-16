package spacesurvival.model.collisioni.hitevent;

import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.worldevent.WorldEvent;

public class HitChaseEnemyEvent implements WorldEvent {
    private final MainGameObject chaseEnemy;

    /**
     * Constructor for new HitChaseEnemyEvent, generated after the collision to notify the world.
     * 
     * @param obj the MainGameObject representing the chase enemy.
     */
    public HitChaseEnemyEvent(final MainGameObject obj) {
        this.chaseEnemy = obj;
    }
	
    /**
     * Returns MainGameObject rapresents the specific chase enemy that collided.
     * 
     * @return the specified chase enemy.
     */
    public MainGameObject getCollisionObj() {
        return this.chaseEnemy;
    }	
}
