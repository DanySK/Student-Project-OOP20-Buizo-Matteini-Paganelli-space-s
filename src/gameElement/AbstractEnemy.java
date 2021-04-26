package gameElement;

import java.awt.Dimension;
import java.util.Optional;

import gameElement.weapon.Weapon;
import model.environment.Point2D;

public abstract class AbstractEnemy extends AbstractGameObject {

	private boolean isShooter;
	private Optional<Weapon> weapon;
	
	public AbstractEnemy(String path, Integer life,Integer damage, Dimension dim, Point2D point, Movement movement, V2d vel) {
		super(path, life, damage, dim, point, movement, vel);
	}


}
