package model.worldEcollisioni.hitEvents;

import model.gameObject.takeableGameObject.TakeableGameObject;
import model.worldEcollisioni.WorldEvent;

public class HitHeartEvent implements WorldEvent {

	private TakeableGameObject heart;
	
	public HitHeartEvent(TakeableGameObject obj) {
		this.heart = obj;
	}
	
	public TakeableGameObject getCollisionObj() {
		return this.heart;
	}
	
}
