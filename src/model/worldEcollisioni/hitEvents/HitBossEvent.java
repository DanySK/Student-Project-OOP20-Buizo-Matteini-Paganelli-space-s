package model.worldEcollisioni.hitEvents;

import model.gameObject.AbstractGameObject;
import model.worldEcollisioni.WorldEvent;

public class HitBossEvent implements WorldEvent {

	private AbstractGameObject boss;
	
	public HitBossEvent(AbstractGameObject obj){
		this.boss = obj;
	}
	
	public AbstractGameObject getCollisionObj(){
		return this.boss;
	}
}
