package spaceSurvival.model.command.concreteCommand;

import spaceSurvival.model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.gameObject.GameObjectUtils;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spaceSurvival.model.common.V2d;

public class UpCommand implements CommandGameObject {

    @Override
    public void execute(final SpaceShipSingleton ship) {
        if (ship.getVelocity().getY() == GameObjectUtils.SPACESHIP_STARTING_VELOCITY) {
            final V2d vel = new V2d(ship.getVelocity().getX(), 1);
            ship.setVelocity(vel);
        }
        ship.setAcceleration(new V2d(ship.getAcceleration().getX(), GameObjectUtils.SPACESHIP_ACCELERATION));
    }
}
