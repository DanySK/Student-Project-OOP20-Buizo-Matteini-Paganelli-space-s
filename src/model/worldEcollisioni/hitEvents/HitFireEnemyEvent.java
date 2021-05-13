package model.worldEcollisioni.hitEvents;

import model.gameObject.AbstractGameObject;
import model.worldEcollisioni.WorldEvent;

public class HitFireEnemyEvent implements WorldEvent {
	private AbstractGameObject fireEnemy;
	
	public HitFireEnemyEvent(AbstractGameObject obj){
		this.fireEnemy = obj;
	}
	
	public AbstractGameObject getCollisionObj(){
		return this.fireEnemy;
	}
	
}
