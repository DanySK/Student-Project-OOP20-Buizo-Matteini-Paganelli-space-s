package model.gameObject.factories;

import java.awt.Dimension;
import java.util.Optional;
import model.gameObject.GameObjectUtils;
import model.gameObject.Movement;
import model.common.*;
import model.gameObject.chaseEnemy.ChaseEnemy;
import model.gameObject.weapon.Weapon;
import model.image.EngineImage;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import model.worldEcollisioni.physics.components.ShipPhysicsComponent;
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
		Optional<Weapon> weapon = Optional.empty();
		
		return new ChaseEnemy(engineImage, life, damage, point, movement, velocity, weapon, new RectBoundingBox(), new ShipPhysicsComponent());
	}

}
