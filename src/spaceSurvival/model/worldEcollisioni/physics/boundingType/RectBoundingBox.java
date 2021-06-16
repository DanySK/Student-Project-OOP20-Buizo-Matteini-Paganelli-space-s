package spaceSurvival.model.worldEcollisioni.physics.boundingType;

import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

import spaceSurvival.model.common.P2d;
import spaceSurvival.utilities.SystemVariables;
import spaceSurvival.model.EngineImage;

public class RectBoundingBox implements BoundingBox {
    private P2d p0, p1;
    private AffineTransform transform;
    private double width, height;
	
    public RectBoundingBox() {

        this.p0 = new P2d(0, 0);
        this.p1 = new P2d(0, 0);
        this.transform = new AffineTransform();
    }
	
    public RectBoundingBox(final P2d p0, final P2d p1, final AffineTransform transform) {

        this();
        this.p0 = p0;
        this.p1 = p1;
        this.width = Math.abs(this.p1.getX() - this.p0.getX());
        this.height = Math.abs(this.p1.getY() - this.p0.getY());
        this.transform = transform;
        this.transform.setToTranslation(p0.getX(), p0.getY());
    }
	
    public RectBoundingBox(final P2d center, final EngineImage engineImage, final AffineTransform transform) {

        this.p0 = new P2d(center.getX() - (engineImage.getWidth() / 2), center.getY() - (engineImage.getHeight() / 2));
        this.p1 = new P2d(center.getX() + (engineImage.getWidth() / 2), center.getY() + (engineImage.getHeight() / 2));
        this.width = engineImage.getWidth();
        this.height = engineImage.getHeight();
        this.transform = transform;
        this.transform.setToTranslation(center.getX() - (engineImage.getWidth() / 2), center.getY() - (engineImage.getHeight() / 2));
    }

    public RectBoundingBox(final Rectangle rectangle) {

        this.p0 = new P2d(rectangle.getX(), rectangle.getY());
        this.p1 = new P2d(rectangle.getWidth() * SystemVariables.SCALE_X, rectangle.getHeight() * SystemVariables.SCALE_Y);
        this.width = rectangle.getWidth();
        this.height = rectangle.getHeight();
        this.transform = new AffineTransform();
    }
	
    public P2d getULCorner() {
        return this.p0;
    }
	
    public P2d getBRCorner() {
        return this.p1;
    }
	
    public double getWidth() {
        return this.width;
    }
	
    public double getHeight() {
        return this.height;
    }

    @Override
    public AffineTransform getTransform() {
        return this.transform;
    }
	
    @Override
    public void setTransform(final AffineTransform transform) { 
        this.transform.setTransform(transform); 
	
        final AffineTransform trans = new AffineTransform();
        trans.setTransform(transform);
        this.p0 = new P2d(trans.getTranslateX(), trans.getTranslateY());
        trans.translate(this.width, this.height);
        this.p1 = new P2d(trans.getTranslateX(), trans.getTranslateY());
    }
	
	/**
	 * @TODO to be implemented
	 * Il raggio sarà il lato.
	 */
	@Override
    public boolean isCollidingWith(final P2d p, final double radius) {

	if (p.getX() <= this.getULCorner().getX() + this.getWidth() 
	&&  p.getY() <= this.getULCorner().getY() + this.getHeight()) {
	        return true;
	}
		return false;
    }

    @Override
    public String toString() {
        return "RectBoundingBox [p0=" + this.p0 + ", p1=" + this.p1 + "]";
    }
}