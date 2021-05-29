package spaceSurvival.model.command.concreteCommand;

import java.awt.geom.AffineTransform;

import spaceSurvival.model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;


public class RotateRightCommand implements CommandGameObject{
	
	public RotateRightCommand() {}

	@Override
	public void execute(MainGameObject object) {
		System.out.println("Rotate Right");

		SpaceShipSingleton ship = (SpaceShipSingleton) object;
		AffineTransform transform = ship.getTransform();

		transform.rotate(Math.toRadians(15), ship.getSize().getWidth() / 2, ship.getSize().getHeight() / 2);
		ship.setTransform(transform);
	}
}