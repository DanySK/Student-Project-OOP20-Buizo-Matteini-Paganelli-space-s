package model.gameObject.boss;

import java.awt.Dimension;
import java.util.Optional;

import model.gameObject.AbstractGameObject;
import model.gameObject.Movement;
import model.gameObject.V2d;
import model.gameObject.weapon.Weapon;
import model.image.EngineImage;
import model.environment.Point2D;

public class Boss extends AbstractGameObject {

	public Boss(EngineImage engineImage, Integer life,Integer damage, Dimension dim, Point2D point, Movement movement, V2d vel, Optional<Weapon> weapon) {
		super(engineImage, life, damage, point, movement, vel, weapon);
	}

	@Override
	public String toString() {
		return "Asteroid [getImageEngine()=" + getImageEngine() + ", getLife()=" + getLife() + ", getDamage()="
				+ getDamage() + ", getPosition()=" + getPosition() + ", getMovement()=" + getMovement()
				+ ", getVelocity()=" + getVelocity() + ", getWeapon()=" + getWeapon() + ", getSize()=" + getSize()
				+ ", getScaleOf()=" + getScaleOf() + ", getPath()=" + getPath() + ", getRespectTo()=" + getRespectTo()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	

}
