
package spacesurvival.model.gameobject.fireable.weapon;

import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;
import spacesurvival.model.gameobject.Effect;
import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.Status;
import spacesurvival.model.gameobject.fireable.FireableObject;
import spacesurvival.model.gameobject.main.MainObject;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;
import spacesurvival.model.gameobject.movable.MovableObject;
import spacesurvival.model.gameobject.movable.movement.implementation.FixedMovement;
import spacesurvival.model.worldevent.WorldEvent;
import java.util.Optional;
import spacesurvival.model.EngineImage;
import spacesurvival.model.World;
import spacesurvival.model.collision.event.EventType;
import spacesurvival.model.collision.event.hit.HitBulletEvent;
import spacesurvival.model.collision.physics.bounding.BoundingBox;
import spacesurvival.model.collision.physics.component.PhysicsComponent;

public class Bullet extends MovableObject {

    private int damage;
    private Effect effect;
    private Weapon originWeapon;

    public Bullet(final EngineImage engineImage, final P2d position, final BoundingBox bb, final PhysicsComponent phys,
            final V2d velocity, final double acceleration, final int damage, final Effect effect, final Weapon originWeapon) {
        super(engineImage, position, bb, phys, velocity, acceleration, new FixedMovement());
        this.setBoundingBox(GameObjectUtils.createRectBoundingBox(position, engineImage, this.getTransform()));
        this.damage = damage;
        this.effect = effect;
        this.originWeapon = originWeapon;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(final int damage) {
        this.damage = damage;
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(final Effect effect) {
        this.effect = effect;
    }

    public Weapon getOriginWeapon() {
        return originWeapon;
    }

    public void setOriginWeapon(final Weapon originWeapon) {
        this.originWeapon = originWeapon;
    }

    public FireableObject getShooter() {
        return this.originWeapon.getOwner();
    }

    @Override
    public void collided(final World world, final WorldEvent ev) {
        final Optional<EventType> evType = EventType.getEventFromHit(ev);
        if (evType.isPresent()) {
            switch (EventType.getEventFromHit(ev).get()) {
            case BORDER_EVENT:
                world.removeBullet(this);
                break;
            case BULLET_EVENT:
                final HitBulletEvent bulletEvent = (HitBulletEvent) ev;
                final MainObject collidedObject = bulletEvent.getCollidedObject();
                if (!this.getShooter().equals(collidedObject)) {
                    if (collidedObject instanceof SpaceShipSingleton && !collidedObject.isInvincible()) {
                        world.getQueueDecreaseLife().add(collidedObject.getImpactDamage());
                    } else {
                        world.damageObject(collidedObject, this.getDamage(), this.getEffect().getStatus());
                    }
                    world.removeBullet(this);
                }
                break;
            default:
                break;
            }
        }

    }

}
