package spacesurvival.model.worldEcollisioni.physics.components;

import spacesurvival.model.gameobject.GameObject;
import spacesurvival.model.gameobject.enemy.FireEnemy;
import spacesurvival.model.worldEcollisioni.hitEvents.HitBorderEvent;
import spacesurvival.model.worldEcollisioni.physics.BoundaryCollision;
import spacesurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import java.util.Optional;
import spacesurvival.model.World;

public class FireEnemyPhysicsComponent implements PhysicsComponent {

    @Override
    public void update(final int dt, final GameObject abstractObj, final World w) {
        final FireEnemy fireEnemy = (FireEnemy) abstractObj;
        final RectBoundingBox boundingBox = w.getMainBBox();
        final Optional<BoundaryCollision> borderInfo = w.checkCollisionWithBoundaries(fireEnemy.getPosition(), boundingBox);
        if (borderInfo.isPresent()) {
            final BoundaryCollision info = borderInfo.get();
            w.notifyWorldEvent(new HitBorderEvent(info.getWhere(), info.getEdge(), fireEnemy));
        }
    }

}
