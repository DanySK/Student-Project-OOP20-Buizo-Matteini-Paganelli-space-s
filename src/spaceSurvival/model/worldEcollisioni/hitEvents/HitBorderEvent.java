package spaceSurvival.model.worldEcollisioni.hitEvents;

import spaceSurvival.model.common.*;
import spaceSurvival.model.gameObject.MovableGameObject;
import spaceSurvival.model.worldEcollisioni.WorldEvent;

public class HitBorderEvent implements WorldEvent {

	private P2d where;
	private MovableGameObject object;
	
	public HitBorderEvent(final P2d where, final MovableGameObject object){
		this.where = where;
		this.object = object;
	}
	
	public P2d getWhere(){
		return where;
	}
	
	public MovableGameObject getCollisionObj(){
		return this.object;
	}
}
