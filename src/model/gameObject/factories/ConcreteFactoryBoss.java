package model.gameObject.factories;

import java.awt.Dimension;
import java.util.Optional;

import model.gameObject.GameObjectUtils;
import model.gameObject.Movement;
import model.common.*;
import model.gameObject.boss.Boss;
import model.gameObject.weapon.Weapon;
import model.image.EngineImage;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import model.worldEcollisioni.physics.components.ShipPhysicsComponent;
import utilities.IconPath;

public class ConcreteFactoryBoss extends AbstractFactoryGameObject {

	@Override
	public Boss createObject() {
		EngineImage engineImage = new EngineImage(IconPath.ICON_BULLET);
		Dimension size = engineImage.getSize();
		int life = GameObjectUtils.BOSS_LIFE;
		int damage = GameObjectUtils.BOSS_DAMAGE;		
		P2d point = GameObjectUtils.generateSpawnPoint(size);
		Movement movement = Movement.RANDOM;
		V2d velocity = GameObjectUtils.BOSS_VEL;
		Optional<Weapon> weapon = Optional.of(new Weapon());
		
		return new Boss(engineImage, life, damage, point, movement, velocity, weapon, new RectBoundingBox(), new ShipPhysicsComponent());
	}

}
