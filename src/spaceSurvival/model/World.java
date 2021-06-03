package spaceSurvival.model;

import java.awt.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;


import spaceSurvival.model.GUI.settings.SkinSpaceShip;
import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.MovableGameObject;
import spaceSurvival.model.gameObject.factories.AbstractFactoryGameObject;
import spaceSurvival.model.gameObject.factories.ConcreteFactoryGameObject;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spaceSurvival.model.gameObject.takeableGameObject.AmmoType;
import spaceSurvival.model.gameObject.takeableGameObject.TakeableGameObject;
import spaceSurvival.model.gameObject.weapon.Bullet;
import spaceSurvival.model.gameObject.weapon.Weapon;
import spaceSurvival.model.worldEcollisioni.WorldEvent;
import spaceSurvival.model.worldEcollisioni.WorldEventListener;
import spaceSurvival.model.worldEcollisioni.physics.BoundaryCollision;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.CircleBoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.CollisionChecker;
import spaceSurvival.model.common.*;
import spaceSurvival.utilities.pathImage.Skin.SkinShip;

public class World {
	
	private AbstractFactoryGameObject factoryGameObject = new ConcreteFactoryGameObject();

	private final Set<MainGameObject> asteroids = new HashSet<>();
	private final Set<MainGameObject> fireEnemies = new HashSet<>();
	private final Set<MainGameObject> chaseEnemies = new HashSet<>();
	private Optional<MainGameObject> boss = Optional.empty();
	
	private final Set<TakeableGameObject> takeables = new HashSet<>();

	private SpaceShipSingleton ship;
	private RectBoundingBox mainBBox;
	private WorldEventListener evListener;
	
	public World(final RectBoundingBox mainBBox) {
		this.ship = SpaceShipSingleton.getSpaceShip();
		this.ship.setWeapon(Optional.of(new Weapon(AmmoType.NORMAL, ship)));
		
		this.mainBBox = mainBBox;

		for (int i = 0; i < 1; i++) {
			asteroids.add(factoryGameObject.createAsteroid());
			chaseEnemies.add(factoryGameObject.createChaseEnemy());
			takeables.add(factoryGameObject.createAmmo());
		}
	}

	public World(final Rectangle rectangle) {
		this.ship = SpaceShipSingleton.getSpaceShip();
		this.ship.setWeapon(Optional.of(new Weapon(AmmoType.NORMAL, ship)));

		
		this.mainBBox = new RectBoundingBox(rectangle);

		for (int i = 0; i < 1; i++) {
			asteroids.add(factoryGameObject.createAsteroid());
			chaseEnemies.add(factoryGameObject.createChaseEnemy());
			takeables.add(factoryGameObject.createAmmo());
		}
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
		asteroids.add(factoryGameObject.createAsteroid());
	}

	public void removeAsteroid(final MainGameObject obj) {
		asteroids.remove(obj);
	}
	
	public void addChaseEnemy() {
		chaseEnemies.add(factoryGameObject.createChaseEnemy());
	}
	
	public void removeChaseEnemy(final MainGameObject obj) {
		chaseEnemies.remove(obj);
	}
	
	public void addFireEnemy() {
		fireEnemies.add(factoryGameObject.createFireEnemy());
	}
	
	public void removeFireEnemy(final MainGameObject obj) {
		fireEnemies.remove(obj);
	}
	
	public void addPickable() {
		takeables.add(factoryGameObject.createAmmo());
	}

	public void removePickable(final TakeableGameObject obj) {
		takeables.remove(obj);
	}
	
	public boolean removeBullet(final Bullet bullet) {
		if(getShipBullets().remove(bullet)) {
			return true;
		}
		if(getBossBullets().remove(bullet)) {
			return true;
		}
		boolean found = false;
		Iterator<MainGameObject> fireEnemiesIterator = fireEnemies.iterator();
		while (!found || fireEnemiesIterator.hasNext()) {
			if (getFireEnemyBullets(fireEnemiesIterator.next()).remove(bullet)) {
				found = true;
			}
		}
		return found;
	}
	
	public void updateState(int dt) {
		//ship.updatePhysics(dt, this);
		this.getAllEntities().forEach(entity -> entity.updatePhysics(dt, this));
	}

	public Optional<BoundaryCollision> checkCollisionWithBoundaries(P2d pos, RectBoundingBox box){
		P2d ul = box.getULCorner();
		P2d br = box.getBRCorner();

		double xShip = pos.getX();
		double yShip = pos.getY();
		
		if (yShip < ul.y){
			return Optional.of(new BoundaryCollision(BoundaryCollision.CollisionEdge.TOP, new P2d(xShip, ul.y)));
		} 
		else if (yShip + ship.getSize().getHeight() > br.y){
			return Optional.of(new BoundaryCollision(BoundaryCollision.CollisionEdge.BOTTOM, new P2d(pos.x, br.y)));
		} 
		else if (xShip + ship.getSize().getWidth() > br.x){
			return Optional.of(new BoundaryCollision(BoundaryCollision.CollisionEdge.RIGHT, new P2d(br.x, pos.y)));
		} 
		else if (xShip < ul.x){
			return Optional.of(new BoundaryCollision(BoundaryCollision.CollisionEdge.LEFT, new P2d(ul.x, pos.y)));
		} else {
			return Optional.empty();
		}
	}

	CollisionChecker checker = new CollisionChecker();
	
