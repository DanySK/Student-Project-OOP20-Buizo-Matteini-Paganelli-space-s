package spacesurvival.model.gameobject.factories;

import java.util.Optional;

import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.gameobject.enemy.ChaseEnemy;
import spacesurvival.model.gameobject.enemy.FireEnemy;
import spacesurvival.model.movement.ChasingMovement;
import spacesurvival.model.movement.DistantMovement;
import spacesurvival.model.movement.FixedMovement;
import spacesurvival.model.movement.Movement;
import spacesurvival.model.gameobject.main.Asteroid;
import spacesurvival.model.gameobject.enemy.Boss;
import spacesurvival.model.gameobject.takeable.Ammo;
import spacesurvival.model.gameobject.takeable.AmmoType;
import spacesurvival.model.gameobject.takeable.Heart;
import spacesurvival.model.gameobject.takeable.HeartType;
import spacesurvival.model.gameobject.takeable.TakeableGameObject;
import spacesurvival.model.common.*;
import spacesurvival.model.gameobject.weapon.Weapon;
import spacesurvival.model.EngineImage;
import spacesurvival.model.collisioni.physics.bounding.CircleBoundingBox;
import spacesurvival.model.collisioni.physics.bounding.RectBoundingBox;
import spacesurvival.model.collisioni.physics.component.AsteroidPhysicsComponent;
import spacesurvival.model.collisioni.physics.component.BossPhysicsComponent;
import spacesurvival.model.collisioni.physics.component.ChaseEnemyPhysicsComponent;
import spacesurvival.model.collisioni.physics.component.FireEnemyPhysicsComponent;
import spacesurvival.model.collisioni.physics.component.PickablePhysicsComponent;
import spacesurvival.utilities.Score;
import spacesurvival.utilities.dimension.ScaleOf;
import spacesurvival.utilities.dimension.Screen;

import spacesurvival.utilities.path.skin.SkinAsteroid;
import spacesurvival.utilities.path.skin.SkinChase;
import spacesurvival.utilities.path.skin.SkinPerk;


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
		final HeartType heartType = HeartType.random();
		
		return new Heart(engineImage, position, new CircleBoundingBox(), new PickablePhysicsComponent(),
				heartType.getAnimation(), heartType);
	}

}
