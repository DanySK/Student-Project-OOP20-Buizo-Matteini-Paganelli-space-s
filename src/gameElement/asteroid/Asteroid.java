package gameElement.asteroid;


import java.awt.Dimension;

import gameElement.AbstractGameObject;
import gameElement.Movement;
import gameElement.V2d;
import model.environment.Point2D;

public class Asteroid extends AbstractGameObject {
	
	public Asteroid(String path, Integer life,Integer damage, Dimension dim, Point2D point, Movement movement, V2d vel) {
		super(path, life, damage, dim, point, movement, vel);
	}

	@Override
	public String toString() {
		return "Asteroid [getLife()=" + getLife() + ", getMovement()=" + getMovement() + ", getDamage()=" + getDamage()
				+ ", getVelocity()=" + getVelocity() + ", getPosition()=" + getPosition() + ", getDimension()="
				+ getDimension() + ", getPathImage()=" + getPathImage() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
