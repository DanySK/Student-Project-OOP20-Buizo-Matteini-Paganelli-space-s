package model.gameObject.weapon;

import model.common.P2d;
import model.common.V2d;
import model.gameObject.GameObjectUtils;
import model.gameObject.MainGameObject;
import model.gameObject.Movement;
import model.gameObject.weapon.bullet.BulletUtils;
import model.gameObject.weapon.bullet.ElectricBullet;
import model.gameObject.weapon.bullet.FireBullet;
import model.gameObject.weapon.bullet.IceBullet;
import model.gameObject.weapon.bullet.NormalBullet;
import model.image.EngineImage;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import model.worldEcollisioni.physics.components.NormalBulletPhysicsComponent;
import utilities.dimension.Screen;
import utilities.pathImage.Icon;

public class Weapon {
	
	private MainGameObject owner;
	private AmmoType ammoType;
	private Magazine magazine;
	private int munitions;
	private int multiplierDamage = 1;
	
	public Weapon() {
		this.ammoType = AmmoType.NORMAL;
		this.magazine =  Magazine.UNLIMITED;
		this.munitions = GameObjectUtils.INFINITY;
	}
	
	public Weapon(final AmmoType ammoType, final MainGameObject owner) {
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
		
	}
	
	public void shot() {
		EngineImage engineImage = new EngineImage(GameObjectUtils.SPACESHIP_SCALEOF, Screen.WIDTH_FULL_SCREEN, Icon.BULLET);
		P2d position = owner.getPosition(); //GameObjectUtils.generateSpawnPoint(engineImage.getSize());
		V2d velocity = GameObjectUtils.BULLET_VEL;
		Movement movement = Movement.FIXED;
		
		switch (ammoType) {
		case NORMAL:
			new NormalBullet(engineImage, position, new RectBoundingBox(), new NormalBulletPhysicsComponent(), velocity, 
					movement, BulletUtils.NORMAL_BULLET_DAMAGE);
			break;
		case FIRE:
			new FireBullet(engineImage, position, new RectBoundingBox(), new NormalBulletPhysicsComponent(), velocity, 
					movement, BulletUtils.FIRE_BULLET_DAMAGE);
			break;
		case ICE: 
			new IceBullet(engineImage, position, new RectBoundingBox(), new NormalBulletPhysicsComponent(), velocity, 
					movement, BulletUtils.ICE_BULLET_DAMAGE);
			break;
		case ELECTRIC:
			new ElectricBullet(engineImage, position, new RectBoundingBox(), new NormalBulletPhysicsComponent(), velocity, 
					movement, BulletUtils.ELECTRIC_BULLET_DAMAGE);
			break;
		default:
			break;
		}
		
		if (magazine == Magazine.LIMITED) {
			munitions--;
		}
		
	}
	
	public MainGameObject getOwner() {
		return owner;
	}

	public void setOwner(MainGameObject owner) {
		this.owner = owner;
	}
	
	public AmmoType getAmmoType() {
		return ammoType;
	}

	public void setAmmoType(AmmoType ammoType) {
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

	private void setMagazine(Magazine magazine) {
		this.magazine = magazine;
	}

	public int getMunitions() {
		return munitions;
	}

	private void setMunitions(int munitions) {
		this.munitions = munitions;
	}

	public int getMultiplierDamage() {
		return multiplierDamage;
	}

	public void setMultiplierDamage(int multiplierDamage) {
		this.multiplierDamage = multiplierDamage;
	}



}