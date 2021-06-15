package spaceSurvival.model.worldEcollisioni.hitEvents;

import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.worldEcollisioni.WorldEvent;

public class HitAsteroidEvent implements WorldEvent {

    private final MainGameObject asteroid;

    public HitAsteroidEvent(MainGameObject obj){
        this.asteroid = obj;
    }
	
    public MainGameObject getCollisionObj(){
        return this.asteroid;
    }
}
