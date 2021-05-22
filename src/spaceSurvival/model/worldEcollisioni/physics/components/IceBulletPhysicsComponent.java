package spaceSurvival.model.worldEcollisioni.physics.components;

import spaceSurvival.model.common.P2d;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.World;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import spaceSurvival.model.gameObject.weapon.IceBullet;

public class IceBulletPhysicsComponent implements PhysicsComponent {

	@Override
	public void update(int dt, GameObject abstractObj, World w) {
		IceBullet obj = (IceBullet) abstractObj;
		P2d position = obj.getPosition();
		V2d velocity = obj.getVelocity();
		obj.setPosition(position.sum(velocity.mul(0.001 * dt)));
		
		RectBoundingBox bbox = (RectBoundingBox) obj.getBoundingBox();
		
	}

}
