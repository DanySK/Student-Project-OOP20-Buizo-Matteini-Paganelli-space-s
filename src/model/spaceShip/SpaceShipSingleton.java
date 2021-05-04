package model.spaceShip;

import java.util.Optional;

import model.gameObject.AbstractGameObject;
import model.gameObject.GameObjectUtils;
import model.gameObject.Movement;
import model.common.V2d;
import model.gameObject.weapon.Weapon;
import model.image.EngineImage;
import model.GUI.settings.SkinSpaceShip;
import model.environment.Point2D;
import utilities.DesignSpace;
import utilities.DimensionScreen;

public class SpaceShipSingleton extends AbstractGameObject {
    
    // Eager and unique instance of this class for Threadsafing
    private static SpaceShipSingleton spaceShip = new SpaceShipSingleton(
    		new EngineImage(GameObjectUtils.SPACESHIP_SCALEOF, DimensionScreen.WIDTH_FULL_SCREEN, SkinSpaceShip.GNEGNE.getPath()),
    		GameObjectUtils.SPACESHIP_LIFE,
    		GameObjectUtils.SPACESHIP_DAMAGE,
    		DesignSpace.CENTER_ENVIRONMENT,
    		Movement.CONTROLLED,
    		new V2d(),
    		Optional.of(new Weapon()));

    /** 
    * Invisible class constructor specifying space ship initial position and image path
    */
    private SpaceShipSingleton(final EngineImage engineImage, final int life, final int damage,
    						   final Point2D position, final Movement movement, final V2d velocity,
    						   final Optional<Weapon> weapon) {
    	super(engineImage, life, damage, position, movement, velocity, weapon);
    }
    
    /**
     * @return space ship static instance
     */
    public static SpaceShipSingleton getSpaceShip() {
        return spaceShip;
    }
}

