package spaceSurvival.model.gameObject;

import java.awt.Dimension;
import java.awt.geom.AffineTransform;

import spaceSurvival.model.common.P2d;
import spaceSurvival.model.EngineImage;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.PhysicsComponent;
import spaceSurvival.model.World;


public abstract class GameObject {
	private EngineImage engineImage;
	private P2d position;
	private BoundingBox boundingBox;

	private PhysicsComponent phys;
	private AffineTransform transform;
	
	
	public GameObject(final EngineImage engineImage, final P2d position, final BoundingBox bb,
                      final PhysicsComponent phys) {
		this.engineImage = engineImage;	
		this.boundingBox = bb;
		this.phys = phys;
		this.position = position;
		this.transform = new AffineTransform();
		this.setPosition(position);
	}
	
	public AffineTransform getTransform() {
		return transform;
	}

	public void setTransform(AffineTransform transform) {
		this.transform.setTransform(transform);
		//RectBoundingBox rectBB = (RectBoundingBox) this.getBoundingBox();
		//rectBB.setTransform(transform);
		this.position.x = transform.getTranslateX();
		this.position.y = transform.getTranslateY();

		this.boundingBox.setTransform(transform);
	}
	
	
	public EngineImage getEngineImage() {
		return engineImage;
	}
	
	public P2d getPosition() {
		return new P2d(this.transform.getTranslateX(), this.getTransform().getTranslateY());
	}

	public void setPosition(P2d position) {
		AffineTransform newTransform = new AffineTransform();
		newTransform.translate(position.getX(), position.getY());
		
		this.transform.setTransform(newTransform);
		
		this.boundingBox.setTransform(newTransform);
	}
	
	public BoundingBox getBoundingBox() {
		return boundingBox;
	}


	public void setBoundingBox(BoundingBox boundingBox) {
		this.boundingBox = boundingBox;
	}

	public void setEngineImage(EngineImage engineImage) {
		this.engineImage = engineImage;
	}


	public PhysicsComponent getPhys() {
		return phys;
	}

	public void setPhys(PhysicsComponent phys) {
		this.phys = phys;
	}

	
//	public void setScale(int scaleOf, int respectTo) {
//	this.engineImage.setScaleOfRespect(scaleOf, respectTo);
//}
	
	public void updatePhysics(int dt, World w){
		phys.update(dt, this, w);
	}
	
	public Dimension getSize() {
		return this.getEngineImage().getSize();
	}

	@Override
	public String toString() {
		return "GameObject [engineImage=" + engineImage + ", position=" + position + ", boundingBox=" + boundingBox
				+ ", phys=" + phys + "]";
	}

}
