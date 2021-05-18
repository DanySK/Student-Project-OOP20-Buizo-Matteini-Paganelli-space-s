package model.world;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import model.gameObject.GameObject;
import model.gameObject.MainGameObject;
import model.gameObject.PickableGameObject;
import model.gameObject.factories.AbstractFactoryGameObject;
import model.gameObject.factories.ConcreteFactoryGameObject;
import model.gameObject.mainGameObject.SpaceShipSingleton;
import model.worldEcollisioni.WorldEvent;
import model.worldEcollisioni.WorldEventListener;
import model.worldEcollisioni.physics.BoundaryCollision;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import model.GUI.game.EngineGame;
import model.common.*;

public class World {
	
	private AbstractFactoryGameObject factoryGameObject = new ConcreteFactoryGameObject();

	private Set<MainGameObject> asteroids = new HashSet<>();
	private Set<MainGameObject> fireEnemies = new HashSet<>();
	private Set<MainGameObject> chaseEnemies = new HashSet<>();
	private Optional<MainGameObject> boss = Optional.of(factoryGameObject.createBoss()); 
	
	private Set<PickableGameObject> pickables = new HashSet<>();

	private SpaceShipSingleton ship;
	private RectBoundingBox mainBBox;
	private WorldEventListener evListener;
	
	public World(RectBoundingBox bbox){
		ship = SpaceShipSingleton.getSpaceShip();
		
		for (int i = 0; i < 1; i++) {
			asteroids.add(factoryGameObject.createAsteroid());
			chaseEnemies.add(factoryGameObject.createChaseEnemy());
			fireEnemies.add(factoryGameObject.createFireEnemy());
		}
		
		
		mainBBox = bbox;
		
		System.out.println(getFireEnemies());
		System.out.println(getChaseEnemies());

	}

	public void setEventListener(WorldEventListener l){
		evListener = l;
	}
	
	public void setShip(SpaceShipSingleton ship){
		this.ship = ship;
	}
	
	public SpaceShipSingleton getShip(){
		return this.ship;
	}

	public void setSkin(final String path){
		this.ship.getEngineImage().setPath(path);
	}
	
	public AbstractFactoryGameObject getFactoryGameObject() {
		return factoryGameObject;
	}

	public void setFactoryGameObject(AbstractFactoryGameObject factoryGameObject) {
		this.factoryGameObject = factoryGameObject;
	}
	
	public void addAsteroid(MainGameObject obj){
		asteroids.add(obj);
	}

	public void removeAsteroid(MainGameObject obj){
		asteroids.remove(obj);
	}
	
	public void addChaseEnemy(MainGameObject obj){
		chaseEnemies.add(obj);
	}
	
	public void removeChaseEnemy(MainGameObject obj){
		chaseEnemies.remove(obj);
	}
	
	public void addFireEnemy(MainGameObject obj){
		fireEnemies.add(obj);
	}
	
	public void removeFireEnemy(MainGameObject obj){
		fireEnemies.remove(obj);
	}
	
	public void addPickablePerk(PickableGameObject obj){
		pickables.add(obj);
	}

	public void removePickablePerk(PickableGameObject obj){
		pickables.remove(obj);
	}
	
	public void updateState(int dt){
		ship.updatePhysics(dt, this);
		asteroids.forEach(a -> a.updatePhysics(dt, this));
	}

	public Optional<BoundaryCollision> checkCollisionWithBoundaries(P2d pos, RectBoundingBox box){
		P2d ul = mainBBox.getULCorner();
		P2d br = mainBBox.getBRCorner();
		//System.out.println("Main Box UL " + mainBBox.getULCorner());
		//System.out.println("Ship Box UL " + box.getULCorner());
		//System.out.println("Position " + pos.toString());
		//System.out.println("Transform " + ship.getTransform());
		
		double heightRect = box.getHeight();
		if (pos.y < -br.y){
			return Optional.of(new BoundaryCollision(BoundaryCollision.CollisionEdge.TOP, new P2d(pos.x, ul.y)));
		} 
		//else if (pos.y - r < br.y){
//			return Optional.of(new BoundaryCollision(BoundaryCollision.CollisionEdge.BOTTOM, new P2d(pos.x, br.y)));
//		} else if (pos.x + r > br.x){
//			return Optional.of(new BoundaryCollision(BoundaryCollision.CollisionEdge.RIGHT, new P2d(br.x, pos.y)));
//		} else if (pos.x - r < ul.x){
//			return Optional.of(new BoundaryCollision(BoundaryCollision.CollisionEdge.LEFT, new P2d(ul.x, pos.y)));
//		} else {
			return Optional.empty();
//		}
	}

	public Optional<MainGameObject> checkCollisionWithAsteroids(P2d pos, RectBoundingBox box){
		double radius = box.getWidth();
		for (MainGameObject obj: asteroids){
			if (obj.getBoundingBox().isCollidingWith(pos, radius)){
				return Optional.of(obj);
			}
		}
		return Optional.empty();
	}
	
	public Optional<MainGameObject> checkCollisionWithChaseEnemies(P2d pos, RectBoundingBox box){
		double radius = box.getWidth();
		for (MainGameObject obj: chaseEnemies){
			if (obj.getBoundingBox().isCollidingWith(pos, radius)){
				return Optional.of(obj);
			}
		}
		return Optional.empty();
	}
	
	public Optional<MainGameObject> checkCollisionWithFireEnemies(P2d pos, RectBoundingBox box){
		double radius = box.getWidth();
		for (MainGameObject obj: fireEnemies){
			if (obj.getBoundingBox().isCollidingWith(pos, radius)){
				return Optional.of(obj);
			}
		}
		return Optional.empty();
	}
	
	public Optional<MainGameObject> checkCollisionWithBoss(P2d pos, RectBoundingBox box){
		if (boss.isPresent()) {
			double radius = box.getWidth();
			if (this.getBoss().get().getBoundingBox().isCollidingWith(pos, radius)){
				return this.getBoss();
			}
		}
		return Optional.empty();
	}
	
	public Optional<PickableGameObject> checkCollisionWithPickables(P2d pos, RectBoundingBox box){
		double radius = box.getWidth();
		for (PickableGameObject obj: pickables){
			if (obj.getBoundingBox().isCollidingWith(pos, radius)){
				return Optional.of(obj);
			}
		}
		return Optional.empty();
	}
	
	public void notifyWorldEvent(WorldEvent ev){
		evListener.notifyEvent(ev);
	}
	
	public RectBoundingBox getMainBBox(){
		return mainBBox;
	}
	
	public Set<MainGameObject> getAsteroids(){
		return this.asteroids;
	}
	
	public Set<MainGameObject> getAllEnemies(){
		HashSet<MainGameObject> allEnemies = new HashSet<>();
		allEnemies.addAll(chaseEnemies);
		allEnemies.addAll(fireEnemies);
		return allEnemies;
	}
	
	public Set<MainGameObject> getFireEnemies(){
		return this.fireEnemies;
	}
	
	public Set<MainGameObject> getChaseEnemies(){
		return this.chaseEnemies;
	}
	
	public Optional<MainGameObject> getBoss() {
		return boss;
	}

	public void setBoss(Optional<MainGameObject> boss) {
		this.boss = boss;
	}
	
	public Set<PickableGameObject> getPickablePerks(){
		return this.pickables;
	}

	public List<GameObject> getSceneEntities(){
		List<GameObject> entities = new ArrayList<GameObject>();
		entities.addAll(asteroids);
		entities.addAll(getAllEnemies());
		if (boss.isPresent()) {
			entities.add(boss.get());
		}
		entities.add(ship);
		return entities;
	}
	
}
