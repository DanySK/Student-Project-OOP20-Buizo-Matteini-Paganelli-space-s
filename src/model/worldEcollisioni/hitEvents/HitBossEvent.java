package model.worldEcollisioni.hitEvents;

import model.gameObject.MainGameObject;
import model.worldEcollisioni.WorldEvent;

public class HitBossEvent implements WorldEvent {

	private MainGameObject boss;
	
	public HitBossEvent(MainGameObject obj){
		this.boss = obj;
	}
	
	public MainGameObject getCollisionObj(){
		return this.boss;
	}
}
