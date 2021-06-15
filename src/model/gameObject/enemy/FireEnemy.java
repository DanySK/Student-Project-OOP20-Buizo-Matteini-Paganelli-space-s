package model.gameObject.enemy;

import java.util.Optional;

import model.gameObject.GameObjectUtils;
import model.movement.Movement;
import model.common.P2d;
import model.common.V2d;
import model.gameObject.weapon.Weapon;
import model.EngineImage;
import model.worldEcollisioni.physics.boundingType.BoundingBox;
import model.worldEcollisioni.physics.components.PhysicsComponent;

public class FireEnemy extends Enemy {

    public FireEnemy(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
            final int impactDamage, final Optional<Weapon> weapon, final int score, final P2d target) {

        super(engineImage, position, bb, phys, velocity, movement, life, impactDamage, weapon, score, target);
        this.setBoundingBox(GameObjectUtils.createRectBoundingBox(position, engineImage, this.getTransform()));
    }

    @Override
    public String toString() {
        return "FireEnemy { " + super.toString() + " }";
    }

}
