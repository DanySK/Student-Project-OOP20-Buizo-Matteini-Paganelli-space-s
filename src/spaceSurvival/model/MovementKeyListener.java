package spaceSurvival.model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Optional;

import spaceSurvival.controller.CallerCommand;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spaceSurvival.utilities.CommandType;

public class MovementKeyListener implements KeyListener {

    final private CallerCommand caller;

    public MovementKeyListener(final SpaceShipSingleton ship) {
        caller = new CallerCommand(ship);
    }


    @Override
    public void keyTyped(final KeyEvent e) {
    }

    @Override
    public void keyPressed(final KeyEvent e) {
    	final int pressedKeyCode = e.getKeyCode();
    	if(canHandleKey(pressedKeyCode)) {
    		final CommandType cmd = translateKeyCode(pressedKeyCode).get();
    		this.caller.execute(cmd);
    	} else {
    		System.out.println("tasto non riconosciuto");
    	}
    }

    @Override
    public void keyReleased(final KeyEvent e) {
    	System.out.println(e.getKeyCode());
    	final int pressedKeyCode = e.getKeyCode();
    	if (canHandleKey(pressedKeyCode)) {
    		final CommandType cmd = translateKeyCode(pressedKeyCode).get();
    		this.caller.release(cmd);
    	} else {
    		System.out.println("tasto non riconosciuto");
    	}
    }

    private boolean canHandleKey(final int currentKeyCode) {
        return CommandType.getValue(currentKeyCode).isPresent(); 
    }


    public Optional<CommandType> translateKeyCode(final Integer keyCode) {
    	if (canHandleKey(keyCode)) {
    	    return CommandType.getValue(keyCode);
    }
    	    return Optional.empty();
    }
	


}
