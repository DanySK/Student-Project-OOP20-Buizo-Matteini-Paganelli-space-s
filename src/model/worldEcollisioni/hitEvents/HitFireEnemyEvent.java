package model.worldEcollisioni.hitEvents;

import model.gameObject.MainGameObject;
import model.worldEcollisioni.WorldEvent;

public class HitFireEnemyEvent implements WorldEvent {
	private MainGameObject fireEnemy;
	
	public HitFireEnemyEvent(MainGameObject obj){
		this.fireEnemy = obj;
	}
	
	public MainGameObject getCollisionObj(){
		return this.fireEnemy;
	}
	
}
