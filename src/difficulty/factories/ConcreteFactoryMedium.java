package difficulty.factories;

import difficulty.FireEnemy.AbstractFireEnemy;
import difficulty.asteroid.AsteroidMedium;
import difficulty.boss.BossMedium;
import difficulty.chaseEnemy.AbstractChaseEnemy;

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
