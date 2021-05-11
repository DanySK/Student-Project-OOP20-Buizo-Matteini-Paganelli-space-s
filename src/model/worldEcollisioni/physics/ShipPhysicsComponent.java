package model.worldEcollisioni.physics;

import java.util.Optional;

import model.gameObject.AbstractGameObject;
import model.world.World;

import model.common.P2d;

public class ShipPhysicsComponent extends PhysicsComponent {

	public void update(int dt, AbstractGameObject obj, World w) {
		super.update(dt, obj, w);
		//w.checkBoundaries(obj);
		CircleBoundingBox bbox = (CircleBoundingBox) obj.getBBox();
		Optional<BoundaryCollision> binfo = w.checkCollisionWithBoundaries(obj.getPosition(), bbox);
		if (binfo.isPresent()){
			BoundaryCollision info = binfo.get();
			P2d pos = obj.getPosition();
			
			switch (info.getEdge()){
			case TOP: 
				obj.setPosition(new P2d(pos.x, info.getWhere().y - bbox.getRadius()));
				//obj.flipVelOnY();
				w.notifyWorldEvent(new HitBorderEvent(info.getWhere()));
				break;
			case BOTTOM: 
				obj.setPosition(new P2d(pos.x, info.getWhere().y + bbox.getRadius()));
				//obj.flipVelOnY();
				w.notifyWorldEvent(new HitBorderEvent(info.getWhere()));
				break;
			case LEFT: 
				obj.setPosition(new P2d(info.getWhere().x + bbox.getRadius(), pos.y));
				//obj.flipVelOnX();
				w.notifyWorldEvent(new HitBorderEvent(info.getWhere()));
				break;
			case RIGHT: 
				obj.setPosition(new P2d(info.getWhere().x - bbox.getRadius(), pos.y));
				//obj.flipVelOnX();
				w.notifyWorldEvent(new HitBorderEvent(info.getWhere()));
				break;
			}
		}
		
		Optional<AbstractGameObject> asteroid = w.checkCollisionWithAsteroids(obj.getPosition(), bbox);
		//collisioni con asteroidi
		if (asteroid.isPresent()){
			w.notifyWorldEvent(new HitAsteroidEvent(asteroid.get()));
		}
		
	}

}
