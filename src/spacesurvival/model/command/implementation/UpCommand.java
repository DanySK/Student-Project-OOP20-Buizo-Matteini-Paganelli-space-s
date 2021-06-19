package spacesurvival.model.command.implementation;

import spacesurvival.model.command.CommandGameObject;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;
import spacesurvival.utilities.gameobject.VelocityUtils;
import spacesurvival.model.common.V2d;

public class UpCommand implements CommandGameObject {

    /** 
     * Accelerate the ship forward.
     * 
     * @param ship the controlled ship 
     */
    @Override
    public void execute(final SpaceShipSingleton ship) {
        V2d vel = ship.getVelocity();
        if (Math.abs(vel.getY()) < VelocityUtils.SPACESHIP_TOLLERANCE_RESTART) {
            vel = new V2d(vel.getX(), -VelocityUtils.SPACESHIP_STARTING_VEL);
            ship.setVelocity(vel);
        }
        ship.setAcceleration(VelocityUtils.SPACESHIP_ACCELERATION);
    }
}
