package spaceSurvival.model.gameObject;

import java.util.Optional;

import spaceSurvival.model.common.P2d;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.weapon.Weapon;
import spaceSurvival.model.movement.Movement;
import spaceSurvival.model.ImageDesign;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.PhysicsComponent;

public abstract class MainGameObject extends MovableGameObject {
	private int life;
	private int impactDamage;
	private Status status;
	private Optional<Weapon> weapon;
	
	public MainGameObject(final ImageDesign imageDesign, final P2d position, final BoundingBox bb,
						  final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
						  final int impactDamage, final Optional<Weapon> weapon) {
		super(imageDesign, position, bb, phys, velocity, movement);
		this.life = life;
		this.setImpactDamage(impactDamage);
		this.status = Status.NORMAL;
		this.weapon = weapon;
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
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public boolean isInvincible() {
		return this.status == Status.INVINCIBLE;
	}

	@Override
	public String toString() {
		return "MainGameObject [life=" + life + ", impactDamage=" + impactDamage + ", state=" + status 
				+ ", weapon=" + weapon + ", " + super.toString() + "]";
	}

}
