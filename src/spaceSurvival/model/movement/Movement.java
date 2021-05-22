package spaceSurvival.model.movement;

import spaceSurvival.model.command.caller.CallerMovement;

public interface Movement {
	void move(CallerMovement caller);
}
