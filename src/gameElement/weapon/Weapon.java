package gameElement.weapon;

public class Weapon {
	private WeaponType type;
	
	public Weapon(WeaponType type) {
		this.type = type;
	}

	public WeaponType getType() {
		return type;
	}

	public void setType(WeaponType type) {
		this.type = type;
	}
}
