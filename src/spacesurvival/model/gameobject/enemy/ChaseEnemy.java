package spacesurvival.model.gameobject.enemy;

import java.util.List;
import java.util.Optional;

import spacesurvival.model.gameobject.Edge;
import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.gameobject.weapon.Bullet;
import spacesurvival.model.movement.Movement;
import spacesurvival.model.worldevent.WorldEvent;
import spacesurvival.utilities.path.SoundPath;
import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;
import spacesurvival.model.EngineImage;
import spacesurvival.model.World;
import spacesurvival.model.collision.hitevent.EventType;
import spacesurvival.model.collision.hitevent.HitBorderEvent;
import spacesurvival.model.collision.hitevent.HitBulletEvent;
import spacesurvival.model.collision.physics.bounding.BoundingBox;
import spacesurvival.model.collision.physics.component.PhysicsComponent;

public class ChaseEnemy extends MainGameObject {

    public ChaseEnemy(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
            final int impactDamage, final int score, final Optional<P2d> target, final List<String> animation) {
        super(engineImage, position, bb, phys, velocity, movement, life, impactDamage, score, target);

        this.setBoundingBox(GameObjectUtils.createRectBoundingBox(position, engineImage, this.getTransform()));
        this.setAnimation(animation);
    }

    public ChaseEnemy(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
            final int impactDamage, final int score, final Optional<P2d> target) {
        super(engineImage, position, bb, phys, velocity, movement, life, impactDamage, score, target);
        this.setBoundingBox(GameObjectUtils.createRectBoundingBox(position, engineImage, this.getTransform()));
    }

    @Override
    public void manageEvent(final World world, final WorldEvent ev) {
        System.out.println("gestisco chase enemy e evento" + EventType.getEventFromHit(ev));
        final Optional<EventType> evType = EventType.getEventFromHit(ev);
        if (evType.isPresent()) {
            switch (EventType.getEventFromHit(ev).get()) {
            case BORDER_EVENT:
                final HitBorderEvent hitEvent = (HitBorderEvent) ev;
                final Edge edge = hitEvent.getEdge();
                this.pushEffect(SoundPath.WALL_COLLISION);
                world.pacmanEffect(this, edge);
                break;
            case BULLET_EVENT:
                final HitBulletEvent bulletEvent = (HitBulletEvent) ev;
                final Bullet bullet = bulletEvent.getBullet();
                bullet.stopAnimation();
                world.removeBullet(bullet);
                world.damageObject(this, bullet.getDamage(), bullet.getEffect().getStatus());
                break;
            default:
                break;
            }
        }
    }
    
    @Override
    public String toString() {
        return "ChaseEnemy { " + super.toString() + " }";
    }

}
