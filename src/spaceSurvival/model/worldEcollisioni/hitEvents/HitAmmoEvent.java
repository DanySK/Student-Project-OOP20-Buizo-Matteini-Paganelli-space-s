package spaceSurvival.model.worldEcollisioni.hitEvents;

import spaceSurvival.model.gameObject.takeableGameObject.TakeableGameObject;
import spaceSurvival.model.worldEcollisioni.WorldEvent;

public class HitAmmoEvent implements WorldEvent {

    private final TakeableGameObject ammo;

    public HitAmmoEvent(final TakeableGameObject obj) {
        this.ammo = obj;
    }

    public TakeableGameObject getCollisionObj() {
        return this.ammo;
    }
}
