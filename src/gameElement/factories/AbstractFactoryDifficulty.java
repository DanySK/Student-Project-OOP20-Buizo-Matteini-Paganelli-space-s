package gameElement.factories;

import java.util.ArrayList;

import gameElement.fireEnemy.AbstractFireEnemy;
import gameElement.asteroid.AbstractAsteroid;
import gameElement.boss.AbstractBoss;
import gameElement.chaseEnemy.AbstractChaseEnemy;

public abstract class AbstractFactoryDifficulty {
	
	public abstract AbstractAsteroid createAsteroid();
	public abstract AbstractChaseEnemy createChaseEnemy();
	public abstract AbstractFireEnemy createFireEnemy();
	public abstract AbstractBoss createBoss();

	
	public static void main(String[] args) {
		AbstractFactoryDifficulty factoryEasy = new ConcreteFactoryEasy();
		AbstractFactoryDifficulty factoryMedium = new ConcreteFactoryMedium();
		AbstractFactoryDifficulty factoryHard = new ConcreteFactoryHard();
		
		ArrayList<AbstractAsteroid> enemyList = new ArrayList<AbstractAsteroid>();
		
		for (int i = 0; i < 10; i++) {
			enemyList.add(factoryEasy.createAsteroid());
		}

	}
}