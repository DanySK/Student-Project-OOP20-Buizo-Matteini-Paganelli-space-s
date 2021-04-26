package gameElement.factories;

import java.util.ArrayList;

import gameElement.AbstractGameObject;

public abstract class AbstractFactoryGameObject {
	
	public abstract AbstractGameObject createObject();

	
	public static void main(String[] args) {
		AbstractFactoryGameObject factoryAsteroid = new ConcreteFactoryAsteroid();
		AbstractFactoryGameObject factoryEnemy = new ConcreteFactoryAsteroid();
		AbstractFactoryGameObject factoryBoss = new ConcreteFactoryAsteroid();
		
		ArrayList<AbstractGameObject> enemyList = new ArrayList<AbstractGameObject>();
		
		for (int i = 0; i < 10; i++) {
			enemyList.add(factoryAsteroid.createObject());
		}

	}
}