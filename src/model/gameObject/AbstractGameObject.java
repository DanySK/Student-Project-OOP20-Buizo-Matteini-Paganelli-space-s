package model.gameObject;

import java.awt.Dimension;
import java.awt.geom.AffineTransform;
import java.util.Optional;

import model.gameObject.weapon.Weapon;
import model.common.*;
import model.image.EngineImage;
import model.worldEcollisioni.physics.BoundingBox;


public abstract class AbstractGameObject {
	private EngineImage engineImage;
	private int life;
	private int damage;
	private P2d position;
	private Movement movement;
	private V2d velocity;
	private Optional<Weapon> weapon;
	private BoundingBox boundingBox;
	private AffineTransform transform;

	public AbstractGameObject(EngineImage engineImage, int life, int damage, P2d point,
							  Movement movement, V2d vel, AffineTransform transform, Optional<Weapon> weapon) {
		this.engineImage = engineImage;
		this.life = life;
		this.damage = damage;
		this.position = point;
		this.movement = movement;
		this.velocity = vel;
		this.weapon = weapon;
		this.transform = transform;
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

	public P2d getPosition() {
		return position;
	}

	public void setPosition(P2d position) {
		this.position = position;
	}
	
	public BoundingBox getBoundingBox() {
		return boundingBox;
	}


	public void setBoundingBox(BoundingBox boundingBox) {
		this.boundingBox = boundingBox;
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
	
	public AffineTransform getTransform() {
		return transform;
	}

	public void setTransform(AffineTransform transform) {
		this.transform = transform;
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
		
	public BoundingBox getBBox(){
		return this.boundingBox;
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
				+ ", position=" + position + ", movement=" + movement + ", velocity=" + velocity + ", weapon=" + ", trasform=" + transform + "]";
	}

	


}
