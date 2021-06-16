package spacesurvival.model.gameobject.takeable;

import java.util.List;

import spacesurvival.model.EngineImage;
import spacesurvival.model.collisioni.physics.bounding.BoundingBox;
import spacesurvival.model.collisioni.physics.component.PhysicsComponent;
import spacesurvival.model.common.P2d;

public class Ammo extends TakeableGameObject {

	private AmmoType type;
	
	public Ammo(final EngineImage engineImage, final P2d position, final BoundingBox bb,
			final PhysicsComponent phys, final AmmoType type) {
		super(engineImage, position, bb, phys);
		this.type = type;
	}
	
	public Ammo(final EngineImage engineImage, final P2d position, final BoundingBox bb,
			final PhysicsComponent phys, final List<String> animation, final AmmoType type) {
		super(engineImage, position, bb, phys, animation);
		this.type = type;
	}

	public AmmoType getType() {
		return type;
	}

	public void setType(AmmoType type) {
		this.type = type;
	}
}
