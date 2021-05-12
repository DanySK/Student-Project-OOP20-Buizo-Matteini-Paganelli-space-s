package model.gameObject.factories;

import java.awt.Dimension;
import java.util.Optional;

import model.gameObject.GameObjectUtils;
import model.gameObject.Movement;
import model.common.*;
import model.gameObject.fireEnemy.FireEnemy;
import model.gameObject.weapon.Weapon;
import model.image.EngineImage;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import model.worldEcollisioni.physics.components.ShipPhysicsComponent;
import utilities.IconPath;

public class ConcreteFactoryFireEnemy extends AbstractFactoryGameObject {

	@Override
	public FireEnemy createObject() {
		EngineImage engineImage = new EngineImage(IconPath.ICON_BULLET);
		Dimension size = engineImage.getSize();
		int life = GameObjectUtils.FIRE_ENEMY_LIFE;
		int damage = GameObjectUtils.FIRE_ENEMY_DAMAGE;		
		P2d point = GameObjectUtils.generateSpawnPoint(size);
		Movement movement = Movement.RANDOM;
		V2d velocity = GameObjectUtils.FIRE_ENEMY_VEL;
		Optional<Weapon> weapon = Optional.of(new Weapon());
		
		return new FireEnemy(engineImage, life, damage, point, movement, velocity, weapon, new RectBoundingBox(), new ShipPhysicsComponent());	
	}

}
