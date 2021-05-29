package spaceSurvival.model.command.concreteCommand;

import java.awt.geom.AffineTransform;

import spaceSurvival.model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;

public class RotateLeftCommand implements CommandGameObject{
	
	public RotateLeftCommand() {}

	@Override
	public void execute(MainGameObject object) {
		System.out.println("Rotate Left");
		
		SpaceShipSingleton ship = (SpaceShipSingleton) object;
		AffineTransform transform = ship.getTransform();

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