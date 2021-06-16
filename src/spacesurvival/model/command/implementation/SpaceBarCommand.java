package spacesurvival.model.command.implementation;

import spacesurvival.model.command.CommandGameObject;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;
import spacesurvival.utilities.path.SoundPath;

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
