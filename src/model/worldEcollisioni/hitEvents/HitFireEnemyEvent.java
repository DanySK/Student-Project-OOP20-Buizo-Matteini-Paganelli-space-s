package model.worldEcollisioni.hitEvents;

import model.gameObject.MainGameObject;
import model.worldEcollisioni.WorldEvent;

public class HitFireEnemyEvent implements WorldEvent {
    private final MainGameObject fireEnemy;
    
    public HitFireEnemyEvent(final MainGameObject obj) {
        this.fireEnemy = obj;
    }
	
    public MainGameObject getCollisionObj(){
        return this.fireEnemy;
    }	
}
