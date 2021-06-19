package spacesurvival.model.gameobject.main;

import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;
import spacesurvival.model.gameobject.Status;
import spacesurvival.model.gameobject.movable.MovableObject;
import spacesurvival.model.gameobject.movable.movement.MovementLogic;
import spacesurvival.utilities.Delay;
import spacesurvival.utilities.gameobject.StatusUtils;
import spacesurvival.utilities.gameobject.VelocityUtils;
import java.util.Optional;
import spacesurvival.model.EngineImage;
import spacesurvival.model.collision.physics.bounding.BoundingBox;
import spacesurvival.model.collision.physics.component.PhysicsComponent;

public abstract class MainObject extends MovableObject {
    private int life;
    private int impactDamage;
    private Status status;
    private int score;

    public MainObject(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final PhysicsComponent phys, final V2d velocity, final double acceleration, final MovementLogic movementLogic, final int life,
            final int impactDamage, final int score, final Optional<P2d> target) {
        super(engineImage, position, bb, phys, velocity, acceleration, movementLogic, target);
        this.life = life;
        this.impactDamage = impactDamage;
        this.status = Status.NORMAL;
        this.score = score;
    }

    public boolean isAlive() {
        return this.life > 0;
    }

    public boolean isDead() {
        return !isAlive();
    }

    public int getLife() {
        return life;
    }

    public void setLife(final int life) {
        this.life = life;
    }

    public void increaseLife(final int heal) {
        this.life += heal;
    }

    public void decreaseLife(final int damage) {
        this.life -= damage;
    }

    public int getImpactDamage() {
        return impactDamage;
    }

    public void setImpactDamage(final int impactDamage) {
        this.impactDamage = impactDamage;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(final Status status) {
        if (!this.status.equals(status)) {
            System.out.println("STATUS   " + status);

            this.status = status;
            super.setAnimationEffect(status.getAnimation());
            this.onStatus();
        }
    }

    /**
     * @return true if object is invincible
     */
    public boolean isInvincible() {
        return this.status == Status.INVINCIBLE;
    }

    public void onStatus() {
        switch (this.status) {
        case INVINCIBLE:
            break;
        case ON_FIRE:
            new Thread(MainObject.this::onFire).start();
            break;
        case FROZEN:
            new Thread(MainObject.this::frozen).start();
            break;
        case PARALYZED:
            new Thread(MainObject.this::paralized).start();
            break;
        default:
            break;
        }
        new Thread(() -> waitStatusDuration(status.getDuration())).start();
    }

    public void waitStatusDuration(final int milliseconds) {
        mySleep(milliseconds);
        this.setStatus(Status.NORMAL);
    }

    public void onFire() {
        while (this.status == Status.ON_FIRE) {
            this.decreaseLife(StatusUtils.FIRE_DAMAGE);
            mySleep(Delay.FIRE_EFFECT);
        }
    }

    public void frozen() {
        final V2d initialVel = this.getVelocity();
        final double initialAcc = this.getAcceleration();
        this.setVelocity(getVelocity().mul(StatusUtils.FROZEN_SLOWDOWN));
        this.setAcceleration(getAcceleration() * StatusUtils.FROZEN_SLOWDOWN);

        while (this.status == Status.FROZEN) {
            mySleep(Delay.WAIT_IN_WHILE);
        }
        this.setVelocity(initialVel);
        this.setAcceleration(initialAcc);
    }

    public void paralized() {
        this.stopMoving();        
        while (this.status == Status.PARALYZED) {
            mySleep(Delay.WAIT_IN_WHILE);
        }
        this.startMoving();
    }

    public int getScore() {
        return score;
    }

    public void setScore(final int score) {
        this.score = score;
    }

    public void mySleep(final int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "MainGameObject [life=" + life + ", impactDamage=" + impactDamage + ", state=" + status 
                + ", " + super.toString() + "]";
    }

}
