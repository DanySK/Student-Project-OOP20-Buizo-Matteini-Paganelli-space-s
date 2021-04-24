package difficulty.factories;

import difficulty.FireEnemy.FireEnemyEasy;
import difficulty.asteroid.AsteroidEasy;
import difficulty.boss.BossEasy;
import difficulty.chaseEnemy.ChaseEnemyEasy;

public class ConcreteFactoryEasy extends AbstractFactoryDifficulty {

	public AsteroidEasy createAsteroid() {
		return null;
	}

	public ChaseEnemyEasy createChaseEnemy() {
		return null;
	}

	public FireEnemyEasy createFireEnemy() {
		return null;
	}

	public BossEasy createBoss() {
		return null;
	}

}
