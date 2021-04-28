package gameElement.factories;

import java.awt.Dimension;
import java.util.Optional;

import gameElement.GameObjectUtils;
import gameElement.Movement;
import gameElement.V2d;
import gameElement.fireEnemy.FireEnemy;
import gameElement.weapon.Weapon;
import model.environment.Point2D;
import utilities.IconPath;

public class ConcreteFactoryFireEnemy extends AbstractFactoryGameObject {

	@Override
	public FireEnemy createObject() {
		String path = IconPath.ICON_BULLET;
		int life = GameObjectUtils.FIRE_ENEMY_LIFE;
		int damage = GameObjectUtils.FIRE_ENEMY_DAMAGE;
		Dimension dimension = new Dimension();
		Point2D point = GameObjectUtils.generateSpawnPoint(dimension);
		Movement movement = Movement.RANDOM;
		V2d velocity = GameObjectUtils.FIRE_ENEMY_VEL;
		Optional<Weapon> weapon = Optional.of(new Weapon());
		
		return new FireEnemy(path, life, damage, dimension, point, movement, velocity, weapon);
	}

}
