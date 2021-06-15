package model.command.concreteCommand;

import java.awt.geom.AffineTransform;

import model.command.commandInterfaces.CommandGameObject;
import model.gameObject.GameObjectUtils;
import model.gameObject.MainGameObject;

public class RotateLeftCommand implements CommandGameObject {
	
    @Override
    public void execute(final MainGameObject ship) {
        final AffineTransform transform = ship.getTransform();
        transform.rotate(Math.toRadians(-GameObjectUtils.SPACESHIP_ROTATION), ship.getSize().getWidth() / 2, ship.getSize().getHeight() / 2);
        ship.setTransform(transform);
    }

//		public static void main (String[] args) {
//			AffineTransform transform = new AffineTransform();
//			Rectangle rectangle = new Rectangle(30,50);
//			transform.rotate(Math.toRadians(45), rectangle.getX() + rectangle.width/2, rectangle.getY() + rectangle.height/2);
//			g2.fill(transformed);
//		}
 
}