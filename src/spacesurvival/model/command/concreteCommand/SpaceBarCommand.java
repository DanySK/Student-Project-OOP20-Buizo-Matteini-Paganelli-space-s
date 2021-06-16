package spacesurvival.model.command.concreteCommand;

import spacesurvival.model.command.commandInterfaces.CommandGameObject;
import spacesurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spacesurvival.utilities.SoundPath;

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
