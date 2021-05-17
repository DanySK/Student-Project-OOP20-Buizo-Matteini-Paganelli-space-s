package model.worldEcollisioni.hitEvents;

import model.gameObject.MainGameObject;
import model.worldEcollisioni.WorldEvent;

public class HitAsteroidEvent implements WorldEvent {

	private MainGameObject asteroid;
	
	public HitAsteroidEvent(MainGameObject obj){
		this.asteroid = obj;
	}
	
	public MainGameObject getCollisionObj(){
		return this.asteroid;
	}
}
