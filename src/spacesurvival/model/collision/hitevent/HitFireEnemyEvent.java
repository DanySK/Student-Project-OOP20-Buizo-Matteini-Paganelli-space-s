package spacesurvival.model.collision.hitevent;

import spacesurvival.model.World;
import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.worldevent.WorldEvent;

public class HitFireEnemyEvent implements WorldEvent {
    private final MainGameObject fireEnemy;
    private final EventType type = EventType.FIRE_ENEMY_EVENT;

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
    
    @Override
    public EventType getType() {
        return this.type;
    }
    
    @Override
    public void manage(World world) {
        this.getCollisionObj().manageEvent(world, this);
    }
}
