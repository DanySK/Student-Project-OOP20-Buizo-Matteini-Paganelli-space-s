package model.gameObject.weapon;

import java.awt.Dimension;

import model.common.P2d;
import model.common.V2d;
import model.gameObject.AbstractGameObject;
import model.gameObject.Movable;
import model.image.EngineImage;

public class Bullet extends Movable {
	private AmmoType type;
	private EngineImage engineImage;
	private int damage;
	
	public Bullet() {
		// TODO Auto-generated constructor stub
	}
	
	public Bullet(AmmoType type, AbstractGameObject gameObject) {
		this.type = type;
	}
	
	public AmmoType getType() {
		return type;
	}

	public void setType(AmmoType type) {
		this.type = type;
	}


	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	
}
