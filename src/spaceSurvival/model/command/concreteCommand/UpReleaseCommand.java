package spaceSurvival.model.command.concreteCommand;

import spaceSurvival.model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.GameObjectUtils;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;

public class UpReleaseCommand implements CommandGameObject {

    @Override
    public void execute(final SpaceShipSingleton ship) {
        ship.setAcceleration(new V2d(0, GameObjectUtils.SPACESHIP_DECELERATION));	
    }
}
