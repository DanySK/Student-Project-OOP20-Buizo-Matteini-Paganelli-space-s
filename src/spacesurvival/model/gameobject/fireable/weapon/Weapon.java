package spacesurvival.model.gameobject.fireable.weapon;

import spacesurvival.utilities.dimension.ScaleOf;
import spacesurvival.utilities.dimension.Screen;
import spacesurvival.utilities.gameobject.BulletUtils;
import spacesurvival.utilities.gameobject.VelocityUtils;
import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;
import spacesurvival.model.gameobject.fireable.FireableObject;
import spacesurvival.model.gameobject.takeable.ammo.AmmoType;

import java.awt.geom.AffineTransform;
import java.util.HashSet;
import java.util.Set;

import spacesurvival.model.EngineImage;
import spacesurvival.model.collision.physics.bounding.RectBoundingBox;
import spacesurvival.model.collision.physics.component.BulletPhysic;

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
        this.munitions = BulletUtils.INFINITY;
        this.multiplierDamage = 1;
        this.shootedBullets = new HashSet<>();
    }

    public Weapon(final AmmoType ammoType, final FireableObject owner) {
        this.owner = owner;
        this.ammoType = ammoType;

        switch (ammoType) {
        case NORMAL:
            this.magazine =  Magazine.UNLIMITED;
            this.munitions = BulletUtils.INFINITY;
            break;
        case FIRE:
        case ICE: 
        case ELECTRIC:
            this.magazine =  Magazine.LIMITED;
            this.munitions = BulletUtils.SPECIAL_MUNITIONS_QUANTITY;
            break;
        default:
            break;
        }
        this.multiplierDamage = 1;

        this.shootedBullets = new HashSet<>();
    }

    public void shoot() {
        System.out.println("IMG FIREEEEEEEEE" + ammoType.getBulletFire());
        final EngineImage engineImage = new EngineImage(ScaleOf.BULLET, Screen.WIDTH_FULL_SCREEN, ammoType.getBulletFire());
        final P2d position = new P2d();
        final V2d velocity = VelocityUtils.BULLET_VEL;
        final double acceleration = VelocityUtils.NO_ACCELERATION;
        final Bullet bullet = new Bullet(engineImage, position, new RectBoundingBox(), new BulletPhysic(),
                velocity, acceleration, BulletUtils.NORMAL_BULLET_DAMAGE * multiplierDamage, ammoType.getEffect(), this);

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

        shootedBullets.add(bullet);
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
            setMunitions(BulletUtils.INFINITY);
        } else {
            setMagazine(Magazine.LIMITED);
            setMunitions(BulletUtils.SPECIAL_MUNITIONS_QUANTITY);
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
