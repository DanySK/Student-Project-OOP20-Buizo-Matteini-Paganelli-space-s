package spaceSurvival.model.worldEcollisioni.hitEvents;

import spaceSurvival.model.common.P2d;
import spaceSurvival.model.gameObject.MovableGameObject;
import spaceSurvival.model.worldEcollisioni.WorldEvent;
import spaceSurvival.model.worldEcollisioni.physics.BoundaryCollision.CollisionEdge;

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
