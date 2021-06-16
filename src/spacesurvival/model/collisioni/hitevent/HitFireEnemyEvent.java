package spacesurvival.model.collisioni.hitevent;

import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.worldevent.WorldEvent;

public class HitFireEnemyEvent implements WorldEvent {
    private final MainGameObject fireEnemy;

    /**
     * Constructor for new HitChaseEnemyEvent, generated after the collision to notify the world.
     * 
     * @param obj the MainGameObject representing the chase enemy.
     */
    public HitFireEnemyEvent(final MainGameObject obj) {
        this.fireEnemy = obj;
    }

    /**
     * Returns MainGameObject rapresents the specific fire enemy that collided.
     * 
     * @return the specified fire enemy.
     */
    public MainGameObject getCollisionObj() {
        return this.fireEnemy;
    }	
}
