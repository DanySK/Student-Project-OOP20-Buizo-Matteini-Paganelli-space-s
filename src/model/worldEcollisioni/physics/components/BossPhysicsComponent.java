package model.worldEcollisioni.physics.components;

import model.common.P2d;
import model.common.V2d;
import model.gameObject.GameObject;
import model.gameObject.mainGameObject.Boss;
import model.world.World;

public class BossPhysicsComponent implements PhysicsComponent {

	@Override
	public void update(int dt, GameObject abstractObj, World w) {
		Boss obj = (Boss) abstractObj;
		P2d position = obj.getPosition();
		V2d velocity = obj.getVelocity();
		obj.setPosition(position.sum(velocity.mul(0.001 * dt)));
	}

}
