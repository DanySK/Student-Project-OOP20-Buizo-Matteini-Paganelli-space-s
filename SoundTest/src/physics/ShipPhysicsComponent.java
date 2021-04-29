package physics;

import java.util.Optional;

import CommandProva.model.*;
import common.P2d;


public class ShipPhysicsComponent extends PhysicsComponent {

	public void update(int dt, GameObject obj, World w) {
		super.update(dt, obj, w);
		//w.checkBoundaries(obj);
		PerkBoundingBox bbox = (PerkBoundingBox) obj.getBBox();
		Optional<ShipCollision> binfo = w.checkCollisionWithBoundaries(obj.getCurrentPos(), bbox);
		if (binfo.isPresent()){
			ShipCollision info = binfo.get();
			P2d pos = obj.getCurrentPos();
			
			switch (info.getEdge()){
			case TOP: 
				obj.setPos(new P2d(pos.x, info.getWhere().y - bbox.getRadius()));
				obj.flipVelOnY();
				w.notifyWorldEvent(new HitWallEvent(info.getWhere()));
				break;
			case BOTTOM: 
				obj.setPos(new P2d(pos.x, info.getWhere().y + bbox.getRadius()));
				obj.flipVelOnY();
				w.notifyWorldEvent(new HitWallEvent(info.getWhere()));
				break;
			case LEFT: 
				obj.setPos(new P2d(info.getWhere().x + bbox.getRadius(), pos.y));
				obj.flipVelOnX();
				w.notifyWorldEvent(new HitWallEvent(info.getWhere()));
				break;
			case RIGHT: 
				obj.setPos(new P2d(info.getWhere().x - bbox.getRadius(), pos.y));
				obj.flipVelOnX();
				w.notifyWorldEvent(new HitWallEvent(info.getWhere()));
				break;
			}
		}
		
		Optional<GameObject> pick = w.checkCollisionWithPickUpObj(obj.getCurrentPos(), bbox);
		if (pick.isPresent()){
			w.notifyWorldEvent(new HitPickUpEvent(pick.get()));
		}
		
	}

}
