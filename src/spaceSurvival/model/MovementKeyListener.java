package spaceSurvival.model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import spaceSurvival.model.command.caller.CallerCommand;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.utilities.CommandType;

public class MovementKeyListener implements KeyListener {

    private static final int LEFT_KEY_CODE 	= 37;
//    private static final int UP_KEY_CODE 	= 38;
//    private static final int RIGHT_KEY_CODE = 39;
    private static final int DOWN_KEY_CODE  = 40;
    CallerCommand caller;

    public MovementKeyListener(final MainGameObject ship) {
    	caller = new CallerCommand(ship);
    }
        

	public void keyTyped(final KeyEvent e) {
		//System.out.println(e.getKeyCode());
    }

    public void keyPressed(final KeyEvent e) {
    	System.out.println(e.getKeyCode());
    	int pressedKeyCode = e.getKeyCode(); 	
    	if(canHandleKey(pressedKeyCode)) {
    		final CommandType cmd = translateKeyCode(pressedKeyCode);
    		this.caller.execute(cmd);
    	}else {
    		System.out.println("tasto non riconosciuto");
    	} 		
    }

    public void keyReleased(final KeyEvent e) {
    	System.out.println(e.getKeyCode());
    	int pressedKeyCode = e.getKeyCode();
    	if(canHandleKey(pressedKeyCode)) {
    		final CommandType cmd = translateKeyCode(pressedKeyCode);
    		this.caller.release(cmd);
    	}else {
    		System.out.println("tasto non riconosciuto");
    	}
    }
    
    private boolean canHandleKey(final int currentKeyCode) {
    	return isArrowKey(currentKeyCode) || isEQ(currentKeyCode) || isSpaceBar(currentKeyCode);
    }
    
    private boolean isArrowKey(final int keyCode) {
    	//37 = LEFT, 38 = UP, 39 = RIGHT, 40 = DOWN
    	return keyCode >= LEFT_KEY_CODE && keyCode <= DOWN_KEY_CODE;
	}
    
      //ANDRA' FATTO IL MOVIMENTO ANCHE CON WASD OLTRE ALLE FRECCE    
//    private boolean isWASD(final int keyCode) {
//    	//69 = E, 81 = Q
//    	return keyCode == 69 || keyCode == 81;
//	}

    private boolean isEQ(final int keyCode) {
    	//69 = E, 81 = Q
    	return keyCode == 69 || keyCode == 81;
	}
    
    private boolean isSpaceBar(final int keyCode) {
    	//32 = SPACE BAR
    	return keyCode == 32;
	}
    
	public CommandType translateKeyCode(final Integer keyCode) {
    	if(canHandleKey(keyCode)) {
    		return CommandType.getValue(keyCode);
    	}
		return null;
    }

}
