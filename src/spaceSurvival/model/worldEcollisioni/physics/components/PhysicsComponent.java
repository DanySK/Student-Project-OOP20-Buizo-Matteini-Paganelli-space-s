package spaceSurvival.model.worldEcollisioni.physics.components;

import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.World;

public interface PhysicsComponent {

    void update(int dt, GameObject abstractObj, World w);
}