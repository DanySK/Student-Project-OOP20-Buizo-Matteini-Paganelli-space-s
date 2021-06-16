package model.command.concreteCommand;

import java.awt.geom.AffineTransform;
import model.command.commandInterfaces.CommandGameObject;
import model.gameObject.GameObjectUtils;
import model.gameObject.mainGameObject.SpaceShipSingleton;

public class RotateRightCommand implements CommandGameObject {

    /** 
     * Rotate right the ship.
     * @param ship the controlled ship 
     * 
     */

    @Override
    public void execute(final SpaceShipSingleton ship) {
        final AffineTransform transform = ship.getTransform();
        transform.rotate(Math.toRadians(GameObjectUtils.SPACESHIP_ROTATION), ship.getSize().getWidth() / 2, ship.getSize().getHeight() / 2);
        ship.setTransform(transform);
    }
}