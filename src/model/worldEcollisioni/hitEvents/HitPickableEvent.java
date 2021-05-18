package model.worldEcollisioni.hitEvents;

import model.gameObject.PickableGameObject;
import model.worldEcollisioni.WorldEvent;

public class HitPickableEvent implements WorldEvent {

	private PickableGameObject perk;
	
	public HitPickableEvent(PickableGameObject obj){
		this.perk = obj;
	}
	
	public PickableGameObject getCollisionObj(){
		return this.perk;
	}
	
}
