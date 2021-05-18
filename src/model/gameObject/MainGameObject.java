package model.gameObject;

import java.util.Optional;

import model.common.P2d;
import model.common.V2d;
import model.gameObject.weapon.Weapon;
import model.image.EngineImage;
import model.worldEcollisioni.physics.boundingType.BoundingBox;
import model.worldEcollisioni.physics.components.PhysicsComponent;

public abstract class MainGameObject extends MovableGameObject {
	private int life;
	private int impactDamage;
	
	private Optional<Weapon> weapon;
	
	public MainGameObject(final EngineImage engineImage, final P2d position, final BoundingBox bb,
			final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
			final int impactDamage, final Optional<Weapon> weapon) {
		super(engineImage, position, bb, phys, velocity, movement);
		this.life = life;
		this.setImpactDamage(impactDamage);
		this.weapon = weapon;
	}

    public int getLife() {
		return life;
	}

    public void increaseLife(int heal) {
		this.life += heal;
	}
    
	public void decreaseLife(int damage) {
		this.life -= damage;
		System.out.println("Ahia danno" + this.life);
		if (this.life <= 0) {
			this.life = 0;
		}
	}
	
	public int getImpactDamage() {
		return impactDamage;
	}

	public void setImpactDamage(int impactDamage) {
		this.impactDamage = impactDamage;
	}
	

	public Optional<Weapon> getWeapon() {
		return weapon;
	}

	public void setWeapon(Optional<Weapon> weapon) {
		this.weapon = weapon;
	}

	@Override
	public String toString() {
		return "MainGameObject [life=" + life + ", impactDamage=" + impactDamage + ", "
				+ "weapon=" + weapon + ", " + super.toString() + "]";
	}

//	@Override
//	public String toString() {
//		return "MainGameObject [life=" + life + ", weapon=" + weapon + "]";
//	}

}
