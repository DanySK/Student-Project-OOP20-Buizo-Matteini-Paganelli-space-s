
package model.worldEcollisioni.physics.components;

import model.gameObject.AbstractGameObject;
import model.world.World;

public interface PhysicsComponent {

	public void update(int dt, AbstractGameObject abstractObj, World w);
}