package spaceSurvival.model.gameObject;

import spaceSurvival.model.common.P2d;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.movement.Movement;
import spaceSurvival.model.ImageDesign;
import spaceSurvival.model.command.caller.CallerMovement;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.PhysicsComponent;

import java.awt.geom.AffineTransform;

public abstract class MovableGameObject extends GameObject {
	private V2d velocity;
	private Movement movement;
	private CallerMovement caller;
	
	public MovableGameObject() {
		super(new ImageDesign(), new P2d(0, 0), null, null);
		this.velocity = new V2d();
		this.movement = null;
	}
	
	public MovableGameObject(final ImageDesign imageDesign, final P2d position, final BoundingBox bb,
							 final PhysicsComponent phys, final V2d velocity, final Movement movement) {
		super(imageDesign, position, bb, phys);
		this.velocity = velocity;
		this.movement = movement;
	}
	
	public void move() {
		this.movement.move(caller);
	}
	
	public void draw() {
		//this.getTransform().translate(this.getVelocity().getX(), this.getVelocity().getY());
		//this.setPosition(this.getPosition().sum(this.getVelocity()));
		AffineTransform at = this.getTransform();
		//at.transform()
		at.translate(this.getVelocity().getX(), this.getVelocity().getY());
		this.setTransform(this.getTransform());

		//this.getTransform().translate(this.getVelocity().getX(), this.getVelocity().getY());
		//this.getBoundingBox().getTransform()
		//RectBoundingBox bbox = (RectBoundingBox) this.getBoundingBox();
		//bbox.getTransform().translate(this.getVelocity().getX(), this.getVelocity().getY());

		//System.out.println("RectBoundingBox -->" + this.getBoundingBox());
		//System.out.println("SpaceShip Position -->" + this.getPosition());
		//System.out.println("SpaceShip transform -->" + this.getTransform());

		RectBoundingBox bbox2 = (RectBoundingBox) this.getBoundingBox();
		//System.out.println("RectBoundingBox transform -->" + bbox2.getTransform());






//		double x = this.getTransform().getTranslateX();
//		double y = this.getTransform().getTranslateY();
//
//
//		AffineTransform newAff = new AffineTransform();
//        newAff.setToTranslation(x, y);
//        double m00 = this.getTransform().getScaleX();
//        double m01 = this.getTransform().getShearX();
//        
//        double angle = Math.atan2(-m01, m00);
//        
//        
//        newAff.rotate(angle, this.getSize().getWidth() / 2, this.getSize().getHeight() / 2);
//        
//        bbox.setTransform(newAff);
        

		//BoundingBox newBox = new RectBoundingBox(new P2d(x,y), new P2d(x + this.getSize().getWidth(),y + this.getSize().getHeight()));
		//RectBoundingBox newBox = new RectBoundingBox(new P2d(x,y), new P2d(x + this.getSize().getWidth(), y + this.getSize().getHeight()));
		//BoundingBox newBox = new RectBoundingBox(new P2d(this.getPosition().getX(),this.getPosition().getY()), this.getEngineImage());

		//RectBoundingBox rectBB = (RectBoundingBox) newBox;
		//newBox.setTransform(this.getTransform());
		//this.setBoundingBox(bbox);
	}

	public V2d getVelocity() {
		return velocity;
	}

	public void setVelocity(V2d velocity) {
		this.velocity = velocity;
	}

	public Movement getMovement() {
		return movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}
	

	public CallerMovement getCaller() {
		return caller;
	}

	public void setCaller(CallerMovement caller) {
		this.caller = caller;
	}
	
	@Override
	public String toString() {
		return "MovableGameObject [velocity=" + velocity + ", movement=" + movement + ", "
				+ "transform=" + super.getTransform() + ", " + super.toString() +  "]";
	}
}
