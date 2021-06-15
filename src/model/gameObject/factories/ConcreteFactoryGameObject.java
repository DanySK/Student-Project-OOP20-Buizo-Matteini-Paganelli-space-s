package model.gameObject.factories;

import java.util.List;
import java.util.Optional;

import model.gameObject.GameObjectUtils;
import model.gameObject.MainGameObject;
import model.gameObject.enemy.ChaseEnemy;
import model.gameObject.enemy.FireEnemy;
import model.movement.ChasingMovement;
import model.movement.DistantMovement;
import model.movement.FixedMovement;
import model.movement.Movement;
import model.gameObject.mainGameObject.Asteroid;
import model.gameObject.enemy.Boss;
import model.gameObject.takeableGameObject.Ammo;
import model.gameObject.takeableGameObject.AmmoType;
import model.gameObject.takeableGameObject.Heart;
import model.gameObject.takeableGameObject.HeartType;
import model.gameObject.takeableGameObject.TakeableGameObject;
import model.common.*;
import model.gameObject.weapon.Weapon;
import model.EngineImage;
import model.worldEcollisioni.physics.boundingType.CircleBoundingBox;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import model.worldEcollisioni.physics.components.AsteroidPhysicsComponent;
import model.worldEcollisioni.physics.components.BossPhysicsComponent;
import model.worldEcollisioni.physics.components.ChaseEnemyPhysicsComponent;
import model.worldEcollisioni.physics.components.FireEnemyPhysicsComponent;
import model.worldEcollisioni.physics.components.PickablePhysicsComponent;
import utilities.Score;
import utilities.dimension.ScaleOf;
import utilities.dimension.Screen;

import utilities.pathImage.Skin.SkinAsteroid;
import utilities.pathImage.Skin.SkinChase;
import utilities.pathImage.Skin.SkinPerk;


public class ConcreteFactoryGameObject extends AbstractFactoryGameObject {
	
	public ConcreteFactoryGameObject() {
		super();
	}

	@Override
	public MainGameObject createAsteroid() {
	    final EngineImage engineImage = new EngineImage(ScaleOf.GAME_OBJECT, Screen.WIDTH_FULL_SCREEN,
				SkinAsteroid.ASTEROID1);
	    //final P2d position = GameObjectUtils.generateRandomPoint();
        final P2d position = GameObjectUtils.generateSpawnPoint(engineImage.getSize());
	    final V2d velocity = GameObjectUtils.ASTEROID_VEL;
	    final Movement movement = new FixedMovement();
	    final int life = GameObjectUtils.ASTEROID_LIFE;
	    final int impactDamage = GameObjectUtils.ASTEROID_DAMAGE;
	    final Optional<Weapon> weapon = Optional.empty();
		
		return new Asteroid(engineImage, position, new CircleBoundingBox(), new AsteroidPhysicsComponent(),
				velocity, movement, life, impactDamage, weapon, Score.ASTEROID, SkinAsteroid.LIST_ASTEROID);
	}

	@Override
	public MainGameObject createChaseEnemy() {
	    final EngineImage engineImage = new EngineImage(ScaleOf.GAME_OBJECT, Screen.WIDTH_FULL_SCREEN, SkinChase.POOH0);
	    //final P2d position = GameObjectUtils.generateRandomPoint();
        final P2d position = GameObjectUtils.generateSpawnPoint(engineImage.getSize());
	    final V2d velocity = GameObjectUtils.CHASE_ENEMY_VEL;
	    final Movement movement = new ChasingMovement();
	    final int life = GameObjectUtils.CHASE_ENEMY_LIFE;
	    final int impactDamage = GameObjectUtils.CHASE_ENEMY_DAMAGE;		
	    final Optional<Weapon> weapon = Optional.empty();
		
		return new ChaseEnemy(engineImage, position, new RectBoundingBox(), new ChaseEnemyPhysicsComponent(),
				velocity, movement, life, impactDamage, weapon, Score.CHASE_ENEMY, SkinChase.LIST_POOH, Screen.POINT_CENTER_FULLSCREEN);
	}

	@Override
	public MainGameObject createFireEnemy() {
	    final EngineImage engineImage = new EngineImage(ScaleOf.GAME_OBJECT, Screen.WIDTH_FULL_SCREEN, SkinChase.CHASE0);
	    //final P2d position = GameObjectUtils.generateRandomPoint();
        final P2d position = GameObjectUtils.generateSpawnPoint(engineImage.getSize());
	    final V2d velocity = GameObjectUtils.FIRE_ENEMY_VEL;
	    final Movement movement = new DistantMovement();
	    final int life = GameObjectUtils.FIRE_ENEMY_LIFE;
	    final int impactDamage = GameObjectUtils.FIRE_ENEMY_DAMAGE;		
	    final Optional<Weapon> weapon = Optional.empty();
		
	    final FireEnemy fireEnemy = new FireEnemy(engineImage, position, new RectBoundingBox(), new FireEnemyPhysicsComponent(),
				velocity, movement, life, impactDamage, weapon, Score.FIRE_ENEMY, Screen.POINT_CENTER_FULLSCREEN);
		fireEnemy.setWeapon(Optional.of(new Weapon(AmmoType.NORMAL, fireEnemy)));
		return fireEnemy;
	}

	@Override
	public MainGameObject createBoss() {
		final EngineImage engineImage = new EngineImage(ScaleOf.BOSS, Screen.WIDTH_FULL_SCREEN, SkinChase.CHASE0);
		final P2d position = GameObjectUtils.generateRandomPoint();
		//final P2d position = GameObjectUtils.generateSpawnPoint(engineImage.getSize());
		final V2d velocity = GameObjectUtils.BOSS_VEL;
		final Movement movement = new DistantMovement();
		final int life = GameObjectUtils.BOSS_LIFE;
		final int impactDamage = GameObjectUtils.BOSS_DAMAGE;		
		final Optional<Weapon> weapon = Optional.of(new Weapon());
		
		final Boss boss = new Boss(engineImage, position, new RectBoundingBox(), new BossPhysicsComponent(),
				velocity, movement, life, impactDamage, weapon, Score.BOSS, Screen.POINT_CENTER_FULLSCREEN);
		boss.setWeapon(Optional.of(new Weapon(AmmoType.NORMAL, boss)));
		return boss;
	}

	@Override
	public TakeableGameObject createAmmo() {
		final EngineImage engineImage = new EngineImage(ScaleOf.GAME_OBJECT, Screen.WIDTH_FULL_SCREEN, SkinPerk.ELECTRIC0);
		final P2d position = GameObjectUtils.generateRandomPoint();
		
		return new Ammo(engineImage, position, new CircleBoundingBox(), new PickablePhysicsComponent(),
				SkinPerk.LIST_ICE, AmmoType.ICE);
	}
	
	@Override
	public TakeableGameObject createHeart() {
		final EngineImage engineImage = new EngineImage(ScaleOf.GAME_OBJECT, Screen.WIDTH_FULL_SCREEN, SkinPerk.FIRE0);
		final P2d position = GameObjectUtils.generateRandomPoint();
		
		return new Heart(engineImage, position, new CircleBoundingBox(), new PickablePhysicsComponent(),
				List.of(), HeartType.random());
	}

}
