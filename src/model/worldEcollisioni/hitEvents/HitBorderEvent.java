package model.worldEcollisioni.hitEvents;

import model.common.P2d;
import model.gameObject.MovableGameObject;
import model.worldEcollisioni.WorldEvent;
import model.worldEcollisioni.physics.BoundaryCollision.CollisionEdge;

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
