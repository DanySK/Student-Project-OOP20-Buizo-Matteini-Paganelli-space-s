package spaceSurvival.model.gameObject.factories;

import java.util.List;
import java.util.Optional;

import spaceSurvival.model.gameObject.GameObjectUtils;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.enemy.ChaseEnemy;
import spaceSurvival.model.gameObject.enemy.FireEnemy;
import spaceSurvival.model.movement.ChasingMovement;
import spaceSurvival.model.movement.DistantMovement;
import spaceSurvival.model.movement.FixedMovement;
import spaceSurvival.model.movement.Movement;
import spaceSurvival.model.gameObject.mainGameObject.Asteroid;
import spaceSurvival.model.gameObject.enemy.Boss;
import spaceSurvival.model.gameObject.takeableGameObject.Ammo;
import spaceSurvival.model.gameObject.takeableGameObject.AmmoType;
import spaceSurvival.model.gameObject.takeableGameObject.Heart;
import spaceSurvival.model.gameObject.takeableGameObject.HeartType;
import spaceSurvival.model.gameObject.takeableGameObject.TakeableGameObject;
import spaceSurvival.model.common.*;
import spaceSurvival.model.gameObject.weapon.Weapon;
import spaceSurvival.model.EngineImage;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.CircleBoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.AsteroidPhysicsComponent;
import spaceSurvival.model.worldEcollisioni.physics.components.BossPhysicsComponent;
import spaceSurvival.model.worldEcollisioni.physics.components.ChaseEnemyPhysicsComponent;
import spaceSurvival.model.worldEcollisioni.physics.components.FireEnemyPhysicsComponent;
import spaceSurvival.model.worldEcollisioni.physics.components.PickablePhysicsComponent;
import spaceSurvival.utilities.Score;
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
		//P2d position = GameObjectUtils.generateRandomPoint();
		final P2d position = GameObjectUtils.generateSpawnPoint(engineImage.getSize());
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
