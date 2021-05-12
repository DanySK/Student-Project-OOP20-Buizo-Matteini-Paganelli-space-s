package model.gameObject;

import java.awt.Dimension;
import java.awt.geom.AffineTransform;
import java.util.Optional;

import model.common.P2d;
import model.common.V2d;
import model.gameObject.weapon.Weapon;
import model.image.EngineImage;
import model.worldEcollisioni.physics.boundingType.BoundingBox;
import model.worldEcollisioni.physics.components.PhysicsComponent;
import model.world.World;


public abstract class AbstractGameObject extends Movable {
	private EngineImage engineImage;
	private int life;
	private int damage;
	
	private Optional<Weapon> weapon;
	private AffineTransform transform;

	private BoundingBox boundingBox;
	private PhysicsComponent phys;
	//DA CAMBIARE, SARà L'ENUM DEGLI STATI DEGLI OGGETTI
	private String state = "NORMAL";
	
	public AbstractGameObject(EngineImage engineImage, int life, int damage, P2d point,
			  Movement movement, V2d vel, Optional<Weapon> weapon, BoundingBox bb, PhysicsComponent phys) {
		super(point, vel, movement);
		this.engineImage = engineImage;
		this.life = life;
		this.damage = damage;
		this.weapon = weapon;
		this.transform = new AffineTransform();
		this.boundingBox = bb;
		this.phys = phys;
	}
	
	public EngineImage getEngineImage() {
		return engineImage;
	}

	public void setEngineImage(EngineImage engineImage) {
		this.engineImage = engineImage;
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

	public BoundingBox getBoundingBox() {
		return boundingBox;
	}

	public void setBoundingBox(BoundingBox boundingBox) {
		this.boundingBox = boundingBox;
	}

	public AffineTransform getTransform() {
		return transform;
	}

	public void setTransform(AffineTransform transform) {
		this.transform = transform;
	}

	public PhysicsComponent getPhys() {
		return phys;
	}

	public void setPhys(PhysicsComponent phys) {
		this.phys = phys;
	}

	
//	public void setScale(int scaleOf, int respectTo) {
//	this.engineImage.setScaleOfRespect(scaleOf, respectTo);
//}
	
	public void updatePhysics(int dt, World w){
		phys.update(dt, this, w);
	}
	
	public String getState(){
		return this.state;
	}
	
	public void setState(String state){
		this.state = state;
	}
	
	public Dimension getSize() {
		return this.getEngineImage().getSize();
	}

	@Override
	public String toString() {
		return "AbstractGameObject [engineImage=" + engineImage + ", life=" + life + ", damage=" + damage + ", weapon="
				+ weapon + ", boundingBox=" + boundingBox + ", transform=" + transform + ", phys=" + phys + ", state="
				+ state + "]";
	}

}
