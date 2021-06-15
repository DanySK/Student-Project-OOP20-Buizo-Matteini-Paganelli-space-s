package spaceSurvival.model.gameObject.enemy;

import spaceSurvival.model.EngineImage;
import spaceSurvival.model.common.P2d;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.movement.Movement;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.PhysicsComponent;

public class Enemy {

    private P2d target;

    public Enemy(final EngineImage engineImage, final P2d position, final BoundingBox bb, final PhysicsComponent phys,
            final V2d velocity, final Movement movement, final int life, final int impactDamage, final int score,
            final P2d target) {
     //   super(engineImage, position, bb, phys, velocity, movement, life, impactDamage, score);
        this.target = target;
    }

    /**
     * Return the target position of Enemy.
     *
     * @return the target position of Enemy
     */
    public P2d getTarget() {
        return this.target;
    }

    /**
     * Sets the target position of Enemy.
     *
     * @param target the new target position
     */
    public void setTarget(final P2d target) {
        this.target = target;
    }

}
