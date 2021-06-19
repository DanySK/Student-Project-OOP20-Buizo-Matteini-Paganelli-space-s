package spacesurvival.utilities.dimension;

import java.awt.geom.AffineTransform;

/**
 * Class for the utils methods for the AffineTransform.
 */
public final class AffineUtils {

    /**
     * Method that return the angle in degrees readed from an AffineTransform.
     * 
     * @param transform AffineTransform from which to read the angle
     * @return the angle in degrees
     */
    public static double getRotationAngleInDegrees(final AffineTransform transform) {
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
    public static double getRotationAngleInRadiant(final AffineTransform transform) {
        final double m00 = transform.getScaleX();
        final double m01 = transform.getShearX();

        return Math.round(Math.atan2(-m01, m00));
    }

    private AffineUtils() {

    }
}
