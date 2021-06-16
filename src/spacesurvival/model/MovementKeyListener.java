package spacesurvival.model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Optional;

import spacesurvival.controller.CallerCommand;
import spacesurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spacesurvival.utilities.CommandType;


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
        if (canHandleKey(pressedKeyCode)) {
            final CommandType cmd = translateKeyCode(pressedKeyCode).get();
            this.caller.execute(cmd);
        }
    }

    @Override
    public void keyReleased(final KeyEvent e) {
        final int pressedKeyCode = e.getKeyCode();
        if (canHandleKey(pressedKeyCode)) {
            final CommandType cmd = translateKeyCode(pressedKeyCode).get();
            this.caller.release(cmd);
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
