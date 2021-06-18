package spacesurvival.model.collision.event.hit;


import spacesurvival.model.World;
import spacesurvival.model.collision.event.EventType;
import spacesurvival.model.common.P2d;
import spacesurvival.model.gameobject.Edge;
import spacesurvival.model.gameobject.movable.MovableObject;
import spacesurvival.model.worldevent.WorldEvent;

public class HitBorderEvent implements WorldEvent {
    private final P2d where;
    private final Edge edge;
    private final MovableObject object;
    private final EventType type = EventType.BORDER_EVENT;

    /**
     * Constructor for new HitBorderEvent, generated after the collision with a border to notify the world.
     * 
     * @param where represents the point where the collision occurred.
     * @param edge represents on which edge the collision occurred.
     * @param object represents the object that collided.
     */
    public HitBorderEvent(final P2d where, final Edge edge, final MovableObject object) {
        this.where = where;
        this.edge = edge;
        this.object = object;
    }

    /**
     * Returns the specific point where the collision occurred.
     * 
     * @return the specified point where the collision occurred.
     */
    public P2d getWhere() {
        return this.where;
    }

    /**
     * Returns the specific edge where the collision occurred.
     * 
     * @return the specified edge.
     */
    public Edge getEdge() {
        return this.edge;
    }

    /**
     * Returns the specific MovableGameObject that collided.
     * 
     * @return the specified MovableGameObject.
     */
    public MovableObject getCollisionObj() {
        return this.object;
    }

    @Override
    public EventType getType() {
        return this.type;
    }

    @Override
    public void manage(final World world) {
        this.getCollisionObj().collided(world, this);
    }
}
