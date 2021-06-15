package model.worldEcollisioni.hitEvents;

import model.gameObject.takeableGameObject.TakeableGameObject;
import model.worldEcollisioni.WorldEvent;

public class HitTakeableGameObject implements WorldEvent{

	private TakeableGameObject collidedObject;
	
	public HitTakeableGameObject(TakeableGameObject collidedObject){
		this.collidedObject = collidedObject;
	}
	
	public TakeableGameObject getCollidedObject(){
		return this.collidedObject;
	}
}
