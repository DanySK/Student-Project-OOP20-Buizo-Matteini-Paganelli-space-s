package model.command.concreteCommand;

import java.awt.geom.AffineTransform;

import model.command.commandInterfaces.CommandMovement;
import model.gameObject.MovableGameObject;
import model.gameObject.mainGameObject.SpaceShipSingleton;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import utilities.dimension.Screen;


public class RotateRightCommand implements CommandMovement{
	
	public RotateRightCommand() {}

	@Override
	public void execute(MovableGameObject obj) {
		System.out.println("Rotate Right");
		
//		System.out.println(obj);
//		
//		SpaceShipSingleton ship = (SpaceShipSingleton) obj;
//		AffineTransform transform = ship.getTransform();
//		//transform.rotate(Math.toRadians(15));
//		//transform.rotate(Math.toRadians(15), ship.getSize().getHeight() / 2, ship.getSize().getWidth() / 2);
//		
//				//, ship.getSize().getHeight() / 2, ship.getSize().getWidth() / 2);
//		transform.rotate(Math.toRadians(15));
//		System.out.println(ship.getTransform());
//		//transform.rotate
//		//transform.rotate(Math.toRadians(-15));
//		ship.setTransform(transform);
//		
//		System.out.println(ship.toString());
		
		
//		SpaceShipSingleton ship = (SpaceShipSingleton) obj;
//		AffineTransform transform = ship.getTransform();
//
//		RectBoundingBox bbox = (RectBoundingBox) ship.getBoundingBox();
//		
//		
//		double xCenter = (ship.getTransform().getTranslateX() ) + ship.getSize().getWidth() / 2;
//		double yCenter = (ship.getTransform().getTranslateY() ) + ship.getSize().getHeight() / 2;	
//
//		
//		System.out.println("xCenter" + ship.getSize().getWidth() / 2);
//		System.out.println("yCenter" + ship.getSize().getHeight() / 2);
//		
//		System.out.println("ScaleX" + transform.getScaleX());
//		
//		
//		transform.rotate(Math.toRadians(15), ship.getSize().getWidth() / 2, 50);
//
//		ship.setTransform(transform); 
		SpaceShipSingleton ship = (SpaceShipSingleton) obj;
		AffineTransform transform = ship.getTransform();

		RectBoundingBox bbox = (RectBoundingBox) ship.getBoundingBox();
		
		
		//double xCenter = (ship.getTransform().getTranslateX() ) + ship.getSize().getWidth() / 2;
		//double yCenter = (ship.getTransform().getTranslateY() ) + ship.getSize().getHeight() / 2;	

		transform.rotate(Math.toRadians(15), ship.getSize().getWidth() / 2, ship.getSize().getHeight() / 2);

		ship.setTransform(transform);
	}
}