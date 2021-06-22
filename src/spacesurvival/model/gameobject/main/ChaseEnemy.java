package spacesurvival.model.gameobject.main;

import java.util.List;
import java.util.Optional;

import spacesurvival.model.gameobject.Edge;
import spacesurvival.model.gameobject.moveable.movement.MovementLogic;
import spacesurvival.model.worldevent.WorldEvent;
import spacesurvival.utilities.path.SoundPath;
import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;
import spacesurvival.model.EngineImage;
import spacesurvival.model.World;
import spacesurvival.model.collision.bounding.BoundingBox;
import spacesurvival.model.collision.bounding.RectBoundingBox;
import spacesurvival.model.collision.event.EventType;
import spacesurvival.model.collision.event.hit.HitBorderEvent;
import spacesurvival.model.collision.eventgenerator.EventComponent;

/**
 * An enemy able to chase the ship, auto destroy itself when collide with an object.
 */
public class ChaseEnemy extends MainObject {

    public ChaseEnemy(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final EventComponent phys, final V2d velocity, final double acceleration, final MovementLogic movementLogic,
            final int life, final int impactDamage, final int score, final Optional<P2d> target, final List<String> animation) {
        super(engineImage, position, bb, phys, velocity, acceleration, movementLogic, life, impactDamage, score, target);

        this.setBoundingBox(RectBoundingBox.createRectBoundingBox(position, engineImage, this.getTransform()));
        this.setMainAnimation(animation);
    }

    public ChaseEnemy(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final EventComponent phys, final V2d velocity, final double acceleration, final MovementLogic movementLogic,
            final int life, final int impactDamage, final int score, final Optional<P2d> target) {
        super(engineImage, position, bb, phys, velocity, acceleration, movementLogic, life, impactDamage, score, target);
        this.setBoundingBox(RectBoundingBox.createRectBoundingBox(position, engineImage, this.getTransform()));
    }

    @Override
    public void collided(final World world, final WorldEvent ev) {
        System.out.println("gestisco chase enemy e evento" + EventType.getEventFromHit(ev));
        final Optional<EventType> evType = EventType.getEventFromHit(ev);
        if (evType.isPresent()) {
            switch (EventType.getEventFromHit(ev).get()) {
            case BORDER_EVENT:
                final HitBorderEvent hitEvent = (HitBorderEvent) ev;
                final Edge edge = hitEvent.getEdge();
                world.pacmanEffect(this, edge);
                break;
            case MAIN_GAME_OBJECT_EVENT:
            case DEAD_EVENT:
                world.getSoundQueue().add(SoundPath.ENEMY_EXPL);
                world.removeChaseEnemy(this); 
                break;
            default:
                break;
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "ChaseEnemy [ " + super.toString() + "]";
    }

}
