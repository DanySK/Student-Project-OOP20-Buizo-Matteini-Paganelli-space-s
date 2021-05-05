package model.worldEcollisioni.physics;

import model.common.P2d;
import model.common.V2d;

public class RectBoundingBox implements BoundingBox {

	private P2d p0,p1;
	
	public RectBoundingBox(P2d p0, P2d p1){
		this.p0 = p0;
		this.p1 = p1;
	}
	
	public P2d getULCorner(){
		return p0;
	}
	
	public P2d getBRCorner(){
		return p1;
	}
	
	public double getWidth(){
		return this.p0.getX() - this.p1.getX();
	}
	
	public double getHeight(){
		return this.p0.getY() - this.p1.getY();
	}
	
	/**
	 * @TODO to be implemented
	 * Il raggio sarà il lato.
	 */
	public boolean isCollidingWith(P2d p, double radius){
		
		
		
		System.out.println(p.toString());
			//boolean returnn = 
					//new V2d(p,radius).module() <= radius+this.radius;
			
			
		
		
		
//		if (ball.getX() + ball.getR() >= rect.getTheLeft() &&
//			    ball.getX() - ball.getR() <= rect.getTheRight() &&
//			    ball.getY() - ball.getR() <= rect.getTheBottom() &&
//			    ball.getY() + ball.getR() >= rect.getTheTop())
//			{
//			    intersects = true;
//			}
		
		//System.out.println("check the collision");
		return false;
	}
	
	public static void main (String[] args) {
		System.out.println("Ciao collisioni");
		
		RectBoundingBox r1 = new RectBoundingBox(new P2d(0,0), new P2d(10,10));
		RectBoundingBox r2 = new RectBoundingBox(new P2d(5,5), new P2d(15,15));
		
		System.out.println(r1.toString());
		System.out.println(r2.toString());
		r1.isCollidingWith(r1.getULCorner(), 10);

		
		System.out.println(r1.isCollidingWith(r1.getULCorner(), 10));
		
	}
}
	
	


