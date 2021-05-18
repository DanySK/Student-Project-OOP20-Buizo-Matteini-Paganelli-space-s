package model.worldEcollisioni.physics.components;

import model.common.P2d;
import model.common.V2d;
import model.gameObject.GameObject;
import model.gameObject.weapon.bullet.FireBullet;
import model.world.World;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;

public class FireBulletPhysicsComponent implements PhysicsComponent {

	@Override
	public void update(int dt, GameObject abstractObj, World w) {
		FireBullet obj = (FireBullet) abstractObj;
		P2d position = obj.getPosition();
		V2d velocity = obj.getVelocity();
		obj.setPosition(position.sum(velocity.mul(0.001 * dt)));
		
		RectBoundingBox bbox = (RectBoundingBox) obj.getBoundingBox();
		
	}

}
