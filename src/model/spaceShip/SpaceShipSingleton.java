package model.spaceShip;

import java.awt.geom.AffineTransform;
import java.util.Optional;

import model.gameObject.AbstractGameObject;
import model.gameObject.GameObjectUtils;
import model.gameObject.Movement;
import model.common.*;
import model.gameObject.weapon.Weapon;
import model.image.EngineImage;
import model.GUI.settings.SkinSpaceShip;
import utilities.DesignSpace;
import utilities.dimension.Screen;
import utilities.pathImage.Skin;

public class SpaceShipSingleton extends AbstractGameObject {
    
    // Eager and unique instance of this class for Threadsafing
    private static SpaceShipSingleton spaceShip = new SpaceShipSingleton(
    		new EngineImage(GameObjectUtils.SPACESHIP_SCALEOF, Screen.WIDTH_FULL_SCREEN, Skin.NORMAL),
    		GameObjectUtils.SPACESHIP_LIFE,
    		GameObjectUtils.SPACESHIP_DAMAGE,
    		DesignSpace.CENTER_ENVIRONMENT,
    		Movement.CONTROLLED,
    		new V2d(),
    		new AffineTransform(),
    		Optional.of(new Weapon()));

    /** 
    * Invisible class constructor specifying space ship initial position and image path
    */
    private SpaceShipSingleton(final EngineImage engineImage, final int life, final int damage,
    						   final P2d position, final Movement movement, final V2d velocity, final AffineTransform trasform,
    						   final Optional<Weapon> weapon) {
    	super(engineImage, life, damage, position, movement, velocity, trasform, weapon);
    }
    
    /**
     * @return space ship static instance
     */
    public static SpaceShipSingleton getSpaceShip() {
        return spaceShip;
    }
}

