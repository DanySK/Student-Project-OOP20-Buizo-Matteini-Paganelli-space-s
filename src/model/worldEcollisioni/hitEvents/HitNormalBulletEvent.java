package model.worldEcollisioni.hitEvents;

import model.gameObject.MovableGameObject;
import model.worldEcollisioni.WorldEvent;

public class HitNormalBulletEvent implements WorldEvent {

	private MovableGameObject bullet;
	
	public HitNormalBulletEvent(MovableGameObject obj){
		this.bullet = obj;
	}
	
	public MovableGameObject getCollisionObj(){
		return this.bullet;
	}
}
