package model.worldEcollisioni.physics.components;

import java.util.Optional;

import model.gameObject.*;
import model.gameObject.mainGameObject.Asteroid;
import model.World;
import model.worldEcollisioni.hitEvents.HitBorderEvent;
import model.worldEcollisioni.physics.BoundaryCollision;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;

public class AsteroidPhysicsComponent implements PhysicsComponent {
	
	public void update(int dt, GameObject abstractObj, World w) {
	    final Asteroid asteroid = (Asteroid) abstractObj;
        final RectBoundingBox boundingBox = w.getMainBBox();
        
        final Optional<BoundaryCollision> borderInfo = w.checkCollisionWithBoundaries(asteroid.getPosition(), boundingBox);
        if (borderInfo.isPresent()) {
            BoundaryCollision info = borderInfo.get();
            w.notifyWorldEvent(new HitBorderEvent(info.getWhere(), info.getEdge(), asteroid));
        }	
	}
}
