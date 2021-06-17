package spacesurvival.model.gameobject.factories;

import java.util.Optional;

import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.gameobject.enemy.ChaseEnemy;
import spacesurvival.model.gameobject.enemy.FireEnemy;
import spacesurvival.model.gameobject.enemy.FireableObject;
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
import spacesurvival.model.gameobject.weapon.shootinglogic.FiringLogic;
import spacesurvival.model.gameobject.weapon.shootinglogic.implementation.BossFiringImpl;
import spacesurvival.model.gameobject.weapon.shootinglogic.implementation.FireEnemyFiringImpl;
import spacesurvival.model.gameobject.weapon.shootinglogic.implementation.NoFiringImpl;
import spacesurvival.model.EngineImage;
import spacesurvival.model.collision.physics.bounding.CircleBoundingBox;
import spacesurvival.model.collision.physics.bounding.RectBoundingBox;
import spacesurvival.model.collision.physics.component.AsteroidPhysicsComponent;
import spacesurvival.model.collision.physics.component.BossPhysicsComponent;
import spacesurvival.model.collision.physics.component.ChaseEnemyPhysicsComponent;
import spacesurvival.model.collision.physics.component.FireEnemyPhysicsComponent;
import spacesurvival.model.collision.physics.component.PickablePhysicsComponent;
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
        final EngineImage engineImage = new EngineImage(ScaleOf.GAME_OBJECT, Screen.WIDTH_FULL_SCREEN, SkinAsteroid.ASTEROID1);
        //final P2d position = GameObjectUtils.generateRandomPoint();
        final P2d position = GameObjectUtils.generateSpawnPoint(engineImage.getSize());
        final V2d velocity = GameObjectUtils.ASTEROID_VEL;
        final Movement movement = new FixedMovement();
        final int life = GameObjectUtils.ASTEROID_LIFE;
        final int impactDamage = GameObjectUtils.ASTEROID_DAMAGE;

        return new Asteroid(engineImage, position, new CircleBoundingBox(), new AsteroidPhysicsComponent(),
                velocity, movement, life, impactDamage, Score.ASTEROID, Optional.empty(), SkinAsteroid.LIST_ASTEROID);
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

        return new ChaseEnemy(engineImage, position, new RectBoundingBox(), new ChaseEnemyPhysicsComponent(),
                velocity, movement, life, impactDamage, Score.CHASE_ENEMY, Optional.empty(), SkinChase.LIST_POOH);
    }

    @Override
    public FireableObject createFireEnemy() {
        final EngineImage engineImage = new EngineImage(ScaleOf.GAME_OBJECT, Screen.WIDTH_FULL_SCREEN, SkinChase.CHASE0);
        final P2d position = GameObjectUtils.generateRandomPoint();
        //final P2d position = GameObjectUtils.generateSpawnPoint(engineImage.getSize());
        final V2d velocity = GameObjectUtils.FIRE_ENEMY_VEL;
        final Movement movement = new DistantMovement();
        final int life = GameObjectUtils.FIRE_ENEMY_LIFE;
        final int impactDamage = GameObjectUtils.FIRE_ENEMY_DAMAGE;
        final Weapon weapon = new Weapon();
        final FiringLogic firingLogic = new FireEnemyFiringImpl();

        final FireEnemy fireEnemy = new FireEnemy(engineImage, position, new RectBoundingBox(), new FireEnemyPhysicsComponent(),
                velocity, movement, life, impactDamage, Score.FIRE_ENEMY, Optional.empty(), weapon, firingLogic);
        fireEnemy.setWeapon(new Weapon(AmmoType.NORMAL, fireEnemy));
        return fireEnemy;
    }

    @Override
    public FireableObject createBoss() {
        final EngineImage engineImage = new EngineImage(ScaleOf.BOSS, Screen.WIDTH_FULL_SCREEN, SkinChase.CHASE0);
        final P2d position = GameObjectUtils.generateRandomPoint();
        //final P2d position = GameObjectUtils.generateSpawnPoint(engineImage.getSize());
        final V2d velocity = GameObjectUtils.BOSS_VEL;
        final Movement movement = new DistantMovement();
        final int life = GameObjectUtils.BOSS_LIFE;
        final int impactDamage = GameObjectUtils.BOSS_DAMAGE;
        final Weapon weapon = new Weapon();
        final FiringLogic firingLogic = new BossFiringImpl();

        final Boss boss = new Boss(engineImage, position, new RectBoundingBox(), new BossPhysicsComponent(),
                velocity, movement, life, impactDamage, Score.BOSS, Optional.empty(), weapon, firingLogic);
        boss.setWeapon(new Weapon(AmmoType.NORMAL, boss));
        return boss;
    }

    @Override
    public TakeableGameObject createAmmo() {
        final EngineImage engineImage = new EngineImage(ScaleOf.GAME_OBJECT, Screen.WIDTH_FULL_SCREEN, SkinPerk.FIRE0);
        final P2d position = GameObjectUtils.generateRandomPoint();

        return new Ammo(engineImage, position, new CircleBoundingBox(), new PickablePhysicsComponent(),
                AmmoType.FIRE, SkinPerk.LIST_FIRE);
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
