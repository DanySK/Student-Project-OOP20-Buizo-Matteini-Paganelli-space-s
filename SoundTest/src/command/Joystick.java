package command;

import java.util.Iterator;
import java.util.List;

/**
 * A Joystick controller which connects to all other controllers.
 * @author alberto pagan
 *
 */
public class Joystick implements CommandController{
	private List<CommandController> commandControls;
	
	public Joystick(List<CommandController> commandControls){
		commandControls.add(this);
		this.commandControls = commandControls;
	}
	
	public static final String KEY_UP = "KEY_UP";
	public static final String KEY_DOWN = "KEY_DOWN";
	public static final String KEY_LEFT = "KEY_LEFT";
	public static final String KEY_RIGHT = "KEY_RIGHT";
	
	public static final String RELEASE_KEY_UP = "RELEASE_KEY_UP";
	public static final String RELEASE_KEY_DOWN = "RELEASE_KEY_DOWN";
	public static final String RELEASE_KEY_LEFT = "RELEASE_KEY_LEFT";
	public static final String RELEASE_KEY_RIGHT = "RELEASE_KEY_RIGHT";
	public static final String EXIT = "EXIT";
	
	@Override
	public void execute(final String command) {
		Iterator<CommandController> commandIterator = this.commandControls.iterator();
		while(commandIterator.hasNext()){
			CommandController commandController = commandIterator.next();
			if(commandController instanceof Joystick){
				switch (command) {
				case Joystick.KEY_UP:
					this.keyUp();
					break;
				case Joystick.KEY_DOWN:
					this.keyDown();
					break;
				case Joystick.KEY_LEFT:
					this.keyLeft();
					break;
				case Joystick.KEY_RIGHT:
					this.keyRight();
					break;
				case Joystick.RELEASE_KEY_UP:
					this.releaseKeyUp();
					break;
				case Joystick.RELEASE_KEY_DOWN:
					this.releaseKeyDown();
					break;
				case Joystick.RELEASE_KEY_LEFT:
					this.releaseKeyLeft();
					break;
				case Joystick.RELEASE_KEY_RIGHT:
					this.releaseKeyRight();
					break;
				case Joystick.EXIT:
				System.exit(1);
				}
			}else if(commandController.canHandle(command)){
				commandController.execute(command);
			}
		}
	}

	@Override
	public boolean canHandle(String command) {
		if(KEY_UP.equals(command)||
				KEY_DOWN.equals(command)||
					KEY_LEFT.equals(command)||
						KEY_RIGHT.equals(command)||
							EXIT.equals(command)){
			return true;
		}
		return false;
	}
	

	
	private void keyUp(){
		System.out.println("sending command to move UP the ship");
		this.execute(ShipEngineControls.MOVE_UP);
		System.out.println("---------------");
	}
	
	private void keyDown(){
		System.out.println("sending command to move DOWN the ship");
		this.execute(ShipEngineControls.MOVE_DOWN);
		System.out.println("---------------");
	}
	
	private void keyLeft(){
		System.out.println("sending command to move LEFT the ship");
		this.execute(ShipEngineControls.MOVE_LEFT);
		System.out.println("---------------");
	}
	
	private void keyRight(){
		System.out.println("sending command to move RIGHT the ship");
		this.execute(ShipEngineControls.MOVE_RIGHT);
		System.out.println("---------------");
	}
	
	private void releaseKeyUp() {
		System.out.println("sending command to decrease UP the ship");
		this.execute(ShipEngineControls.RELEASE_UP);
		System.out.println("---------------");
		
	}
	private void releaseKeyDown() {
		System.out.println("sending command to decrease DOWN the ship");
		this.execute(ShipEngineControls.RELEASE_DOWN);
		System.out.println("---------------");
		
	}
	private void releaseKeyLeft() {
		System.out.println("sending command to decrease LEFT the ship");
		this.execute(ShipEngineControls.RELEASE_LEFT);
		System.out.println("---------------");
		
	}
	private void releaseKeyRight() {
		System.out.println("sending command to decrease RIGHT the ship");
		this.execute(ShipEngineControls.RELEASE_RIGHT);
		System.out.println("---------------");
		
	}


}
