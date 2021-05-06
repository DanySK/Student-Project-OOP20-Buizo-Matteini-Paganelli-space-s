package model.gameObject;

import java.awt.Dimension;
import java.util.Optional;

import model.gameObject.weapon.Weapon;
import model.common.*;
import model.image.EngineImage;
import model.worldEcollisioni.physics.BoundingBox;


public abstract class AbstractGameObject extends Movable {
	private EngineImage engineImage;
	private int life;
	private int damage;
	
	private Optional<Weapon> weapon;
	private BoundingBox boundingBox;

	public AbstractGameObject(EngineImage engineImage, int life, int damage, P2d point,
							  Movement movement, V2d vel, Optional<Weapon> weapon) {
		super(point, vel, movement);
		this.engineImage = engineImage;
		this.life = life;
		this.damage = damage;
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

	@Override
	public String toString() {
		return "AbstractGameObject [engineImage=" + engineImage + ", life=" + life + ", damage=" + damage + ", weapon="
				+ weapon + ", boundingBox=" + boundingBox + "], " + super.toString();
	}
	
//	public void setScale(int scaleOf, int respectTo) {
//	this.engineImage.setScaleOfRespect(scaleOf, respectTo);
//}
	


}
