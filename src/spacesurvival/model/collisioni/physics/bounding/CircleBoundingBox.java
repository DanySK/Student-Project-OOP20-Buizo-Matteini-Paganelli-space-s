package spacesurvival.model.collisioni.physics.bounding;

import spacesurvival.model.common.P2d;

import java.awt.geom.AffineTransform;

public class CircleBoundingBox implements BoundingBox {
    private final P2d center;
    private final double radius;
    private final AffineTransform transform;

    /**
     * Constructor for new simple CircleBoundingBox, composed by the a center in (0,0), a radius setted to 0 and an AffineTransform.
     * 
     */
    public CircleBoundingBox() {
        this.center = new P2d(0, 0);
        this.radius = 0;
        this.transform = new AffineTransform();
    }

    /**
     * Constructor for new simple CircleBoundingBox, composed by the a center in (0,0), a radius setted to 0 and an AffineTransform.
     * 
     * @param center P2d rapresenting the center of the CircleBoundingBox.
     * @param radius double rapresenting the radius of the CircleBoundingBox.
     * @param transform an affine to set the transformation.
     */
    public CircleBoundingBox(final P2d center, final double radius, final AffineTransform transform) {
        this.center = new P2d(0, 0);
        this.center.x = center.getX();
        this.center.y = center.getY();
        this.radius = radius;
        this.transform = transform;
    }

    /**
     * Return the transform of the CircleBoundingBox.
     * @return the transform of the box.
     */
    public AffineTransform getTransform() {
        return this.transform;
    }

    /**
     * Set the transformation to the CircleBoundingBox.
     * @param transform the transformation to be set in the circle bound.
     */
    public void setTransform(final AffineTransform transform) {
        this.transform.setTransform(transform);
    }

    /**
     * Return the radius of the CircleBoundingBox.
     * @return the radius of the circle.
     */
    public double getRadius() {
        return this.radius;
    }

    /**
     * Return a P2d representing the center of the CircleBoundingBox.
     * @return the center of the circle.
     */
    public P2d getCenter() {
        return this.center;
    }

    /** 
     * Return a string rapresenting the CircleBoudingBox.
     * @return return the string.
     */
    public String toString() {
        return "CircleBoundingBox [radius=" + this.radius + ", center=" + this.center.toString() + ", transform=" + this.transform.toString() + "]";
    }
}
