package spacesurvival.model.collision.event;

import java.util.Optional;
import java.util.stream.Stream;

import spacesurvival.model.worldevent.WorldEvent;

public enum EventType {

    /**
     * Represent the HitAmmoEvent.
     */
    BORDER_EVENT,
    /**
     * Represent the HitAmmoEvent.
     */
    BULLET_EVENT,
    /**
     * Represent the HitAmmoEvent.
     */
    MAIN_GAME_OBJECT_EVENT,
    /**
     * Represent the HitAmmoEvent.
     */
    TAKEABLE_OBJECT_EVENT,
    /**
     * Represent the Dead Event.
     */
    DEAD_EVENT;

    private EventType type;

    /**
     * Return the current EventType.
     * @return the current EventType
     */
    public EventType getType() {
        return this.type;
    }

    /**
     * Return the corresponding EventType for thw EorldEvent passed.
     * 
     * @param event the event to check
     * @return an optional of EventType if the passed WorldEvent exists or an empty optional
     */
    public static Optional<EventType> getEventFromHit(final WorldEvent event) {
        return Stream.of(EventType.values()).filter(ev -> ev.equals(event.getType())).findFirst();
    }
}

























