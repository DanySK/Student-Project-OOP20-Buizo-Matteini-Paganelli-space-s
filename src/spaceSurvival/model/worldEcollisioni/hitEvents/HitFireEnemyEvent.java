package spaceSurvival.model.worldEcollisioni.hitEvents;

import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.worldEcollisioni.WorldEvent;

public class HitFireEnemyEvent implements WorldEvent {
	private MainGameObject fireEnemy;
	
	public HitFireEnemyEvent(MainGameObject obj){
		this.fireEnemy = obj;
	}
	
	public MainGameObject getCollisionObj(){
		return this.fireEnemy;
	}
	
}
