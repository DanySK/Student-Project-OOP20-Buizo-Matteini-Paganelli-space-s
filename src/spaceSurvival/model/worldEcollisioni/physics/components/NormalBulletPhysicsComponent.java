package spaceSurvival.model.worldEcollisioni.physics.components;

import spaceSurvival.model.gameObject.GameObject;

import java.util.Optional;

import spaceSurvival.model.World;
import spaceSurvival.model.worldEcollisioni.hitEvents.HitBorderEvent;
import spaceSurvival.model.worldEcollisioni.physics.BoundaryCollision;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import spaceSurvival.model.gameObject.weapon.NormalBullet;

public class NormalBulletPhysicsComponent implements PhysicsComponent {

	@Override
	public void update(int dt, GameObject abstractObj, World w) {
		NormalBullet normalBullet = (NormalBullet) abstractObj;
		RectBoundingBox boundingBox = w.getMainBBox();

		Optional<BoundaryCollision> borderInfo = w.checkCollisionWithBoundaries(normalBullet.getPosition(), boundingBox);

		if (borderInfo.isPresent()) {
			w.notifyWorldEvent(new HitBorderEvent(borderInfo.get().getWhere(), normalBullet));
		}
	}

}
