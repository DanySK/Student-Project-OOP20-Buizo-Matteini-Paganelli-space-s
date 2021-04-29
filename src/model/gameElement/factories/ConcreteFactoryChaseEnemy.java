package model.gameElement.factories;

import java.awt.Dimension;
import java.util.Optional;

import model.gameElement.GameObjectUtils;
import model.gameElement.Movement;
import model.gameElement.V2d;
import model.gameElement.chaseEnemy.ChaseEnemy;
import model.gameElement.weapon.Weapon;
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
