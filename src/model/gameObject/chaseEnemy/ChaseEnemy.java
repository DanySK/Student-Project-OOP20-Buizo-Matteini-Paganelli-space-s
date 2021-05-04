package model.gameObject.chaseEnemy;

import java.awt.Dimension;
import java.util.Optional;

import model.gameObject.AbstractGameObject;
import model.gameObject.Movement;
import model.common.V2d;
import model.gameObject.weapon.Weapon;
import model.image.EngineImage;
import model.environment.Point2D;

public class ChaseEnemy extends AbstractGameObject {

	public ChaseEnemy(EngineImage engineImage, Integer life,Integer damage, Dimension dim, Point2D point, Movement movement, V2d vel, Optional<Weapon> weapon) {
		super(engineImage, life, damage, point, movement, vel, weapon);
	}

	@Override
	public String toString() {
		return "ChaseEnemy { " + super.toString() + " }";
	}
	

}
