package spacesurvival.model.collision.physics.component;

import spacesurvival.model.gameobject.GameObject;
import spacesurvival.model.gameobject.fireable.FireEnemy;

import java.util.Optional;
import spacesurvival.model.World;
import spacesurvival.model.collision.hitevent.HitBorderEvent;
import spacesurvival.model.collision.physics.BoundaryCollision;
import spacesurvival.model.collision.physics.bounding.RectBoundingBox;

public class FireEnemyPhysicsComponent implements PhysicsComponent {

    /**
     * Update the physics of the fire enemy.
     * 
     * @param abstractObj the fire enemy
     * @param w represent the current world
     */
    public void update(final GameObject abstractObj, final World w) {
        final FireEnemy fireEnemy = (FireEnemy) abstractObj;
        final RectBoundingBox boundingBox = w.getMainBBox();
        final Optional<BoundaryCollision> borderInfo = w.checkCollisionWithBoundaries(fireEnemy.getPosition(), boundingBox);
        if (borderInfo.isPresent()) {
            final BoundaryCollision info = borderInfo.get();
            w.notifyWorldEvent(new HitBorderEvent(info.getWhere(), info.getEdge(), fireEnemy));
        }
    }

}
