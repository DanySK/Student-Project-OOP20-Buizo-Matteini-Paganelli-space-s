package spaceSurvival.model.worldEcollisioni.physics.components;

import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.gameObject.enemy.Boss;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitBorderEvent;
import spaceSurvival.model.worldEcollisioni.physics.BoundaryCollision;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;

import java.util.Optional;

import spaceSurvival.model.World;

public class BossPhysicsComponent implements PhysicsComponent {

	@Override
	public void update(int dt, GameObject abstractObj, World w) {
	    final Boss boss = (Boss) abstractObj;
        final RectBoundingBox boundingBox = w.getMainBBox();
        
        final Optional<BoundaryCollision> borderInfo = w.checkCollisionWithBoundaries(boss.getPosition(), boundingBox);
        if (borderInfo.isPresent()) {
            BoundaryCollision info = borderInfo.get();
            w.notifyWorldEvent(new HitBorderEvent(info.getWhere(), info.getEdge(), boss));
        }
	}

}
