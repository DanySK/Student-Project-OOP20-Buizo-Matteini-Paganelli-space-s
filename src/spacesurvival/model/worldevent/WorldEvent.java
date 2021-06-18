package spacesurvival.model.worldevent;

import spacesurvival.model.World;
import spacesurvival.model.collision.event.EventType;

/**
 * 
 * Interface for every world event.
 *
 */
public interface WorldEvent {

    void manage(World world);

    EventType getType();

}
