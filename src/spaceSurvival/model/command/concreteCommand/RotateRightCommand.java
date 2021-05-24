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
		//double xCenter = (ship.getTransform().getTranslateX() ) + ship.getSize().getWidth() / 2;
		//double yCenter = (ship.getTransform().getTranslateY() ) + ship.getSize().getHeight() / 2;

		transform.rotate(Math.toRadians(15), ship.getSize().getWidth() / 2, ship.getSize().getHeight() / 2);
		//transform2.rotate(Math.toRadians(-15), ship.getSize().getWidth() / 2, ship.getSize().getHeight() / 2);

		//bbox.getTransform().rotate(Math.toRadians(-15), Screen.POINT_CENTER_FULLSCREEN.getX(), Screen.POINT_CENTER_FULLSCREEN.getY());

		//RectBoundingBox bbox = (RectBoundingBox) ship.getBoundingBox();
		//transform.rotate(Math.toRadians(-15), bbox.getWidth(), bbox.getHeight());
		//System.out.println("Rotate Left" + bbox.toString());
		ship.setTransform(transform);
	}
}