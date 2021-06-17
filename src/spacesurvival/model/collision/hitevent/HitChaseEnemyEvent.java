package spacesurvival.model.collision.hitevent;

import spacesurvival.model.gameobject.main.MainObject;
import spacesurvival.model.worldevent.WorldEvent;

public class HitChaseEnemyEvent implements WorldEvent {
    private final MainObject chaseEnemy;

    /**
     * Constructor for new HitChaseEnemyEvent, generated after the collision to notify the world.
     * 
     * @param obj the MainGameObject representing the chase enemy.
     */
    public HitChaseEnemyEvent(final MainObject obj) {
        this.chaseEnemy = obj;
    }

    /**
     * Returns MainGameObject rapresents the specific chase enemy that collided.
     * 
     * @return the specified chase enemy.
     */
    public MainObject getCollisionObj() {
        return this.chaseEnemy;
    }
}
