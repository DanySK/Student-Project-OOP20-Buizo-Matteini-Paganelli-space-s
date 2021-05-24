package spaceSurvival.model.command.concreteCommand;

import java.awt.geom.AffineTransform;

import spaceSurvival.model.command.commandInterfaces.CommandMovement;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.MovableGameObject;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;

public class RotateLeftCommand implements CommandMovement{
	
	public RotateLeftCommand() {}

	@Override
	public void execute(MovableGameObject obj) {
		System.out.println("Rotate Left");
		
		

		
		
		SpaceShipSingleton ship = (SpaceShipSingleton) obj;
		AffineTransform transform = ship.getTransform();
		//RectBoundingBox bbox = (RectBoundingBox) ship.getBoundingBox();
		//AffineTransform transform2 = bbox.getTransform();


		//double xCenter = (ship.getTransform().getTranslateX() ) + ship.getSize().getWidth() / 2;
		//double yCenter = (ship.getTransform().getTranslateY() ) + ship.getSize().getHeight() / 2;

		transform.rotate(Math.toRadians(-15), ship.getSize().getWidth() / 2, ship.getSize().getHeight() / 2);
		//transform2.rotate(Math.toRadians(-15), ship.getSize().getWidth() / 2, ship.getSize().getHeight() / 2);

		//bbox.getTransform().rotate(Math.toRadians(-15), Screen.POINT_CENTER_FULLSCREEN.getX(), Screen.POINT_CENTER_FULLSCREEN.getY());
		
		//RectBoundingBox bbox = (RectBoundingBox) ship.getBoundingBox();
		//transform.rotate(Math.toRadians(-15), bbox.getWidth(), bbox.getHeight());
		//System.out.println("Rotate Left" + bbox.toString());
		ship.setTransform(transform);

	}
	 
//		public static void main (String[] args) {
//			AffineTransform transform = new AffineTransform();
//			Rectangle rectangle = new Rectangle(30,50);
//			transform.rotate(Math.toRadians(45), rectangle.getX() + rectangle.width/2, rectangle.getY() + rectangle.height/2);
//			g2.fill(transformed);
//		}
 

	
	
}