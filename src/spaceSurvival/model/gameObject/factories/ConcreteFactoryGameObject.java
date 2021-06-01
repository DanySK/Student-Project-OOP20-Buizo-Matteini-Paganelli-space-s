package spaceSurvival.model.gameObject.factories;

import java.util.Optional;

import spaceSurvival.model.gameObject.Effect;
import spaceSurvival.model.gameObject.GameObjectUtils;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.movement.ChasingMovement;
import spaceSurvival.model.movement.DistantMovement;
import spaceSurvival.model.movement.FixedMovement;
import spaceSurvival.model.movement.Movement;
import spaceSurvival.model.gameObject.TakeableGameObject;
import spaceSurvival.model.gameObject.mainGameObject.Asteroid;
import spaceSurvival.model.gameObject.mainGameObject.Boss;
import spaceSurvival.model.gameObject.mainGameObject.ChaseEnemy;
import spaceSurvival.model.gameObject.mainGameObject.FireEnemy;
import spaceSurvival.model.common.*;
import spaceSurvival.model.gameObject.weapon.AmmoType;
import spaceSurvival.model.gameObject.weapon.Weapon;
import spaceSurvival.model.EngineImage;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.CircleBoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.AsteroidPhysicsComponent;
import spaceSurvival.model.worldEcollisioni.physics.components.BossPhysicsComponent;
import spaceSurvival.model.worldEcollisioni.physics.components.ChaseEnemyPhysicsComponent;
import spaceSurvival.model.worldEcollisioni.physics.components.FireEnemyPhysicsComponent;
import spaceSurvival.model.worldEcollisioni.physics.components.PickablePhysicsComponent;
import spaceSurvival.utilities.dimension.ScaleOf;
import spaceSurvival.utilities.dimension.Screen;

import spaceSurvival.utilities.pathImage.Skin.SkinAsteroid;
import spaceSurvival.utilities.pathImage.Skin.SkinChase;
import spaceSurvival.utilities.pathImage.Skin.SkinPerk;


public class ConcreteFactoryGameObject extends AbstractFactoryGameObject {
	
	public ConcreteFactoryGameObject() {
		super();
	}

	@Override
	public MainGameObject createAsteroid() {
		EngineImage engineImage = new EngineImage(ScaleOf.GAME_OBJECT, Screen.WIDTH_FULL_SCREEN,
				SkinAsteroid.ASTEROID1);
		P2d position = GameObjectUtils.generateRandomPoint();//GameObjectUtils.generateSpawnPoint(engineImage.getSize());
		V2d velocity = GameObjectUtils.ASTEROID_VEL;
		Movement movement = new FixedMovement();
		int life = GameObjectUtils.ASTEROID_LIFE;
		int impactDamage = GameObjectUtils.ASTEROID_DAMAGE;
		Optional<Weapon> weapon = Optional.empty();
		
		return new Asteroid(engineImage, position, new CircleBoundingBox(), new AsteroidPhysicsComponent(),
				velocity, movement, life, impactDamage, weapon, SkinAsteroid.LIST_ASTEROID);
	}


	@Override
	public MainGameObject createChaseEnemy() {
		EngineImage engineImage = new EngineImage(ScaleOf.GAME_OBJECT, Screen.WIDTH_FULL_SCREEN, SkinChase.POOH0);
		P2d position = GameObjectUtils.generateRandomPoint();//GameObjectUtils.generateSpawnPoint(engineImage.getSize());
		V2d velocity = GameObjectUtils.CHASE_ENEMY_VEL;
		Movement movement = new ChasingMovement();
		int life = GameObjectUtils.CHASE_ENEMY_LIFE;
		int impactDamage = GameObjectUtils.CHASE_ENEMY_DAMAGE;		
		Optional<Weapon> weapon = Optional.empty();
		
		return new ChaseEnemy(engineImage, position, new RectBoundingBox(), new ChaseEnemyPhysicsComponent(),
				velocity, movement, life, impactDamage, weapon, SkinChase.LIST_POOH);
	}


	@Override
	public MainGameObject createFireEnemy() {
		EngineImage engineImage = new EngineImage(ScaleOf.GAME_OBJECT, Screen.WIDTH_FULL_SCREEN, SkinChase.CHASE0);
		P2d position = GameObjectUtils.generateRandomPoint();// GameObjectUtils.generateSpawnPoint(engineImage.getSize());
		V2d velocity = GameObjectUtils.FIRE_ENEMY_VEL;
		Movement movement = new DistantMovement();
		int life = GameObjectUtils.FIRE_ENEMY_LIFE;
		int impactDamage = GameObjectUtils.FIRE_ENEMY_DAMAGE;		
		Optional<Weapon> weapon = Optional.empty();
		
		FireEnemy fireEnemy = new FireEnemy(engineImage, position, new RectBoundingBox(), new FireEnemyPhysicsComponent(),
				velocity, movement, life, impactDamage, weapon);
		fireEnemy.setWeapon(Optional.of(new Weapon(AmmoType.NORMAL, fireEnemy)));
		return fireEnemy;
	}


	@Override
	public MainGameObject createBoss() {
		EngineImage engineImage = new EngineImage(ScaleOf.GAME_OBJECT, Screen.WIDTH_FULL_SCREEN, SkinChase.CHASE0);
		P2d position = GameObjectUtils.generateRandomPoint();//GameObjectUtils.generateSpawnPoint(engineImage.getSize());
		V2d velocity = GameObjectUtils.BOSS_VEL;
		Movement movement = new DistantMovement();
		int life = GameObjectUtils.BOSS_LIFE;
		int impactDamage = GameObjectUtils.BOSS_DAMAGE;		
		Optional<Weapon> weapon = Optional.of(new Weapon());
		
		Boss boss = new Boss(engineImage, position, new RectBoundingBox(), new BossPhysicsComponent(),
				velocity, movement, life, impactDamage, weapon);
		boss.setWeapon(Optional.of(new Weapon(AmmoType.NORMAL, boss)));
		return boss;
	}

	@Override
	public TakeableGameObject createPickable() {
		final EngineImage engineImage = new EngineImage(ScaleOf.GAME_OBJECT, Screen.WIDTH_FULL_SCREEN, SkinPerk.ELECTRIC0);
		final P2d position = GameObjectUtils.generateRandomPoint();
	 	final Effect effectType = Effect.random();
		
		return new TakeableGameObject(engineImage, position, new CircleBoundingBox(), new PickablePhysicsComponent(),
				effectType, SkinPerk.LIST_ELECTRIC);
	}

}
