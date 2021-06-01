package spaceSurvival.model.worldEcollisioni.physics.components;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import spaceSurvival.model.common.Line;
import spaceSurvival.model.common.P2d;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.CircleBoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import spaceSurvival.utilities.SystemVariables;

public class CollisionChecker {
	
	private static final double TOLLERANCE = 0;

	/** Rectangle To Point. */
	//RectBoundingBox rbb, P2d point
	public boolean testRectangleToPoint(RectBoundingBox rbb, P2d point) {
	    
		AffineTransform transform = new AffineTransform();
		transform.setTransform(rbb.getTransform());
		transform.translate(rbb.getWidth()/2, rbb.getHeight()/2);
	
		P2d rectCenter = new P2d(transform.getTranslateX(), transform.getTranslateY());
		double rotation = getRotationAngleInDegrees(rbb.getTransform());
		
		
		// Higher Efficiency for Rectangles with 0 rotation.
		if(rotation == 0) {
	        return Math.abs(rectCenter.getX()-point.getX()) < rbb.getWidth()/2 && Math.abs(rectCenter.getY()-point.getY()) < rbb.getHeight()/2;
		}
	    double tx = Math.cos(rotation)*point.getX() - Math.sin(rotation)*point.getY();
	    double ty = Math.cos(rotation)*point.getY() + Math.sin(rotation)*point.getX();

	    double cx = Math.cos(rotation)*rectCenter.getX() - Math.sin(rotation)*rectCenter.getY();
	    double cy = Math.cos(rotation)*rectCenter.getY() + Math.sin(rotation)*rectCenter.getX();

	    return Math.abs(cx-tx) < rbb.getWidth()/2 && Math.abs(cy-ty) < rbb.getHeight()/2; 
	}
	
	
	/** Rectangle To Point. */
//	boolean testRectangleToPoint(double rectWidth, double rectHeight, double rectRotation, double rectCenterX, double rectCenterY, double pointX, double pointY) {
//	    if(rectRotation == 0)   // Higher Efficiency for Rectangles with 0 rotation.
//	        return Math.abs(rectCenterX-pointX) < rectWidth/2 && Math.abs(rectCenterY-pointY) < rectHeight/2;
//
//	    double tx = Math.cos(rectRotation)*pointX - Math.sin(rectRotation)*pointY;
//	    double ty = Math.cos(rectRotation)*pointY + Math.sin(rectRotation)*pointX;
//
//	    double cx = Math.cos(rectRotation)*rectCenterX - Math.sin(rectRotation)*rectCenterY;
//	    double cy = Math.cos(rectRotation)*rectCenterY + Math.sin(rectRotation)*rectCenterX;
//
//	    return Math.abs(cx-tx) < rectWidth/2 && Math.abs(cy-ty) < rectHeight/2;
//	}

