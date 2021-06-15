package model.command.concreteCommand;

import model.command.commandInterfaces.CommandGameObject;
import model.gameObject.GameObjectUtils;
import model.gameObject.MainGameObject;
import model.common.V2d;
import model.gameObject.mainGameObject.SpaceShipSingleton;

public class UpCommand implements CommandGameObject {
    private static final double TOLLERANCE = 0.1;

    @Override
    public void execute(final MainGameObject ship) {
        V2d vel = ship.getVelocity();
        if (vel.getY() > -TOLLERANCE && vel.getY() < TOLLERANCE) {
            vel = new V2d(vel.getX(), -1);
            ship.setVelocity(vel);
        }
        System.out.println(Math.abs(vel.getY()));
        if (Math.abs(vel.getY()) < GameObjectUtils.SPACESHIP_MAXVEL) {
            ((SpaceShipSingleton)ship).setAcceleration(new V2d(((SpaceShipSingleton)ship).getAcceleration().getX(), GameObjectUtils.SPACESHIP_ACCELERATION));
        } else {
            ((SpaceShipSingleton)ship).setAcceleration(new V2d(((SpaceShipSingleton)ship).getAcceleration().getX(), 1));
        }

    }
}