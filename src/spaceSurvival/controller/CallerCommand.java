package spacesurvival.controller;

import spacesurvival.model.command.concreteCommand.SpaceBarCommand;
import spacesurvival.model.command.commandInterfaces.CommandGameObject;
import spacesurvival.model.command.concreteCommand.RotateLeftCommand;
import spacesurvival.model.command.concreteCommand.RotateRightCommand;
import spacesurvival.model.command.concreteCommand.UpCommand;
import spacesurvival.model.command.concreteCommand.UpReleaseCommand;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;
import spacesurvival.utilities.CommandType;

public class CallerCommand {

    private final CommandGameObject cmdUp;
    private final CommandGameObject cmdReleaseUp;
    private final CommandGameObject cmdRotateLeft;
    private final CommandGameObject cmdRotateRight;	
    private final CommandGameObject cmdShot;

    private final SpaceShipSingleton ship;
	
	
    public CallerCommand(final SpaceShipSingleton ship) {
        this.cmdUp = new UpCommand();
        this.cmdReleaseUp = new UpReleaseCommand();
        this.cmdRotateLeft = new RotateLeftCommand();
        this.cmdRotateRight = new RotateRightCommand();
        this.cmdShot = new SpaceBarCommand();
        this.ship = ship;
    }
	
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
