package spaceSurvival.model.command.concreteCommand;

import java.awt.geom.AffineTransform;

import spaceSurvival.model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.gameObject.GameObjectUtils;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;


public class RotateRightCommand implements CommandGameObject {

	@Override
	public void execute(final SpaceShipSingleton ship) {

		final AffineTransform transform = ship.getTransform();

		transform.rotate(Math.toRadians(GameObjectUtils.SPACESHIP_ROTATION), ship.getSize().getWidth() / 2, ship.getSize().getHeight() / 2);
		ship.setTransform(transform);
	}
}