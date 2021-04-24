package difficulty.factories;

import difficulty.FireEnemy.AbstractFireEnemy;
import difficulty.asteroid.AsteroidHard;
import difficulty.boss.BossHard;
import difficulty.chaseEnemy.AbstractChaseEnemy;

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
