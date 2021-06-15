package model.worldEcollisioni.physics.components;

import model.gameObject.GameObject;
import model.World;

public class PickablePhysicsComponent implements PhysicsComponent {
	
	@Override
	public void update(int dt, GameObject obj, World w) {
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
