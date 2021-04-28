package gameElement.factories;

import java.awt.Dimension;
import java.util.Optional;

import gameElement.GameObjectUtils;
import gameElement.Movement;
import gameElement.V2d;
import gameElement.chaseEnemy.ChaseEnemy;
import gameElement.weapon.Weapon;
import model.environment.Point2D;
import utilities.IconPath;

public class ConcreteFactoryChaseEnemy extends AbstractFactoryGameObject {

	@Override
	public ChaseEnemy createObject() {
		String path = IconPath.ICON_BULLET;
		int life = GameObjectUtils.CHASE_ENEMY_LIFE;
		int damage = GameObjectUtils.CHASE_ENEMY_DAMAGE;
		Dimension dimension = new Dimension();
		Point2D point = GameObjectUtils.generateSpawnPoint(dimension);
		Movement movement = Movement.CONTROLLED;
		V2d velocity = GameObjectUtils.CHASE_ENEMY_VEL;
		Optional<Weapon> weapon = Optional.empty();
		
		return new ChaseEnemy(path, life, damage, dimension, point, movement, velocity, weapon);
	}

}
