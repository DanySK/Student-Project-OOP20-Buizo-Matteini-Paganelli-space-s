package spacesurvival.model.command.concreteCommand;

import spacesurvival.model.command.commandInterfaces.CommandGameObject;
import spacesurvival.model.common.V2d;
import spacesurvival.model.gameObject.GameObjectUtils;
import spacesurvival.model.gameObject.mainGameObject.SpaceShipSingleton;

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
