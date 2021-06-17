package spacesurvival.model.gameobject.weapon;

import spacesurvival.utilities.dimension.ScaleOf;
import spacesurvival.utilities.dimension.Screen;
import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;
import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.gameobject.enemy.FireableObject;
import spacesurvival.model.gameobject.takeable.AmmoType;

import java.awt.geom.AffineTransform;
import java.util.HashSet;
import java.util.Set;

import spacesurvival.model.EngineImage;
import spacesurvival.model.collision.physics.bounding.RectBoundingBox;
import spacesurvival.model.collision.physics.component.BulletPhysicsComponent;

public class Weapon {

    private FireableObject owner;
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

    public Weapon(final AmmoType ammoType, final FireableObject owner) {
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
        final EngineImage engineImage = new EngineImage(ScaleOf.BULLET_OBJECT, Screen.WIDTH_FULL_SCREEN, "shutBullet/vertical/ice.png");
        final P2d position = new P2d();
        final V2d velocity = GameObjectUtils.BULLET_VEL;
        final Bullet bullet = new Bullet(engineImage, position, new RectBoundingBox(), new BulletPhysicsComponent(),
                velocity, BulletUtils.NORMAL_BULLET_DAMAGE * multiplierDamage, ammoType.getEffect(), this);

        final AffineTransform newTransform = new AffineTransform();
        newTransform.setTransform(owner.getTransform());

        //newTransform.setTransform(owner.getTransform());
        final double bulletX = owner.getWidth() / 2 - bullet.getWidth() / 2;
        final double bulletY = -owner.getHeight() / 2;
        newTransform.translate(bulletX, bulletY);
        bullet.setTransform(newTransform);

        if (magazine == Magazine.LIMITED) {
            munitions--;
            if (munitions == 0) {
                setAmmoType(AmmoType.NORMAL);
            }
        }

        System.out.println("BULLET SPARATO POSIZIONE");
        System.out.println(bullet.getBoundingBox());
        System.out.println(bullet.getPosition());

        shootedBullets.add(bullet);
//		System.out.println(owner.getPosition());
//		System.out.println(owner.getSize());
	}
	
    public FireableObject getOwner() {
        return owner;
    }

    public void setOwner(final FireableObject owner) {
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

	public void setShootedBullets(final Set<Bullet> shootedBullets) {
	    this.shootedBullets = shootedBullets;
	}

}
