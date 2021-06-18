package spacesurvival.model.collision;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import spacesurvival.model.collision.physics.bounding.CircleBoundingBox;
import spacesurvival.model.collision.physics.bounding.RectBoundingBox;
import spacesurvival.utilities.SystemVariables;

/**
 * CollisionChecker class created to check for collisions between transformed 
 * shapes and consider the rotation angle.
 *
 */
public class CollisionChecker {

    private static final double TOLLERANCE = 0;

    /**
     * Returns true if the two rect bounding boxes collide.
     * 
     * @param rbb1 first RectBoundingBox to check
     * @param rbb2 second RectBoundingBox to check
     * @return true if the two RectBoundingboxes collide
     */
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

    /**
     * Returns true if the rect bounding box collide with the circle bounding box.
     * 
     * @param rbb RectBoundingBox to check
     * @param cbb CircleBoundingBox to check
     * @return true if the two RectBoundingboxes collide
     */
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

    /**
     * Method that return the angle in degrees readed from an AffineTransform.
     * 
     * @param transform AffineTransform from which to read the angle
     * @return the angle in degrees
     */
    public double getRotationAngleInDegrees(final AffineTransform transform) {
        final double m00 = transform.getScaleX();
        final double m01 = transform.getShearX();

        return Math.round(Math.toDegrees(Math.atan2(-m01, m00)));
    }

    /**
     * Method that return the angle in radiants readed from an AffineTransform.
     * 
     * @param transform AffineTransform from which to read the angle
     * @return the angle in radiants
     */
    public double getRotationAngleInRadiant(final AffineTransform transform) {
        final double m00 = transform.getScaleX();
        final double m01 = transform.getShearX();

        return Math.round(Math.atan2(-m01, m00));
    }

    /**
     * Return a string describing the types of collisions that can be checked.
     * 
     * @return a string describing the collision
     */
    @Override
    public String toString() {
        return "Collision checker {Rectangle to Rectangle, Rectangle to Circle}";
    }
}