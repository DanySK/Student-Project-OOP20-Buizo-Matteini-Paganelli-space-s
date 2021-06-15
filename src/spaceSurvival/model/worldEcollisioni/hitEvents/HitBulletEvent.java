package spaceSurvival.model.worldEcollisioni.hitEvents;

import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.weapon.Bullet;
import spaceSurvival.model.worldEcollisioni.WorldEvent;

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