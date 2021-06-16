package spacesurvival.model.collisioni.physics.component;

import java.util.Optional;

import spacesurvival.model.gameobject.GameObject;
import spacesurvival.model.gameobject.main.Asteroid;
import spacesurvival.model.World;
import spacesurvival.model.collisioni.hitevent.HitBorderEvent;
import spacesurvival.model.collisioni.physics.BoundaryCollision;
import spacesurvival.model.collisioni.physics.bounding.RectBoundingBox;

public class AsteroidPhysicsComponent implements PhysicsComponent {
	
    @Override
    public void update(final GameObject abstractObj, final World w) {
        final Asteroid asteroid = (Asteroid) abstractObj;
        final RectBoundingBox boundingBox = w.getMainBBox();

        final Optional<BoundaryCollision> borderInfo = w.checkCollisionWithBoundaries(asteroid.getPosition(), boundingBox);
        if (borderInfo.isPresent()) {
            final BoundaryCollision info = borderInfo.get();
            w.notifyWorldEvent(new HitBorderEvent(info.getWhere(), info.getEdge(), asteroid));
        }	
    }
}
