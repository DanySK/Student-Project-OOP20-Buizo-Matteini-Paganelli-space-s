package spacesurvival.model.gameobject.movable;

import spacesurvival.controller.CallerCommand;
import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;
import spacesurvival.model.gameobject.GameObject;
import spacesurvival.model.gameobject.movable.movement.Movement;
import spacesurvival.model.EngineImage;
import spacesurvival.model.collision.physics.bounding.BoundingBox;
import spacesurvival.model.collision.physics.component.PhysicsComponent;


public abstract class MovableObject extends GameObject {
    private V2d velocity;
    private Movement movement;
    private CallerCommand caller;

    public MovableObject() {
        super(new EngineImage(), new P2d(), null, null);
        this.velocity = new V2d();
        this.movement = null;
    }

    public MovableObject(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final PhysicsComponent phys, final V2d velocity, final Movement movement) {
        super(engineImage, position, bb, phys);
        this.velocity = velocity;
        this.movement = movement;
    }

    public void move() {
        this.movement.move(this);
    }

    public V2d getVelocity() {
        return velocity;
    }

    public void setVelocity(final V2d velocity) {
        this.velocity = velocity;
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(final Movement movement) {
        this.movement = movement;
    }

    public CallerCommand getCaller() {
        return caller;
    }

    public void setCaller(final CallerCommand caller) {
        this.caller = caller;
    }

    @Override
    public String toString() {
        return "MovableGameObject [velocity=" + velocity + ", movement=" + movement + ", "
                + "transform=" + super.getTransform() + ", " + super.toString() +  "]";
    }
}
