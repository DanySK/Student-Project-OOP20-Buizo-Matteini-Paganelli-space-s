
package model.worldEcollisioni.physics.components;

import model.gameObject.GameObject;
import model.world.World;

public interface PhysicsComponent {

	public void update(int dt, GameObject abstractObj, World w);
}