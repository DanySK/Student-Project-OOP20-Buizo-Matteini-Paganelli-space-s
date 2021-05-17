package model.gameObject;

import java.awt.Dimension;

import model.common.P2d;
import model.image.EngineImage;
import model.worldEcollisioni.physics.boundingType.BoundingBox;
import model.worldEcollisioni.physics.components.PhysicsComponent;
import model.world.World;


public abstract class GameObject {
	private EngineImage engineImage;
	private P2d position;
	private BoundingBox boundingBox;

	private PhysicsComponent phys;
	
	//DA CAMBIARE, SARà L'ENUM DEGLI STATI DEGLI OGGETTI
	private String state = "NORMAL";
	
	public GameObject(final EngineImage engineImage, final P2d position, final BoundingBox bb,
			final PhysicsComponent phys) {
		this.engineImage = engineImage;
		this.position = position;
		this.boundingBox = bb;
		this.phys = phys;
	}
	
	
	public EngineImage getEngineImage() {
		return engineImage;
	}
	
	public P2d getPosition() {
		return position;
	}

	public void setPosition(P2d position) {
		this.position = position;
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
		return "AbstractGameObject [engineImage=" + engineImage + ", boundingBox=" + boundingBox + 
				", phys=" + phys + ", state="+ state + "]";
	}

}
