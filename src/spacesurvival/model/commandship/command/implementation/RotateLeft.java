package spacesurvival.model.commandship.command.implementation;

import java.awt.geom.AffineTransform;

import spacesurvival.model.commandship.command.CommandShip;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;
import spacesurvival.utilities.gameobject.VelocityUtils;

public class RotateLeft implements CommandShip {

    /** 
     * Rotate left the ship.
     * 
     * @param ship the controlled ship 
     */
    @Override
    public void execute(final SpaceShipSingleton ship) {
        final AffineTransform transform = ship.getTransform();
        transform.rotate(Math.toRadians(-VelocityUtils.SPACESHIP_ROTATION), ship.getSize().getWidth() / 2, ship.getSize().getHeight() / 2);
        ship.setTransform(transform);
    }
}
