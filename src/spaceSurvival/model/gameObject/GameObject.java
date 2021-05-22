package spaceSurvival.model.gameObject;

import java.awt.Dimension;
import java.awt.geom.AffineTransform;

import spaceSurvival.model.common.P2d;
import spaceSurvival.model.ImageDesign;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.PhysicsComponent;
import spaceSurvival.model.World;


public abstract class GameObject {
	private ImageDesign imageDesign;
	private P2d position;
	private BoundingBox boundingBox;

	private PhysicsComponent phys;
	private AffineTransform transform;
	
	//DA CAMBIARE, SARà L'ENUM DEGLI STATI DEGLI OGGETTI
	private String state = "NORMAL";
	
	public GameObject(final ImageDesign imageDesign, final P2d position, final BoundingBox bb,
					  final PhysicsComponent phys) {
		this.imageDesign = imageDesign;
		this.position = position;
		this.boundingBox = bb;
		this.phys = phys;
		this.transform = new AffineTransform();
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
	
	
	public ImageDesign getEngineImage() {
		return imageDesign;
	}
	
	public P2d getPosition() {
		return new P2d(this.transform.getTranslateX(), this.getTransform().getTranslateY());
	}

	public void setPosition(P2d position) {
		AffineTransform newTransform = new AffineTransform();
		newTransform.translate(position.getX(), position.getY());
		this.transform = newTransform;
		
		//this.position = position;
	}
	
	public BoundingBox getBoundingBox() {
		return boundingBox;
	}


	public void setBoundingBox(BoundingBox boundingBox) {
		this.boundingBox = boundingBox;
	}

	public void setEngineImage(ImageDesign imageDesign) {
		this.imageDesign = imageDesign;
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
	
	public String getState(){
		return this.state;
	}
	
	public void setState(String state){
		this.state = state;
	}
	
	public Dimension getSize() {
		return this.getEngineImage().getSize();
	}

	@Override
	public String toString() {
		return "GameObject [engineImage=" + imageDesign + ", position=" + position + ", boundingBox=" + boundingBox
				+ ", phys=" + phys + ", state=" + state + "]";
	}

}
