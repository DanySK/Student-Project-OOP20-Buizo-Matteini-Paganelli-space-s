package spacesurvival.model.gameobject.main;

import java.util.Optional;

import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.gameobject.takeable.Ammo;
import spacesurvival.model.gameobject.takeable.Heart;
import spacesurvival.model.gameobject.takeable.TakeableGameObject;
import spacesurvival.model.movement.ControlledMovement;
import spacesurvival.model.movement.Movement;
import spacesurvival.model.common.*;
import spacesurvival.model.gameobject.weapon.Weapon;
import spacesurvival.model.EngineImage;
import spacesurvival.model.collisioni.physics.bounding.BoundingBox;
import spacesurvival.model.collisioni.physics.bounding.RectBoundingBox;
import spacesurvival.model.collisioni.physics.component.PhysicsComponent;
import spacesurvival.model.collisioni.physics.component.ShipPhysicsComponent;
import spacesurvival.utilities.Score;
import spacesurvival.utilities.dimension.ScaleOf;
import spacesurvival.utilities.dimension.Screen;
import spacesurvival.utilities.path.skin.SkinShip;

public class SpaceShipSingleton extends MainGameObject {

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
   		Optional.empty(),
   		Score.SHIP
    	);

    /** 
    * Invisible class constructor specifying space ship initial position and image path
    */
    private SpaceShipSingleton(final EngineImage engineImage, final P2d position, final BoundingBox bb,
                               final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
                               final int impactDamage, final Optional<Weapon> weapon, final int score) {
		super(engineImage, position, bb, phys, velocity, movement, life, impactDamage, weapon, score);
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

	public void setAcceleration(V2d acceleration) {
		this.acceleration = acceleration;
	}
	
	public void take(TakeableGameObject takeableGameObject) {
		if (takeableGameObject instanceof Ammo) {
			Ammo ammo = (Ammo) takeableGameObject;
			this.getWeapon().get().setAmmoType(ammo.getType());
		} else if (takeableGameObject instanceof Heart) {
			Heart heart = (Heart) takeableGameObject;
			// DA FARE
		}
	}

}