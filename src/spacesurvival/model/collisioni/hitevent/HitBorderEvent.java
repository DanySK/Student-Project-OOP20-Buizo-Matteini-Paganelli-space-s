package spacesurvival.model.collisioni.hitevent;

import spacesurvival.model.collisioni.physics.BoundaryCollision.CollisionEdge;
import spacesurvival.model.common.P2d;
import spacesurvival.model.gameobject.MovableGameObject;
import spacesurvival.model.worldevent.WorldEvent;

public class HitBorderEvent implements WorldEvent {
    private final P2d where;
    private final CollisionEdge edge;
    private final MovableGameObject object;

    public HitBorderEvent(final P2d where, final CollisionEdge edge, final MovableGameObject object) {
        this.where = where;
        this.edge = edge;
        this.object = object;
    }
	
    public P2d getWhere() {
        return where;
    }
	
    public CollisionEdge getEdge() {
        return edge;
    }
	
    public MovableGameObject getCollisionObj() {
        return this.object;
    }
}
