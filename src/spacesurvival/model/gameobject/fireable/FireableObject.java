package spacesurvival.model.gameobject.fireable;

import java.util.Optional;

import spacesurvival.model.EngineImage;
import spacesurvival.model.collision.physics.bounding.BoundingBox;
import spacesurvival.model.collision.physics.component.PhysicsComponent;
import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;
import spacesurvival.model.gameobject.fireable.shootinglogic.FiringLogic;
import spacesurvival.model.gameobject.fireable.weapon.Weapon;
import spacesurvival.model.gameobject.main.MainObject;
import spacesurvival.model.gameobject.movable.movement.MovementLogic;

public abstract class FireableObject extends MainObject {

    private Weapon weapon;
    private FiringLogic firingLogic;

    public FireableObject(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final PhysicsComponent phys, final V2d velocity, final double acceleration, final MovementLogic movementLogic,
            final int life, final int impactDamage, final int score, final Optional<P2d> target, final Weapon weapon,
            final FiringLogic firingLogic) {
        super(engineImage, position, bb, phys, velocity, acceleration, movementLogic, life, impactDamage, score, target);
        this.weapon = weapon;
        this.firingLogic = firingLogic;
    }

    /**
     * Start firing with the own weapon and logics.
     */
    public void startFiring() {
        firingLogic.startFiring(this);
        firingLogic.startChangingAmmo(this);
    }

    /**
     * Fire one shot with the own weapon.
     */
    public void fire() {
        weapon.shoot();
    }

    /**
     * @return the FireableObject weapon
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
    * Sets a new weapon to FireableObject.
    *
    * @param weapon the new weapon to set
    */
    public void setWeapon(final Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * @return the FireableObject shooting logic
     */
    public FiringLogic getShootingLogic() {
        return firingLogic;
    }

    /**
     * Sets a new shooting logic to FireableObject.
     *
     * @param firingLogic the new shootingLogic to set
     */
    public void setShootingLogic(final FiringLogic firingLogic) {
        this.firingLogic = firingLogic;
    }
}
