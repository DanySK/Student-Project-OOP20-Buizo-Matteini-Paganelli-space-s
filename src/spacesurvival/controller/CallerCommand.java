package spacesurvival.controller;

import spacesurvival.model.command.implementation.FireCommand;
import spacesurvival.model.command.CommandGameObject;
import spacesurvival.model.command.implementation.RotateLeftCommand;
import spacesurvival.model.command.implementation.RotateRightCommand;
import spacesurvival.model.command.implementation.UpCommand;
import spacesurvival.model.command.implementation.UpReleaseCommand;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;
import spacesurvival.utilities.CommandType;

public class CallerCommand {
    private final CommandGameObject cmdUp;
    private final CommandGameObject cmdReleaseUp;
    private final CommandGameObject cmdRotateLeft;
    private final CommandGameObject cmdRotateRight;
    private final CommandGameObject cmdShot;

    private final SpaceShipSingleton ship;


    /** 
     * Contructor for CallerCommand, inizialize a new CallerCommand for the spaceship.
     * 
     * @param ship ship on which to execute the commands.
     */
    public CallerCommand(final SpaceShipSingleton ship) {
        this.cmdUp = new UpCommand();
        this.cmdReleaseUp = new UpReleaseCommand();
        this.cmdRotateLeft = new RotateLeftCommand();
        this.cmdRotateRight = new RotateRightCommand();
        this.cmdShot = new FireCommand();
        this.ship = ship;
    }

    /** 
     * Read the passed command and execute the command on the specified concrete command. 
     * 
     * @param cmd the command to execute
     */
    public void execute(final CommandType cmd) {
        switch (cmd) {
        case KEY_UP:
            cmdUp.execute(ship);
            break;
        case KEY_W:
            cmdUp.execute(ship);
            break;
        case KEY_LEFT:
            cmdRotateLeft.execute(ship);
            break;
        case KEY_A:
            cmdRotateLeft.execute(ship);
            break;
        case KEY_RIGHT:
            cmdRotateRight.execute(ship);
            break;
        case KEY_D:
            cmdRotateRight.execute(ship);
            break;
        case KEY_SPACE_BAR:
            cmdShot.execute(ship);
            break;
        default:
            break;
        }
    }

    /** 
     * Read the release event and and execute the command on the specified concrete command. 
     * 
     * @param cmd the command to execute
     */
    public void release(final CommandType cmd) {
        switch (cmd) {
        case KEY_UP:
            cmdReleaseUp.execute(ship);
            break;
        case KEY_W:
            cmdReleaseUp.execute(ship);
            break;
        default:
            break;
        }
    }
}
