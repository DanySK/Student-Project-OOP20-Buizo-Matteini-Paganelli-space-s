package spaceSurvival.model.worldEcollisioni.hitEvents;

import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.worldEcollisioni.WorldEvent;

public class HitChaseEnemyEvent implements WorldEvent {

	private MainGameObject chaseEnemy;
	
	public HitChaseEnemyEvent(MainGameObject obj){
		this.chaseEnemy = obj;
	}
	
	public MainGameObject getCollisionObj(){
		return this.chaseEnemy;
	}
	
}