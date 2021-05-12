package model.gameObject.factories;

import java.awt.Dimension;
import java.awt.geom.AffineTransform;
import java.util.Optional;
import model.gameObject.GameObjectUtils;
import model.gameObject.Movement;
import model.common.*;
import model.gameObject.chaseEnemy.ChaseEnemy;
import model.gameObject.weapon.Weapon;
import model.image.EngineImage;
import utilities.IconPath;

public class ConcreteFactoryChaseEnemy extends AbstractFactoryGameObject {

	@Override
	public ChaseEnemy createObject() {
		EngineImage engineImage = new EngineImage(IconPath.ICON_BULLET);
		Dimension size = engineImage.getSize();
		int life = GameObjectUtils.CHASE_ENEMY_LIFE;
		int damage = GameObjectUtils.CHASE_ENEMY_DAMAGE;		
		P2d point = GameObjectUtils.generateSpawnPoint(size);
		Movement movement = Movement.CHASE;
		V2d velocity = GameObjectUtils.CHASE_ENEMY_VEL;
		AffineTransform transform = new AffineTransform();
		Optional<Weapon> weapon = Optional.empty();
		
		return new ChaseEnemy(engineImage, life, damage, size, point, movement, velocity, transform, weapon);
	}

}
