package spacesurvival.model.gameobject.factories;

import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.gameobject.enemy.FireableObject;
import spacesurvival.model.gameobject.takeable.TakeableGameObject;

public abstract class AbstractFactoryGameObject {
    public abstract MainGameObject createAsteroid();
    public abstract MainGameObject createChaseEnemy();
    public abstract FireableObject createFireEnemy();
    public abstract FireableObject createBoss();
    public abstract TakeableGameObject createAmmo();
    public abstract TakeableGameObject createHeart();
}