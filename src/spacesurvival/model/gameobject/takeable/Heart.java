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

public class Heart extends TakeableGameObject {

	private HeartType type;
	
	public Heart(final EngineImage engineImage, final P2d position, final BoundingBox bb,
			final PhysicsComponent phys, final HeartType type) {
		super(engineImage, position, bb, phys);
		this.type = type;
	}
	
	public Heart(final EngineImage engineImage, final P2d position, final BoundingBox bb,
			final PhysicsComponent phys, final List<String> animation, final HeartType type) {
		super(engineImage, position, bb, phys, animation);
		this.type = type;
	}

	public HeartType getType() {
		return type;
	}

	public void setType(final HeartType type) {
		this.type = type;
	}

    @Override
    public void manageEvent(final World world, final WorldEvent ev) {
        System.out.println("HEART EVENTO->" + EventType.getEventFromHit(ev));
        final Optional<EventType> evType = EventType.getEventFromHit(ev);
        if (evType.isPresent()) {
            switch (EventType.getEventFromHit(ev).get()) {
            case TAKEABLE_OBJECT_EVENT:
                this.stopAnimation();
                world.getShip().increaseLife(this.getType().getAmount());
                break;
            default:
                break;
            }
            world.removeTakeableObject(this);
        }
    }

}
