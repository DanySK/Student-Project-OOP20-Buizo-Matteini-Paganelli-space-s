package model.worldEcollisioni.physics.components;

import model.gameObject.GameObject;
import model.gameObject.enemy.FireEnemy;
import model.worldEcollisioni.hitEvents.HitBorderEvent;
import model.worldEcollisioni.physics.BoundaryCollision;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;

import java.util.Optional;

import model.World;

public class FireEnemyPhysicsComponent implements PhysicsComponent {

	@Override
	public void update(int dt, GameObject abstractObj, World w) {
	    final FireEnemy fireEnemy = (FireEnemy) abstractObj;

        final RectBoundingBox boundingBox = w.getMainBBox();
	    final Optional<BoundaryCollision> borderInfo = w.checkCollisionWithBoundaries(fireEnemy.getPosition(), boundingBox);
        if (borderInfo.isPresent()) {
            BoundaryCollision info = borderInfo.get();
            w.notifyWorldEvent(new HitBorderEvent(info.getWhere(), info.getEdge(), fireEnemy));
        }
	}

}
