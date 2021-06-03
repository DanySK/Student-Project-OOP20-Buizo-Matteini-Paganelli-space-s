package spaceSurvival.model.worldEcollisioni.hitEvents;

import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.weapon.Bullet;
import spaceSurvival.model.worldEcollisioni.WorldEvent;

public class HitBulletEvent implements WorldEvent {

	private Bullet bullet;
	private MainGameObject collidedObject;
	
	
	public HitBulletEvent(Bullet bullet, MainGameObject collidedObject){
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