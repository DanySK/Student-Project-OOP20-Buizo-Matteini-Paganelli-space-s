package model.gameObject.factories;

import java.util.Optional;

import model.gameObject.GameObjectUtils;
import model.gameObject.Movement;
import model.common.*;
import model.gameObject.boss.Boss;
import model.gameObject.weapon.Weapon;
import model.image.EngineImage;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import model.worldEcollisioni.physics.components.BossPhysicsComponent;
import utilities.pathImage.Icon;

public class ConcreteFactoryBoss extends AbstractFactoryGameObject {

	@Override
	public Boss createObject() {
		EngineImage engineImage = new EngineImage(Icon.BULLET);
		P2d point = GameObjectUtils.generateSpawnPoint(engineImage.getSize());
		V2d velocity = GameObjectUtils.BOSS_VEL;
		Movement movement = Movement.RANDOM;
		int life = GameObjectUtils.BOSS_LIFE;
		int damage = GameObjectUtils.BOSS_DAMAGE;		
		Optional<Weapon> weapon = Optional.of(new Weapon());
		
		return new Boss(engineImage, point, new RectBoundingBox(), new BossPhysicsComponent(),
				velocity, movement, life, damage, weapon);
	}
}
