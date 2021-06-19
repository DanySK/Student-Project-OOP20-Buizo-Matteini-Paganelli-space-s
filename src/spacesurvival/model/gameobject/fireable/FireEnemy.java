package spacesurvival.model.gameobject.fireable;

import java.util.List;
import java.util.Optional;

import spacesurvival.model.gameobject.Edge;
import spacesurvival.model.gameobject.fireable.shootinglogic.FiringLogic;
import spacesurvival.model.gameobject.fireable.weapon.Weapon;
import spacesurvival.model.gameobject.main.MainObject;
import spacesurvival.model.gameobject.movable.movement.MovementLogic;
import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;
import spacesurvival.model.gameobject.Status;
import spacesurvival.model.worldevent.WorldEvent;
import spacesurvival.model.EngineImage;
import spacesurvival.model.World;
import spacesurvival.model.collision.bounding.BoundingBox;
import spacesurvival.model.collision.bounding.RectBoundingBox;
import spacesurvival.model.collision.event.EventType;
import spacesurvival.model.collision.event.hit.HitBorderEvent;
import spacesurvival.model.collision.event.hit.HitMainGameObject;
import spacesurvival.model.collision.eventgenerator.EventComponent;

public class FireEnemy extends FireableObject {

    public FireEnemy(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final EventComponent phys, final V2d velocity, final double acceleration, final MovementLogic movementLogic,
            final int life, final int impactDamage, final int score, final Optional<P2d> target, final Weapon weapon,
            final FiringLogic firingLogic, final List<String> animation) {
        super(engineImage, position, bb, phys, velocity, acceleration, movementLogic, life, impactDamage, score,
                target, weapon, firingLogic);
        this.setBoundingBox(RectBoundingBox.createRectBoundingBox(position, engineImage, this.getTransform()));
        this.setAnimation(animation);
    }

    public FireEnemy(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final EventComponent phys, final V2d velocity, final double acceleration, final MovementLogic movementLogic,
            final int life, final int impactDamage, final int score, final Optional<P2d> target, final Weapon weapon,
            final FiringLogic firingLogic) {
        super(engineImage, position, bb, phys, velocity, acceleration, movementLogic, life, impactDamage, score,
                target, weapon, firingLogic);
        this.setBoundingBox(RectBoundingBox.createRectBoundingBox(position, engineImage, this.getTransform()));
    }

    @Override
    public void collided(final World world, final WorldEvent ev) {
        final Optional<EventType> evType = EventType.getEventFromHit(ev);
        if (evType.isPresent()) {
            switch (EventType.getEventFromHit(ev).get()) {
            case BORDER_EVENT:
                final HitBorderEvent hitEvent = (HitBorderEvent) ev;
                final Edge edge = hitEvent.getEdge();
                world.pacmanEffect(this, edge);
                break;
            case MAIN_GAME_OBJECT_EVENT:
                final HitMainGameObject mainEvent = (HitMainGameObject) ev;
                final MainObject collidedObj = mainEvent.getObject();
                world.damageObject(this, collidedObj.getImpactDamage(), Status.INVINCIBLE);
                break;
            case DEAD_EVENT:
                world.removeFireEnemy(this);
                break;
            default:
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "FireEnemy { " + super.toString() + " }";
    }

}
