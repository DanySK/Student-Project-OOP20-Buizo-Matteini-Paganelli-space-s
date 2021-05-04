package model.worldEcollisioni.physics;

import model.gameObject.AbstractGameObject;
import model.worldEcollisioni.WorldEvent;

public class HitAsteroidEvent implements WorldEvent {

	private AbstractGameObject obj;
	
	public HitAsteroidEvent(AbstractGameObject obj){
		this.obj = obj;
	}
	
	public AbstractGameObject getCollisionObj(){
		return this.obj;
	}
}
