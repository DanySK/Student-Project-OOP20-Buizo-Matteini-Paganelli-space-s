package spaceSurvival.model.worldEcollisioni.hitEvents;

import spaceSurvival.model.gameObject.PickableGameObject;
import spaceSurvival.model.worldEcollisioni.WorldEvent;

public class HitPickableEvent implements WorldEvent {

	private PickableGameObject perk;
	
	public HitPickableEvent(PickableGameObject obj){
		this.perk = obj;
	}
	
	public PickableGameObject getCollisionObj(){
		return this.perk;
	}
	
}
