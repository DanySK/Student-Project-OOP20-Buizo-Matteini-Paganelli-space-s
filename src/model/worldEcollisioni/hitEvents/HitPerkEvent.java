package model.worldEcollisioni.hitEvents;

import model.gameObject.AbstractGameObject;
import model.worldEcollisioni.WorldEvent;

public class HitPerkEvent implements WorldEvent {

	private AbstractGameObject perk;
	
	public HitPerkEvent(AbstractGameObject obj){
		this.perk = obj;
	}
	
	public AbstractGameObject getCollisionObj(){
		return this.perk;
	}
	
}
