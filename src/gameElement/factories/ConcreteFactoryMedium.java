package gameElement.factories;

import gameElement.fireEnemy.AbstractFireEnemy;
import gameElement.asteroid.AsteroidMedium;
import gameElement.boss.BossMedium;
import gameElement.chaseEnemy.AbstractChaseEnemy;

public class ConcreteFactoryMedium extends AbstractFactoryDifficulty {

	public AsteroidMedium createAsteroid() {
		return null;
	}

	public AbstractChaseEnemy createChaseEnemy() {
		return null;
	}

	public AbstractFireEnemy createFireEnemy() {
		return null;
	}

	public BossMedium createBoss() {
		return null;
	}
}
