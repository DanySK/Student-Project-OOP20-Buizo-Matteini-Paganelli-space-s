package model.gameObject.factories;

import java.awt.Dimension;
import java.util.Optional;
import model.gameObject.GameObjectUtils;
import model.gameObject.Movement;
import model.common.*;
import model.gameObject.asteroid.Asteroid;
import model.gameObject.weapon.Weapon;
import model.image.EngineImage;
import model.worldEcollisioni.physics.boundingType.CircleBoundingBox;
import model.worldEcollisioni.physics.components.ShipPhysicsComponent;
import utilities.IconPath;


public class ConcreteFactoryAsteroid extends AbstractFactoryGameObject {

	public Asteroid createObject() {
		EngineImage engineImage = new EngineImage(IconPath.ICON_BULLET);
		Dimension size = engineImage.getSize();
		int life = GameObjectUtils.ASTEROID_LIFE;
		int damage = GameObjectUtils.ASTEROID_DAMAGE;		
		P2d point = GameObjectUtils.generateSpawnPoint(size);
		Movement movement = Movement.FIXED;
		V2d velocity = GameObjectUtils.ASTEROID_VEL;
		Optional<Weapon> weapon = Optional.empty();
		
		return new Asteroid(engineImage, life, damage, point, movement, velocity, weapon, new CircleBoundingBox(), new ShipPhysicsComponent());

	}

}
