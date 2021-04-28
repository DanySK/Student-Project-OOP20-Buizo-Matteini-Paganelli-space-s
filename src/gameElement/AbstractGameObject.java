package gameElement;

import java.util.Optional;

import gameElement.weapon.Weapon;
import model.MyJImage.MyJImageEngine;
import model.environment.Point2D;

public abstract class AbstractGameObject {
	private MyJImageEngine pathImage;
	private int life;
	private int damage;
	private Point2D position;
	private Movement movement;
	private V2d velocity;
	private Optional<Weapon> weapon;

	
	public AbstractGameObject(String path, int life, int damage, Point2D point, Movement movement, V2d vel, Optional<Weapon> weapon) {
		this.life = life;
		this.movement = movement;
		this.damage = damage;
		this.velocity = vel;
		this.position = point;
		this.pathImage = new MyJImageEngine(path);
		this.weapon = weapon;
	}

	public MyJImageEngine getImageEngine() {
		return pathImage;
	}

	public void setImageEngine(String pathImage) {
		this.pathImage = new MyJImageEngine(pathImage);
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
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

	public Optional<Weapon> getWeapon() {
		return weapon;
	}

	public void setWeapon(Optional<Weapon> weapon) {
		this.weapon = weapon;
	}

}
