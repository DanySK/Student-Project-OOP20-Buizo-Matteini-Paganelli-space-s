package spacesurvival.model.collision.hitevent;

import spacesurvival.model.gameobject.main.MainObject;
import spacesurvival.model.worldevent.WorldEvent;

public class HitBossEvent implements WorldEvent {
    private final MainObject boss;

    /**
     * Constructor for new HitBossEvent, generated after the collision occured with the boss to notify the world.
     * 
     * @param obj the MainGameObject representing the boss.
     */
    public HitBossEvent(final MainObject obj) {
        this.boss = obj;
    }

    /**
     * Returns the boss that collided.
     * 
     * @return the specified MainGameObject.
     */
    public MainObject getCollisionObj() {
        return this.boss;
    }
}
