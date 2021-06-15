package model.command.concreteCommand;

import model.command.commandInterfaces.CommandGameObject;
import model.common.V2d;
import model.gameObject.GameObjectUtils;
import model.gameObject.mainGameObject.SpaceShipSingleton;

public class UpReleaseCommand implements CommandGameObject {

    /** 
     * Decelerate the ship.
     * @param ship the controlled ship 
     * 
     */
    public void execute(final SpaceShipSingleton ship) {
        ship.setAcceleration(new V2d(0, GameObjectUtils.SPACESHIP_DECELERATION));	
    }
}
