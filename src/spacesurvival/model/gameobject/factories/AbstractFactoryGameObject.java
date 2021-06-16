package spacesurvival.model.gameobject.factories;

import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.gameobject.takeable.TakeableGameObject;

public abstract class AbstractFactoryGameObject {
	
	public abstract MainGameObject createAsteroid();
	public abstract MainGameObject createChaseEnemy();
	public abstract MainGameObject createFireEnemy();
	public abstract MainGameObject createBoss();
	public abstract TakeableGameObject createAmmo();
	public abstract TakeableGameObject createHeart();
}