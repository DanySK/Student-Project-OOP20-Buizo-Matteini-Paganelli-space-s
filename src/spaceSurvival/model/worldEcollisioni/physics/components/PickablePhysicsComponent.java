package spaceSurvival.model.worldEcollisioni.physics.components;

import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.World;

public class PickablePhysicsComponent implements PhysicsComponent {
	
	@Override
	public void update(final int dt, final GameObject obj, final World w) {
		//CircleBoundingBox bbox = (CircleBoundingBox) obj.getBoundingBox();
		//Optional<PickableGameObject> perk = w.checkCollisionWithPickables(obj.getPosition(), bbox);
		//collisioni con perks
//		if (perk.isPresent()) {
//			w.notifyWorldEvent(new HitPickableEvent(perk.get()));
//			System.out.println("Preso il PERK Fratellì");
//		}
//		
	}

}
