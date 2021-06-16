package spacesurvival.model.gameObject.factories;

import spacesurvival.model.gameObject.MainGameObject;
import spacesurvival.model.gameObject.takeableGameObject.TakeableGameObject;

public abstract class AbstractFactoryGameObject {
	
	public abstract MainGameObject createAsteroid();
	public abstract MainGameObject createChaseEnemy();
	public abstract MainGameObject createFireEnemy();
	public abstract MainGameObject createBoss();
	public abstract TakeableGameObject createAmmo();
	public abstract TakeableGameObject createHeart();
}