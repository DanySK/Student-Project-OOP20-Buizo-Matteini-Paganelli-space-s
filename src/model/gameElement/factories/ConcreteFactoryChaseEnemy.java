package model.gameElement.factories;

import java.awt.Dimension;
import java.util.Optional;

import model.gameElement.GameObjectUtils;
import model.gameElement.Movement;
import model.gameElement.V2d;
import model.gameElement.boss.Boss;
import model.gameElement.chaseEnemy.ChaseEnemy;
import model.gameElement.weapon.Weapon;
import model.image.EngineImage;
import model.environment.Point2D;
import utilities.IconPath;

public class ConcreteFactoryChaseEnemy extends AbstractFactoryGameObject {

	@Override
	public ChaseEnemy createObject() {
		EngineImage engineImage = new EngineImage(IconPath.ICON_BULLET);
		Dimension size = engineImage.getSize();
		int life = GameObjectUtils.CHASE_ENEMY_LIFE;
		int damage = GameObjectUtils.CHASE_ENEMY_DAMAGE;		
		Point2D point = GameObjectUtils.generateSpawnPoint(size);
		Movement movement = Movement.CHASE;
		V2d velocity = GameObjectUtils.CHASE_ENEMY_VEL;
		Optional<Weapon> weapon = Optional.empty();
		
		return new ChaseEnemy(engineImage, life, damage, size, point, movement, velocity, weapon);
	}

}
