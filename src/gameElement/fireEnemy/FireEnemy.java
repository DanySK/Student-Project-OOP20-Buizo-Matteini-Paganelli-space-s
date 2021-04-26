package gameElement.fireEnemy;

import java.awt.Dimension;

import gameElement.AbstractEnemy;
import gameElement.Movement;
import gameElement.V2d;
import model.environment.Point2D;

public class FireEnemy extends AbstractEnemy {

	public FireEnemy(String path, Integer life,Integer damage, Dimension dim, Point2D point, Movement movement, V2d vel) {
		super(path, life, damage, dim, point, movement, vel);
	}


}
