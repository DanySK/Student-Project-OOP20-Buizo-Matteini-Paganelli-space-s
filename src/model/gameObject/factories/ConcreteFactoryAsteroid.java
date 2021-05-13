package model.gameObject.factories;

import java.util.Optional;
import model.gameObject.GameObjectUtils;
import model.gameObject.Movement;
import model.common.*;
import model.gameObject.asteroid.Asteroid;
import model.gameObject.weapon.Weapon;
import model.image.EngineImage;
import model.worldEcollisioni.physics.boundingType.CircleBoundingBox;
import model.worldEcollisioni.physics.components.AsteroidPhysicsComponent;
import utilities.IconPath;


public class ConcreteFactoryAsteroid extends AbstractFactoryGameObject {

	public Asteroid createObject() {
		EngineImage engineImage = new EngineImage(IconPath.ICON_BULLET);
		P2d point = GameObjectUtils.generateSpawnPoint(engineImage.getSize());
		V2d velocity = GameObjectUtils.ASTEROID_VEL;
		Movement movement = Movement.FIXED;
		int life = GameObjectUtils.ASTEROID_LIFE;
		int damage = GameObjectUtils.ASTEROID_DAMAGE;		
		Optional<Weapon> weapon = Optional.empty();
		
		return new Asteroid(engineImage, point, new CircleBoundingBox(), new AsteroidPhysicsComponent(),
				velocity, movement, life, damage, weapon);
	}

}
