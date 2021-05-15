package model.gameObject.factories;

import java.util.Optional;

import model.gameObject.GameObjectUtils;
import model.gameObject.Movement;
import model.common.*;
import model.gameObject.fireEnemy.FireEnemy;
import model.gameObject.weapon.Weapon;
import model.image.EngineImage;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import model.worldEcollisioni.physics.components.FireEnemyPhysicsComponent;
import utilities.pathImage.Icon;

public class ConcreteFactoryFireEnemy extends AbstractFactoryGameObject {

	public ConcreteFactoryFireEnemy() {
		super();
	}
	
	@Override
	public FireEnemy createObject() {
		EngineImage engineImage = new EngineImage(Icon.BULLET);
		P2d point = GameObjectUtils.generateSpawnPoint(engineImage.getSize());
		V2d velocity = GameObjectUtils.FIRE_ENEMY_VEL;
		Movement movement = Movement.RANDOM;
		int life = GameObjectUtils.FIRE_ENEMY_LIFE;
		int damage = GameObjectUtils.FIRE_ENEMY_DAMAGE;		
		Optional<Weapon> weapon = Optional.of(new Weapon());
		
		return new FireEnemy(engineImage, point, new RectBoundingBox(), new FireEnemyPhysicsComponent(),
				velocity, movement, life, damage, weapon);
	}
	

}
