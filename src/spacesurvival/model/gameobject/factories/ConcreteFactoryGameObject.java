package spacesurvival.model.gameobject.factories;

import java.util.Optional;

import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.fireable.Boss;
import spacesurvival.model.gameobject.fireable.FireEnemy;
import spacesurvival.model.gameobject.fireable.FireableObject;
import spacesurvival.model.gameobject.fireable.shootinglogic.FiringLogic;
import spacesurvival.model.gameobject.fireable.shootinglogic.implementation.BossFiringImpl;
import spacesurvival.model.gameobject.fireable.shootinglogic.implementation.FireEnemyFiringImpl;
import spacesurvival.model.gameobject.fireable.weapon.Weapon;
import spacesurvival.model.gameobject.main.Asteroid;
import spacesurvival.model.gameobject.main.ChaseEnemy;
import spacesurvival.model.gameobject.main.MainObject;
import spacesurvival.model.gameobject.movable.movement.MovementLogic;
import spacesurvival.model.gameobject.movable.movement.implementation.ChasingMovement;
import spacesurvival.model.gameobject.movable.movement.implementation.RandomMovement;
import spacesurvival.model.gameobject.movable.movement.implementation.FixedMovement;
import spacesurvival.model.gameobject.takeable.TakeableGameObject;
import spacesurvival.model.gameobject.takeable.ammo.Ammo;
import spacesurvival.model.gameobject.takeable.ammo.AmmoType;
import spacesurvival.model.gameobject.takeable.heart.Heart;
import spacesurvival.model.gameobject.takeable.heart.HeartType;
import spacesurvival.model.EngineImage;
import spacesurvival.model.collision.physics.bounding.CircleBoundingBox;
import spacesurvival.model.collision.physics.bounding.RectBoundingBox;
import spacesurvival.model.collision.physics.component.AsteroidPhysic;
import spacesurvival.model.collision.physics.component.BossPhysic;
import spacesurvival.model.collision.physics.component.ChaseEnemyPhysic;
import spacesurvival.model.collision.physics.component.FireEnemyPhysic;
import spacesurvival.model.collision.physics.component.PickablePhysic;
import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;
import spacesurvival.utilities.Score;
import spacesurvival.utilities.dimension.ScaleOf;
import spacesurvival.utilities.dimension.Screen;
import spacesurvival.utilities.gameobject.DamageUtils;
import spacesurvival.utilities.gameobject.LifeUtils;
import spacesurvival.utilities.gameobject.VelocityUtils;
import spacesurvival.utilities.path.skin.SkinAsteroid;
import spacesurvival.utilities.path.skin.SkinChase;
import spacesurvival.utilities.path.skin.SkinPerk;

public class ConcreteFactoryGameObject extends AbstractFactoryGameObject {

    private final double acceleration = VelocityUtils.NO_ACCELERATION;

    @Override
    public MainObject createAsteroid() {
        final EngineImage engineImage = new EngineImage(ScaleOf.GAME_OBJECT, Screen.WIDTH_FULL_SCREEN, SkinAsteroid.ASTEROID1);
        //final P2d position = GameObjectUtils.generateRandomPoint();
        final P2d position = GameObjectUtils.generateSpawnPoint(engineImage.getSize());
        final V2d velocity = VelocityUtils.ASTEROID_VEL;
        final MovementLogic movementLogic = new FixedMovement();
        final int life = LifeUtils.ASTEROID_LIFE;
        final int impactDamage = DamageUtils.ASTEROID_DAMAGE;

        return new Asteroid(engineImage, position, new CircleBoundingBox(), new AsteroidPhysic(), velocity,
                acceleration,  movementLogic, life, impactDamage, Score.ASTEROID, Optional.empty(), SkinAsteroid.LIST_ASTEROID);
    }

