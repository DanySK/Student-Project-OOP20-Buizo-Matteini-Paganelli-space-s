package model.gameElement.factories;

import java.awt.Dimension;
import java.util.Optional;

import model.GUI.settings.SkinSpaceShip;
import model.gameElement.GameObjectUtils;
import model.gameElement.Movement;
import model.gameElement.V2d;
import model.gameElement.boss.Boss;
import model.gameElement.fireEnemy.FireEnemy;
import model.gameElement.weapon.Weapon;
import model.environment.Point2D;
import model.image.EngineImage;
import utilities.DimensionScreen;
import utilities.IconPath;

public class ConcreteFactoryFireEnemy extends AbstractFactoryGameObject {

	@Override
	public FireEnemy createObject() {
		EngineImage engineImage = new EngineImage(IconPath.ICON_BULLET);
		Dimension size = engineImage.getSize();
		int life = GameObjectUtils.FIRE_ENEMY_LIFE;
		int damage = GameObjectUtils.FIRE_ENEMY_DAMAGE;		
		Point2D point = GameObjectUtils.generateSpawnPoint(size);
		Movement movement = Movement.RANDOM;
		V2d velocity = GameObjectUtils.FIRE_ENEMY_VEL;
		Optional<Weapon> weapon = Optional.of(new Weapon());
		
		return new FireEnemy(engineImage, life, damage, size, point, movement, velocity, weapon);
		
	}

}
