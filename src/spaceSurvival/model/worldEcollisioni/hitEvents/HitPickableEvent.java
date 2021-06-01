package spaceSurvival.model.worldEcollisioni.hitEvents;

import spaceSurvival.model.gameObject.TakeableGameObject;
import spaceSurvival.model.worldEcollisioni.WorldEvent;

public class HitPickableEvent implements WorldEvent {

	private TakeableGameObject perk;
	
	public HitPickableEvent(TakeableGameObject obj){
		this.perk = obj;
	}
	
	public TakeableGameObject getCollisionObj(){
		return this.perk;
	}
	
}
