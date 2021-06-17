package spacesurvival.model.collision.hitevent;

import spacesurvival.model.World;
import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.worldevent.WorldEvent;

public class HitBossEvent implements WorldEvent {
    private final MainGameObject boss;
    private final EventType type = EventType.BOSS_EVENT;

    /**
     * Constructor for new HitBossEvent, generated after the collision occured with the boss to notify the world.
     * 
     * @param obj the MainGameObject representing the boss.
     */
    public HitBossEvent(final MainGameObject obj) {
        this.boss = obj;
    }

    /**
     * Returns the boss that collided.
     * 
     * @return the specified MainGameObject.
     */
    public MainGameObject getCollisionObj() {
        return this.boss;
    }
    
    @Override
    public EventType getType() {
        return this.type;
    }
    
    @Override
    public void manage(final World world) {
        this.getCollisionObj().manageEvent(world, this);
    }
}
