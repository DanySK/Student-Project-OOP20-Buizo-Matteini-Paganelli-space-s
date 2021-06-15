package spaceSurvival.model.gameObject.mainGameObject;

import spaceSurvival.model.gameObject.GameObjectUtils;
import spaceSurvival.model.gameObject.enemy.FireableObject;
import spaceSurvival.model.gameObject.takeableGameObject.Ammo;
import spaceSurvival.model.gameObject.takeableGameObject.Heart;
import spaceSurvival.model.gameObject.takeableGameObject.TakeableGameObject;
import spaceSurvival.model.movement.ControlledMovement;
import spaceSurvival.model.movement.Movement;
import spaceSurvival.model.common.P2d;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.weapon.Weapon;
import spaceSurvival.model.gameObject.weapon.shootinglogic.ControlledShooting;
import spaceSurvival.model.gameObject.weapon.shootinglogic.ShootingLogic;

import java.util.Optional;

import spaceSurvival.model.EngineImage;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.PhysicsComponent;
import spaceSurvival.model.worldEcollisioni.physics.components.ShipPhysicsComponent;
import spaceSurvival.utilities.Score;
import spaceSurvival.utilities.dimension.ScaleOf;
import spaceSurvival.utilities.dimension.Screen;
import spaceSurvival.utilities.pathImage.Skin.SkinShip;

public final class SpaceShipSingleton extends FireableObject {

    private V2d acceleration;
	
    // Eager and unique instance of this class for Threadsafing
    private static SpaceShipSingleton spaceShip = new SpaceShipSingleton(
            new EngineImage(ScaleOf.GAME_OBJECT, Screen.WIDTH_FULL_SCREEN, SkinShip.NORMAL0),
            Screen.POINT_CENTER_FULLSCREEN,
            new RectBoundingBox(),
            new ShipPhysicsComponent(),
            GameObjectUtils.SPACESHIP_VEL,
            new ControlledMovement(),
            GameObjectUtils.SPACESHIP_LIFE,
            GameObjectUtils.ASTEROID_DAMAGE,
            Score.SHIP,
            Optional.empty(),
            new Weapon(),
            new ControlledShooting()
            );

    /** 
    * Invisible class constructor specifying space ship initial position and image path.
    */
    private SpaceShipSingleton(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
            final int impactDamage, final int score, final Optional<P2d> target, final Weapon weapon,
            final ShootingLogic shootingLogic) {
        super(engineImage, position, bb, phys, velocity, movement, life, impactDamage, score, target, weapon, shootingLogic);
        this.setBoundingBox(GameObjectUtils.createRectBoundingBox(position, engineImage, this.getTransform()));
    	this.acceleration = new V2d(1, 1);
    }

    /**
     * @return space ship static instance
     */
    public static SpaceShipSingleton getSpaceShip() {
        return spaceShip;
    }

    public V2d getAcceleration() {
        return this.acceleration;
    }

    /**
     * Sets a new acceleration to FireableObject.
     *
     * @param acceleration the acceleration to set
     */
    public void setAcceleration(final V2d acceleration) {
        this.acceleration = acceleration;
    }

    /**
     * Sets the ammo type taken from ship to its weapon.
     *
     * @param ammo the ammo taken from ship 
     */
    public void take(final Ammo ammo) {
        System.out.println("PRENDO MUNIZIONI DI TIPO " + ammo.getType());
        this.getWeapon().setAmmoType(ammo.getType());
    }
}