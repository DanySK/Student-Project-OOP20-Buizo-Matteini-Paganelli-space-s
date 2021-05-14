package model.gameObject.factories;

import java.util.Optional;
import model.gameObject.GameObjectUtils;
import model.gameObject.Movement;
import model.common.*;
import model.gameObject.chaseEnemy.ChaseEnemy;
import model.gameObject.weapon.Weapon;
import model.image.EngineImage;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import model.worldEcollisioni.physics.components.ChaseEnemyPhysicsComponent;
import utilities.pathImage.Icon;

public class ConcreteFactoryChaseEnemy extends AbstractFactoryGameObject {

	@Override
	public ChaseEnemy createObject() {
		EngineImage engineImage = new EngineImage(Icon.BULLET);
		P2d point = GameObjectUtils.generateSpawnPoint(engineImage.getSize());
		V2d velocity = GameObjectUtils.CHASE_ENEMY_VEL;
		Movement movement = Movement.CHASE;
		int life = GameObjectUtils.CHASE_ENEMY_LIFE;
		int damage = GameObjectUtils.CHASE_ENEMY_DAMAGE;		
		Optional<Weapon> weapon = Optional.empty();
		
		return new ChaseEnemy(engineImage, point, new RectBoundingBox(), new ChaseEnemyPhysicsComponent(),
				velocity, movement, life, damage, weapon);
	}

}
