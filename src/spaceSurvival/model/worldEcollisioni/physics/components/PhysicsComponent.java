
package spaceSurvival.model.worldEcollisioni.physics.components;

import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.world.World;

public interface PhysicsComponent {

	public void update(int dt, GameObject abstractObj, World w);
}