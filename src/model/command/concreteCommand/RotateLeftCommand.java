package model.command.concreteCommand;

import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

import model.command.commandInterfaces.CommandMovement;
import model.gameObject.MovableGameObject;
import model.gameObject.mainGameObject.SpaceShipSingleton;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import utilities.dimension.Screen;

public class RotateLeftCommand implements CommandMovement{
	
	public RotateLeftCommand() {}

	@Override
	public void execute(MovableGameObject obj) {
		System.out.println("Rotate Left");
		
		

		
		
		SpaceShipSingleton ship = (SpaceShipSingleton) obj;
		AffineTransform transform = ship.getTransform();

		RectBoundingBox bbox = (RectBoundingBox) ship.getBoundingBox();
		
		
		//double xCenter = (ship.getTransform().getTranslateX() ) + ship.getSize().getWidth() / 2;
		//double yCenter = (ship.getTransform().getTranslateY() ) + ship.getSize().getHeight() / 2;

		transform.rotate(Math.toRadians(-15), ship.getSize().getWidth() / 2, ship.getSize().getHeight() / 2);
		//bbox.getTransform().rotate(Math.toRadians(-15), Screen.POINT_CENTER_FULLSCREEN.getX(), Screen.POINT_CENTER_FULLSCREEN.getY());
		
		//RectBoundingBox bbox = (RectBoundingBox) ship.getBoundingBox();
		//transform.rotate(Math.toRadians(-15), bbox.getWidth(), bbox.getHeight());
		System.out.println("Rotate Left" + bbox.toString());
		ship.setTransform(transform);

	}
	 
//		public static void main (String[] args) {
//			AffineTransform transform = new AffineTransform();
//			Rectangle rectangle = new Rectangle(30,50);
//			transform.rotate(Math.toRadians(45), rectangle.getX() + rectangle.width/2, rectangle.getY() + rectangle.height/2);
//			g2.fill(transformed);
//		}
 

	
	
}