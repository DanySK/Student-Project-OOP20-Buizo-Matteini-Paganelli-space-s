package model.gameElement.factories;

import java.util.ArrayList;
import java.util.List;

import model.gameElement.AbstractGameObject;

public abstract class AbstractFactoryGameObject {
	
	public abstract AbstractGameObject createObject();

	
	public static void main(String[] args) {
		AbstractFactoryGameObject factoryAsteroid = new ConcreteFactoryAsteroid();
		AbstractFactoryGameObject factoryChaseEnemy = new ConcreteFactoryChaseEnemy();
		AbstractFactoryGameObject factoryBoss = new ConcreteFactoryBoss();
		
		List<AbstractGameObject> asteroidList = new ArrayList<AbstractGameObject>();
		List<AbstractGameObject> enemyList = new ArrayList<AbstractGameObject>();
		List<AbstractGameObject> bossList = new ArrayList<AbstractGameObject>();

		
		for (int i = 0; i < 10; i++) {
			asteroidList.add(factoryAsteroid.createObject());
			enemyList.add(factoryChaseEnemy.createObject());
			bossList.add(factoryBoss.createObject());
		}

	}
}