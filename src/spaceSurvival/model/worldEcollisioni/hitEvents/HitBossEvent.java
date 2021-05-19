package spaceSurvival.model.worldEcollisioni.hitEvents;

import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.worldEcollisioni.WorldEvent;

public class HitBossEvent implements WorldEvent {

	private MainGameObject boss;
	
	public HitBossEvent(MainGameObject obj){
		this.boss = obj;
	}
	
	public MainGameObject getCollisionObj(){
		return this.boss;
	}
}
