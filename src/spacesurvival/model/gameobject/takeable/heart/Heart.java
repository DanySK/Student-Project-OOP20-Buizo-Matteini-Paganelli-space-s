package spacesurvival.model.gameobject.takeable.heart;

import java.util.Optional;

import spacesurvival.model.EngineImage;
import spacesurvival.model.World;
import spacesurvival.model.collision.event.EventType;
import spacesurvival.model.collision.physics.bounding.BoundingBox;
import spacesurvival.model.collision.physics.component.PhysicsComponent;
import spacesurvival.model.common.P2d;
import spacesurvival.model.gameobject.takeable.TakeableGameObject;
import spacesurvival.model.worldevent.WorldEvent;
import spacesurvival.utilities.path.SoundPath;

public class Heart extends TakeableGameObject {

    private HeartType type;

    public Heart(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final PhysicsComponent phys, final HeartType type) {
        super(engineImage, position, bb, phys, type.getAnimation());
        this.type = type;
    }

    public HeartType getType() {
        return type;
    }

    public void setType(final HeartType type) {
        this.type = type;
    }

    @Override
    public void collided(final World world, final WorldEvent ev) {
        System.out.println("HEART EVENTO->" + EventType.getEventFromHit(ev));
        final Optional<EventType> evType = EventType.getEventFromHit(ev);
        if (evType.isPresent()) {
            switch (EventType.getEventFromHit(ev).get()) {
            case TAKEABLE_OBJECT_EVENT:
                //this.pushEffect(SoundPath.PERK);
                world.getSoundQueue().add(SoundPath.PERK);
                world.getQueueIncreaseLife().add(this.getType().getAmount());
                break;
            default:
                break;
            }
            world.removeHeart(this);
        }
    }

}
