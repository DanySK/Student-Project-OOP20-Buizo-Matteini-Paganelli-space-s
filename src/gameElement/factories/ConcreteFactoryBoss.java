package gameElement.factories;

import java.awt.Dimension;

import gameElement.GameObjectUtils;
import gameElement.Movement;
import gameElement.V2d;
import gameElement.boss.Boss;
import model.environment.Point2D;
import utilities.IconPath;

public class ConcreteFactoryBoss extends AbstractFactoryGameObject {

	@Override
	public Boss createObject() {
		String path = IconPath.ICON_BULLET;
		Integer life = GameObjectUtils.BOSS_LIFE;
		Integer damage = GameObjectUtils.BOSS_DAMAGE;
		Dimension dimension = new Dimension();
		Point2D point = GameObjectUtils.generateSpawnPoint(dimension);
		Movement movement = Movement.FIXED;
		V2d velocity = GameObjectUtils.BOSS_VEL;
		
		return new Boss(path, life, damage, dimension, point, movement, velocity);
	}

}
