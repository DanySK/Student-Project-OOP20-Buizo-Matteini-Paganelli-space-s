package spacesurvival.model.collisioni.hitevent;

import spacesurvival.model.gameobject.takeable.TakeableGameObject;
import spacesurvival.model.worldevent.WorldEvent;

public class HitAmmoEvent implements WorldEvent {
    private final TakeableGameObject ammo;

    public HitAmmoEvent(final TakeableGameObject obj) {
        this.ammo = obj;
    }

    public TakeableGameObject getCollisionObj() {
        return this.ammo;
    }
}
