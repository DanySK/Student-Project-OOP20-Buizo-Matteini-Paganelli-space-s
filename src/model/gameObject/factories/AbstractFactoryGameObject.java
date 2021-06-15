package model.gameObject.factories;

import model.gameObject.MainGameObject;
import model.gameObject.takeableGameObject.TakeableGameObject;

public abstract class AbstractFactoryGameObject {
	
	public abstract MainGameObject createAsteroid();
	public abstract MainGameObject createChaseEnemy();
	public abstract MainGameObject createFireEnemy();
	public abstract MainGameObject createBoss();
	public abstract TakeableGameObject createAmmo();
	public abstract TakeableGameObject createHeart();
}