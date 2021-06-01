package spaceSurvival.model.worldEcollisioni.hitEvents;

import java.util.ArrayList;
import java.util.List;

import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.MovableGameObject;
import spaceSurvival.model.worldEcollisioni.WorldEvent;

public class HitBulletEvent implements WorldEvent {

	private GameObject bullet;
	private GameObject gameObject;
	
	
	public HitBulletEvent(MovableGameObject obj, MainGameObject gameObject){
		this.bullet = obj;
		this.gameObject = gameObject;
	}
	
	public List<GameObject> getCollisionObj(){
		List<GameObject> list = new ArrayList<>();
		list.add(this.bullet);
		list.add(this.gameObject);
		return list;
	}
}