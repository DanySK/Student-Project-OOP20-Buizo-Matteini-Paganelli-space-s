package spacesurvival.model.worldevent;

import spacesurvival.model.World;
import spacesurvival.model.collision.hitevent.EventType;

/**
 * 
 * Interface for every world event.
 *
 */
public interface WorldEvent {

    void manage(World world);

    EventType getType();

}
