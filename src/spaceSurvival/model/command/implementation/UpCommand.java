package spacesurvival.model.command.implementation;

import spacesurvival.model.command.CommandGameObject;
import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;
import spacesurvival.model.common.V2d;

public class UpCommand implements CommandGameObject {
    private static final double TOLLERANCE = 0.1;

    @Override
    public void execute(final SpaceShipSingleton ship) {

        V2d vel = ship.getVelocity();
        if (vel.getY() > -TOLLERANCE && vel.getY() < TOLLERANCE) {
            vel = new V2d(vel.getX(), -1);
            ship.setVelocity(vel);
        }
        ship.setAcceleration(new V2d(ship.getAcceleration().getX(), GameObjectUtils.SPACESHIP_ACCELERATION));
    }
}
