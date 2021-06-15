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

public class SpaceShipSingleton extends FireableObject {

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
            new Weapon(),
            Score.SHIP,
            Optional.empty(),
            new ControlledShooting()
            );

    /** 
    * Invisible class constructor specifying space ship initial position and image path.
    */
    private SpaceShipSingleton(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
            final int impactDamage, final Weapon weapon, final int score, final Optional<P2d> target,
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

    public void setAcceleration(final V2d acceleration) {
        this.acceleration = acceleration;
    }

    public void take(final TakeableGameObject takeableGameObject) {
        if (takeableGameObject instanceof Ammo) {
            final Ammo ammo = (Ammo) takeableGameObject;
            this.getWeapon().setAmmoType(ammo.getType());
        } else if (takeableGameObject instanceof Heart) {
            final Heart heart = (Heart) takeableGameObject;
            // DA FARE
        }
    }
}