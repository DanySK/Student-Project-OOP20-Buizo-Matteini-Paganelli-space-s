package model.worldEcollisioni.hitEvents;

import model.gameObject.MovableGameObject;
import model.worldEcollisioni.WorldEvent;

public class HitIceBulletEvent implements WorldEvent {

	private MovableGameObject bullet;
	
	public HitIceBulletEvent(MovableGameObject obj){
		this.bullet = obj;
	}
	
	public MovableGameObject getCollisionObj(){
		return this.bullet;
	}
}