	public Optional<MainGameObject> checkCollisionWithAsteroids(final RectBoundingBox rectBoundingBox) {
		//double radius = box.getWidth();
		//System.out.println("Questa è la width della ship" + radius);
		for (MainGameObject obj: asteroids) {
			if (checker.testRectangleToCircle(rectBoundingBox, (CircleBoundingBox) obj.getBoundingBox())) {		
			    System.out.println("MANDATO UN EVENTO ASTEROID");
				return Optional.of(obj);
			}

		}
		return Optional.empty();
	}
	
	public Optional<MainGameObject> checkCollisionWithChaseEnemies(final RectBoundingBox rectBoundingBox) {
	//double radius = box.getWidth();
		for (MainGameObject obj: chaseEnemies) {
			if(checker.testRectangleToRectangle(rectBoundingBox, (RectBoundingBox) obj.getBoundingBox())) {
				System.out.println("MANDATO UN EVENTO ENEMIES");
				return Optional.of(obj);
			}
		}
		return Optional.empty();
	}
	

	public Optional<MainGameObject> checkCollisionWithFireEnemies(final RectBoundingBox rectBoundingBox) {
	//double radius = box.getWidth();
		for (MainGameObject obj: fireEnemies) {
			if(checker.testRectangleToRectangle(rectBoundingBox, (RectBoundingBox) obj.getBoundingBox())) {
				System.out.println("MANDATO UN EVENTO ENEMIES");
				return Optional.of(obj);
			}
		}
		return Optional.empty();
	}
	


//
//	public Optional<MainGameObject> checkCollisionWithBoss(final P2d pos, final RectBoundingBox box) {
//		if (boss.isPresent()) {
//			double radius = box.getWidth();
//			if (this.getBoss().get().getBoundingBox().isCollidingWith(pos, radius)) {
//				return this.getBoss();
//			}
//		}
//		return Optional.empty();
//	}
//	
	public Optional<TakeableGameObject> checkCollisionWithPickables(final RectBoundingBox rectBoundingBox) {
		for (TakeableGameObject obj: takeables) {
			if (checker.testRectangleToCircle(rectBoundingBox, (CircleBoundingBox) obj.getBoundingBox())) {		
			    System.out.println("MANDATO UN EVENTO PICKABLE");
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
	
	public Set<MainGameObject> getAsteroids() {
		return this.asteroids;
	}
	
	public Set<MainGameObject> getFireEnemies() {
		return this.fireEnemies;
	}
	
	public Set<MainGameObject> getChaseEnemies() {
		return this.chaseEnemies;
	}

	public Set<Bullet> getShipBullets() {
		if (this.ship.getWeapon().isPresent()) {
			return this.ship.getWeapon().get().getShootedBullets();
		}
		return new HashSet<>();
	}
	
	public Set<Bullet> getFireEnemyBullets(final MainGameObject fireEnemy) {
		if (fireEnemy.getWeapon().isPresent()) {
			return fireEnemy.getWeapon().get().getShootedBullets();
		}
		return new HashSet<>();
	}
	
	public Set<Bullet> getBossBullets() {
		if (this.boss.isPresent() && this.boss.get().getWeapon().isPresent()) {
			return this.boss.get().getWeapon().get().getShootedBullets();
		}
		return new HashSet<>();
	}
	
	public Set<Bullet> getAllBullets() {
		HashSet<Bullet> allBullets = new HashSet<>();
		allBullets.addAll(getShipBullets());
		this.fireEnemies.forEach(fireEnemy -> {
			allBullets.addAll(getFireEnemyBullets(fireEnemy));
		});
		allBullets.addAll(getBossBullets());
		return allBullets;
	}
	
	public Optional<MainGameObject> getBoss() {
		return boss;
	}

	public void setBoss(final Optional<MainGameObject> boss) {
		this.boss = boss;
	}
	
	public Set<TakeableGameObject> getTakeables() {
		return this.takeables;
	}

	public Set<MainGameObject> getAllEnemies() {
		HashSet<MainGameObject> allEnemies = new HashSet<>();
		allEnemies.addAll(chaseEnemies);
		allEnemies.addAll(fireEnemies);
		if (this.boss.isPresent()) {
			allEnemies.add(this.boss.get());
		}
		return allEnemies;
	}
	
	public Set<MovableGameObject> getMovableEntities() {
		Set<MovableGameObject> entities = new HashSet<>();
		entities.add(ship);
		entities.addAll(asteroids);
		entities.addAll(getAllEnemies());
		if (boss.isPresent()) {
			entities.add(boss.get());
		}
		if (ship.getWeapon().isPresent()) {
			entities.addAll(ship.getWeapon().get().getShootedBullets());
		}
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
		entities.addAll(takeables);
		if (ship.getWeapon().isPresent()) {
			entities.addAll(ship.getWeapon().get().getShootedBullets());
		}
		return entities;
	}
	
	public void removeAllEnemies() {
		this.chaseEnemies.clear();
		this.fireEnemies.clear();
		this.boss = Optional.empty();
	}

	public long getCountEnemies() {
		return this.fireEnemies.size() +
				this.chaseEnemies.size() +
				(this.boss.isPresent() ? 1 : 0);
	}

	public int getLifeShip() {
		return this.ship.getLife();
	}

	public int getLifeBoss() {
		return this.boss.map(MainGameObject::getLife).orElse(0);
	}

}
