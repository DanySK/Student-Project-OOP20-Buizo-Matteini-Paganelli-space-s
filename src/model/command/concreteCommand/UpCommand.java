package model.command.concreteCommand;

import model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.gameObject.GameObjectUtils;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spaceSurvival.model.common.V2d;

public class UpCommand implements CommandGameObject {
    private static final double TOLLERANCE = 0.1;

    /** 
     * Accelerate the ship forward.
     * @param ship the controlled ship 
     * 
     */
    public void execute(final SpaceShipSingleton ship) {
        V2d vel = ship.getVelocity();
        if (vel.getY() > -TOLLERANCE && vel.getY() < TOLLERANCE) {
            vel = new V2d(vel.getX(), -1);
            ship.setVelocity(vel);
        }
        System.out.println(Math.abs(vel.getY()));
        if (Math.abs(vel.getY()) < GameObjectUtils.SPACESHIP_MAXVEL) {
            ship.setAcceleration(new V2d(ship.getAcceleration().getX(), GameObjectUtils.SPACESHIP_ACCELERATION));
        } else {
            ship.setAcceleration(new V2d(ship.getAcceleration().getX(), 1));
        }

    }
}