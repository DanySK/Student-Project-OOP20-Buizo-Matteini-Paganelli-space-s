package spacesurvival.model.collision.physics.component;

import spacesurvival.model.gameobject.GameObject;
import spacesurvival.model.gameobject.fireable.Boss;

import java.util.Optional;

import spacesurvival.model.World;
import spacesurvival.model.collision.event.hit.HitBorderEvent;
import spacesurvival.model.collision.physics.BoundaryCollision;
import spacesurvival.model.collision.physics.bounding.RectBoundingBox;

public class BossPhysic implements PhysicsComponent {

    /**
     * Update the physics of the boss.
     * 
     * @param abstractObj the boss
     * @param w represent the current world
     */
    @Override
    public void update(final  GameObject abstractObj, final World w) {
        final Boss boss = (Boss) abstractObj;
        final RectBoundingBox boundingBox = w.getMainBBox();

        final Optional<BoundaryCollision> borderInfo = w.checkCollisionWithBoundaries(boss.getPosition(), boundingBox);
        if (borderInfo.isPresent()) {
            final BoundaryCollision info = borderInfo.get();
            w.notifyWorldEvent(new HitBorderEvent(info.getWhere(), info.getEdge(), boss));
        }
    }

}
