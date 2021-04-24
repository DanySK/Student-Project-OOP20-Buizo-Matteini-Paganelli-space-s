package physics;

import common.P2d;
import common.V2d;
import CommandProva.model.*;

public abstract class PhysicsComponent {

	public void update(int dt, GameObject obj, World w){
		P2d pos = obj.getCurrentPos();
		V2d vel = obj.getCurrentVel();
		obj.setPos(pos.sum(vel.mul(0.001*dt)));
	}
}
