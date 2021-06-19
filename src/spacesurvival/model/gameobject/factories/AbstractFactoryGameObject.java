package spacesurvival.model.gameobject.factories;

import spacesurvival.model.gameobject.fireable.FireableObject;
import spacesurvival.model.gameobject.main.MainObject;
import spacesurvival.model.gameobject.takeable.TakeableGameObject;

/**
 * Contract for the factory which will create all objects for the game.
 */
public abstract class AbstractFactoryGameObject {

    public abstract MainObject createAsteroid();
    public abstract MainObject createChaseEnemy();
    public abstract FireableObject createFireEnemy();
    public abstract FireableObject createBoss();
    public abstract TakeableGameObject createAmmo();
    public abstract TakeableGameObject createHeart();

}
