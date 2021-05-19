package model.worldEcollisioni.physics.boundingType;

import java.awt.geom.AffineTransform;

import model.common.P2d;
import model.image.EngineImage;

public class RectBoundingBox implements BoundingBox {

	private P2d p0,p1;
	private AffineTransform transform;
	
	public RectBoundingBox(){
		this.p0 = new P2d(0, 0);
		this.p1 = new P2d(0, 0);
		this.transform = new AffineTransform();
	}
	
	public RectBoundingBox(P2d p0, P2d p1){
		this();
		this.p0 = p0;
		this.p1 = p1;
		this.transform = new AffineTransform();
	}
	
	public RectBoundingBox(P2d center, EngineImage engineImage){
		
		this.p0 = new P2d(center.getX() - engineImage.getWidth() / 2, center.getY() - engineImage.getHeight() / 2);
		this.p1 = new P2d(center.getX() + engineImage.getWidth() / 2, center.getY() + engineImage.getHeight() / 2);
		this.transform = new AffineTransform();
			
	}
	
	public P2d getULCorner(){
		return p0;
	}
	
	public P2d getBRCorner(){
		return p1;
	}
	
	public double getWidth(){
		return this.p1.getX() - this.p0.getX();
	}
	
	public double getHeight(){
		return this.p1.getY() - this.p0.getY();
	}
	
	public AffineTransform getTransform(){
		return this.transform;
	}
	
	public void setTransform(AffineTransform affineTranform){
		this.transform = affineTranform;
	}
	
	/**
	 * @TODO to be implemented
	 * Il raggio sarà il lato.
	 */
	public boolean isCollidingWith(P2d p, double radius){
		
		if(p.getX() <= this.getULCorner().getX() + this.getWidth() && 
				p.getY() <= this.getULCorner().getY() + this.getHeight()) {
			//System.out.println("return true");
			return true;
		}
			
//		if (this.getULCorner().getX() + this.getWidth() >= p.getX() &&
//			    ball.getX() - ball.getR() <= rect.getTheRight() &&
//			    ball.getY() - ball.getR() <= rect.getTheBottom() &&
//			    ball.getY() + ball.getR() >= rect.getTheTop())
//			{
//			    intersects = true;
//			}
//		

		return false;
	}

	@Override
	public String toString() {
		return "RectBoundingBox [p0=" + p0 + ", p1=" + p1 + "]";
	}

	//TEST
	
	public static void main (String[] args) {
		System.out.println("Ciao collisioni");
		
		RectBoundingBox r1 = new RectBoundingBox(new P2d(0,0), new P2d(10,10));
		RectBoundingBox r2 = new RectBoundingBox(new P2d(7,7), new P2d(15,15));
		
		
		//System.out.println(r1.isCollidingWith(r2.getULCorner(), 10));
		
	}
}
	
	


