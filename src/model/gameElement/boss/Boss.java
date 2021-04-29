package model.gameElement.boss;

import java.util.Optional;

import model.gameElement.AbstractGameObject;
import model.gameElement.Movement;
import model.gameElement.V2d;
import model.gameElement.weapon.Weapon;
import model.environment.Point2D;

public class Boss extends AbstractGameObject {

	public Boss(String path, Integer life,Integer damage, Point2D point, Movement movement, V2d vel, Optional<Weapon> weapon) {
		super(path, life, damage, point, movement, vel, weapon);
	}


}
