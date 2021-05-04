package model.worldEcollisioni.physics;

import model.common.*;
import model.worldEcollisioni.WorldEvent;

public class HitBorderEvent implements WorldEvent {

	private P2d where;
	
	public HitBorderEvent(P2d where){
		this.where = where;
	}
	
	public P2d getWhere(){
		return where;
	}
}
