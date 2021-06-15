package model.worldEcollisioni.physics.components;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import model.common.Line;
import model.common.P2d;
import model.worldEcollisioni.physics.boundingType.CircleBoundingBox;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import utilities.SystemVariables;

public class CollisionChecker {
	
 
	//private static final double TOLLERANCE = 1.5 * SystemVariables.SCALE_X;
 
	private static final double TOLLERANCE = 0;
 

 
	//RectBoundingBox rbb, P2d point
	public boolean testRectangleToPoint(RectBoundingBox rbb, P2d point) {
	    
		return false;
	}
	

	//CircleBoundingBox, Line 
	public boolean testCircleToSegment(CircleBoundingBox cbb, Line line) {
		

	    return false;
	}
	
	
	public boolean testRectangleToRectangle(RectBoundingBox rbb1, RectBoundingBox rbb2) {

		Rectangle2D rectangle1 = new Rectangle2D.Double(0,0, rbb1.getWidth(), rbb1.getHeight());
 		AffineTransform rectTransform1 = new AffineTransform();
 		rectTransform1.setTransform(rbb1.getTransform());
		Shape rotatedRect1 = rectTransform1.createTransformedShape(rectangle1);
		
		Rectangle2D rectangle2 = new Rectangle2D.Double(0,0, rbb2.getWidth(), rbb2.getHeight());
 		AffineTransform rectTransform2 = new AffineTransform();
 		rectTransform2.setTransform(rbb2.getTransform());
		Shape rotatedRect2 = rectTransform2.createTransformedShape(rectangle2);

		return rotatedRect1.intersects(rotatedRect2.getBounds2D());
		}
	
	
	
	public boolean testRectangleToCircle(RectBoundingBox rbb, CircleBoundingBox cbb) {

		Rectangle2D rectangle = new Rectangle2D.Double(0,0, rbb.getWidth(), rbb.getHeight());
 		AffineTransform rectTransform = new AffineTransform();
 		rectTransform.setTransform(rbb.getTransform());
		Shape rotatedRect = rectTransform.createTransformedShape(rectangle);
		
		Ellipse2D ellipse = new Ellipse2D.Double(-cbb.getRadius(),-cbb.getRadius(), (cbb.getRadius() - TOLLERANCE) * SystemVariables.SCALE_X, (cbb.getRadius() - TOLLERANCE) * SystemVariables.SCALE_Y);
 		AffineTransform circleTransform = new AffineTransform();
 		circleTransform.setTransform(cbb.getTransform());
 		circleTransform.rotate(this.getRotationAngleInRadiant(cbb.getTransform()));
		Shape rotatedEllipse = circleTransform.createTransformedShape(ellipse);	

		return rotatedEllipse.intersects(rotatedRect.getBounds2D());
		}

 
	

	public double getRotationAngleInDegrees(AffineTransform transform) {
		double m00 = transform.getScaleX();
		double m01 = transform.getShearX();

		return Math.round(Math.toDegrees(Math.atan2(-m01, m00)));
	}
	
	public double getRotationAngleInRadiant(AffineTransform transform) {
		double m00 = transform.getScaleX();
		double m01 = transform.getShearX();
		
		return Math.round(Math.atan2(-m01, m00));
	}
	
 
//	
//	public static void main (String[] args) {
//		CollisionChecker checker = new CollisionChecker();
//		AffineTransform a = new AffineTransform();
//		//a.rotate(Math.toRadians(30));
//		System.out.println(checker.getRotationAngleInDegrees(a));
//		System.out.println(checker.getRotationAngleInRadiant(a));
//		
//		
//		
//		RectBoundingBox rbox = new RectBoundingBox(new P2d(0,0), new P2d(10,10), a);
//		rbox.getTransform().rotate(Math.toDegrees(0), rbox.getWidth(), rbox.getHeight());
//		System.out.println(rbox.getTransform());
//		P2d point = new P2d(5,5);
//		
//		System.out.println(checker.testRectangleToPoint(rbox, point));
//		
//		
//	}

}
