package spacesurvival.model.worldEcollisioni.hitEvents;

import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.worldEcollisioni.WorldEvent;

public class HitAsteroidEvent implements WorldEvent {
    private final MainGameObject asteroid;

    public HitAsteroidEvent(MainGameObject obj){
        this.asteroid = obj;
    }
	
    public MainGameObject getCollisionObj(){
        return this.asteroid;
    }
}
