package spaceSurvival.model.gameObject;

import java.util.Optional;

import spaceSurvival.model.common.P2d;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.weapon.Weapon;
import spaceSurvival.model.movement.Movement;
import spaceSurvival.model.EngineImage;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.PhysicsComponent;

public abstract class MainGameObject extends MovableGameObject {
    private int life;
    private int impactDamage;
    private Status status;
    private Optional<Weapon> weapon;
    private int score;

    public MainGameObject(final EngineImage engineImage, final P2d position, final BoundingBox bb,
                          final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
                          final int impactDamage, final Optional<Weapon> weapon, final int score) {
        super(engineImage, position, bb, phys, velocity, movement);
        this.life = life;
        this.impactDamage = impactDamage;
        this.weapon = weapon;
        this.setStatus(Status.NORMAL);
        this.score = score;
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
        System.out.println(this.getPhys());
        System.out.println("Ahia danno ricevuto: " + damage);
        System.out.println("Vita rimasta: " + this.life);
    }
	
    public int getImpactDamage() {
        return impactDamage;
    }

    public void setImpactDamage(final int impactDamage) {
        this.impactDamage = impactDamage;
    }
	
    public Optional<Weapon> getWeapon() {
        return weapon;
    }

    public void setWeapon(final Optional<Weapon> weapon) {
        this.weapon = weapon;
    }

    public Status getStatus() {
        return this.status;
    }
	
    public void setStatus(final Status status) {
        if (!(this.status == status) || this.status != Status.NORMAL) {
            System.out.println("STATUS   " + status);
            
            this.status = status;
            super.setAnimationEffect(status.getAnimation());
            this.onStatus();
        }
    }
	
    public boolean isInvincible() {
        return this.status == Status.INVINCIBLE;
    }
	
    public void onStatus() {
        switch (this.status) {
        case INVINCIBLE:
            break;
        case ON_FIRE:
            new Thread(MainGameObject.this::onFire).start();
            break;
        case FROZEN:
            new Thread(MainGameObject.this::frozen).start();
            break;
        case PARALIZED:
            new Thread(MainGameObject.this::paralized).start();
            break;
        default:
            break;
        }
        new Thread(() -> waitStatusDuration(status.getDuration())).start();
    }

    public void waitStatusDuration(int milliseconds) {
        mySleep(milliseconds);
        this.status = Status.NORMAL;
        super.setAnimationEffect(Status.NORMAL.getAnimation());
    }
	
    public void onFire() {
        while (this.status == Status.ON_FIRE) {
            this.decreaseLife(GameObjectUtils.FIRE_DAMAGE);
            System.out.println("SONO ANDATO A FUOCO " + GameObjectUtils.FIRE_DAMAGE + " DANNO");
            mySleep(GameObjectUtils.FIRE_INTERVAL_DAMAGE);
        }
    }
	
    public void frozen() {
        final V2d initialVel = this.getVelocity();
        System.out.println("SALVO VELOCITA INIZIALE " + initialVel);
        this.setVelocity(getVelocity().mul(GameObjectUtils.FROZEN_SLOWDOWN));
        while (this.status == Status.FROZEN) {
            mySleep(20);
        }
        this.setVelocity(initialVel);
        System.out.println("RISETTO VELOCITA INIZIALE " + this.getVelocity());
    }
	
    public void paralized() {
        final V2d initialVel = this.getVelocity();
        this.setVelocity(GameObjectUtils.NO_VEL);
        while (this.status == Status.PARALIZED) {
            mySleep(20);
        }
        this.setVelocity(initialVel);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void mySleep(int milliseconds) {
        try {
            sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
    @Override
    public String toString() {
        return "MainGameObject [life=" + life + ", impactDamage=" + impactDamage + ", state=" + status 
                + ", weapon=" + weapon + ", " + super.toString() + "]";
    }

}