    @Override
    public MainObject createChaseEnemy() {
        final EngineImage engineImage = new EngineImage(ScaleOf.GAME_OBJECT, Screen.WIDTH_FULL_SCREEN, SkinChase.POOH0);
        final P2d position = GameObjectUtils.generateRandomPoint();
        //final P2d position = GameObjectUtils.generateSpawnPoint(engineImage.getSize());
        final V2d velocity = VelocityUtils.CHASE_ENEMY_VEL;
        final MovementLogic movementLogic = new ChasingMovement();
        final int life = LifeUtils.CHASE_ENEMY_LIFE;
        final int impactDamage = DamageUtils.CHASE_ENEMY_DAMAGE;

        return new ChaseEnemy(engineImage, position, new RectBoundingBox(), new ChaseEnemyPhysic(), velocity,
                acceleration, movementLogic, life, impactDamage, Score.CHASE_ENEMY, Optional.empty(), SkinChase.LIST_POOH);
    }

    @Override
    public FireableObject createFireEnemy() {
        final EngineImage engineImage = new EngineImage(ScaleOf.GAME_OBJECT, Screen.WIDTH_FULL_SCREEN, SkinChase.CHASE0);
        final P2d position = GameObjectUtils.generateRandomPoint();
        //final P2d position = GameObjectUtils.generateSpawnPoint(engineImage.getSize());
        final V2d velocity = VelocityUtils.FIRE_ENEMY_VEL;
        final MovementLogic movementLogic = new RandomMovement();
        final int life = LifeUtils.FIRE_ENEMY_LIFE;
        final int impactDamage = DamageUtils.FIRE_ENEMY_DAMAGE;
        final Weapon weapon = new Weapon();
        final FiringLogic firingLogic = new FireEnemyFiringImpl();

        final FireEnemy fireEnemy = new FireEnemy(engineImage, position, new RectBoundingBox(), new FireEnemyPhysic(), velocity,
                acceleration, movementLogic, life, impactDamage, Score.FIRE_ENEMY, Optional.empty(), weapon, firingLogic);
        fireEnemy.setWeapon(new Weapon(AmmoType.NORMAL, fireEnemy));
        return fireEnemy;
    }

    @Override
    public FireableObject createBoss() {
        final EngineImage engineImage = new EngineImage(ScaleOf.BOSS, Screen.WIDTH_FULL_SCREEN, SkinChase.CHASE0);
        final P2d position = GameObjectUtils.generateRandomPoint();
        //final P2d position = GameObjectUtils.generateSpawnPoint(engineImage.getSize());
        final V2d velocity = VelocityUtils.BOSS_VEL;
        final MovementLogic movementLogic = new RandomMovement();
        final int life = LifeUtils.BOSS_LIFE;
        final int impactDamage = DamageUtils.BOSS_DAMAGE;
        final Weapon weapon = new Weapon();
        final FiringLogic firingLogic = new BossFiringImpl();

        final Boss boss = new Boss(engineImage, position, new RectBoundingBox(), new BossPhysic(), velocity,
                acceleration, movementLogic, life, impactDamage, Score.BOSS, Optional.empty(), weapon, firingLogic);
        boss.setWeapon(new Weapon(AmmoType.NORMAL, boss));
        return boss;
    }

    @Override
    public TakeableGameObject createAmmo() {
        final AmmoType ammoType = AmmoType.ICE; // AmmoType.random();
        final EngineImage engineImage = new EngineImage(ScaleOf.GAME_OBJECT, Screen.WIDTH_FULL_SCREEN, SkinPerk.FIRE0);
        final P2d position = GameObjectUtils.generateRandomPoint();

        return new Ammo(engineImage, position, new CircleBoundingBox(), new PickablePhysic(),
                ammoType);
    }

    @Override
    public TakeableGameObject createHeart() {
        final HeartType heartType = HeartType.random();
        final EngineImage engineImage = new EngineImage(ScaleOf.GAME_OBJECT, Screen.WIDTH_FULL_SCREEN, SkinPerk.FIRE0);
        final P2d position = GameObjectUtils.generateRandomPoint();

        return new Heart(engineImage, position, new CircleBoundingBox(), new PickablePhysic(),
                heartType);
    }

}
