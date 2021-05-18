package model.worldEcollisioni.hitEvents;

import model.gameObject.MovableGameObject;
import model.worldEcollisioni.WorldEvent;

public class HitElectricBulletEvent implements WorldEvent {

	private MovableGameObject bullet;
	
	public HitElectricBulletEvent(MovableGameObject obj){
		this.bullet = obj;
	}
	
	public MovableGameObject getCollisionObj(){
		return this.bullet;
	}
}
