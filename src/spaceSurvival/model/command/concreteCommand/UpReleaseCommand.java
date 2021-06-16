package spacesurvival.model.command.concreteCommand;

import spacesurvival.model.command.commandInterfaces.CommandGameObject;
import spacesurvival.model.common.V2d;
import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;

public class UpReleaseCommand implements CommandGameObject {

    @Override
    public void execute(final SpaceShipSingleton ship) {
        ship.setAcceleration(new V2d(0, GameObjectUtils.SPACESHIP_DECELERATION));	
    }
}
