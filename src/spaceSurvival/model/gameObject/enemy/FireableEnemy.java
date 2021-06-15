package spaceSurvival.model.gameObject.enemy;

import java.util.Optional;

import spaceSurvival.model.EngineImage;
import spaceSurvival.model.common.P2d;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.weapon.Weapon;
import spaceSurvival.model.movement.Movement;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.PhysicsComponent;

public abstract class FireableEnemy extends Enemy {

    public FireableEnemy(EngineImage engineImage, P2d position, BoundingBox bb, PhysicsComponent phys, V2d velocity,
            Movement movement, int life, int impactDamage, Optional<Weapon> weapon, int score, P2d target) {
        super(engineImage, position, bb, phys, velocity, movement, life, impactDamage, weapon, score, target);
    }
}
