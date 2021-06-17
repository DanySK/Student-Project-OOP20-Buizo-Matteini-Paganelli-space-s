package spacesurvival.model.collision.hitevent;

import spacesurvival.model.gameobject.takeable.TakeableGameObject;
import spacesurvival.model.worldevent.WorldEvent;

public class HitHeartEvent implements WorldEvent {
    private final TakeableGameObject heart;

    /**
     * Constructor for new HitHeartEvent, generated after the collision with the perk to notify the world.
     * 
     * @param obj the TakeableGameObject representing the heart perk.
     */
    public HitHeartEvent(final TakeableGameObject obj) {
        this.heart = obj;
    }

    /**
     * Returns TakeableGameObject rapresents the specific heart perk that collided.
     * 
     * @return the specified heart perk.
     */
    public TakeableGameObject getCollisionObj() {
        return this.heart;
    }
}
