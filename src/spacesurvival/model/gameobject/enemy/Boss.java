package spacesurvival.model.gameobject.enemy;

import java.util.List;
import java.util.Optional;

import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.movement.Movement;
import spacesurvival.model.worldevent.WorldEvent;
import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;
import spacesurvival.model.gameobject.weapon.Bullet;
import spacesurvival.model.gameobject.weapon.Weapon;
import spacesurvival.model.gameobject.weapon.shootinglogic.FiringLogic;
import spacesurvival.model.EngineImage;
import spacesurvival.model.World;
import spacesurvival.model.collision.hitevent.EventType;
import spacesurvival.model.collision.hitevent.HitBulletEvent;
import spacesurvival.model.collision.physics.bounding.BoundingBox;
import spacesurvival.model.collision.physics.component.PhysicsComponent;

public class Boss extends FireableObject {

    public Boss(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
            final int impactDamage, final int score, final Optional<P2d> target, final Weapon weapon,
            final FiringLogic firingLogic, final List<String> animation) {
        super(engineImage, position, bb, phys, velocity, movement, life, impactDamage, score, target, weapon, firingLogic);
        this.setBoundingBox(GameObjectUtils.createRectBoundingBox(position, engineImage, this.getTransform()));
        this.setAnimation(animation);
    }

    public Boss(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
            final int impactDamage, final int score, final Optional<P2d> target, final Weapon weapon,
            final FiringLogic firingLogic) {
        super(engineImage, position, bb, phys, velocity, movement, life, impactDamage, score, target, weapon, firingLogic);
        this.setBoundingBox(GameObjectUtils.createRectBoundingBox(position, engineImage, this.getTransform()));
    }

    @Override
    public void manageEvent(final World world, final WorldEvent ev) {
        System.out.println("gestisco boss e evento" + EventType.getEventFromHit(ev));
        final Optional<EventType> evType = EventType.getEventFromHit(ev);
        if (evType.isPresent()) {
            switch (EventType.getEventFromHit(ev).get()) {
            case BORDER_EVENT:
                break;
            case BULLET_EVENT:
                final HitBulletEvent bulletEvent = (HitBulletEvent) ev;
                final Bullet bullet = bulletEvent.getBullet();
                if (!bullet.getShooter().equals(this)) {
                    bullet.stopAnimation();
                    world.removeBullet(bullet);
                    world.damageObject(this, bullet.getDamage(), bullet.getEffect().getStatus());
                }
                break;
            default:
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Boss { " + super.toString() + " }";
    }

}
