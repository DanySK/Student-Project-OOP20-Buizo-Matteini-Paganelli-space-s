package spacesurvival.model.gameObject.weapon;

import spacesurvival.model.worldEcollisioni.physics.components.BulletPhysicsComponent;
import spacesurvival.utilities.dimension.ScaleOf;
import spacesurvival.utilities.dimension.Screen;
import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;
import spacesurvival.model.gameObject.GameObjectUtils;
import spacesurvival.model.gameObject.MainGameObject;
import spacesurvival.model.gameObject.takeableGameObject.AmmoType;

import java.util.HashSet;
import java.util.Set;

import spacesurvival.model.EngineImage;
import spacesurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;

public class Weapon {
	
	private MainGameObject owner;
	private AmmoType ammoType;
	private Magazine magazine;
	private int munitions;
	private int multiplierDamage;
	
	private Set<Bullet> shootedBullets;
	
	public Weapon() {
		this.ammoType = AmmoType.NORMAL;
		this.magazine =  Magazine.UNLIMITED;
		this.munitions = GameObjectUtils.INFINITY;
		this.multiplierDamage = 1;
		this.shootedBullets = new HashSet<>();
	}
	
	public Weapon(final AmmoType ammoType, final MainGameObject owner) {
		this.owner = owner;
		this.ammoType = ammoType;
		
		switch (ammoType) {
		case NORMAL:
			this.magazine =  Magazine.UNLIMITED;
			this.munitions = GameObjectUtils.INFINITY;
			break;
		case FIRE:
		case ICE: 
		case ELECTRIC:
			this.magazine =  Magazine.LIMITED;
			this.munitions = GameObjectUtils.SPECIAL_MUNITIONS_QUANTITY;
			break;
		default:
			break;
		}
		this.multiplierDamage = 1;

		this.shootedBullets = new HashSet<>();		
	}
	
	public void shoot() {
		EngineImage engineImage = new EngineImage(ScaleOf.BULLET_OBJECT, Screen.WIDTH_FULL_SCREEN, "shutBullet/vertical/ice.png");
		System.out.println("Sparo");
		System.out.println(owner);
		P2d position = new P2d(0, 0);
		V2d velocity = GameObjectUtils.BULLET_VEL;
		Bullet bullet = new Bullet(engineImage, position, new RectBoundingBox(), new BulletPhysicsComponent(),
				velocity, BulletUtils.NORMAL_BULLET_DAMAGE * multiplierDamage, ammoType.getEffect());
		
		bullet.setTransform(owner.getTransform());
		bullet.getTransform().translate(owner.getSize().getWidth() / 2 - bullet.getSize().getWidth() / 2,
				-owner.getSize().getHeight() / 2);

		if (magazine == Magazine.LIMITED) {
			munitions--;
			if (munitions == 0) {
				setAmmoType(AmmoType.NORMAL);
			}
		}
		shootedBullets.add(bullet);
		System.out.println("bullet sparati: " + shootedBullets.size());
	}
	
	public MainGameObject getOwner() {
		return owner;
	}

	public void setOwner(final MainGameObject owner) {
		this.owner = owner;
	}
	
	public AmmoType getAmmoType() {
		return ammoType;
	}

	public void setAmmoType(final AmmoType ammoType) {
		this.ammoType = ammoType;
		if (this.ammoType == AmmoType.NORMAL) {
			setMagazine(Magazine.UNLIMITED);
			setMunitions(GameObjectUtils.INFINITY);
		} else {
			setMagazine(Magazine.LIMITED);
			setMunitions(GameObjectUtils.SPECIAL_MUNITIONS_QUANTITY);
		}
	}
	
	public Magazine getMagazine() {
		return magazine;
	}

	private void setMagazine(final Magazine magazine) {
		this.magazine = magazine;
	}

	public int getMunitions() {
		return munitions;
	}

	private void setMunitions(final int munitions) {
		this.munitions = munitions;
	}

	public int getMultiplierDamage() {
		return multiplierDamage;
	}

	public void setMultiplierDamage(final int multiplierDamage) {
		this.multiplierDamage = multiplierDamage;
	}

	public Set<Bullet> getShootedBullets() {
		return shootedBullets;
	}

	public void setShootedBullets(Set<Bullet> shootedBullets) {
		this.shootedBullets = shootedBullets;
	}



}