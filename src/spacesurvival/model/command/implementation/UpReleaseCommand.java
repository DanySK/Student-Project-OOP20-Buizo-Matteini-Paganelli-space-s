package spacesurvival.model.command.implementation;

import spacesurvival.model.command.CommandGameObject;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;
import spacesurvival.utilities.gameobject.VelocityUtils;

public class UpReleaseCommand implements CommandGameObject {

    /** 
     * Decelerate the ship.
     * 
     * @param ship the controlled ship 
     */
    public void execute(final SpaceShipSingleton ship) {
        ship.setAcceleration(VelocityUtils.SPACESHIP_DECELERATION);
    }
}
