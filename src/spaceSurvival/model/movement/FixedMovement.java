package spaceSurvival.model.movement;

import java.awt.geom.AffineTransform;

import spaceSurvival.model.gameObject.MovableGameObject;

public class FixedMovement implements Movement {

	@Override
	public void move(MovableGameObject object) {
		//new CallerMovement(object).execute(CommandType.KEY_UP);
		//object.getCaller().execute(CommandType.KEY_UP);
		
		
		AffineTransform at = object.getTransform();
		at.translate(object.getVelocity().getX(), object.getVelocity().getY());
		//at.rotate(5);
		object.setTransform(object.getTransform());

	}

	@Override
	public String toString() {
		return "Fixed Movement";
	}
}
