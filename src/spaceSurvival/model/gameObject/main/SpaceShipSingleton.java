package spacesurvival.model.gameobject.main;

import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.enemy.FireableObject;
import spacesurvival.model.gameobject.takeable.Ammo;
import spacesurvival.model.movement.ControlledMovement;
import spacesurvival.model.movement.Movement;
import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;
import spacesurvival.model.gameobject.weapon.Weapon;
import spacesurvival.model.gameobject.weapon.shootinglogic.ControlledShooting;
import spacesurvival.model.gameobject.weapon.shootinglogic.ShootingLogic;

import java.util.Optional;

import spacesurvival.model.EngineImage;
import spacesurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spacesurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import spacesurvival.model.worldEcollisioni.physics.components.PhysicsComponent;
import spacesurvival.model.worldEcollisioni.physics.components.ShipPhysicsComponent;
import spacesurvival.utilities.Score;
import spacesurvival.utilities.dimension.ScaleOf;
import spacesurvival.utilities.dimension.Screen;
import spacesurvival.utilities.path.Skin.SkinShip;

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