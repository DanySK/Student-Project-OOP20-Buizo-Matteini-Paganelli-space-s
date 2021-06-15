package model.worldEcollisioni.hitEvents;

import model.gameObject.takeableGameObject.TakeableGameObject;
import model.worldEcollisioni.WorldEvent;

public class HitAmmoEvent implements WorldEvent {

	private TakeableGameObject ammo;
	
	public HitAmmoEvent(TakeableGameObject obj) {
		this.ammo = obj;
	}
	
	public TakeableGameObject getCollisionObj() {
		return this.ammo;
	}
	
}
