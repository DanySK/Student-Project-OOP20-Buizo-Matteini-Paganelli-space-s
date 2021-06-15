package spaceSurvival.model.worldEcollisioni.physics.components;

import spaceSurvival.model.gameObject.GameObject;

import spaceSurvival.model.gameObject.enemy.ChaseEnemy;
import java.util.Optional;
import spaceSurvival.model.World;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitBorderEvent;
import spaceSurvival.model.worldEcollisioni.physics.BoundaryCollision;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;

public class ChaseEnemyPhysicsComponent implements PhysicsComponent {

	@Override
	public void update(final int dt, final GameObject abstractObj, final World w) {
	    final ChaseEnemy chaseEnemy = (ChaseEnemy) abstractObj;
        final RectBoundingBox boundingBox = w.getMainBBox();

        final Optional<BoundaryCollision> borderInfo = w.checkCollisionWithBoundaries(chaseEnemy.getPosition(), boundingBox);
        if (borderInfo.isPresent()) {
            final BoundaryCollision info = borderInfo.get();
            w.notifyWorldEvent(new HitBorderEvent(info.getWhere(), info.getEdge(), chaseEnemy));
        }
	}

}
