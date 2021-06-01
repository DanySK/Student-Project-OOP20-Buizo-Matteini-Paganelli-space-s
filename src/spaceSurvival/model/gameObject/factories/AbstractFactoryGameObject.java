package spaceSurvival.model.gameObject.factories;

import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.TakeableGameObject;

public abstract class AbstractFactoryGameObject {
	
	public abstract MainGameObject createAsteroid();
	public abstract MainGameObject createChaseEnemy();
	public abstract MainGameObject createFireEnemy();
	public abstract MainGameObject createBoss();
	public abstract TakeableGameObject createPickable();

}