package spaceSurvival.model.worldEcollisioni.physics.boundingType;

import spaceSurvival.model.common.*;

import java.awt.geom.AffineTransform;

public class CircleBoundingBox implements BoundingBox{

	private P2d center;
	private double radius;
	AffineTransform transform;

	public CircleBoundingBox(){
		this.center = new P2d(0, 0);
		this.radius = 0;
	}
	
	public CircleBoundingBox(P2d center, double radius){
		this.center = center;
		this.radius = radius;
	}

	public AffineTransform getTransform(){
		return this.transform;
	}
	public void setTransform(AffineTransform transform){ this.transform.setTransform(transform); }

	public double getRadius(){
		return radius;
	}
	
	public boolean isCollidingWith(P2d p, double radius){
		return new V2d(p,center).module() <= radius+this.radius;		
	}
}
