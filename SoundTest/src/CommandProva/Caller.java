package CommandProva;

public class Caller {
	

	private final CommandMovement cmdLeft;
	private final CommandMovement cmdUp;
	private final CommandMovement cmdRight;
	private final CommandMovement cmdDown;
	private final CommandMovement cmdReleaseLeft;
	private final CommandMovement cmdReleaseUp;
	private final CommandMovement cmdReleaseRight;
	private final CommandMovement cmdReleaseDown;
	
	public Caller() {
		
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
