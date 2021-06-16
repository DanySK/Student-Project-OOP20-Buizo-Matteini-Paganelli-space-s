package spacesurvival.model.worldEcollisioni.hitEvents;

import spacesurvival.model.gameObject.MainGameObject;
import spacesurvival.model.gameObject.weapon.Bullet;
import spacesurvival.model.worldEcollisioni.WorldEvent;

public class HitBulletEvent implements WorldEvent {
    private final Bullet bullet;
    private final MainGameObject collidedObject;

    public HitBulletEvent(final Bullet bullet, final MainGameObject collidedObject) {
        this.bullet = bullet;
        this.collidedObject = collidedObject;
    }
	
    public MainGameObject getCollidedObject() {
        return this.collidedObject;
    }
	
    public Bullet getBullet() {
        return this.bullet;
    }

}