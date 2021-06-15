package spaceSurvival.model.gameObject.enemy;

import java.util.Optional;

import spaceSurvival.model.EngineImage;
import spaceSurvival.model.common.P2d;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.weapon.Weapon;
import spaceSurvival.model.gameObject.weapon.shootinglogic.ShootingLogic;
import spaceSurvival.model.movement.Movement;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.PhysicsComponent;

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
     * Return the FireableObject weapon.
     *
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
     * Return the FireableObject shooting logic.
     *
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
