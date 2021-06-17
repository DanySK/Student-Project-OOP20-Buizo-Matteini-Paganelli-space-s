package spacesurvival.model;

import java.awt.Rectangle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import spacesurvival.model.gui.settings.SkinSpaceShip;
import spacesurvival.model.collision.CollisionChecker;
import spacesurvival.model.collision.physics.BoundaryCollision;
import spacesurvival.model.collision.physics.bounding.CircleBoundingBox;
import spacesurvival.model.collision.physics.bounding.RectBoundingBox;
import spacesurvival.model.common.P2d;
import spacesurvival.model.gameobject.Edge;
import spacesurvival.model.gameobject.GameObject;
import spacesurvival.model.gameobject.factories.AbstractFactoryGameObject;
import spacesurvival.model.gameobject.factories.ConcreteFactoryGameObject;
import spacesurvival.model.gameobject.fireable.Boss;
import spacesurvival.model.gameobject.fireable.FireEnemy;
import spacesurvival.model.gameobject.fireable.FireableObject;
import spacesurvival.model.gameobject.fireable.weapon.Bullet;
import spacesurvival.model.gameobject.fireable.weapon.Weapon;
import spacesurvival.model.gameobject.main.Asteroid;
import spacesurvival.model.gameobject.main.ChaseEnemy;
import spacesurvival.model.gameobject.main.MainObject;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;
import spacesurvival.model.gameobject.movable.MovableObject;
import spacesurvival.model.gameobject.takeable.TakeableGameObject;
import spacesurvival.model.gameobject.takeable.ammo.Ammo;
import spacesurvival.model.gameobject.takeable.ammo.AmmoType;
import spacesurvival.model.gameobject.takeable.heart.Heart;
import spacesurvival.model.worldevent.WorldEvent;
import spacesurvival.model.worldevent.WorldEventListener;

public class World {
    private AbstractFactoryGameObject factoryGameObject = new ConcreteFactoryGameObject();

    private final Set<MainObject> asteroids = new HashSet<>();
    private final Set<MainObject> chaseEnemies = new HashSet<>();
    private final Set<FireableObject> fireEnemies = new HashSet<>();
    private Optional<FireableObject> boss;
    private final Set<TakeableGameObject> ammo = new HashSet<>();
    private final Set<TakeableGameObject> hearts = new HashSet<>();
    private SpaceShipSingleton ship;
    private final RectBoundingBox mainBBox;
    private WorldEventListener evListener;
    private final CollisionChecker collisionChecker = new CollisionChecker();

    public World(final RectBoundingBox mainBBox) {
        this.ship = SpaceShipSingleton.getSpaceShip();
        this.ship.setWeapon(new Weapon(AmmoType.NORMAL, ship));
        this.mainBBox = mainBBox;

        for (int i = 0; i < 1; i++) {
            this.addAsteroid();
            this.addChaseEnemy();
            this.addFireEnemy();
            this.addAmmo();
            //asteroids.add(factoryGameObject.createAsteroid());
            //chaseEnemies.add(factoryGameObject.createChaseEnemy());
            //ammo.add(factoryGameObject.createAmmo());
            //hearts.add(factoryGameObject.createHeart());
        }
        this.addBoss();
        //this.boss = Optional.of(factoryGameObject.createBoss());
    }

    public World(final Rectangle rectangle) {
        this.ship = SpaceShipSingleton.getSpaceShip();
        this.ship.setWeapon(new Weapon(AmmoType.NORMAL, ship));
        this.mainBBox = new RectBoundingBox(rectangle);

        for (int i = 0; i < 1; i++) {
            this.addAsteroid();
            this.addChaseEnemy();
            this.addFireEnemy();
            this.addAmmo();
        }
        this.addBoss();
    }

    public void setEventListener(final WorldEventListener l) {
        evListener = l;
    }

    public void setShip(final SpaceShipSingleton ship) {
        this.ship = ship;
    }

    public SpaceShipSingleton getShip() {
        return this.ship;
    }

    public void setSkin(final SkinSpaceShip skin) {
        this.ship.getEngineImage().setPath(skin.getSkin());
        this.ship.setAnimation(skin.getAnimation());
    }

    public void moveShip() {
        this.ship.move();
    }

    public AbstractFactoryGameObject getFactoryGameObject() {
        return factoryGameObject;
    }

    public void setFactoryGameObject(final AbstractFactoryGameObject factoryGameObject) {
        this.factoryGameObject = factoryGameObject;
    }
	
    public void addAsteroid() {
        final MainObject asteroid = factoryGameObject.createAsteroid();
        asteroids.add(asteroid);
        asteroid.startMoving();
    }

    public void removeAsteroid(final MainObject asteroid) {
        asteroid.stopMoving();
        asteroids.remove(asteroid);
    }

    public void addChaseEnemy() {
        final MainObject chaseEnemy = factoryGameObject.createChaseEnemy();
        chaseEnemies.add(chaseEnemy);
        chaseEnemy.startMoving();
    }
	
    public void removeChaseEnemy(final MainObject chaseEnemy) {
        chaseEnemy.stopMoving();
        chaseEnemies.remove(chaseEnemy);
    }
	
