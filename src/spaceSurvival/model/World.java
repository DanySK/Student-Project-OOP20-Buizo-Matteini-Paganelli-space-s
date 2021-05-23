package spaceSurvival.model;

import java.awt.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.MovableGameObject;
import spaceSurvival.model.gameObject.PickableGameObject;
import spaceSurvival.model.gameObject.factories.AbstractFactoryGameObject;
import spaceSurvival.model.gameObject.factories.ConcreteFactoryGameObject;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spaceSurvival.model.worldEcollisioni.WorldEvent;
import spaceSurvival.model.worldEcollisioni.WorldEventListener;
import spaceSurvival.model.worldEcollisioni.physics.BoundaryCollision;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import spaceSurvival.model.common.*;

public class World {
	
	private AbstractFactoryGameObject factoryGameObject = new ConcreteFactoryGameObject();

	private Set<MainGameObject> asteroids = new HashSet<>();
	private Set<MainGameObject> fireEnemies = new HashSet<>();
	private Set<MainGameObject> chaseEnemies = new HashSet<>();
	private Optional<MainGameObject> boss = Optional.empty();
	
	private Set<PickableGameObject> pickables = new HashSet<>();

	private SpaceShipSingleton ship;
	private RectBoundingBox mainBBox;
	private WorldEventListener evListener;
	
	public World(final RectBoundingBox mainBBox) {
		this.ship = SpaceShipSingleton.getSpaceShip();
		this.mainBBox = mainBBox;

		for (int i = 0; i < 1; i++) {
			addChaseEnemy(factoryGameObject.createChaseEnemy());
			addPickable(factoryGameObject.createPickable());
			//addFireEnemy(factoryGameObject.createFireEnemy());
			//asteroids.add(factoryGameObject.createAsteroid());
			//chaseEnemies.add(factoryGameObject.createChaseEnemy());
			//fireEnemies.add(factoryGameObject.createFireEnemy());
		}
		
//		System.out.println(getFireEnemies());
//		System.out.println(getChaseEnemies());
//		System.out.println(getPickables());


	}

	public World(final Rectangle rectangle){
		this.ship = SpaceShipSingleton.getSpaceShip();
		this.mainBBox = new RectBoundingBox(rectangle);

		for (int i = 0; i < 1; i++) {
			addChaseEnemy(factoryGameObject.createChaseEnemy());
			addPickable(factoryGameObject.createPickable());
			//addFireEnemy(factoryGameObject.createFireEnemy());
			//asteroids.add(factoryGameObject.createAsteroid());
			//chaseEnemies.add(factoryGameObject.createChaseEnemy());
			//fireEnemies.add(factoryGameObject.createFireEnemy());
		}
	}

	public void setEventListener(WorldEventListener l) {
		evListener = l;
	}
	
	public void setShip(SpaceShipSingleton ship) {
		this.ship = ship;
	}
	
	public SpaceShipSingleton getShip() {
		return this.ship;
	}

	public void setSkin(final String path) {
		this.ship.getEngineImage().setPath(path);
	}

	public void moveShip(){
		this.ship.move();
	}
	
	public AbstractFactoryGameObject getFactoryGameObject() {
		return factoryGameObject;
	}

	public void setFactoryGameObject(AbstractFactoryGameObject factoryGameObject) {
		this.factoryGameObject = factoryGameObject;
	}
	
	public void addAsteroid(MainGameObject obj) {
		asteroids.add(obj);
	}

	public void removeAsteroid(MainGameObject obj) {
		asteroids.remove(obj);
	}
	
	public void addChaseEnemy(MainGameObject obj) {
		chaseEnemies.add(obj);
	}
	
	public void removeChaseEnemy(MainGameObject obj) {
		chaseEnemies.remove(obj);
	}
	
	public void addFireEnemy(MainGameObject obj) {
		fireEnemies.add(obj);
	}
	
	public void removeFireEnemy(MainGameObject obj) {
		fireEnemies.remove(obj);
	}
	
