package difficulty.asteroid;

import java.awt.Dimension;

import difficulty.Movement;
import gameElements.Velocity;
import model.environment.Point2D;

public abstract class AbstractAsteroid {

	private Integer life;
	private Movement movement;
	private Integer damage;
	private Velocity velocity;
	private Point2D position;
	private Dimension dimension;
	
	public AbstractAsteroid() {
		this.movement = Movement.RANDOM;
		this.velocity = Velocity.MEDIUM;
	}
	
}
