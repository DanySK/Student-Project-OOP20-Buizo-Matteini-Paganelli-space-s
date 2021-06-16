package model.command.concreteCommand;

import model.command.commandInterfaces.CommandGameObject;
import model.gameObject.mainGameObject.SpaceShipSingleton;
import utilities.SoundPath;

public class SpaceBarCommand implements CommandGameObject {

    /** 
     * Fires the shot from the ship's weapon if it is present.
     * @param ship the controlled ship 
     * 
     */
    public void execute(final SpaceShipSingleton ship) {
        if (ship.getWeapon().isPresent()) {
            ship.getWeapon().get().shoot();
            ship.pushEffect(SoundPath.SHOOT);
        }	
    }
}
