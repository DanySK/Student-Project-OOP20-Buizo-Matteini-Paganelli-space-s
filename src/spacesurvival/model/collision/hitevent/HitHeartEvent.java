package spacesurvival.model.collision.hitevent;

import spacesurvival.model.World;
import spacesurvival.model.gameobject.takeable.TakeableGameObject;
import spacesurvival.model.worldevent.WorldEvent;

public class HitHeartEvent implements WorldEvent {
    private final TakeableGameObject heart;
    private final EventType type = EventType.HEART_EVENT;

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
    
    @Override
    public EventType getType() {
        return this.type;
    }
    
    @Override
    public void manage(World world) {
        this.getCollisionObj().manageEvent(world, this);
    }
}
