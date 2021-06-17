package spacesurvival.model.collisioni.hitevent;

import spacesurvival.model.gameobject.takeable.TakeableGameObject;
import spacesurvival.model.worldevent.WorldEvent;

public class HitAmmoEvent implements WorldEvent {
    private final TakeableGameObject ammo;

    /**
     * Constructor for new HitAmmoEvent, generated after the collision to notify the world.
     * 
     * @param obj the TakeableGameObject representing the ammo.
     */
    public HitAmmoEvent(final TakeableGameObject obj) {
        this.ammo = obj;
    }

    /**
     * Returns the specific ammo that collided.
     * 
     * @return the specified ammo.
     */
    public TakeableGameObject getCollisionObj() {
        return this.ammo;
    }
}
