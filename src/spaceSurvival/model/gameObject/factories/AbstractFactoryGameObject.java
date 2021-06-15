package spaceSurvival.model.gameObject.factories;

import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.enemy.FireableObject;
import spaceSurvival.model.gameObject.takeableGameObject.TakeableGameObject;

public abstract class AbstractFactoryGameObject {	
    public abstract MainGameObject createAsteroid();
    public abstract MainGameObject createChaseEnemy();
    public abstract FireableObject createFireEnemy();
    public abstract FireableObject createBoss();
    public abstract TakeableGameObject createAmmo();
    public abstract TakeableGameObject createHeart();
}