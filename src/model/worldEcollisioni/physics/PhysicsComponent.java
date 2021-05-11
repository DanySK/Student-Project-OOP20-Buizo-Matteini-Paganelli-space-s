package model.worldEcollisioni.physics;

import model.common.*;
import model.gameObject.AbstractGameObject;
import model.world.World;

public abstract class PhysicsComponent {

	public void update(int dt, AbstractGameObject obj, World w){
		P2d pos = obj.getPosition();
		V2d vel = obj.getVelocity();
		obj.setPosition(pos.sum(vel.mul(0.001*dt)));
	}
}
