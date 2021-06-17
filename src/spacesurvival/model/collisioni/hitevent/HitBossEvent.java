package spacesurvival.model.collisioni.hitevent;

import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.worldevent.WorldEvent;

public class HitBossEvent implements WorldEvent {
    private final MainGameObject boss;

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
}
