package model.worldEcollisioni.physics.components;

import java.util.Optional;

import model.gameObject.*;
import model.world.World;
import model.worldEcollisioni.hitEvents.HitAsteroidEvent;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;

public class AsteroidObjPhysicsComponent extends PhysicsComponent {
	
	public void update(int dt, AbstractGameObject obj, World w) {
		super.update(dt, obj, w);
		//w.checkBoundaries(obj);
		RectBoundingBox bbox = (RectBoundingBox) obj.getBoundingBox();
		
		Optional<AbstractGameObject> asteroid = w.checkCollisionWithAsteroids(obj.getPosition(), bbox);
		//collisioni con asteroidi
		if (asteroid.isPresent()){
			w.notifyWorldEvent(new HitAsteroidEvent(asteroid.get()));
			System.out.println("Preso il asteroid Fratellì");
		}
		
	}

}
