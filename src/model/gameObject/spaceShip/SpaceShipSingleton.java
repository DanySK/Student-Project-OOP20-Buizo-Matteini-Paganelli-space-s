package model.gameObject.spaceShip;

import java.util.Optional;

import model.gameObject.AbstractGameObject;
import model.gameObject.GameObjectUtils;
import model.gameObject.Movement;
import model.common.*;
import model.gameObject.weapon.AmmoType;
import model.gameObject.weapon.Weapon;
import model.image.EngineImage;
import model.worldEcollisioni.physics.boundingType.BoundingBox;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import model.worldEcollisioni.physics.components.PhysicsComponent;
import model.worldEcollisioni.physics.components.ShipPhysicsComponent;
import model.GUI.settings.SkinSpaceShip;
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
   		Optional.of(new Weapon(AmmoType.NORMAL)),
   		new RectBoundingBox(),
   		new ShipPhysicsComponent()
    	);

    /** 
    * Invisible class constructor specifying space ship initial position and image path
    */
    private SpaceShipSingleton(final EngineImage engineImage, final int life, final int damage,
    						   final P2d position, final Movement movement, final V2d velocity,
    						   final Optional<Weapon> weapon, final BoundingBox bb, final PhysicsComponent phys) {
    	super(engineImage, life, damage, position, movement, velocity, weapon, bb, phys);
    	this.setBoundingBox(GameObjectUtils.createRectBoundingBox(position, engineImage));
    }
    
    /**
     * @return space ship static instance
     */
    public static SpaceShipSingleton getSpaceShip() {
        return spaceShip;
    }
}

