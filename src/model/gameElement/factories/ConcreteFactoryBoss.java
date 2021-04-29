package model.gameElement.factories;

import java.awt.Dimension;
import java.util.Optional;

import model.gameElement.GameObjectUtils;
import model.gameElement.Movement;
import model.gameElement.V2d;
import model.gameElement.asteroid.Asteroid;
import model.gameElement.boss.Boss;
import model.gameElement.weapon.Weapon;
import model.image.EngineImage;
import model.environment.Point2D;
import utilities.IconPath;

public class ConcreteFactoryBoss extends AbstractFactoryGameObject {

	@Override
	public Boss createObject() {
		EngineImage engineImage = new EngineImage(IconPath.ICON_BULLET);
		Dimension size = engineImage.getSize();
		int life = GameObjectUtils.BOSS_LIFE;
		int damage = GameObjectUtils.BOSS_DAMAGE;		
		Point2D point = GameObjectUtils.generateSpawnPoint(size);
		Movement movement = Movement.RANDOM;
		V2d velocity = GameObjectUtils.BOSS_VEL;
		Optional<Weapon> weapon = Optional.of(new Weapon());
		
		return new Boss(engineImage, life, damage, size, point, movement, velocity, weapon);
	}

}
