package spacesurvival.model.collision.physics.component;

import spacesurvival.model.gameobject.GameObject;
import spacesurvival.model.World;

public interface PhysicsComponent {

    /**
     * Update the physics of the object passed.
     * 
     * @param abstractObj object to which the physics will be updated
     * @param w represent the current world
     */
    void update(GameObject abstractObj, World w);
}