    public void addFireEnemy() {
        final FireableObject fireEnemy = factoryGameObject.createFireEnemy();
        fireEnemies.add(fireEnemy);
        fireEnemy.startMoving();
        fireEnemy.startFiring();
    }
	
    public void removeFireEnemy(final MainObject fireEnemy) {
        fireEnemy.stopMoving();
        fireEnemies.remove(fireEnemy);
    }
	
    public void addBoss() {
        this.boss = Optional.of(factoryGameObject.createBoss());
        this.boss.get().startMoving();
        this.boss.get().startFiring();
    }
	
    public void removeBoss() {
        if (this.boss.isPresent()) {
            this.boss.get().stopMoving();
            this.boss = Optional.empty();
        }
    }

    public void addAmmo() {
        ammo.add(factoryGameObject.createAmmo());
    }

    public void removeAmmo(final TakeableGameObject obj) {
        ammo.remove(obj);
    }
	
    public void addHeart() {
        hearts.add(factoryGameObject.createHeart());
    }

    public void removeHeart(final TakeableGameObject obj) {
        hearts.remove(obj);
    }
	
    public boolean removeBullet(final Bullet bullet) {
        bullet.stopMoving();
        if (getShipBullets().remove(bullet)) {
            return true;
        }
        if (getBossBullets().remove(bullet)) {
            return true;
        }
        final boolean found = false;
        final Iterator<FireableObject> fireEnemiesIterator = fireEnemies.iterator();
        while (fireEnemiesIterator.hasNext()) {
            getFireEnemyBullets(fireEnemiesIterator.next()).remove(bullet);
	}
        return found;
    }
	
    public void removeMainObject(final MainObject object) {
        if (object instanceof Asteroid) {
            removeAsteroid(object);
        } else if (object instanceof ChaseEnemy) {
            removeChaseEnemy(object);
        } else if (object instanceof FireEnemy) {
            removeFireEnemy(object);
        } else if (object instanceof Boss) {
            removeBoss();
        }
    }
	
    public void removeTakeableObject(final TakeableGameObject object) {
        if (object instanceof Ammo) {
            removeAmmo(object);
        } else if (object instanceof Heart) {
            removeHeart(object);
        }
    }
	
    public void updateState() {
        this.getAllEntities().forEach(entity -> {
            entity.updatePhysics(this);
        });
    }

    public Optional<BoundaryCollision> checkCollisionWithBoundaries(final P2d pos, final RectBoundingBox box) {
        final P2d ul = box.getULCorner();
        final P2d br = box.getBRCorner();

        final double xShip = pos.getX();
        final double yShip = pos.getY();

        final double tollerance = 100;
        if (yShip < ul.getY() - tollerance) {
            return Optional.of(new BoundaryCollision(Edge.TOP, new P2d(xShip, ul.getY())));
        } else if (yShip > br.getY() + tollerance) {
            return Optional.of(new BoundaryCollision(Edge.BOTTOM, new P2d(pos.getX(), br.getY())));
        } else if (xShip > br.getX() + tollerance) {
            return Optional.of(new BoundaryCollision(Edge.RIGHT, new P2d(br.getX(), pos.getY())));
        } else if (xShip < ul.getX() - tollerance) {
            return Optional.of(new BoundaryCollision(Edge.LEFT, new P2d(ul.getX(), pos.getY())));
        } else {
            return Optional.empty();
        }
    }
	
    public Optional<SpaceShipSingleton> checkCollisionWithShip(final RectBoundingBox rectBoundingBox) {
        if (boss.isPresent()) {
            if (collisionChecker.testRectangleToRectangle(rectBoundingBox, (RectBoundingBox) ship.getBoundingBox())) {
                return Optional.of(this.ship);
            }
        }
        return Optional.empty();
    }

    public Optional<MainObject> checkCollisionWithAsteroids(final RectBoundingBox rectBoundingBox) {
        for (final MainObject obj: asteroids) {
            if (collisionChecker.testRectangleToCircle(rectBoundingBox, (CircleBoundingBox) obj.getBoundingBox())) {
                return Optional.of(obj);
            }
        }
        return Optional.empty();
    }
	
    public Optional<MainObject> checkCollisionWithChaseEnemies(final RectBoundingBox rectBoundingBox) {
        for (final MainObject obj: chaseEnemies) {
            if (collisionChecker.testRectangleToRectangle(rectBoundingBox, (RectBoundingBox) obj.getBoundingBox())) {
                return Optional.of(obj);
            }
        }
        return Optional.empty();
    }
	
    public Optional<FireableObject> checkCollisionWithFireEnemies(final RectBoundingBox rectBoundingBox) {
        for (final FireableObject obj: fireEnemies) {
            if (collisionChecker.testRectangleToRectangle(rectBoundingBox, (RectBoundingBox) obj.getBoundingBox())) {
                return Optional.of(obj);
            }
        }
        return Optional.empty();
    }
	
    public Optional<FireableObject> checkCollisionWithBoss(final RectBoundingBox rectBoundingBox) {
        if (boss.isPresent()) {
            if (collisionChecker.testRectangleToRectangle(rectBoundingBox, (RectBoundingBox) boss.get().getBoundingBox())) {
                return this.boss;
            }
        }
        return Optional.empty();
    }

