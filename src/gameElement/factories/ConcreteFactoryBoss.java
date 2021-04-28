package gameElement.factories;

import java.awt.Dimension;
import java.util.Optional;

import gameElement.GameObjectUtils;
import gameElement.Movement;
import gameElement.V2d;
import gameElement.boss.Boss;
import gameElement.weapon.Weapon;
import model.environment.Point2D;
import utilities.IconPath;

public class ConcreteFactoryBoss extends AbstractFactoryGameObject {

	@Override
	public Boss createObject() {
		String path = IconPath.ICON_BULLET;
		int life = GameObjectUtils.BOSS_LIFE;
		int damage = GameObjectUtils.BOSS_DAMAGE;
		Dimension dimension = new Dimension();
		Point2D point = GameObjectUtils.generateSpawnPoint(dimension);
		Movement movement = Movement.RANDOM;
		V2d velocity = GameObjectUtils.BOSS_VEL;
		Optional<Weapon> weapon = Optional.of(new Weapon());
		
		return new Boss(path, life, damage, dimension, point, movement, velocity, weapon);
	}

}