	/** Circle To Segment. */
	//CircleBoundingBox, Line 
	public boolean testCircleToSegment(CircleBoundingBox cbb, Line line) {
		
		double lineLength = line.getLineLength();
	    double distance;

	    if (lineLength == 0.0) {
	        distance = Math.sqrt(Math.pow(cbb.getCenter().getX()-line.getStartPoint().getX(), 2) + Math.pow(cbb.getCenter().getY()-line.getStartPoint().getY(), 2));
	        return distance < cbb.getRadius();
	    }

	    double u = ((cbb.getCenter().getX() - line.getStartPoint().getX()) * (line.getEndPoint().getX() - line.getStartPoint().getX()) + (cbb.getCenter().getY() - line.getStartPoint().getY()) * (line.getEndPoint().getY() - line.getStartPoint().getY())) / (lineLength * lineLength);

	    if (u < 0) {
	        distance = Math.sqrt(Math.pow(cbb.getCenter().getX()-line.getStartPoint().getX(), 2) + Math.pow(cbb.getCenter().getY()-line.getStartPoint().getY(), 2));
	    } else if (u > 1) {
	        distance = Math.sqrt(Math.pow(cbb.getCenter().getX()-line.getEndPoint().getX(), 2) + Math.pow(cbb.getCenter().getY()-line.getEndPoint().getY(), 2));
	    } else {
	        double ix = line.getStartPoint().getX() + u * (line.getEndPoint().getX() - line.getStartPoint().getX());
	        double iy = line.getStartPoint().getY() + u * (line.getEndPoint().getY() - line.getStartPoint().getY());
	        distance = Math.sqrt(Math.pow(cbb.getCenter().getX()-ix, 2) + Math.pow(cbb.getCenter().getY()-iy, 2));
	    }

	    return distance < cbb.getRadius();
	}
	
	
//	boolean testCircleToSegment(double circleCenterX, double circleCenterY, double circleRadius, double lineAX, double lineAY, double lineBX, double lineBY) {
//	    double lineSize = Math.sqrt(Math.pow(lineAX-lineBX, 2) + Math.pow(lineAY-lineBY, 2));
//	    double distance;
//
//	    if (lineSize == 0) {
//	        distance = Math.sqrt(Math.pow(circleCenterX-lineAX, 2) + Math.pow(circleCenterY-lineAY, 2));
//	        return distance < circleRadius;
//	    }
//
//	    double u = ((circleCenterX - lineAX) * (lineBX - lineAX) + (circleCenterY - lineAY) * (lineBY - lineAY)) / (lineSize * lineSize);
//
//	    if (u < 0) {
//	        distance = Math.sqrt(Math.pow(circleCenterX-lineAX, 2) + Math.pow(circleCenterY-lineAY, 2));
//	    } else if (u > 1) {
//	        distance = Math.sqrt(Math.pow(circleCenterX-lineBX, 2) + Math.pow(circleCenterY-lineBY, 2));
//	    } else {
//	        double ix = lineAX + u * (lineBX - lineAX);
//	        double iy = lineAY + u * (lineBY - lineAY);
//	        distance = Math.sqrt(Math.pow(circleCenterX-ix, 2) + Math.pow(circleCenterY-iy, 2));
//	    }
//
//	    return distance < circleRadius;
//	}		AffineTransform transform = rbb.getTransform();
	//transform.translate(rbb.getWidth()/2, rbb.getHeight()/2);
	
	//P2d rectCenter = new P2d(transform.getTranslateX(), transform.getTranslateY());
	
//	public boolean testRectangleToCircle(RectBoundingBox rbb, CircleBoundingBox cbb) {
//		
//		AffineTransform transform = new AffineTransform();
//		transform.setTransform(rbb.getTransform());
//
//		transform.translate(rbb.getWidth()/2, rbb.getHeight()/2);
//	
//		P2d rectCenter = new P2d(transform.getTranslateX(), transform.getTranslateY());
//		double rotation = getRotationAngleInDegrees(rbb.getTransform());
//		
//		double tx, ty, cx, cy;
//
//	    if(rotation == 0.0) { // Higher Efficiency for Rectangles with 0 rotation.
//	        tx = cbb.getCenter().getX();
//	        ty = cbb.getCenter().getY();
//
//	        cx = rectCenter.getX();
//	        cy = rectCenter.getY();
//	    } else {
//	        tx = Math.cos(rotation)*cbb.getCenter().getX() - Math.sin(rotation)*cbb.getCenter().getY();
//	        ty = Math.cos(rotation)*cbb.getCenter().getY() + Math.sin(rotation)*cbb.getCenter().getX();
//
//	        cx = Math.cos(rotation)*rectCenter.getX() - Math.sin(rotation)*rectCenter.getY();
//	        cy = Math.cos(rotation)*rectCenter.getY() + Math.sin(rotation)*rectCenter.getX();
//	    }
//	    
//	    
//	    return testRectangleToPoint(rbb, new P2d(cbb.getCenter().getX(), cbb.getCenter().getY())) || 
//	    		testCircleToSegment(cbb, new Line(new P2d(cx-rbb.getWidth()/2, cy+rbb.getHeight()/2), new P2d(cx+rbb.getWidth()/2, cy+rbb.getHeight()/2))) ||
//	    		testCircleToSegment(cbb, new Line(new P2d(cx+rbb.getWidth()/2, cy+rbb.getHeight()/2), new P2d(cx+rbb.getWidth()/2, cy-rbb.getHeight()/2))) ||
//	    		testCircleToSegment(cbb, new Line(new P2d(cx+rbb.getWidth()/2, cy-rbb.getHeight()/2), new P2d(cx-rbb.getWidth()/2, cy-rbb.getHeight()/2))) ||
//	    		testCircleToSegment(cbb, new Line(new P2d(cx-rbb.getWidth()/2, cy-rbb.getHeight()/2), new P2d(cx-rbb.getWidth()/2, cy+rbb.getHeight()/2)));
//	}
	 
//	public boolean testRectangleToCircle(RectBoundingBox rbb, CircleBoundingBox cbb) {
//		
//		AffineTransform transform = new AffineTransform();
//		transform.setTransform(rbb.getTransform());
//
//		transform.translate(rbb.getWidth()/2, rbb.getHeight()/2);
//	
//		P2d rectCenter = new P2d(transform.getTranslateX(), transform.getTranslateY());
//		double rotation = getRotationAngleInDegrees(rbb.getTransform());
//		
//		double tx, ty, cx, cy;
//
//	    if(rotation == 0.0) { // Higher Efficiency for Rectangles with 0 rotation.
//	        tx = cbb.getCenter().getX();
//	        ty = cbb.getCenter().getY();
//
//	        cx = rectCenter.getX();
//	        cy = rectCenter.getY();
//	    } else {
//	        tx = Math.cos(rotation)*cbb.getCenter().getX() - Math.sin(rotation)*cbb.getCenter().getY();
//	        ty = Math.cos(rotation)*cbb.getCenter().getY() + Math.sin(rotation)*cbb.getCenter().getX();
//
//	        cx = Math.cos(rotation)*rectCenter.getX() - Math.sin(rotation)*rectCenter.getY();
//	        cy = Math.cos(rotation)*rectCenter.getY() + Math.sin(rotation)*rectCenter.getX();
//	    }
//	    
//	    
//	    return false;
//	}
	
