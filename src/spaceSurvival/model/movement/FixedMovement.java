package spaceSurvival.model.movement;

import spaceSurvival.model.command.caller.CallerMovement;
import spaceSurvival.model.gameObject.MovableGameObject;
import spaceSurvival.utilities.CommandType;

public class FixedMovement implements Movement {

	@Override
	public void move(MovableGameObject object) {
		//new CallerMovement(object).execute(CommandType.KEY_UP);
		object.getCaller().execute(CommandType.KEY_UP);
	}

}
