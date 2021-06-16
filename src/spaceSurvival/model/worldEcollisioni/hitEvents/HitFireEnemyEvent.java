package spaceSurvival.model.worldEcollisioni.hitEvents;

import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.worldEcollisioni.WorldEvent;

public class HitFireEnemyEvent implements WorldEvent {
    private final MainGameObject fireEnemy;
    
    public HitFireEnemyEvent(final MainGameObject obj) {
        this.fireEnemy = obj;
    }
	
    public MainGameObject getCollisionObj(){
        return this.fireEnemy;
    }	
}
