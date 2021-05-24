package spaceSurvival.model.worldEcollisioni.physics.boundingType;

import spaceSurvival.model.common.*;

import java.awt.geom.AffineTransform;

public class CircleBoundingBox implements BoundingBox {

	private P2d center;
	private double radius;
	AffineTransform transform;

	public CircleBoundingBox() {
		this.center = new P2d(0, 0);
		this.radius = 0;
		this.transform = new AffineTransform();
	}

	public CircleBoundingBox(final P2d center, final double radius, final AffineTransform transform) {
		this.center = center;
		this.radius = radius;
		this.transform = transform;
	}

	public boolean isCollidingWith(final P2d p, final double radius) {
		return new V2d(p,center).module() <= radius+this.radius;
	}

	public AffineTransform getTransform() {
		return this.transform;
	}
	
	public void setTransform(final AffineTransform transform) {
		System.out.println(this.transform);
		this.transform.setTransform(transform);
	}

	public double getRadius() {
		return radius;
	}
	
	public P2d getCenter() {
		return center;
	}

}
