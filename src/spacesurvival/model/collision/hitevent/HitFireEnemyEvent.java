package spacesurvival.model.collision.hitevent;

import spacesurvival.model.gameobject.main.MainObject;
import spacesurvival.model.worldevent.WorldEvent;

public class HitFireEnemyEvent implements WorldEvent {
    private final MainObject fireEnemy;

    /**
     * Constructor for new HitChaseEnemyEvent, generated after the collision to notify the world.
     * 
     * @param obj the MainGameObject representing the chase enemy.
     */
    public HitFireEnemyEvent(final MainObject obj) {
        this.fireEnemy = obj;
    }

    /**
     * Returns MainGameObject rapresents the specific fire enemy that collided.
     * 
     * @return the specified fire enemy.
     */
    public MainObject getCollisionObj() {
        return this.fireEnemy;
    }
}
