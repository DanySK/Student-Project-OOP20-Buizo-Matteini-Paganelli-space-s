package command;

import movement.Physics;

/**
 * An engine controller which takes care of all engine relevant commands.
 * @author java9s.com
 *
 */
public class ShipEngineControls implements CommandController{
	private ShipEngine engine;
	
	public static final String MOVE_UP ="MOVE_UP";
	public static final String MOVE_DOWN ="MOVE_DOWN";
	public static final String MOVE_LEFT ="MOVE_LEFT";
	public static final String MOVE_RIGHT ="MOVE_RIGHT";

	public static final String RELEASE_UP = "RELEASE_UP";
	public static final String RELEASE_DOWN = "RELEASE_DOWN";
	public static final String RELEASE_LEFT = "RELEASE_LEFT";
	public static final String RELEASE_RIGHT = "RELEASE_RIGHT";
	
	public ShipEngineControls(Physics physics){
		this.engine = new ShipEngine(physics);
	}
	@Override
	public void execute(String command) {
		switch (command) {
		case MOVE_UP:
			engine.moveUp();
			break;
		case MOVE_DOWN:
			engine.moveDown();
			break;
		case MOVE_LEFT:
			engine.moveLeft();
			break;
		case MOVE_RIGHT:
			engine.moveRight();
			break;
		case RELEASE_UP:
			engine.releaseUp();
			break;
		case RELEASE_DOWN:
			engine.releaseDown();
			break;
		case RELEASE_LEFT:
			engine.releaseLeft();
			break;
		case RELEASE_RIGHT:
			engine.releaseRight();
			break;
		default:
				System.out.println("Comando non esistente.");
			break;
		}
	}
	@Override
	public boolean canHandle(String command) {
		if(MOVE_UP.equals(command)||
				MOVE_DOWN.equals(command)||
					MOVE_LEFT.equals(command)||
						MOVE_RIGHT.equals(command)||
							RELEASE_UP.equals(command)||
								RELEASE_DOWN.equals(command)||
									RELEASE_LEFT.equals(command)||
										RELEASE_RIGHT.equals(command)){
			return true;
		}
		return false;
	}
	
}
