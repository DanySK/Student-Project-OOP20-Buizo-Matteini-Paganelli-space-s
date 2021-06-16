package spacesurvival.model.command;

import spacesurvival.model.gameobject.main.SpaceShipSingleton;

public interface CommandGameObject {
    /** 
     * Execute the specified command on the ship.
     * @param ship the controlled ship 
     * 
     */
    void execute(SpaceShipSingleton ship);
}