	public boolean testRectangleToCircle(RectBoundingBox rbb, CircleBoundingBox cbb) {
		

		//Rectangle2D rectangle = new Rectangle2D.Double(rbb.getTransform().getTranslateX(), rbb.getTransform().getTranslateY(), rbb.getWidth(), rbb.getHeight());
//		Rectangle2D rectangle = new Rectangle2D.Double(rbb.getTransform().getTranslateX(), rbb.getTransform().getTranslateY(), rbb.getWidth(), rbb.getHeight());
//		AffineTransform rectTransform = new AffineTransform();
//		rectTransform.setTransform(rbb.getTransform());
//		Shape rotatedRect = rectTransform.createTransformedShape(rectangle);
//		
//		//Ellipse2D myCircle = new Ellipse2D()
//		Ellipse2D ellipse = new Ellipse2D.Double(cbb.getCenter().getX(), cbb.getCenter().getY(), 50, 50);
//		AffineTransform circleTransform = new AffineTransform();
//		circleTransform.setTransform(cbb.getTransform());
//		Shape rotatedEllipse = circleTransform.createTransformedShape(ellipse);	
//		
//		Area areaA = new Area(rotatedRect);
//		Area areaB = new Area(rotatedEllipse);
//		
		
		//areaB.getBounds2D().intersects(areaA.getBounds2D());
		
	//	areaA.subtract(areaB);
		
		Rectangle2D rectangle = new Rectangle2D.Double(0,0, rbb.getWidth() * SystemVariables.SCALE_X, rbb.getHeight() * SystemVariables.SCALE_Y);
 		AffineTransform rectTransform = new AffineTransform();
 		rectTransform.setTransform(rbb.getTransform());
 		//rectTransform.rotate(this.getRotationAngleInRadiant(rbb.getTransform()), rbb.getWidth()/2, rbb.getHeight()/2);
		Shape rotatedRect = rectTransform.createTransformedShape(rectangle);
		
		System.out.println(cbb.getRadius());
		Ellipse2D ellipse = new Ellipse2D.Double(0,0, ( cbb.getRadius() - TOLLERANCE) * SystemVariables.SCALE_X, (cbb.getRadius() - TOLLERANCE));
 		AffineTransform circleTransform = new AffineTransform();
 		circleTransform.setTransform(cbb.getTransform());
 		circleTransform.rotate(this.getRotationAngleInRadiant(cbb.getTransform()));
		//circleTransform.setTransform(cbb.getTransform());
		Shape rotatedEllipse = circleTransform.createTransformedShape(ellipse);	
		
		
		
		//return rotatedRect.intersects(rotatedEllipse);
		return rotatedEllipse.intersects(rotatedRect.getBounds2D());
	
		//PROVA OGGI 
//		Rectangle2D rectangle = new Rectangle2D.Double(rbb.getTransform().getTranslateX(),rbb.getTransform().getTranslateY(), rbb.getWidth(), rbb.getHeight());
// 		AffineTransform rectTransform = new AffineTransform();
// 		rectTransform.rotate(this.getRotationAngleInRadiant(rbb.getTransform()), rbb.getWidth()/2, rbb.getHeight()/2);
//		Shape rotatedRect = rectTransform.createTransformedShape(rectangle);
//		
//		
//		Ellipse2D ellipse = new Ellipse2D.Double(cbb.getTransform().getTranslateX(),cbb.getTransform().getTranslateY(), 50, 50);
// 		AffineTransform circleTransform = new AffineTransform();
// 		circleTransform.rotate(this.getRotationAngleInRadiant(cbb.getTransform()), cbb.getRadius(), cbb.getRadius());
//		//circleTransform.setTransform(cbb.getTransform());
//		Shape rotatedEllipse = circleTransform.createTransformedShape(ellipse);	
//		
//		
//		
//		//return rotatedRect.intersects(rotatedEllipse);
//		return rotatedEllipse.getBounds2D().intersects(rotatedRect.getBounds2D());
		//PROVA OGGI 
		
//		Area areaA = new Area(rotatedRect);
//		Area areaB = new Area(rotatedEllipse);
//		
//		
//		return false;
//		
//		System.out.println("areaA ->" + areaA.isEmpty());
//		System.out.println("areaB ->" + areaB.isEmpty());
//		areaA.intersect(areaB);
//		//areaA.in
//		return !areaA.isEmpty();		
		
		
//		Area areaA = new Area(rotatedRect);
//		Area areaB = new Area(rotatedEllipse);
//		
//		System.out.println("areaA ->" + areaA.isEmpty());
//		System.out.println("areaB ->" + areaB.isEmpty());
//		areaA.intersect(areaB);
//		//areaA.in
//		return !areaA.isEmpty();
		
//		Area areaB = new Area(rotatedEllipse);
// 
//		   areaA.intersect(areaB);
//		   areaA.
//		  //areaA.subtract(areaB);
//		   return !areaA.isEmpty();
		
		
		//areaB.getBounds2D().intersects(areaA.getBounds2D());
		
	//	areaA.subtract(areaB);
		
		//return areaB.getBounds2D().intersects(areaA.getBounds2D());
				
//				new Rectangle2D.Double(rbb.getTransform().getTranslateX(), rbb.getTransform().getTranslateY(), rbb.getWidth(), rbb.getHeight());
//		AffineTransform at = new AffineTransform();
//		at.setTransform(rbb.getTransform());
//		Shape rotatedRect = at.createTransformedShape(myRect);
		
		
//		
 		
//		   
//		   
//		   areaA.intersect(new Area(shapeB));
//		   return !areaA.isEmpty();
//		return false;
		}

