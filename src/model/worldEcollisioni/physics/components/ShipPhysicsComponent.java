package model.worldEcollisioni.physics.components;

import java.util.Optional;

import model.gameObject.AbstractGameObject;
import model.gameObject.spaceShip.SpaceShipSingleton;
import model.world.World;
import model.worldEcollisioni.hitEvents.HitAsteroidEvent;
import model.worldEcollisioni.hitEvents.HitBorderEvent;
import model.worldEcollisioni.physics.BoundaryCollision;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import model.common.P2d;
import model.common.V2d;

public class ShipPhysicsComponent implements PhysicsComponent {
	
	@Override
	public void update(int dt, AbstractGameObject abstractObj, World w) {
		SpaceShipSingleton ship = (SpaceShipSingleton) abstractObj;
		
		P2d position = ship.getPosition();
		V2d velocity = ship.getVelocity();
	
		//System.out.println("Velocità: " + velocity);
		
		//w.checkBoundaries(ship);
		
		RectBoundingBox boundingBox = (RectBoundingBox) ship.getBoundingBox();
		//System.out.println("Altezza Bounding Box:" + boundingBox.getHeight() + "Larghezza Bounding Box:" + boundingBox.getWidth() + 
				//"UL:" + boundingBox.getULCorner() + "BR:" + boundingBox.getBRCorner());
		Optional<BoundaryCollision> binfo = w.checkCollisionWithBoundaries(ship.getPosition(), boundingBox);
		
		//ship.setPosition(position.sum(velocity.mul(0.001 * dt)));		
//		//super.update(dt, obj, w);
//		
//		//w.checkBoundaries(obj);
//		RectBoundingBox bbox = (RectBoundingBox) obj.getBoundingBox();
		//Optional<BoundaryCollision> binfo = w.checkCollisionWithBoundaries(ship.getPosition(), boundingBox);
		if (binfo.isPresent()){
			BoundaryCollision info = binfo.get();
			P2d pos = ship.getPosition();
			
			switch (info.getEdge()){
			case TOP: 
				//ship.setPosition(new P2d(60, 60));
				ship.setVelocity(new V2d(ship.getVelocity().getX(), -ship.getVelocity().getY()));
				ship.getTransform().translate(ship.getVelocity().getX(), ship.getVelocity().getY());
				ship.setPosition(ship.getPosition().sum(ship.getVelocity()));
			
				//ship.getTransform()
				w.notifyWorldEvent(new HitBorderEvent(info.getWhere()));
				System.out.println("toccato il muro TOP fratellì");
				break;
			case BOTTOM: 
				ship.setPosition(new P2d(pos.x, info.getWhere().y + boundingBox.getWidth()));
				w.notifyWorldEvent(new HitBorderEvent(info.getWhere()));
				System.out.println("toccato il muro BOTTOM fratellì");
				break;
			case LEFT: 
				ship.setPosition(new P2d(info.getWhere().x + boundingBox.getWidth(), pos.y));
				w.notifyWorldEvent(new HitBorderEvent(info.getWhere()));
				System.out.println("toccato il muro LEFT fratellì");
				break;
			case RIGHT: 
				ship.setPosition(new P2d(info.getWhere().x - boundingBox.getWidth(), pos.y));
				w.notifyWorldEvent(new HitBorderEvent(info.getWhere()));
				System.out.println("toccato il muro RIGHT fratellì");
				break;
			}
		}
		
		Optional<AbstractGameObject> asteroid = w.checkCollisionWithAsteroids(ship.getPosition(), boundingBox);
		//collisioni con asteroidi
		if (asteroid.isPresent()){
			w.notifyWorldEvent(new HitAsteroidEvent(asteroid.get()));
			System.out.println("Preso l'asteroid Fratellì");
		}
		
	}

}