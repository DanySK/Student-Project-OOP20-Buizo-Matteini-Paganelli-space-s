package spacesurvival.model.worldEcollisioni.hitEvents;

import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.gameobject.weapon.Bullet;
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