package spaceSurvival.model.worldEcollisioni.physics.boundingType;

import java.awt.*;
import java.awt.geom.AffineTransform;

import spaceSurvival.model.common.P2d;
import spaceSurvival.model.EngineImage;

public class RectBoundingBox implements BoundingBox {

	private P2d p0,p1;
	private AffineTransform transform;
	private double width, height;
	
	public RectBoundingBox(){
		this.p0 = new P2d(0, 0);
		this.p1 = new P2d(0, 0);
		this.transform = new AffineTransform();
	}
	
	public RectBoundingBox(P2d p0, P2d p1){
		this();
		this.p0 = p0;
		this.p1 = p1;
		this.width = Math.abs(this.p1.getX() - this.p0.getX());
		this.height = Math.abs(this.p1.getY() - this.p0.getY());
		this.transform = new AffineTransform();
		this.transform.setToTranslation(p0.getX(), p0.getY());
	}
	
	public RectBoundingBox(P2d center, EngineImage engineImage){
		
		this.p0 = new P2d(center.getX() - (engineImage.getWidth() / 2), center.getY() - (engineImage.getHeight() / 2));
		this.p1 = new P2d(center.getX() + (engineImage.getWidth() / 2), center.getY() + (engineImage.getHeight() / 2));
		this.width = engineImage.getWidth();
		this.height = engineImage.getHeight();
		
		this.transform = new AffineTransform();
		this.transform.setToTranslation(center.getX() - (engineImage.getWidth() / 2), center.getY() - (engineImage.getHeight() / 2));
			
	}

	public RectBoundingBox(final Rectangle rectangle){
		this.p0 = new P2d(rectangle.getX(), rectangle.getY());
		this.p1= new P2d(rectangle.getWidth(), rectangle.getHeight());
		this.width = rectangle.getWidth();
		this.height = rectangle.getHeight();
		this.transform = new AffineTransform();
	}
	
	public P2d getULCorner(){
		return this.p0;
	}
	
	public P2d getBRCorner(){
		return this.p1;
	}
	
	

	public double getWidth(){
		
		//return Math.abs(this.p1.getX() - this.p0.getX());
		return this.width;
			
		//DA RIMUOVERE DISTANZA FRA DUE PUNTI.
		//return Math.sqrt(Math.pow(this.p1.getX() - this.p0.getX(), 2) + Math.pow(this.p1.getY() - this.p0.getY(), 2));
	}
	
	public double getHeight(){
		//return Math.abs(this.p1.getY() - this.p0.getY());
		return this.height;
	}
	
	public AffineTransform getTransform(){
		return this.transform;
	}
	public void setTransform(AffineTransform transform){ 
		this.transform.setTransform(transform); 
	
		AffineTransform trans = new AffineTransform();
		trans.setTransform(transform);
		
		this.p0 = new P2d(trans.getTranslateX(), trans.getTranslateY());
		trans.translate(this.width, this.height);
		this.p1 = new P2d(trans.getTranslateX(), trans.getTranslateY());
		
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
		return "RectBoundingBox [p0=" + this.p0 + ", p1=" + this.p1 + "]";
	}


	
//	public static void main (String[] args) {
//		System.out.println("Ciao collisioni");
//
//		RectBoundingBox r1 = new RectBoundingBox(new P2d(0,0), new P2d(10,10));
//		RectBoundingBox r2 = new RectBoundingBox(new P2d(7,7), new P2d(15,15));
//
//
//		//System.out.println(r1.isCollidingWith(r2.getULCorner(), 10));
//
//	}
}
	
	


