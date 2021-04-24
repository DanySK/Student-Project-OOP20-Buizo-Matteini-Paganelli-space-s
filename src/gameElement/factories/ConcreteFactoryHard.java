package gameElement.factories;

import gameElement.fireEnemy.AbstractFireEnemy;
import gameElement.asteroid.AsteroidHard;
import gameElement.boss.BossHard;
import gameElement.chaseEnemy.AbstractChaseEnemy;

public class ConcreteFactoryHard extends AbstractFactoryDifficulty {

	public AsteroidHard createAsteroid() {
		return null;
	}

	public AbstractChaseEnemy createChaseEnemy() {
		return null;
	}

	public AbstractFireEnemy createFireEnemy() {
		return null;
	}

	public BossHard createBoss() {
		return null;
	}

}
