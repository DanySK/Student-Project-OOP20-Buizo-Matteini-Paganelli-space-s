package spacesurvival.model.collision.hitevent;

import spacesurvival.model.gameobject.main.MainObject;
import spacesurvival.model.worldevent.WorldEvent;

public class HitAsteroidEvent implements WorldEvent {
    private final MainObject asteroid;

    /**
     * Constructor for new HitAsteroidEvent, generated after the collision to notify the world.
     * 
     * @param obj the MainGameObject representing the asteroid.
     */
    public HitAsteroidEvent(final MainObject obj) {
        this.asteroid = obj;
    }

    /**
     * Returns the specific asteroid that collided.
     * 
     * @return the specified asteroid.
     */
    public MainObject getCollisionObj() {
        return this.asteroid;
    }
}
