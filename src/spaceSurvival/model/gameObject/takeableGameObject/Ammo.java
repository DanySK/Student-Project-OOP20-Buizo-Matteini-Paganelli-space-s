package spaceSurvival.model.gameObject.takeableGameObject;

import java.util.List;

import spaceSurvival.model.EngineImage;
import spaceSurvival.model.common.P2d;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.PhysicsComponent;

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
