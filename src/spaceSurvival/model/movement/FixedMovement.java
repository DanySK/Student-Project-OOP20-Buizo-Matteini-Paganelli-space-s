package spaceSurvival.model.movement;

import spaceSurvival.model.command.caller.CallerMovement;
import spaceSurvival.utilities.CommandType;

public class FixedMovement implements Movement {

	@Override
	public void move(CallerMovement caller) {
		caller.execute(CommandType.KEY_UP);
	}

}
