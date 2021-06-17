package spacesurvival.model.collision.hitevent;

import java.util.Optional;
import java.util.stream.Stream;

import spacesurvival.model.worldevent.WorldEvent;

public enum EventType {

    /**
     * Represent the HitAmmoEvent.
     */
    AMMO_EVENT,
    /**
     * Represent the HitAmmoEvent.
     */
    ASTEROID_EVENT,
    /**
     * Represent the HitAmmoEvent.
     */
    BORDER_EVENT,
    /**
     * Represent the HitAmmoEvent.
     */
    BOSS_EVENT,
    /**
     * Represent the HitAmmoEvent.
     */
    BULLET_EVENT,
    /**
     * Represent the HitAmmoEvent.
     */
    CHASE_ENEMY_EVENT,
    /**
     * Represent the HitAmmoEvent.
     */
    FIRE_ENEMY_EVENT,
    /**
     * Represent the HitAmmoEvent.
     */
    HEART_EVENT,
    /**
     * Represent the HitAmmoEvent.
     */
    MAIN_GAME_OBJECT_EVENT,
    /**
     * Represent the HitAmmoEvent.
     */
    TAKEABLE_OBJECT_EVENT;

    EventType type;

    public EventType getType() {
        return this.type;
    }

    public static Optional<EventType> getEventFromHit(final WorldEvent event) {
        return Stream.of(EventType.values()).filter(ev -> ev.equals(event.getType())).findFirst();
    }
}

























