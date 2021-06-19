package spacesurvival.model.command.implementation;

import spacesurvival.model.command.CommandGameObject;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;
import spacesurvival.utilities.path.SoundPath;

public class FireCommand implements CommandGameObject {
    /** 
     * Fires the shot from the ship's weapon if it is present.
     * 
     * @param ship the controlled ship
     */
    @Override
    public void execute(final SpaceShipSingleton ship) {
        ship.fire();
        ship.getSoundQueue().add(SoundPath.SHOOT);
    }
}
