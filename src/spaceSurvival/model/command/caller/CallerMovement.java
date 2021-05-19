package spaceSurvival.model.command.caller;

import spaceSurvival.utilities.CmdMovementType;
import spaceSurvival.model.command.concreteCommand.*;
import spaceSurvival.model.command.commandInterfaces.CommandMovement;
import spaceSurvival.model.gameObject.MovableGameObject;

public class CallerMovement {

	private final CommandMovement cmdLeft;
	private final CommandMovement cmdUp;
	private final CommandMovement cmdRight;
	private final CommandMovement cmdDown;
	
	private final CommandMovement cmdReleaseLeft;
	private final CommandMovement cmdReleaseUp;
	private final CommandMovement cmdReleaseRight;
	private final CommandMovement cmdReleaseDown;
	
	private final CommandMovement cmdRotateLeft;
	private final CommandMovement cmdRotateRight;
	
	private final MovableGameObject ship;
	
	
	public CallerMovement(MovableGameObject ship) {
		this.cmdLeft  = new LeftCommand();
		this.cmdUp    = new UpCommand();
		this.cmdRight = new RightCommand();
		this.cmdDown  = new DownCommand();
		
		this.cmdReleaseLeft  = new LeftReleaseCommand();
		this.cmdReleaseUp    = new UpReleaseCommand();
		this.cmdReleaseRight = new RightReleaseCommand();
		this.cmdReleaseDown  = new DownReleaseCommand();
		
		this.cmdRotateLeft   = new RotateLeftCommand();
		this.cmdRotateRight  = new RotateRightCommand();
		
		this.ship = ship;
	}
	
	public void execute(CmdMovementType cmd) {
		 switch(cmd) {
		 case KEY_LEFT:
			 cmdLeft.execute(ship);
			 break;
		 case KEY_RIGHT:
			 cmdRight.execute(ship);
			 break;
		 case KEY_UP:
			 cmdUp.execute(ship);
			 break;
		 case KEY_DOWN:
			 cmdDown.execute(ship);
			 break;		 
		 case KEY_ROTATE_LEFT:
			 cmdRotateLeft.execute(ship);
			 break;
		 case KEY_ROTATE_RIGHT:
			 cmdRotateRight.execute(ship);
			 break;
		 }
	}
	
	public void release(CmdMovementType cmd) {
		 switch(cmd) {
		 case KEY_LEFT:
			 cmdReleaseLeft.execute(ship);
			 break;
		 case KEY_RIGHT:
			 cmdReleaseRight.execute(ship);
			 break;
		 case KEY_UP:
			 cmdReleaseUp.execute(ship);
			 break;
		 case KEY_DOWN:
			 cmdReleaseDown.execute(ship);
			 break;
		default:
			break;
		 }
	}
	
	
}
