package model.worldEcollisioni.hitEvents;

import model.gameObject.AbstractGameObject;
import model.worldEcollisioni.WorldEvent;

public class HitAsteroidEvent implements WorldEvent {

	private AbstractGameObject asteroid;
	
	public HitAsteroidEvent(AbstractGameObject obj){
		this.asteroid = obj;
	}
	
	public AbstractGameObject getCollisionObj(){
		return this.asteroid;
	}
}
