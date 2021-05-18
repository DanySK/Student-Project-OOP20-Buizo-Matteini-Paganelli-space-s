package model.worldEcollisioni.hitEvents;

import model.gameObject.MovableGameObject;
import model.worldEcollisioni.WorldEvent;

public class HitFireBulletEvent implements WorldEvent {

	private MovableGameObject bullet;
	
	public HitFireBulletEvent(MovableGameObject obj){
		this.bullet = obj;
	}
	
	public MovableGameObject getCollisionObj(){
		return this.bullet;
	}
}
