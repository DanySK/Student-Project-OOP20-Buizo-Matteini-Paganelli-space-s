package spacesurvival.model.gameobject.takeable.ammo;

import spacesurvival.model.EngineImage;
import spacesurvival.model.collision.physics.bounding.BoundingBox;
import spacesurvival.model.collision.physics.component.PhysicsComponent;
import spacesurvival.model.common.P2d;
import spacesurvival.model.gameobject.takeable.TakeableGameObject;

public class Ammo extends TakeableGameObject {

    private AmmoType type;

    public Ammo(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final PhysicsComponent phys, final AmmoType type) {
        super(engineImage, position, bb, phys, type.getAnimation());
        this.type = type;
    }

    /**
     * @return the type of ammo
     */
    public AmmoType getType() {
        return type;
    }

    /**
     * Sets the type to the ammo.
     * @param type the type to set
     */
    public void setType(final AmmoType type) {
        this.type = type;
    }
}
