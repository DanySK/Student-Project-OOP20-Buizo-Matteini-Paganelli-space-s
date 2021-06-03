package spaceSurvival.model.worldEcollisioni.hitEvents;

import spaceSurvival.model.gameObject.takeableGameObject.TakeableGameObject;
import spaceSurvival.model.worldEcollisioni.WorldEvent;

public class HitAmmoEvent implements WorldEvent {

	private TakeableGameObject ammo;
	
	public HitAmmoEvent(TakeableGameObject obj) {
		this.ammo = obj;
	}
	
	public TakeableGameObject getCollisionObj() {
		return this.ammo;
	}
	
}
