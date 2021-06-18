package spacesurvival.model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Optional;

import spacesurvival.controller.CallerCommand;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;
import spacesurvival.utilities.CommandType;


public class MovementKeyListener implements KeyListener {

    private final CallerCommand caller;

    /** 
     * Initialize the caller command.
     * 
     * @param ship SpaceShipSingleton the unique controlled ship 
     */
    public MovementKeyListener(final SpaceShipSingleton ship) {
        caller = new CallerCommand(ship);
    }

    /** 
     * Read the pressed key and send the right command.
     * 
     * @param e KeyEvent the event of the pressed key
     */
    @Override
    public void keyTyped(final KeyEvent e) {
    }

    /** 
     * Read the pressed key and send the right command.
     * 
     * @param e KeyEvent the event of the pressed key
     */
    @Override
    public void keyPressed(final KeyEvent e) {
        final int pressedKeyCode = e.getKeyCode();
        System.out.println(pressedKeyCode);
        if (canHandleKey(pressedKeyCode)) {
            final CommandType cmd = translateKeyCode(pressedKeyCode).get();
            this.caller.execute(cmd);
        }
    }

    /** 
     * Read the released key and send the right command.
     * 
     * @param e KeyEvent the event of the released key
     */
    @Override
    public void keyReleased(final KeyEvent e) {
        final int pressedKeyCode = e.getKeyCode();
        if (canHandleKey(pressedKeyCode)) {
            final CommandType cmd = translateKeyCode(pressedKeyCode).get();
            this.caller.release(cmd);
        }
    }

    /** 
     * Check if the passed key code is accepted from the command caller.
     * 
     * @param currentKeyCode code to check
     * @return retur n
     */
    private boolean canHandleKey(final int currentKeyCode) {
        return CommandType.getValue(currentKeyCode).isPresent();
    }

    /**
     * Traduce the key code to the respective command type.
     * 
     * @param keyCode the code to be traduced
     * @return the respective command type is present or an empty optional
     */
    public Optional<CommandType> translateKeyCode(final Integer keyCode) {
        if (canHandleKey(keyCode)) {
            return CommandType.getValue(keyCode);
        }
        return Optional.empty();
    }
}
