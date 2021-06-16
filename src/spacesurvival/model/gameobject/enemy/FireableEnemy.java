package spacesurvival.model.gameobject.enemy;

import java.util.Optional;

import spacesurvival.model.EngineImage;
import spacesurvival.model.collisioni.physics.bounding.BoundingBox;
import spacesurvival.model.collisioni.physics.component.PhysicsComponent;
import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;
import spacesurvival.model.gameobject.weapon.Weapon;
import spacesurvival.model.gameobject.weapon.shootinglogic.ShootingLogic;
import spacesurvival.model.movement.Movement;

public abstract class FireableEnemy extends FireableObject {

    FireableEnemy(EngineImage engineImage, P2d position, BoundingBox bb, PhysicsComponent phys, V2d velocity,
                  Movement movement, int life, int impactDamage, int score, Optional<P2d> target, Weapon weapon, ShootingLogic shootingLogic) {
        super(engineImage, position, bb, phys, velocity, movement, life, impactDamage, score, target, weapon, shootingLogic);
    }
}
