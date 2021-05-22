package spaceSurvival.model.gameObject;

import java.util.Optional;

import spaceSurvival.model.common.P2d;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.weapon.Weapon;
import spaceSurvival.model.EngineImage;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.PhysicsComponent;

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
