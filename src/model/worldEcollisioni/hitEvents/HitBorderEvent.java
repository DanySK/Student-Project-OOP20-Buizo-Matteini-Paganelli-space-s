package model.worldEcollisioni.hitEvents;

import model.common.*;
import model.gameObject.MovableGameObject;
import model.worldEcollisioni.WorldEvent;
import model.worldEcollisioni.physics.BoundaryCollision.CollisionEdge;

public class HitBorderEvent implements WorldEvent {

	private P2d where;
	private CollisionEdge edge;
	private MovableGameObject object;
	
	public HitBorderEvent(final P2d where, final CollisionEdge edge, final MovableGameObject object){
		this.where = where;
		this.edge = edge;
		this.object = object;
	}
	
	public P2d getWhere(){
		return where;
	}
	
	public CollisionEdge getEdge(){
		return edge;
	}
	
	public MovableGameObject getCollisionObj(){
		return this.object;
	}
}
