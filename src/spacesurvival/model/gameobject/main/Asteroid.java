package spacesurvival.model.gameobject.main;

import java.awt.geom.AffineTransform;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;
import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.movement.Movement;

import spacesurvival.model.gameobject.weapon.Weapon;
import spacesurvival.model.EngineImage;
import spacesurvival.model.collisioni.physics.bounding.BoundingBox;
import spacesurvival.model.collisioni.physics.component.PhysicsComponent;

public class Asteroid extends MainGameObject {
	

    public Asteroid(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
            final int impactDamage, final int score, final Optional<P2d> target) {
        super(engineImage, position, bb, phys, velocity, movement, life, impactDamage, score, target);
        this.setBoundingBox(GameObjectUtils.createCircleBoundingBox(position, engineImage, this.getTransform()));
    	initializeRotation();
    }

    public Asteroid(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
            final int impactDamage, final int score, final Optional<P2d> target, final List<String> animation) {
        super(engineImage, position, bb, phys, velocity, movement, life, impactDamage, score, target);
        this.setBoundingBox(GameObjectUtils.createCircleBoundingBox(position, engineImage, this.getTransform()));
        this.setAnimation(animation);
        initializeRotation();
    }

    /**
     * Initialize a random rotation for the ateroid.
     */
    private void initializeRotation() {
        final Random random = new Random();
        final int randomAngle = random.nextInt(360);
        AffineTransform at = getTransform();
        at.rotate(Math.toRadians(randomAngle), getSize().getWidth() / 2, getSize().getHeight() / 2);
        setTransform(at);
    }

    @Override
    public String toString() {
        return "Asteroid { " + super.toString() + " }";
    }

}
