package spacesurvival.model.gameobject.enemy;

import java.util.Optional;

import spacesurvival.model.EngineImage;
import spacesurvival.model.collisioni.physics.bounding.BoundingBox;
import spacesurvival.model.collisioni.physics.component.PhysicsComponent;
import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;
import spacesurvival.model.gameobject.weapon.Weapon;
import spacesurvival.model.movement.Movement;

public abstract class FireableEnemy extends Enemy {

    FireableEnemy(EngineImage engineImage, P2d position, BoundingBox bb, PhysicsComponent phys, V2d velocity,
            Movement movement, int life, int impactDamage, Optional<Weapon> weapon, int score, P2d target) {
        super(engineImage, position, bb, phys, velocity, movement, life, impactDamage, weapon, score, target);
    }
}
