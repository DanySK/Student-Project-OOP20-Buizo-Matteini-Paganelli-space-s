package spacesurvival.model.worldEcollisioni.hitEvents;

import spacesurvival.model.gameObject.takeableGameObject.TakeableGameObject;
import spacesurvival.model.worldEcollisioni.WorldEvent;

public class HitAmmoEvent implements WorldEvent {
    private final TakeableGameObject ammo;

    public HitAmmoEvent(final TakeableGameObject obj) {
        this.ammo = obj;
    }

    public TakeableGameObject getCollisionObj() {
        return this.ammo;
    }
}
