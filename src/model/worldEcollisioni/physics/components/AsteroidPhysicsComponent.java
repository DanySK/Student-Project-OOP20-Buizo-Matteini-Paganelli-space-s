package model.worldEcollisioni.physics.components;

import java.util.Optional;

import model.gameObject.GameObject;
import model.gameObject.mainGameObject.Asteroid;
import model.World;
import model.worldEcollisioni.hitEvents.HitBorderEvent;
import model.worldEcollisioni.physics.BoundaryCollision;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;

public class AsteroidPhysicsComponent implements PhysicsComponent {
	
    public void update(final int dt, final GameObject abstractObj, final World w) {
        final Asteroid asteroid = (Asteroid) abstractObj;
        final RectBoundingBox boundingBox = w.getMainBBox();

        final Optional<BoundaryCollision> borderInfo = w.checkCollisionWithBoundaries(asteroid.getPosition(), boundingBox);
        if (borderInfo.isPresent()) {
            final BoundaryCollision info = borderInfo.get();
            w.notifyWorldEvent(new HitBorderEvent(info.getWhere(), info.getEdge(), asteroid));
        }	
    }
}
