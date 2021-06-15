package model.command.concreteCommand;

import java.awt.geom.AffineTransform;
import model.command.commandInterfaces.CommandGameObject;
import model.gameObject.GameObjectUtils;
import model.gameObject.MainGameObject;

public class RotateRightCommand implements CommandGameObject {

    @Override
    public void execute(final MainGameObject ship) {
        final AffineTransform transform = ship.getTransform();
        transform.rotate(Math.toRadians(GameObjectUtils.SPACESHIP_ROTATION), ship.getSize().getWidth() / 2, ship.getSize().getHeight() / 2);
        ship.setTransform(transform);
    }
}