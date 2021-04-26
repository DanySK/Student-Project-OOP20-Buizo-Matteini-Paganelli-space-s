package gameElement;

import java.awt.Dimension;

import model.environment.Point2D;

public abstract class AbstractGameObject {
	private String pathImage;
	private Integer life;
	private Integer damage;
	private Dimension dimension;
	private Point2D position;
	private Movement movement;
	private V2d velocity;
	
	public AbstractGameObject(String path, Integer life, Integer damage, Dimension dim, Point2D point, Movement movement, V2d vel) {
		this.life = life;
		this.movement = movement;
		this.damage = damage;
		this.velocity = vel;
		this.position = point;
		this.dimension = dim;
		this.pathImage = path;
	}

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

	public Integer getLife() {
		return life;
	}

	public void setLife(Integer life) {
		this.life = life;
	}

	public Integer getDamage() {
		return damage;
	}

	public void setDamage(Integer damage) {
		this.damage = damage;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public Point2D getPosition() {
		return position;
	}

	public void setPosition(Point2D position) {
		this.position = position;
	}

	public Movement getMovement() {
		return movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}

	public V2d getVelocity() {
		return velocity;
	}

	public void setVelocity(V2d velocity) {
		this.velocity = velocity;
	}
	
}
