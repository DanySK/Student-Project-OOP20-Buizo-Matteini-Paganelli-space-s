package model.gameObject;

import java.awt.Dimension;
import java.util.Optional;

import model.gameObject.weapon.Weapon;
import model.environment.Point2D;
import model.image.EngineImage;

public abstract class AbstractGameObject {
	private EngineImage engineImage;
	private int life;
	private int damage;
	private Point2D position;
	private Movement movement;
	private V2d velocity;
	private Optional<Weapon> weapon;

	public AbstractGameObject(EngineImage engineImage, int life, int damage, Point2D point,
							  Movement movement, V2d vel, Optional<Weapon> weapon) {
		this.engineImage = engineImage;
		this.life = life;
		this.damage = damage;
		this.position = point;
		this.movement = movement;
		this.velocity = vel;
		this.weapon = weapon;
	}

	public EngineImage getImageEngine() {
		return engineImage;
	}

	public void setImageEngine(String pathImage) {
		this.engineImage = new EngineImage(pathImage);
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

	public Dimension getSize() {
		return this.engineImage.getSize();
	}
	
	public int getScaleOf(){
		return this.engineImage.getScaleOf();
	}

	public String getPath(){
		return this.engineImage.getPath();
	}

	public int getRespectTo(){
		return this.engineImage.getRespectTo();
	}
	
	public void setScale(int scaleOf, int respectTo) {
		this.engineImage.setScale(scaleOf, respectTo);
	}
	
	public void setScaleOf(int scaleOf) {
		this.engineImage.setScaleOf(scaleOf);
	}
	
//	public void setScale(int scaleOf, int respectTo) {
//	this.engineImage.setScaleOfRespect(scaleOf, respectTo);
//}
	
	@Override
	public String toString() {
		return "AbstractGameObject [engineImage=" + engineImage + ", life=" + life + ", damage=" + damage
				+ ", position=" + position + ", movement=" + movement + ", velocity=" + velocity + ", weapon=" + weapon
				+ "]";
	}

}
