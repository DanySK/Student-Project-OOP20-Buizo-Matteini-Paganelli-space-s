package spacesurvival.model.commandship;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Optional;
import spacesurvival.controller.CallerCommandShip;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;
import spacesurvival.utilities.CommandKey;


public class MovementKeyListener implements KeyListener {

    private final CallerCommandShip caller;

    /** 
     * Initialize the caller command.
     * 
     * @param ship SpaceShipSingleton the unique controlled ship
     */
    public MovementKeyListener(final SpaceShipSingleton ship) {
        caller = new CallerCommandShip(ship);
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
            final CommandKey cmd = translateKeyCode(pressedKeyCode).get();
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
            final CommandKey cmd = translateKeyCode(pressedKeyCode).get();
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
        return CommandKey.getValue(currentKeyCode).isPresent();
    }

    /**
     * Traduce the key code to the respective command type.
     * 
     * @param keyCode the code to be traduced
     * @return the respective command type is present or an empty optional
     */
    public Optional<CommandKey> translateKeyCode(final int keyCode) {
        if (canHandleKey(keyCode)) {
            return CommandKey.getValue(keyCode);
        }
        return Optional.empty();
    }
}