    public Optional<TakeableGameObject> checkCollisionWithAmmo(final RectBoundingBox rectBoundingBox) {
        for (final TakeableGameObject obj: ammo) {
            if (collisionChecker.testRectangleToCircle(rectBoundingBox, (CircleBoundingBox) obj.getBoundingBox())) {
                return Optional.of(obj);
            }
        }
        return Optional.empty();
    }
	
    public Optional<TakeableGameObject> checkCollisionWithHearts(final RectBoundingBox rectBoundingBox) {
        for (final TakeableGameObject obj: hearts) {
            if (collisionChecker.testRectangleToCircle(rectBoundingBox, (CircleBoundingBox) obj.getBoundingBox())) {
                return Optional.of(obj);
            }
        }
        return Optional.empty();
    }
	
    public void notifyWorldEvent(final WorldEvent ev) {
        evListener.notifyEvent(ev);
    }
	
    public RectBoundingBox getMainBBox() {
        return mainBBox;
    }

    public Set<MainObject> getAsteroids() {
        return this.asteroids;
    }
	
    public Set<MainObject> getChaseEnemies() {
        return this.chaseEnemies;
    }
	
    public Set<FireableObject> getFireEnemies() {
        return this.fireEnemies;
    }
	
    public Optional<FireableObject> getBoss() {
        return boss;
    }
	
    public Set<TakeableGameObject> getAmmo() {
        return ammo;
    }

    public Set<TakeableGameObject> getHearts() {
        return hearts;
    }
	
    public Set<MainObject> getMainGameObjects() {
        final Set<MainObject> mainObjects = new HashSet<>();
        mainObjects.addAll(asteroids);
        mainObjects.addAll(chaseEnemies);
        mainObjects.addAll(fireEnemies);
        boss.ifPresent(mainObjects::add);
        mainObjects.add(ship);
        return mainObjects;
    }
	
    public Set<TakeableGameObject> getTakeableGameObjects() {
        final Set<TakeableGameObject> takeableGameObjects = new HashSet<>();
        takeableGameObjects.addAll(ammo);
        takeableGameObjects.addAll(hearts);
        return takeableGameObjects;
    }

    public Set<Bullet> getShipBullets() {
            return this.ship.getWeapon().getShootedBullets();
    }
	
    public Set<Bullet> getFireEnemyBullets(final FireableObject fireEnemy) {
        return fireEnemy.getWeapon().getShootedBullets();
    }
	
    public Set<Bullet> getBossBullets() {
        if (this.boss.isPresent()) {
            return this.boss.get().getWeapon().getShootedBullets();
        }
        return new HashSet<>();
    }
	
    public Set<Bullet> getAllBullets() {
        final HashSet<Bullet> allBullets = new HashSet<>();
        allBullets.addAll(getShipBullets());
        this.fireEnemies.forEach(fireEnemy -> {
            allBullets.addAll(getFireEnemyBullets(fireEnemy));
        });
        allBullets.addAll(getBossBullets());
        return allBullets;
    }
	
    public Set<MainObject> getAllEnemies() {
        final HashSet<MainObject> allEnemies = new HashSet<>();
        allEnemies.addAll(chaseEnemies);
        allEnemies.addAll(fireEnemies);
        if (this.boss.isPresent()) {
            allEnemies.add(this.boss.get());
        }
        return allEnemies;
    }
	
    public Set<MovableObject> getMovableEntities() {
        final Set<MovableObject> entities = new HashSet<>();
        entities.add(ship);
        entities.addAll(asteroids);
        entities.addAll(getAllEnemies());
        if (boss.isPresent()) {
            entities.add(boss.get());
        }
        entities.addAll(getAllBullets());

        return entities;
    }

    public void removeAllEnemies() {
        this.chaseEnemies.clear();
        this.fireEnemies.clear();
        this.boss = Optional.empty();
    }

    public Set<GameObject> getAllEntitiesExceptionBullets() {
        final Set<GameObject> entities = new HashSet<>();
        entities.add(ship);
        entities.addAll(asteroids);
        entities.addAll(getAllEnemies());
        if (boss.isPresent()) {
            entities.add(boss.get());
        }
        entities.addAll(ammo);
        entities.addAll(hearts);
	    return entities;
	}
	
	public Set<GameObject> getAllEntities() {
		Set<GameObject> entities = new HashSet<>();
		entities.add(ship);
		entities.addAll(asteroids);
		entities.addAll(getAllEnemies());
		if (boss.isPresent()) {
			entities.add(boss.get());
		}
        entities.addAll(getAllBullets());
		entities.addAll(ammo);
		entities.addAll(hearts);
		return entities;
	}

    public long getCountEnemies() {
        return this.fireEnemies.size() 
                + this.chaseEnemies.size() 
                + (this.boss.isPresent() ? 1 : 0);
    }


    public int getLifeShip() {
        return this.ship.getLife();
    }

    public int getLifeBoss() {
        return this.boss.get().getLife();
    }

}
