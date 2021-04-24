package CommandProva;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import CommandProva.Caller.CallerMovement;
import CommandProva.CmdType.CmdMovementType;

public class MovementKeyListener implements KeyListener {

    private static final int LEFT_KEY_CODE 	= 37;
//    private static final int UP_KEY_CODE 	= 38;
//    private static final int RIGHT_KEY_CODE = 39;
    private static final int DOWN_KEY_CODE  = 40;
    CallerMovement caller;

    public MovementKeyListener() {
    	caller = new CallerMovement();
    }
        
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
    	int pressedKeyCode = e.getKeyCode(); 	
    	if(canHandleKey(pressedKeyCode)) {
    		final CmdMovementType cmd = translateKeyCode(pressedKeyCode);
    		this.caller.execute(cmd);
    	}else {
    		System.out.println("tasto non riconosciuto");
    	} 		
    }

    public void keyReleased(KeyEvent e) {
    	int pressedKeyCode = e.getKeyCode();
    	if(canHandleKey(pressedKeyCode)) {
    		final CmdMovementType cmd = translateKeyCode(pressedKeyCode);
    		this.caller.release(cmd);
    	}else {
    		System.out.println("tasto non riconosciuto");
    	}
    }
    
    private boolean canHandleKey(int currentKeyCode) {
    	return currentKeyCode >= LEFT_KEY_CODE && currentKeyCode <= DOWN_KEY_CODE;
    }
    
    
    public CmdMovementType translateKeyCode(Integer keyCode) {
    	if(canHandleKey(keyCode)) {
    		return CmdMovementType.getValue(keyCode);
    	}
		return null;
    }
    

}
