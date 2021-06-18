package spacesurvival.model.gameobject;

import spacesurvival.model.World;
import spacesurvival.model.worldevent.WorldEvent;

public interface Collideable {

    void collided(World world, WorldEvent worldEvent);
}
