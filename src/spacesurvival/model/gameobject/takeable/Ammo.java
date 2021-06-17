package spacesurvival.model.gameobject.takeable;

import java.util.List;
import java.util.Optional;

import spacesurvival.model.EngineImage;
import spacesurvival.model.World;
import spacesurvival.model.collision.hitevent.EventType;
import spacesurvival.model.collision.physics.bounding.BoundingBox;
import spacesurvival.model.collision.physics.component.PhysicsComponent;
import spacesurvival.model.common.P2d;
import spacesurvival.model.worldevent.WorldEvent;

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
    //HitTakeableGameObject

    @Override
    public void manageEvent(final World world, final WorldEvent ev) {
        System.out.println("AMMO EVENTO->" + EventType.getEventFromHit(ev));
        final Optional<EventType> evType = EventType.getEventFromHit(ev);
        if (evType.isPresent()) {
            switch (EventType.getEventFromHit(ev).get()) {
            case TAKEABLE_OBJECT_EVENT:
                this.stopAnimation();
                world.getShip().take(this);
                break;
            default:
                break;
            }
            world.removeTakeableObject(this);
        }
        
    }
}
