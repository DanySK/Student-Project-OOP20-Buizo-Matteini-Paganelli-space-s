package spaceSurvival.model.gameObject.weapon;

import spaceSurvival.model.worldEcollisioni.physics.components.NormalBulletPhysicsComponent;
import spaceSurvival.utilities.dimension.Screen;
import spaceSurvival.utilities.pathImage.Icon;
import spaceSurvival.model.common.P2d;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.GameObjectUtils;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.Movement;
import spaceSurvival.model.ImageDesign;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;

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
		ImageDesign imageDesign = new ImageDesign(GameObjectUtils.SPACESHIP_SCALEOF, Screen.WIDTH_FULL_SCREEN, Icon.BULLET);
		System.out.println("Sparo");
		P2d position = new P2d(600, 600);//owner.getPosition(); //GameObjectUtils.generateSpawnPoint(engineImage.getSize());
		V2d velocity = GameObjectUtils.BULLET_VEL;
		Movement movement = Movement.FIXED;
		
		switch (ammoType) {
		case NORMAL:
			new NormalBullet(imageDesign, position, new RectBoundingBox(), new NormalBulletPhysicsComponent(), velocity,
					movement, BulletUtils.NORMAL_BULLET_DAMAGE);
			break;
		case FIRE:
			new FireBullet(imageDesign, position, new RectBoundingBox(), new NormalBulletPhysicsComponent(), velocity,
					movement, BulletUtils.FIRE_BULLET_DAMAGE);
			break;
		case ICE: 
			new IceBullet(imageDesign, position, new RectBoundingBox(), new NormalBulletPhysicsComponent(), velocity,
					movement, BulletUtils.ICE_BULLET_DAMAGE);
			break;
		case ELECTRIC:
			new ElectricBullet(imageDesign, position, new RectBoundingBox(), new NormalBulletPhysicsComponent(), velocity,
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