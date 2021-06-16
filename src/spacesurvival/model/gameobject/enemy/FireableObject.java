package spacesurvival.model.gameobject.enemy;

import java.util.Optional;

import spacesurvival.model.EngineImage;
import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;
import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.gameobject.weapon.Weapon;
import spacesurvival.model.gameobject.weapon.shootinglogic.ShootingLogic;
import spacesurvival.model.movement.Movement;
import spacesurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spacesurvival.model.worldEcollisioni.physics.components.PhysicsComponent;

public abstract class FireableObject extends MainGameObject {

    private Weapon weapon;
    private ShootingLogic shootingLogic;

    public FireableObject(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
            final int impactDamage, final int score, final Optional<P2d> target, final Weapon weapon,
            final ShootingLogic shootingLogic) {
        super(engineImage, position, bb, phys, velocity, movement, life, impactDamage, score, target);
        this.weapon = weapon;
        this.shootingLogic = shootingLogic;
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
    public ShootingLogic getShootingLogic() {
        return shootingLogic;
    }

    /**
     * Sets a new shooting logic to FireableObject.
     *
     * @param shootingLogic the new shootingLogic to set
     */
    public void setShootingLogic(final ShootingLogic shootingLogic) {
        this.shootingLogic = shootingLogic;
    }
}
