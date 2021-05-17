package model.gameObject.spaceShip;

import java.util.Optional;

import model.gameObject.GameObjectUtils;
import model.gameObject.MainGameObject;
import model.gameObject.Movement;
import model.common.*;
import model.gameObject.weapon.AmmoType;
import model.gameObject.weapon.Weapon;
import model.image.EngineImage;
import model.worldEcollisioni.physics.boundingType.BoundingBox;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import model.worldEcollisioni.physics.components.PhysicsComponent;
import model.worldEcollisioni.physics.components.ShipPhysicsComponent;
import utilities.DesignSpace;
import utilities.dimension.Screen;
import utilities.pathImage.Skin;

public class SpaceShipSingleton extends MainGameObject {
    
    // Eager and unique instance of this class for Threadsafing
    private static SpaceShipSingleton spaceShip = new SpaceShipSingleton(
    	new EngineImage(GameObjectUtils.SPACESHIP_SCALEOF, Screen.WIDTH_FULL_SCREEN, Skin.NORMAL),
   		Screen.POINT_CENTER_FULLSCREEN,
   		new RectBoundingBox(),
   		new ShipPhysicsComponent(),
   		new V2d(),
   		Movement.CONTROLLED,
    	GameObjectUtils.SPACESHIP_LIFE,
   		GameObjectUtils.SPACESHIP_DAMAGE,
   		Optional.of(new Weapon(AmmoType.NORMAL))
    	);

    /** 
    * Invisible class constructor specifying space ship initial position and image path
    */
    private SpaceShipSingleton(final EngineImage engineImage, final P2d position, final BoundingBox bb,
			final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
			final int damage, final Optional<Weapon> weapon) {
		super(engineImage, position, bb, phys, velocity, movement, life, damage, weapon);
    	this.setBoundingBox(GameObjectUtils.createRectBoundingBox(position, engineImage));
    	final RectBoundingBox shipBox = (RectBoundingBox) this.getBoundingBox();
    	this.getTransform().translate(shipBox.getULCorner().getX(), shipBox.getBRCorner().getY());

    	System.out.println("POSITION SPACESHIP CONSTRUCTOR -> " + this.getPosition());

		System.out.println("POSITION SPACESHIP CONSTRUCTOR -> " + this.getBoundingBox());

		System.out.println("POSITION SPACESHIP CONSTRUCTOR -> " + this.getTransform());
    }
    
    /**
     * @return space ship static instance
     */
    public static SpaceShipSingleton getSpaceShip() {
        return spaceShip;
    }
}