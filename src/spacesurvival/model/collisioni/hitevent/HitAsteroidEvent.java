package spacesurvival.model.collisioni.hitevent;

import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.worldevent.WorldEvent;

public class HitAsteroidEvent implements WorldEvent {
    private final MainGameObject asteroid;

    public HitAsteroidEvent(MainGameObject obj){
        this.asteroid = obj;
    }
	
    public MainGameObject getCollisionObj(){
        return this.asteroid;
    }
}
