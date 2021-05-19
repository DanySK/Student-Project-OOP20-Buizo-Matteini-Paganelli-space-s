package spaceSurvival.model.gameObject.weapon;

import spaceSurvival.model.gameObject.GameObjectUtils;

public class Weapon {
	
	private Bullet bulletType;
	private Magazine magazine;
	private int munitions;
	private int damage;
	
	public Weapon() {
		this.bulletType = new Bullet();
		this.magazine =  Magazine.UNLIMITED;
		this.munitions = GameObjectUtils.INFINITY;
	}
	
	public Weapon(final AmmoType ammoType, final int damage) {
		this.bulletType = new Bullet();
		
		switch (ammoType) {
		case NORMAL:
			this.magazine =  Magazine.UNLIMITED;
			this.munitions = GameObjectUtils.INFINITY;
			break;
		case FIRE:
		case ICE: 
		case ELECTRIC:
			this.magazine =  Magazine.LIMITED;
			this.munitions = GameObjectUtils.SPECIAL_MUNITIONS;
			break;
		default:
			break;
		}
		
	}
	
	public void shot() {
		
	}
	
	public Bullet getBulletType() {
		return bulletType;
	}

	public void setBulletType(Bullet bulletType) {
		this.bulletType = bulletType;
	}

	public Magazine getMagazine() {
		return magazine;
	}

	public void setMagazine(Magazine magazine) {
		this.magazine = magazine;
	}

	public int getMunitions() {
		return munitions;
	}

	public void setMunitions(int munitions) {
		this.munitions = munitions;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}



}