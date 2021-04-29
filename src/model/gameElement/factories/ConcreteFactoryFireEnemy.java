package model.gameElement.factories;

import java.util.Optional;

import model.GUI.settings.SkinSpaceShip;
import model.gameElement.GameObjectUtils;
import model.gameElement.Movement;
import model.gameElement.V2d;
import model.gameElement.fireEnemy.FireEnemy;
import model.gameElement.weapon.Weapon;
import model.environment.Point2D;
import model.image.EngineImage;
import utilities.DimensionScreen;
import utilities.IconPath;

public class ConcreteFactoryFireEnemy extends AbstractFactoryGameObject {

	@Override
	public FireEnemy createObject() {
		EngineImage engineImage = new EngineImage(100, DimensionScreen.WIDTH_FULL_SCREEN,
				SkinSpaceShip.GNEGNE.getPath());
		String path = IconPath.ICON_BULLET;
		int life = GameObjectUtils.FIRE_ENEMY_LIFE;
		int damage = GameObjectUtils.FIRE_ENEMY_DAMAGE;
		Point2D point = GameObjectUtils.generateSpawnPoint(engineImage.getSize());
		Movement movement = Movement.RANDOM;
		V2d velocity = GameObjectUtils.FIRE_ENEMY_VEL;
		Optional<Weapon> weapon = Optional.of(new Weapon());
		
		return new FireEnemy(path, life, damage, point, movement, velocity, weapon);
	}

}
