package CommandProva.model;

import common.*;

public class HitWallEvent implements WorldEvent {

	private P2d where;
	
	public HitWallEvent(P2d where){
		this.where = where;
	}
	
	public P2d getWhere(){
		return where;
	}
}
