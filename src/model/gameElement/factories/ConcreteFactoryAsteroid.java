package model.gameElement.factories;

import java.awt.Dimension;
import java.util.Optional;

import model.gameElement.GameObjectUtils;
import model.gameElement.Movement;
import model.gameElement.V2d;
import model.gameElement.asteroid.Asteroid;
import model.gameElement.weapon.Weapon;
import model.image.EngineImage;
import model.environment.Point2D;
import utilities.IconPath;


public class ConcreteFactoryAsteroid extends AbstractFactoryGameObject {

	public Asteroid createObject() {
		EngineImage engineImage = new EngineImage(IconPath.ICON_BULLET);
		Dimension size = engineImage.getSize();
		int life = GameObjectUtils.ASTEROID_LIFE;
		int damage = GameObjectUtils.ASTEROID_DAMAGE;		
		Point2D point = GameObjectUtils.generateSpawnPoint(size);
		Movement movement = Movement.FIXED;
		V2d velocity = GameObjectUtils.ASTEROID_VEL;
		Optional<Weapon> weapon = Optional.empty();
		
		return new Asteroid(engineImage, life, damage, size, point, movement, velocity, weapon);

	}

}
