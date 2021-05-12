package model.worldEcollisioni.physics.components;

import java.util.Optional;
import model.gameObject.AbstractGameObject;
import model.world.World;
import model.worldEcollisioni.hitEvents.HitPerkEvent;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;

public class PerkPhysicsComponent extends PhysicsComponent {
	public void update(int dt, AbstractGameObject obj, World w) {
		
	
		RectBoundingBox bbox = (RectBoundingBox) obj.getBoundingBox();
		
		Optional<AbstractGameObject> perk = w.checkCollisionWithAsteroids(obj.getPosition(), bbox);
		//collisioni con perks
		if (perk.isPresent()){
			w.notifyWorldEvent(new HitPerkEvent(perk.get()));
			System.out.println("Preso il PERK Fratellì");
		}
		
	}
}
