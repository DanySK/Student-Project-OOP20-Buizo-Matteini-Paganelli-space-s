package spaceSurvival.model;

import java.awt.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;


import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.MovableGameObject;
import spaceSurvival.model.gameObject.PickableGameObject;
import spaceSurvival.model.gameObject.factories.AbstractFactoryGameObject;
import spaceSurvival.model.gameObject.factories.ConcreteFactoryGameObject;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spaceSurvival.model.gameObject.weapon.AmmoType;
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
	
	private final Set<PickableGameObject> pickables = new HashSet<>();

	private SpaceShipSingleton ship;
	private RectBoundingBox mainBBox;
	private WorldEventListener evListener;
	
	public World(final RectBoundingBox mainBBox) {
		this.ship = SpaceShipSingleton.getSpaceShip();
		this.ship.setWeapon(Optional.of(new Weapon(AmmoType.NORMAL, ship)));
		
		System.out.println(this.ship.getWeapon());
		System.out.println(this.ship.getWeapon().get());
		
		this.mainBBox = mainBBox;

		for (int i = 0; i < 3; i++) {
			asteroids.add(factoryGameObject.createAsteroid());
			chaseEnemies.add(factoryGameObject.createChaseEnemy());
			pickables.add(factoryGameObject.createPickable());
		}
	}

	public World(final Rectangle rectangle) {
		this.ship = SpaceShipSingleton.getSpaceShip();
		this.ship.setWeapon(Optional.of(new Weapon(AmmoType.NORMAL, ship)));
		
		System.out.println("BELLA RAGAAAAA");
		System.out.println(this.ship.getWeapon());
		System.out.println(this.ship.getWeapon().get());
		
		this.mainBBox = new RectBoundingBox(rectangle);

		for (int i = 0; i < 1; i++) {
			asteroids.add(factoryGameObject.createAsteroid());
			chaseEnemies.add(factoryGameObject.createChaseEnemy());
			pickables.add(factoryGameObject.createPickable());
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

	public void setSkin(final String path) {
		this.ship.getEngineImage().setPath(path);

		if(path.contentEquals(SkinShip.SPECIAL0)){
			this.ship.setAnimation(SkinShip.LIST_SHIP1);
		}else if(path.contentEquals(SkinShip.STANDARD0)){
			this.ship.setAnimation(SkinShip.LIST_SHIP2);
		}else if(path.contentEquals(SkinShip.DELUXE0)) {
			this.ship.setAnimation(SkinShip.LIST_SHIP3);
		}else if(path.contentEquals(SkinShip.NORMAL0)) {
			this.ship.setAnimation(SkinShip.LIST_SHIP4);
		}else if(path.contentEquals(SkinShip.ATOMIC0)){
			this.ship.setAnimation(SkinShip.LIST_SHIP5);
		}

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
		pickables.add(factoryGameObject.createPickable());
	}

	public void removePickable(final PickableGameObject obj) {
		pickables.remove(obj);
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
		while (fireEnemiesIterator.hasNext() || found != true) {
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

	/** Rectangle To Circle. */
//	boolean testRectangleToCircle(double rectWidth, double rectHeight, double rectRotation, double rectCenterX, double rectCenterY, double circleCenterX, double circleCenterY, double circleRadius) {
//	    double tx, ty, cx, cy;
//
//	    if(rectRotation == 0) { // Higher Efficiency for Rectangles with 0 rotation.
//	        tx = circleCenterX;
//	        ty = circleCenterY;
//
//	        cx = rectCenterX;
//	        cy = rectCenterY;
//	    } else {
//	        tx = Math.cos(rectRotation)*circleCenterX - Math.sin(rectRotation)*circleCenterY;
//	        ty = Math.cos(rectRotation)*circleCenterY + Math.sin(rectRotation)*circleCenterX;
//
//	        cx = Math.cos(rectRotation)*rectCenterX - Math.sin(rectRotation)*rectCenterY;
//	        cy = Math.cos(rectRotation)*rectCenterY + Math.sin(rectRotation)*rectCenterX;
//	    }
//
//	    return testRectangleToPoint(rectWidth, rectHeight, rectRotation, rectCenterX, rectCenterY, circleCenterX, circleCenterY) ||
//	            testCircleToSegment(tx, ty, circleRadius, cx-rectWidth/2, cy+rectHeight/2, cx+rectWidth/2, cy+rectHeight/2) ||
//	            testCircleToSegment(tx, ty, circleRadius, cx+rectWidth/2, cy+rectHeight/2, cx+rectWidth/2, cy-rectHeight/2) ||
//	            testCircleToSegment(tx, ty, circleRadius, cx+rectWidth/2, cy-rectHeight/2, cx-rectWidth/2, cy-rectHeight/2) ||
//	            testCircleToSegment(tx, ty, circleRadius, cx-rectWidth/2, cy-rectHeight/2, cx-rectWidth/2, cy+rectHeight/2);
//	}
	CollisionChecker checker = new CollisionChecker();
	
	public Optional<MainGameObject> checkCollisionWithAsteroids(final RectBoundingBox shipBoundingBox) {
		//double radius = box.getWidth();
		//System.out.println("Questa è la width della ship" + radius);
		for (MainGameObject obj: asteroids) {
			System.out.println(obj.getBoundingBox());
			if (checker.testRectangleToCircle(shipBoundingBox, (CircleBoundingBox) obj.getBoundingBox())) {
				
			    System.out.println("MANDATO UN EVENTO");
				return Optional.of(obj);
			}
			
//			if (obj.getBoundingBox().isCollidingWith(pos, radius)) {
//				return Optional.of(obj);
//			}
		}
		return Optional.empty();
	}
	
	
//	public Optional<MainGameObject> checkCollisionWithChaseEnemies(final RectBoundingBox box) {
//	//double radius = box.getWidth();
//	for (MainGameObject obj: chaseEnemies) {
//		if(checker) {
//			return Optional.of(obj);
//		}
//	}
//	return Optional.empty();
//}
	
	
//	public Optional<MainGameObject> checkCollisionWithAsteroids(final P2d pos, final RectBoundingBox box) {
//		double radius = box.getWidth();
//		//System.out.println("Questa è la width della ship" + radius);
//		for (MainGameObject obj: asteroids) {
//			if (obj.getBoundingBox().isCollidingWith(pos, radius)) {
//				return Optional.of(obj);
//			}
//		}
//		return Optional.empty();
//	}
	
//	public Optional<MainGameObject> checkCollisionWithChaseEnemies(final P2d pos, final RectBoundingBox box) {
//		double radius = box.getWidth();
//		for (MainGameObject obj: chaseEnemies) {
//			if (obj.getBoundingBox().isCollidingWith(pos, radius)) {
//				return Optional.of(obj);
//			}
//		}
//		return Optional.empty();
//	}
//	
//	public Optional<MainGameObject> checkCollisionWithFireEnemies(final P2d pos, final RectBoundingBox box) {
//		double radius = box.getWidth();
//		for (MainGameObject obj: fireEnemies) {
//			if (obj.getBoundingBox().isCollidingWith(pos, radius)) {
//				return Optional.of(obj);
//			}
//		}
//		return Optional.empty();
//	}
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
//	public Optional<PickableGameObject> checkCollisionWithPickables(final P2d pos, final RectBoundingBox box) {
//		double radius = box.getWidth();
//		for (PickableGameObject obj: pickables) {
//			if (obj.getBoundingBox().isCollidingWith(pos, radius)) {
//				return Optional.of(obj);
//			}
//		}
//		return Optional.empty();
//	}
	
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
	
	public Set<PickableGameObject> getPickables() {
		return this.pickables;
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
		entities.addAll(pickables);
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
