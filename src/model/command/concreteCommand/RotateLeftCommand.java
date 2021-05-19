package model.command.concreteCommand;

import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

import model.command.commandInterfaces.CommandMovement;
import model.gameObject.MainGameObject;
import model.gameObject.mainGameObject.SpaceShipSingleton;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;

public class RotateLeftCommand implements CommandMovement{
	
	public RotateLeftCommand() {}

	@Override
	public void execute(MainGameObject obj) {
		System.out.println("Rotate Left");
		
		

		
		
		SpaceShipSingleton ship = (SpaceShipSingleton) obj;
		AffineTransform transform = ship.getTransform();

		RectBoundingBox bbox = (RectBoundingBox) ship.getBoundingBox();
		
		
		//double xCenter = (ship.getTransform().getTranslateX() ) + ship.getSize().getWidth() / 2;
		//double yCenter = (ship.getTransform().getTranslateY() ) + ship.getSize().getHeight() / 2;	

		transform.rotate(Math.toRadians(-15), ship.getSize().getWidth() / 2, ship.getSize().getHeight() / 2);

		ship.setTransform(transform);

	}
	 
//		public static void main (String[] args) {
//			AffineTransform transform = new AffineTransform();
//			Rectangle rectangle = new Rectangle(30,50);
//			transform.rotate(Math.toRadians(45), rectangle.getX() + rectangle.width/2, rectangle.getY() + rectangle.height/2);
//			g2.fill(transformed);
//		}
 

	
	
}