	/** Rectangle To Circle. */
//	boolean testRectangleToCircle(double rectWidth, double rectHeight, double rectRotation, double rectCenterX, double rectCenterY, double circleCenterX, double circleCenterY, double circleRadius) {
//
//		double tx, ty, cx, cy;
//
//	    if(rectRotation == 0) { // Higher Efficiency for Rectangles with 0 rotation.
//	        tx = circleCenterX;
//	        ty = circleCenterY;
//
//	        cx = rectCenterX;
//	        cy = rectCenterY;
//	    } else {
//	        tx = Math.cos(rectRotation)*circleCenterX - Math.sin(rectRotation)*circleCenterY;
//	        ty = Math.cos(rectRotation)*circleCenterY + Math.sin(rectRotation)*circleCenterX;
//
//	        cx = Math.cos(rectRotation)*rectCenterX - Math.sin(rectRotation)*rectCenterY;
//	        cy = Math.cos(rectRotation)*rectCenterY + Math.sin(rectRotation)*rectCenterX;
//	    }
//
//	    return testRectangleToPoint(rectWidth, rectHeight, rectRotation, rectCenterX, rectCenterY, circleCenterX, circleCenterY) ||
//	            testCircleToSegment(tx, ty, circleRadius, cx-rectWidth/2, cy+rectHeight/2, cx+rectWidth/2, cy+rectHeight/2) ||
//	            testCircleToSegment(tx, ty, circleRadius, cx+rectWidth/2, cy+rectHeight/2, cx+rectWidth/2, cy-rectHeight/2) ||
//	            testCircleToSegment(tx, ty, circleRadius, cx+rectWidth/2, cy-rectHeight/2, cx-rectWidth/2, cy-rectHeight/2) ||
//	            testCircleToSegment(tx, ty, circleRadius, cx-rectWidth/2, cy-rectHeight/2, cx-rectWidth/2, cy+rectHeight/2);
//	}
	
