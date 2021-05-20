package spaceSurvival.model.gameObject;

import spaceSurvival.model.common.P2d;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.image.EngineImage;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.PhysicsComponent;

public abstract class MovableGameObject extends GameObject {
	private V2d velocity;
	private Movement movement;
	

	
	public MovableGameObject() {
		super(new EngineImage(), new P2d(0, 0), null, null);
		this.velocity = new V2d();
		this.movement = null;
	}
	
	public MovableGameObject(final EngineImage engineImage, final P2d position, final BoundingBox bb,
			final PhysicsComponent phys, final V2d velocity, final Movement movement) {
		super(engineImage, position, bb, phys);
		this.velocity = velocity;
		this.movement = movement;
	}
	
	public void move() {
		//this.getTransform().translate(this.getVelocity().getX(), this.getVelocity().getY());
		//this.setPosition(this.getPosition().sum(this.getVelocity()));
		
		this.getTransform().translate(this.getVelocity().getX(), this.getVelocity().getY());
		//this.getBoundingBox().getTransform()
		RectBoundingBox bbox = (RectBoundingBox) this.getBoundingBox();
		bbox.getTransform().translate(this.getVelocity().getX(), this.getVelocity().getY());
		
		System.out.println(this.getTransform());

		System.out.println(bbox.getTransform());


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
	

	@Override
	public String toString() {
		return "MovableGameObject [velocity=" + velocity + ", movement=" + movement + ", "
				+ "transform=" + super.getTransform() + ", " + super.toString() +  "]";
	}
	
}
