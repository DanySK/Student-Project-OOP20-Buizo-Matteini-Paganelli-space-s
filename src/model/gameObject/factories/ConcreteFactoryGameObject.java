package model.gameObject.factories;

import java.util.Optional;

import model.gameObject.EffectType;
import model.gameObject.GameObjectUtils;
import model.gameObject.MainGameObject;
import model.gameObject.Movement;
import model.gameObject.PickableGameObject;
import model.gameObject.mainGameObject.Asteroid;
import model.gameObject.mainGameObject.Boss;
import model.gameObject.mainGameObject.ChaseEnemy;
import model.gameObject.mainGameObject.FireEnemy;
import model.common.*;
import model.gameObject.weapon.Weapon;
import model.image.EngineImage;
import model.worldEcollisioni.physics.boundingType.CircleBoundingBox;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import model.worldEcollisioni.physics.components.AsteroidPhysicsComponent;
import model.worldEcollisioni.physics.components.BossPhysicsComponent;
import model.worldEcollisioni.physics.components.ChaseEnemyPhysicsComponent;
import model.worldEcollisioni.physics.components.FireEnemyPhysicsComponent;
import utilities.dimension.Screen;
import utilities.pathImage.Icon;
import utilities.pathImage.Skin;


public class ConcreteFactoryGameObject extends AbstractFactoryGameObject {
	
	public ConcreteFactoryGameObject() {
		super();
	}

	@Override
	public MainGameObject createAsteroid() {
		EngineImage engineImage = new EngineImage(GameObjectUtils.SPACESHIP_SCALEOF, Screen.WIDTH_FULL_SCREEN,
				utilities.pathImage.Asteroid.NORMAL);
		P2d point = new P2d(300, 300);//GameObjectUtils.generateSpawnPoint(engineImage.getSize());
		V2d velocity = GameObjectUtils.ASTEROID_VEL;
		Movement movement = Movement.FIXED;
		int life = GameObjectUtils.ASTEROID_LIFE;
		int impactDamage = GameObjectUtils.ASTEROID_DAMAGE;
		Optional<Weapon> weapon = Optional.empty();
		
		return new Asteroid(engineImage, point, new CircleBoundingBox(), new AsteroidPhysicsComponent(),
				velocity, movement, life, impactDamage, weapon);
	}


	@Override
	public MainGameObject createChaseEnemy() {
		EngineImage engineImage = new EngineImage(GameObjectUtils.SPACESHIP_SCALEOF, Screen.WIDTH_FULL_SCREEN,
				utilities.pathImage.Asteroid.NORMAL);
		P2d point = new P2d(200, 200);//GameObjectUtils.generateSpawnPoint(engineImage.getSize());
		V2d velocity = GameObjectUtils.CHASE_ENEMY_VEL;
		Movement movement = Movement.CHASE;
		int life = GameObjectUtils.CHASE_ENEMY_LIFE;
		int impactDamage = GameObjectUtils.CHASE_ENEMY_DAMAGE;		
		Optional<Weapon> weapon = Optional.empty();
		
		return new ChaseEnemy(engineImage, point, new RectBoundingBox(), new ChaseEnemyPhysicsComponent(),
				velocity, movement, life, impactDamage, weapon);
	}


	@Override
	public MainGameObject createFireEnemy() {
		EngineImage engineImage = new EngineImage(GameObjectUtils.SPACESHIP_SCALEOF, Screen.WIDTH_FULL_SCREEN,
				utilities.pathImage.Asteroid.NORMAL);
		P2d point =new P2d(500, 500);// GameObjectUtils.generateSpawnPoint(engineImage.getSize());
		V2d velocity = GameObjectUtils.FIRE_ENEMY_VEL;
		Movement movement = Movement.RANDOM;
		int life = GameObjectUtils.FIRE_ENEMY_LIFE;
		int impactDamage = GameObjectUtils.FIRE_ENEMY_DAMAGE;		
		Optional<Weapon> weapon = Optional.of(new Weapon());
		
		return new FireEnemy(engineImage, point, new RectBoundingBox(), new FireEnemyPhysicsComponent(),
				velocity, movement, life, impactDamage, weapon);
	}


	@Override
	public MainGameObject createBoss() {
		EngineImage engineImage = new EngineImage(GameObjectUtils.SPACESHIP_SCALEOF, Screen.WIDTH_FULL_SCREEN,
				utilities.pathImage.Asteroid.NORMAL);
		P2d point = GameObjectUtils.generateSpawnPoint(engineImage.getSize());
		V2d velocity = GameObjectUtils.BOSS_VEL;
		Movement movement = Movement.RANDOM;
		int life = GameObjectUtils.BOSS_LIFE;
		int impactDamage = GameObjectUtils.BOSS_DAMAGE;		
		Optional<Weapon> weapon = Optional.of(new Weapon());
		
		return new Boss(engineImage, point, new RectBoundingBox(), new BossPhysicsComponent(),
				velocity, movement, life, impactDamage, weapon);
	}

	@Override
	public PickableGameObject createPickable() {
		final EngineImage engineImage = new EngineImage(Icon.BULLET);
		final P2d point = GameObjectUtils.generateSpawnPoint(engineImage.getSize());
	 	final EffectType effectType = EffectType.randomEffect();
		
		return new PickableGameObject(engineImage, point, new CircleBoundingBox(), null, effectType);
	}

}
