package model.worldEcollisioni.hitEvents;

import model.gameObject.MainGameObject;
import model.worldEcollisioni.WorldEvent;

public class HitMainGameObject implements WorldEvent{

	private MainGameObject object;
	private MainGameObject collidedObject;
	
	public HitMainGameObject(MainGameObject object, MainGameObject collidedObject){
		this.object = object;
		this.collidedObject = collidedObject;
	}
	
	public MainGameObject getObject(){
		return this.object;
	}
	
	public MainGameObject getCollidedObject(){
		return this.collidedObject;
	}
}
