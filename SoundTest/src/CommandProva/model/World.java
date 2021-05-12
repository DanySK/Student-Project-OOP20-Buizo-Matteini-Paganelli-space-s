package CommandProva.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import common.*;
import physics.ShipCollision;

public class World {
	
	private List<GameObject> asteroids;
	private GameObject ship;
	private RectBoundingBox mainBoundingBox;
	private WorldEventListener evListener;
	
	public World(RectBoundingBox boundingBox){
		asteroids = new ArrayList<GameObject>();
		mainBoundingBox = boundingBox;
	}

	public void setEventListener(WorldEventListener l){
		evListener = l;
	}
	
	public void setShip(GameObject ship){
		this.ship = ship;
	}
	
	public void addPickUp(GameObject obj){
		asteroids.add(obj);
	}

	public void removePickUp(GameObject obj){
		asteroids.remove(obj);
	}
	
	public void updateState(int dt){
		ship.updatePhysics(dt, this);
	}

	public Optional<ShipCollision> checkCollisionWithBoundaries(P2d pos, PerkBoundingBox box){
		P2d ul = mainBoundingBox.getULCorner();
		P2d br = mainBoundingBox.getBRCorner();
		
		double r = box.getRadius();
		
		if (pos.y + r> ul.y){
			return Optional.of(new ShipCollision(ShipCollision.CollisionEdge.TOP, new P2d(pos.x,ul.y)));
		} else if (pos.y - r < br.y){
			return Optional.of(new ShipCollision(ShipCollision.CollisionEdge.BOTTOM, new P2d(pos.x,br.y)));
		} else if (pos.x + r > br.x){
			return Optional.of(new ShipCollision(ShipCollision.CollisionEdge.RIGHT, new P2d(br.x,pos.y)));
		} else if (pos.x - r < ul.x){
			return Optional.of(new ShipCollision(ShipCollision.CollisionEdge.LEFT, new P2d(ul.x,pos.y)));
		} else {
			return Optional.empty();
		}
	}

	public Optional<GameObject> checkCollisionWithPickUpObj(P2d pos, PerkBoundingBox box){
		double radius = box.getRadius();
		for (GameObject obj: asteroids){
			if (obj.getBBox().isCollidingWith(pos,radius)){
				return Optional.of(obj);
			}
		}
		return Optional.empty();
	}
	
	public void notifyWorldEvent(WorldEvent ev){
		evListener.notifyEvent(ev);
	}
	
	public RectBoundingBox getBBox(){
		return mainBoundingBox;
	}
	
	public GameObject getShip(){
		return ship;
	}

	public List<GameObject> getPickablePerk(){
		return asteroids;
	}

	public List<GameObject> getSceneEntities(){
		List<GameObject> entities = new ArrayList<GameObject>();
		entities.addAll(asteroids);
		entities.add(ship);
		return entities;
	}
	
}
