package OLD_input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import command.CommandController;
import command.Joystick;
import command.ShipEngineControls;
import movement.Physics;

public class MyKeyListener implements KeyListener {

    private Joystick joystick;
    private static final int LEFT_KEY_CODE = 37;
    private static final int UP_KEY_CODE = 38;
    private static final int RIGHT_KEY_CODE = 39;
    private static final int DOWN_KEY_CODE = 40;

    public MyKeyListener() {}
    public MyKeyListener(Physics physics) {
		ShipEngineControls shipEngineControls = new ShipEngineControls(physics);
		List<CommandController> commandControllers = new ArrayList<CommandController>();
		commandControllers.add(shipEngineControls);
    	joystick = new Joystick(commandControllers);

    }
        
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
    	int pressedKeyCode = e.getKeyCode();
    	if(canHandleKey(pressedKeyCode)) {
    		switch (pressedKeyCode) {
			case LEFT_KEY_CODE:
				this.joystick.execute(Joystick.KEY_LEFT);
				break;
			case UP_KEY_CODE:
				this.joystick.execute(Joystick.KEY_UP);
				break;
			case RIGHT_KEY_CODE:
				this.joystick.execute(Joystick.KEY_RIGHT);
				break;
			case DOWN_KEY_CODE:
				this.joystick.execute(Joystick.KEY_DOWN);
				break;
			default:
			System.out.println("tasto non riconosciuto");
			}
    	}
    }

    public void keyReleased(KeyEvent e) {
    	int pressedKeyCode = e.getKeyCode();
    	if(canHandleKey(pressedKeyCode)) {
    		switch (pressedKeyCode) {
			case LEFT_KEY_CODE:
				this.joystick.execute(Joystick.RELEASE_KEY_LEFT);
				break;
			case UP_KEY_CODE:
				this.joystick.execute(Joystick.RELEASE_KEY_UP);
				break;
			case RIGHT_KEY_CODE:
				this.joystick.execute(Joystick.RELEASE_KEY_RIGHT);
				break;
			case DOWN_KEY_CODE:
				this.joystick.execute(Joystick.RELEASE_KEY_DOWN);
				break;
			default:
			System.out.println("tasto non riconosciuto");
			}
    	}

    }
    
    private boolean canHandleKey(int currentKeyCode) {
    	return currentKeyCode >= LEFT_KEY_CODE && currentKeyCode <= DOWN_KEY_CODE;
    }


}