	public void addPickable(PickableGameObject obj) {
		pickables.add(obj);
	}

	public void removePickable(PickableGameObject obj) {
		pickables.remove(obj);
	}
	
	public void updateState(int dt) {
		ship.updatePhysics(dt, this);
		//asteroids.forEach(a -> a.updatePhysics(dt, this));
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

	public Optional<MainGameObject> checkCollisionWithAsteroids(P2d pos, RectBoundingBox box) {
		double radius = box.getWidth();
		for (MainGameObject obj: asteroids){
			if (obj.getBoundingBox().isCollidingWith(pos, radius)){
				return Optional.of(obj);
			}
		}
		return Optional.empty();
	}
	
	public Optional<MainGameObject> checkCollisionWithChaseEnemies(P2d pos, RectBoundingBox box) {
		double radius = box.getWidth();
		for (MainGameObject obj: chaseEnemies){
			if (obj.getBoundingBox().isCollidingWith(pos, radius)){
				return Optional.of(obj);
			}
		}
		return Optional.empty();
	}
	
	public Optional<MainGameObject> checkCollisionWithFireEnemies(P2d pos, RectBoundingBox box) {
		double radius = box.getWidth();
		for (MainGameObject obj: fireEnemies){
			if (obj.getBoundingBox().isCollidingWith(pos, radius)){
				return Optional.of(obj);
			}
		}
		return Optional.empty();
	}

	public Optional<MainGameObject> checkCollisionWithBoss(P2d pos, RectBoundingBox box){
		//System.out.println(boss);
		if (boss.isPresent()) {
			System.out.println("SONO DENTRO L IF");
			double radius = box.getWidth();
			if (this.getBoss().get().getBoundingBox().isCollidingWith(pos, radius)){
				return this.getBoss();
			}
		}
		return Optional.empty();
	}
	
	public Optional<PickableGameObject> checkCollisionWithPickables(P2d pos, RectBoundingBox box) {
		double radius = box.getWidth();
		for (PickableGameObject obj: pickables){
			if (obj.getBoundingBox().isCollidingWith(pos, radius)){
				return Optional.of(obj);
			}
		}
		return Optional.empty();
	}
	
	public void notifyWorldEvent(WorldEvent ev) {
		evListener.notifyEvent(ev);
	}
	
	public RectBoundingBox getMainBBox() {
		return mainBBox;
	}
	
	public Set<MainGameObject> getAsteroids() {
		return this.asteroids;
	}
	
	public Set<MainGameObject> getAllEnemies() {
		HashSet<MainGameObject> allEnemies = new HashSet<>();
		allEnemies.addAll(chaseEnemies);
		allEnemies.addAll(fireEnemies);
		return allEnemies;
	}
	
	public Set<MainGameObject> getFireEnemies() {
		return this.fireEnemies;
	}
	
	public Set<MainGameObject> getChaseEnemies() {
		return this.chaseEnemies;
	}
	
	public Optional<MainGameObject> getBoss() {
		return boss;
	}

	public void setBoss(Optional<MainGameObject> boss) {
		this.boss = boss;
	}
	
	public Set<PickableGameObject> getPickables() {
		return this.pickables;
	}

	public Set<MovableGameObject> getMovableEntities() {
		Set<MovableGameObject> entities = new HashSet<>();
		entities.add(ship);
		entities.addAll(asteroids);
		entities.addAll(getAllEnemies());
		if (boss.isPresent()) {
			entities.add(boss.get());
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
		entities.addAll(pickables);
		return entities;
	}

	public int getUsBoss(){
		return this.boss.isPresent() ? 1 : 0;
	}

	public long getCountEnemies(){
		return this.asteroids.size() +
				this.fireEnemies.size() +
				this.chaseEnemies.size() +
				this.getUsBoss();
	}

	public int getLifeShip(){
		return this.ship.getLife();
	}

	public int getLifeBoss() {
		return this.boss.map(MainGameObject::getLife).orElse(0);
	}
}