	public boolean testRectangleToRectangle(RectBoundingBox rbb1, RectBoundingBox rbb2) {
		
		return false;
//		AffineTransform transform = new AffineTransform();
//		transform.setTransform(rbb.getTransform());
//
//		transform.translate(rbb.getWidth()/2, rbb.getHeight()/2);
//	
//		P2d rectCenter = new P2d(transform.getTranslateX(), transform.getTranslateY());
//		double rotation = getRotationAngleInDegrees(rbb.getTransform());
//		
//		double tx, ty, cx, cy;
//
//	    if(rotation == 0.0) { // Higher Efficiency for Rectangles with 0 rotation.
//	        tx = cbb.getCenter().getX();
//	        ty = cbb.getCenter().getY();
//
//	        cx = rectCenter.getX();
//	        cy = rectCenter.getY();
//	    } else {
//	        tx = Math.cos(rotation)*cbb.getCenter().getX() - Math.sin(rotation)*cbb.getCenter().getY();
//	        ty = Math.cos(rotation)*cbb.getCenter().getY() + Math.sin(rotation)*cbb.getCenter().getX();
//
//	        cx = Math.cos(rotation)*rectCenter.getX() - Math.sin(rotation)*rectCenter.getY();
//	        cy = Math.cos(rotation)*rectCenter.getY() + Math.sin(rotation)*rectCenter.getX();
//	    }
//	    
//	    
//	    return testRectangleToPoint(rbb, new P2d(cbb.getCenter().getX(), cbb.getCenter().getY())) || 
//	    		testCircleToSegment(cbb, new Line(new P2d(cx-rbb.getWidth()/2, cy+rbb.getHeight()/2), new P2d(cx+rbb.getWidth()/2, cy+rbb.getHeight()/2))) ||
//	    		testCircleToSegment(cbb, new Line(new P2d(cx+rbb.getWidth()/2, cy+rbb.getHeight()/2), new P2d(cx+rbb.getWidth()/2, cy-rbb.getHeight()/2))) ||
//	    		testCircleToSegment(cbb, new Line(new P2d(cx+rbb.getWidth()/2, cy-rbb.getHeight()/2), new P2d(cx-rbb.getWidth()/2, cy-rbb.getHeight()/2))) ||
//	    		testCircleToSegment(cbb, new Line(new P2d(cx-rbb.getWidth()/2, cy-rbb.getHeight()/2), new P2d(cx-rbb.getWidth()/2, cy+rbb.getHeight()/2)));
	}
	

	public double getRotationAngleInDegrees(AffineTransform transform) {
		double m00 = transform.getScaleX();
		double m01 = transform.getShearX();

		return Math.round(Math.toDegrees(Math.atan2(-m01, m00)));
	}
	
	public double getRotationAngleInRadiant(AffineTransform transform) {
		double m00 = transform.getScaleX();
		double m01 = transform.getShearX();
		
		return Math.round(Math.atan2(-m01, m00));
	}
	
 
//	
//	public static void main (String[] args) {
//		CollisionChecker checker = new CollisionChecker();
//		AffineTransform a = new AffineTransform();
//		//a.rotate(Math.toRadians(30));
//		System.out.println(checker.getRotationAngleInDegrees(a));
//		System.out.println(checker.getRotationAngleInRadiant(a));
//		
//		
//		
//		RectBoundingBox rbox = new RectBoundingBox(new P2d(0,0), new P2d(10,10), a);
//		rbox.getTransform().rotate(Math.toDegrees(0), rbox.getWidth(), rbox.getHeight());
//		System.out.println(rbox.getTransform());
//		P2d point = new P2d(5,5);
//		
//		System.out.println(checker.testRectangleToPoint(rbox, point));
//		
//		
//	}

}
