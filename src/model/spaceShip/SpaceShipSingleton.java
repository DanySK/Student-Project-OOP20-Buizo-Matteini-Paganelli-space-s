package model.spaceShip;

import java.util.Optional;

import model.gameElement.AbstractGameObject;
import model.gameElement.GameObjectUtils;
import model.gameElement.Movement;
import model.gameElement.V2d;
import model.gameElement.weapon.Weapon;
import model.GUI.settings.SkinSpaceShip;
import model.environment.Point2D;
import utilities.DesignSpace;
import utilities.DimensionScreen;

public class SpaceShipSingleton extends AbstractGameObject {
    
    // Eager and unique instance of this class for Threadsafing
    private static SpaceShipSingleton spaceShip = new SpaceShipSingleton(
    		SkinSpaceShip.GNEGNE.getPath(),
    		GameObjectUtils.SPACESHIP_LIFE,
    		GameObjectUtils.SPACESHIP_DAMAGE,
    		DesignSpace.CENTER_ENVIRONMENT,
    		Movement.CONTROLLED,
    		new V2d(),
    		Optional.of(new Weapon()),
            100,
            DimensionScreen.WIDTH_FULL_SCREEN
            );

    /** 
    * Invisible class constructor specifying space ship initial position and image path
    */
    private SpaceShipSingleton(final String imagePath, final int life, final int damage,
    						   final Point2D position, final Movement movement, final V2d velocity,
    						   final Optional<Weapon> weapon, final int scaleOf, final int respectTo) {
    	super(imagePath, life, damage, position, movement, velocity, weapon);
    }
    
    /**
     * @return space ship static instance
     */
    public static SpaceShipSingleton getSpaceShip() {
        return spaceShip;
    }
}

