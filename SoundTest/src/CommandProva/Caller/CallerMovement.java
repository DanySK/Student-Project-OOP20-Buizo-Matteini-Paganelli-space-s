package CommandProva.Caller;

import CommandProva.CmdType.CmdMovementType;
import CommandProva.CommandInterfaces.CommandMovement;
import CommandProva.ConcreteCommandMovement.DownCommand;
import CommandProva.ConcreteCommandMovement.DownReleaseCommand;
import CommandProva.ConcreteCommandMovement.LeftCommand;
import CommandProva.ConcreteCommandMovement.LeftReleaseCommand;
import CommandProva.ConcreteCommandMovement.RightCommand;
import CommandProva.ConcreteCommandMovement.RightReleaseCommand;
import CommandProva.ConcreteCommandMovement.UpCommand;
import CommandProva.ConcreteCommandMovement.UpReleaseCommand;

public class CallerMovement {
	

	private final CommandMovement cmdLeft;
	private final CommandMovement cmdUp;
	private final CommandMovement cmdRight;
	private final CommandMovement cmdDown;
	
	private final CommandMovement cmdReleaseLeft;
	private final CommandMovement cmdReleaseUp;
	private final CommandMovement cmdReleaseRight;
	private final CommandMovement cmdReleaseDown;
	
	public CallerMovement() {
		
		this.cmdLeft  = new LeftCommand();
		this.cmdUp    = new UpCommand();
		this.cmdRight = new RightCommand();
		this.cmdDown  = new DownCommand();
		
		this.cmdReleaseLeft  = new LeftReleaseCommand();
		this.cmdReleaseUp    = new UpReleaseCommand();
		this.cmdReleaseRight = new RightReleaseCommand();
		this.cmdReleaseDown  = new DownReleaseCommand();
	}
	
	public void execute(CmdMovementType cmd) {
		 switch(cmd) {
		 case KEY_LEFT:
			 cmdLeft.execute();
			 break;
		 case KEY_RIGHT:
			 cmdRight.execute();
			 break;
		 case KEY_UP:
			 cmdUp.execute();
			 break;
		 case KEY_DOWN:
			 cmdDown.execute();
			 break;
		 }
	}
	
	public void release(CmdMovementType cmd) {
		 switch(cmd) {
		 case KEY_LEFT:
			 cmdReleaseLeft.execute();
			 break;
		 case KEY_RIGHT:
			 cmdReleaseRight.execute();
			 break;
		 case KEY_UP:
			 cmdReleaseUp.execute();
			 break;
		 case KEY_DOWN:
			 cmdReleaseDown.execute();
			 break;
		 }
	}
	
	
}
