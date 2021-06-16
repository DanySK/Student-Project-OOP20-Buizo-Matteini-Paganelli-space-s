package spacesurvival.model.collisioni.physics.component;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import spacesurvival.model.collisioni.physics.bounding.CircleBoundingBox;
import spacesurvival.model.collisioni.physics.bounding.RectBoundingBox;
import spacesurvival.model.common.Line;
import spacesurvival.model.common.P2d;
import spacesurvival.utilities.SystemVariables;

public class CollisionChecker {

    private static final double TOLLERANCE = 0;

    public boolean testRectangleToPoint(final RectBoundingBox rbb, final P2d point) {
        return false;
    }	

    public boolean testCircleToSegment(final CircleBoundingBox cbb, final Line line) {
        return false;
    }

    public boolean testRectangleToRectangle(final RectBoundingBox rbb1, final RectBoundingBox rbb2) {

	final Rectangle2D rectangle1 = new Rectangle2D.Double(0, 0, rbb1.getWidth(), rbb1.getHeight());
 	final AffineTransform rectTransform1 = new AffineTransform();
 	rectTransform1.setTransform(rbb1.getTransform());
	final Shape rotatedRect1 = rectTransform1.createTransformedShape(rectangle1);

	final Rectangle2D rectangle2 = new Rectangle2D.Double(0, 0, rbb2.getWidth(), rbb2.getHeight());
 	final AffineTransform rectTransform2 = new AffineTransform();
 	rectTransform2.setTransform(rbb2.getTransform());
	final Shape rotatedRect2 = rectTransform2.createTransformedShape(rectangle2);

	return rotatedRect1.intersects(rotatedRect2.getBounds2D());
    }
	

    public boolean testRectangleToCircle(final RectBoundingBox rbb, final CircleBoundingBox cbb) {

        final Rectangle2D rectangle = new Rectangle2D.Double(0, 0, rbb.getWidth(), rbb.getHeight());
        final AffineTransform rectTransform = new AffineTransform();
        rectTransform.setTransform(rbb.getTransform());
        final Shape rotatedRect = rectTransform.createTransformedShape(rectangle);

        final Ellipse2D ellipse = new Ellipse2D.Double(-cbb.getRadius(), -cbb.getRadius(), (cbb.getRadius() - TOLLERANCE) * SystemVariables.SCALE_X, 
                (cbb.getRadius() - TOLLERANCE) * SystemVariables.SCALE_Y);
        final AffineTransform circleTransform = new AffineTransform();
        circleTransform.setTransform(cbb.getTransform());
        circleTransform.rotate(this.getRotationAngleInRadiant(cbb.getTransform()));
        final Shape rotatedEllipse = circleTransform.createTransformedShape(ellipse);	

        return rotatedEllipse.intersects(rotatedRect.getBounds2D());
    }

 
    public double getRotationAngleInDegrees(final AffineTransform transform) {
        final double m00 = transform.getScaleX();
        final double m01 = transform.getShearX();

        return Math.round(Math.toDegrees(Math.atan2(-m01, m00)));
    }
	
    public double getRotationAngleInRadiant(final AffineTransform transform) {
        final double m00 = transform.getScaleX();
        final double m01 = transform.getShearX();

        return Math.round(Math.atan2(-m01, m00));
    }
	
 
//	
//	public static void main (String[] args) {
//		CollisionChecker checker = new CollisionChecker();
//		AffineTransform a = new AffineTransform();
//		//a.rotate(Math.toRadians(30));
//		System.out.println(checker.getRotationAngleInDegrees(a));
//		System.out.println(checker.getRotationAngleInRadiant(a));

//		RectBoundingBox rbox = new RectBoundingBox(new P2d(0,0), new P2d(10,10), a);
//		rbox.getTransform().rotate(Math.toDegrees(0), rbox.getWidth(), rbox.getHeight());
//		System.out.println(rbox.getTransform());
//		P2d point = new P2d(5,5);

//		System.out.println(checker.testRectangleToPoint(rbox, point));
//	}

}
