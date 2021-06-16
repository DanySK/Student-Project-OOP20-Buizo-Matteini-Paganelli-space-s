package spacesurvival.model.collisioni.hitevent;

import spacesurvival.model.collisioni.physics.BoundaryCollision.CollisionEdge;
import spacesurvival.model.common.P2d;
import spacesurvival.model.gameobject.MovableGameObject;
import spacesurvival.model.worldevent.WorldEvent;

public class HitBorderEvent implements WorldEvent {
    private final P2d where;
    private final CollisionEdge edge;
    private final MovableGameObject object;

    /**
     * Constructor for new HitBorderEvent, generated after the collision with a border to notify the world.
     * 
     * @param where represents the point where the collision occurred.
     * @param edge represents on which edge the collision occurred.
     * @param object represents the object that collided.
     */
    public HitBorderEvent(final P2d where, final CollisionEdge edge, final MovableGameObject object) {
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
        return where;
    }
	
    /**
     * Returns the specific edge where the collision occurred.
     * 
     * @return the specified edge.
     */
    public CollisionEdge getEdge() {
        return edge;
    }
	
    /**
     * Returns the specific MovableGameObject that collided.
     * 
     * @return the specified MovableGameObject.
     */
    public MovableGameObject getCollisionObj() {
        return this.object;
    }
}
