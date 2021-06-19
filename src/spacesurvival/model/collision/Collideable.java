package spacesurvival.model.collision;

import spacesurvival.model.World;
import spacesurvival.model.worldevent.WorldEvent;

/**
 * Interface to apply of the object that can collide and manage the WorldEvent.
 *
 */
public interface Collideable {

    void collided(World world, WorldEvent worldEvent);
}
