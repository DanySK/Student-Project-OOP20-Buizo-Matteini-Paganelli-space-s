package spacesurvival.model.collisioni.hitevent;

import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.worldevent.WorldEvent;

public class HitAsteroidEvent implements WorldEvent {
    private final MainGameObject asteroid;

    /**
     * Constructor for new HitAsteroidEvent, generated after the collision to notify the world.
     * 
     * @param obj the MainGameObject representing the asteroid.
     */
    public HitAsteroidEvent(final MainGameObject obj) {
        this.asteroid = obj;
    }

    /**
     * Returns the specific asteroid that collided.
     * 
     * @return the specified asteroid.
     */
    public MainGameObject getCollisionObj() {
        return this.asteroid;
    }
}
