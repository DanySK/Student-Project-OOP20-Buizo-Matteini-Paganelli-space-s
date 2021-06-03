package spaceSurvival.model.worldEcollisioni.hitEvents;

import spaceSurvival.model.gameObject.takeableGameObject.TakeableGameObject;
import spaceSurvival.model.worldEcollisioni.WorldEvent;

public class HitHeartEvent implements WorldEvent {

	private TakeableGameObject heart;
	
	public HitHeartEvent(TakeableGameObject obj) {
		this.heart = obj;
	}
	
	public TakeableGameObject getCollisionObj() {
		return this.heart;
	}
	
}
