package gameElement.boss;

import java.awt.Dimension;
import java.util.Optional;

import gameElement.AbstractGameObject;
import gameElement.Movement;
import gameElement.V2d;
import gameElement.weapon.Weapon;
import model.environment.Point2D;

public class Boss extends AbstractGameObject {

	public Boss(String path, Integer life,Integer damage, Dimension dim, Point2D point, Movement movement, V2d vel, Optional<Weapon> weapon) {
		super(path, life, damage, dim, point, movement, vel, weapon);
	}


}
