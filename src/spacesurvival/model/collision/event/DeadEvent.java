package spacesurvival.model.collision.event;

import spacesurvival.model.World;
import spacesurvival.model.gameobject.GameObject;
import spacesurvival.model.gameobject.takeable.TakeableGameObject;
import spacesurvival.model.worldevent.WorldEvent;

public class DeadEvent implements WorldEvent {
    private final GameObject obj;
    private final EventType type = EventType.DEAD_EVENT;

    /**
     * Constructor for new DeadEvent, generated after the collision to notify the world.
     * 
     * @param obj the GameObjectDead representing the object.
     */
    public DeadEvent(final GameObject obj) {
        this.obj = obj;
    }

    /**
     * Returns the specific ammo that collided.
     * 
     * @return the specified ammo.
     */
    public GameObject getDeadObj() {
        return this.obj;
    }

    @Override
    public EventType getType() {
        return this.type;
    }

    @Override
    public void manage(final World world) {
        this.getDeadObj().collided(world, this);
    }


}
