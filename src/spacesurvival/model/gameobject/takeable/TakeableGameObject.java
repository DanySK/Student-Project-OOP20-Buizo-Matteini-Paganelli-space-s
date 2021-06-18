package spacesurvival.model.gameobject.takeable;

import spacesurvival.model.common.P2d;
import spacesurvival.model.gameobject.GameObject;
import spacesurvival.model.gameobject.GameObjectUtils;

import java.util.List;

import spacesurvival.model.EngineImage;
import spacesurvival.model.collision.bounding.BoundingBox;
import spacesurvival.model.collision.bounding.CircleBoundingBox;
import spacesurvival.model.collision.eventgenerator.PhysicsComponent;

public abstract class TakeableGameObject extends GameObject {
	
    public TakeableGameObject(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final PhysicsComponent phys) {
        super(engineImage, position, bb, phys);
        System.out.println("Takeable ");
        this.setBoundingBox(CircleBoundingBox.createCircleBoundingBox(position, engineImage, this.getTransform()));
    }

    public TakeableGameObject(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final PhysicsComponent phys, final List<String> animation) {
        super(engineImage, position, bb, phys);
        this.setBoundingBox(CircleBoundingBox.createCircleBoundingBox(position, engineImage, this.getTransform()));
        super.setAnimation(animation);
    }

}
