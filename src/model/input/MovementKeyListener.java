package model.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.command.caller.CallerMovement;
import utilities.CmdMovementType;
import model.gameObject.AbstractGameObject;

public class MovementKeyListener implements KeyListener {

    private static final int LEFT_KEY_CODE 	= 37;
//    private static final int UP_KEY_CODE 	= 38;
//    private static final int RIGHT_KEY_CODE = 39;
    private static final int DOWN_KEY_CODE  = 40;
    CallerMovement caller;

    public MovementKeyListener(AbstractGameObject ship) {
    	caller = new CallerMovement(ship);
    }
        

	public void keyTyped(KeyEvent e) {
		//System.out.println(e.getKeyCode());
    }

    public void keyPressed(KeyEvent e) {
    	System.out.println(e.getKeyCode());
    	int pressedKeyCode = e.getKeyCode(); 	
    	if(canHandleKey(pressedKeyCode)) {
    		final CmdMovementType cmd = translateKeyCode(pressedKeyCode);
    		this.caller.execute(cmd);
    	}else {
    		System.out.println("tasto non riconosciuto");
    	} 		
    }

    public void keyReleased(KeyEvent e) {
    	System.out.println(e.getKeyCode());
    	int pressedKeyCode = e.getKeyCode();
    	if(canHandleKey(pressedKeyCode)) {
    		final CmdMovementType cmd = translateKeyCode(pressedKeyCode);
    		this.caller.release(cmd);
    	}else {
    		System.out.println("tasto non riconosciuto");
    	}
    }
    
    private boolean canHandleKey(int currentKeyCode) {
    	return (currentKeyCode >= LEFT_KEY_CODE && currentKeyCode <= DOWN_KEY_CODE) || isWASD(currentKeyCode);
    }
    
    
    private boolean isWASD(int keyCode) {
    	//69 = E, 81 = Q
    	return keyCode == 69 || keyCode == 81;

	}


	public CmdMovementType translateKeyCode(Integer keyCode) {
    	if(canHandleKey(keyCode)) {
    		return CmdMovementType.getValue(keyCode);
    	}
		return null;
    }
    

}
