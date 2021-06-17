package spacesurvival.model.worldevent;

/**
 * 
 * Listener for every event of the world.
 *
 */
public interface WorldEventListener {
    void notifyEvent(WorldEvent ev);
}
