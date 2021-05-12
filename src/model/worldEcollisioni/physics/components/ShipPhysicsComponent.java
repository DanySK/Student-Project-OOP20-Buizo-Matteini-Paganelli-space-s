package model.worldEcollisioni.physics.components;

import java.util.Optional;

import model.gameObject.AbstractGameObject;
import model.world.World;
import model.worldEcollisioni.hitEvents.HitAsteroidEvent;
import model.worldEcollisioni.hitEvents.HitBorderEvent;
import model.worldEcollisioni.physics.BoundaryCollision;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import model.common.P2d;

public class ShipPhysicsComponent extends PhysicsComponent {

	public void update(int dt, AbstractGameObject obj, World w) {
		super.update(dt, obj, w);
		//w.checkBoundaries(obj);
		RectBoundingBox bbox = (RectBoundingBox) obj.getBBox();
		Optional<BoundaryCollision> binfo = w.checkCollisionWithBoundaries(obj.getPosition(), bbox);
		if (binfo.isPresent()){
			BoundaryCollision info = binfo.get();
			P2d pos = obj.getPosition();
			
			switch (info.getEdge()){
			case TOP: 
				obj.setPosition(new P2d(pos.x, info.getWhere().y - bbox.getWidth()));
				w.notifyWorldEvent(new HitBorderEvent(info.getWhere()));
				System.out.println("toccato il muro TOP fratellì");
				break;
			case BOTTOM: 
				obj.setPosition(new P2d(pos.x, info.getWhere().y + bbox.getWidth()));
				w.notifyWorldEvent(new HitBorderEvent(info.getWhere()));
				System.out.println("toccato il muro BOTTOM fratellì");
				break;
			case LEFT: 
				obj.setPosition(new P2d(info.getWhere().x + bbox.getWidth(), pos.y));
				w.notifyWorldEvent(new HitBorderEvent(info.getWhere()));
				System.out.println("toccato il muro LEFT fratellì");
				break;
			case RIGHT: 
				obj.setPosition(new P2d(info.getWhere().x - bbox.getWidth(), pos.y));
				w.notifyWorldEvent(new HitBorderEvent(info.getWhere()));
				System.out.println("toccato il muro RIGHT fratellì");
				break;
			}
		}
		
		Optional<AbstractGameObject> asteroid = w.checkCollisionWithAsteroids(obj.getPosition(), bbox);
		//collisioni con asteroidi
		if (asteroid.isPresent()){
			w.notifyWorldEvent(new HitAsteroidEvent(asteroid.get()));
			System.out.println("Preso l'asteroid Fratellì");
		}
		
	}

}
