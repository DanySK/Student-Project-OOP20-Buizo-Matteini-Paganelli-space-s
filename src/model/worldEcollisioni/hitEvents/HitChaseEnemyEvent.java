package model.worldEcollisioni.hitEvents;

import model.gameObject.AbstractGameObject;
import model.worldEcollisioni.WorldEvent;

public class HitChaseEnemyEvent implements WorldEvent {

	private AbstractGameObject chaseEnemy;
	
	public HitChaseEnemyEvent(AbstractGameObject obj){
		this.chaseEnemy = obj;
	}
	
	public AbstractGameObject getCollisionObj(){
		return this.chaseEnemy;
	}
	
}
