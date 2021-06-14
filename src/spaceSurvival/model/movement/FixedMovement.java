package spaceSurvival.model.movement;

import java.awt.geom.AffineTransform;

import spaceSurvival.model.gameObject.MovableGameObject;

public class FixedMovement implements Movement {

	@Override
	public void move(MovableGameObject object) {
		//System.out.println(object.getPosition());
		AffineTransform at = object.getTransform();
		at.translate(object.getVelocity().getX(), object.getVelocity().getY());
		object.setTransform(object.getTransform());
	}

	@Override
	public String toString() {
		return "Fixed Movement";
	}
}
