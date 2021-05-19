package spaceSurvival.model.gameObject.mainGameObject;

import java.util.Optional;

import spaceSurvival.model.gameObject.GameObjectUtils;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.Movement;
import spaceSurvival.model.common.*;
import spaceSurvival.model.gameObject.weapon.Weapon;
import spaceSurvival.model.image.EngineImage;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.PhysicsComponent;
import spaceSurvival.model.worldEcollisioni.physics.components.ShipPhysicsComponent;
import spaceSurvival.utilities.dimension.Screen;
import spaceSurvival.utilities.pathImage.Skin;

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
    	GameObjectUtils.ASTEROID_DAMAGE,
   		Optional.of(new Weapon())
    	);

    /** 
    * Invisible class constructor specifying space ship initial position and image path
    */
    private SpaceShipSingleton(final EngineImage engineImage, final P2d position, final BoundingBox bb,
			final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
			final int impactDamage, final Optional<Weapon> weapon) {
		super(engineImage, position, bb, phys, velocity, movement, life, impactDamage, weapon);
    	this.setBoundingBox(GameObjectUtils.createRectBoundingBox(position, engineImage));
    	//final RectBoundingBox shipBox = (RectBoundingBox) this.getBoundingBox();
		//this.getTransform().translate(getVelocity().getX(), getVelocity().getY());
//    	System.out.println(position);
//    	System.out.println(Screen.POINT_CENTER_FULLSCREEN);
    	//System.out.println("POSITION  " + position);


    	//this.getTransform().translate(shipBox.getULCorner().getX(), shipBox.getBRCorner().getY());
    	//this.getTransform().translate(shipBox.getULCorner().getX(), shipBox.getULCorner().getY());
    	//this.getTransform().T
    	

//    	System.out.println("POSITION SPACESHIP CONSTRUCTOR-> " + this.getPosition());
//
//		System.out.println("BOUNDING SPACESHIP CONSTRUCTOR -> " + this.getBoundingBox());
//
//		System.out.println("TRANSFORM SPACESHIP CONSTRUCTOR -> " + this.getTransform());
    }
    
    /**
     * @return space ship static instance
     */
    public static SpaceShipSingleton getSpaceShip() {
        return spaceShip;
    }
}