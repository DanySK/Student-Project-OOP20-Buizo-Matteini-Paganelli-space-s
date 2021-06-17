
package spacesurvival.model.gameobject.fireable.weapon;

import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;
import spacesurvival.model.gameobject.Effect;
import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.fireable.FireableObject;
import spacesurvival.model.gameobject.main.MainObject;
import spacesurvival.model.gameobject.movable.MovableObject;
import spacesurvival.model.gameobject.movable.movement.implementation.FixedMovement;
import spacesurvival.model.EngineImage;
import spacesurvival.model.collision.physics.bounding.BoundingBox;
import spacesurvival.model.collision.physics.component.PhysicsComponent;

public class Bullet extends MovableObject {

    private int damage;
    private Effect effect;
    private Weapon originWeapon;
    
    public Bullet() {
        // TODO Auto-generated constructor stub
    }
	
    public Bullet(final EngineImage engineImage, final P2d position, final BoundingBox bb, final PhysicsComponent phys,
            final V2d velocity, final int damage, final Effect effect, final Weapon originWeapon) {
        super(engineImage, position, bb, phys, velocity, new FixedMovement());
        this.setBoundingBox(GameObjectUtils.createRectBoundingBox(position, engineImage, this.getTransform()));
        this.damage = damage;
        this.setEffect(effect);
        this.setOriginWeapon(originWeapon);
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
	
}
