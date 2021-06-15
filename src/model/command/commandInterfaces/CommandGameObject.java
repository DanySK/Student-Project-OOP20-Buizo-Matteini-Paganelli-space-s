package model.command.commandInterfaces;

import model.gameObject.mainGameObject.SpaceShipSingleton;

public interface CommandGameObject {
    /** 
     * Execute the specified command on the ship.
     * @param ship the controlled ship 
     * 
     */
    void execute(SpaceShipSingleton ship);
}