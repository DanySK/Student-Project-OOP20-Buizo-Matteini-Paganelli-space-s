package spaceSurvival.model.gameObject.takeableGameObject;

import java.util.List;

import spaceSurvival.model.EngineImage;
import spaceSurvival.model.common.P2d;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.PhysicsComponent;

public class Ammo extends TakeableGameObject {

    private AmmoType type;

    public Ammo(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final PhysicsComponent phys, final AmmoType type, final List<String> animation) {
        super(engineImage, position, bb, phys, animation);
        this.type = type;
    }

    public Ammo(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final PhysicsComponent phys, final AmmoType type) {
        super(engineImage, position, bb, phys);
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
