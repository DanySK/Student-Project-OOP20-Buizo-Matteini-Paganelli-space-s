package spacesurvival.model.worldEcollisioni.hitEvents;

import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.worldEcollisioni.WorldEvent;

public class HitFireEnemyEvent implements WorldEvent {
    private final MainGameObject fireEnemy;
    
    public HitFireEnemyEvent(final MainGameObject obj) {
        this.fireEnemy = obj;
    }
	
    public MainGameObject getCollisionObj(){
        return this.fireEnemy;
    }	
}
