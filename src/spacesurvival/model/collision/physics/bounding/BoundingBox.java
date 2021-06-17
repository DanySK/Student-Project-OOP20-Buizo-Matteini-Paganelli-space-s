package spacesurvival.model.collision.physics.bounding;

import java.awt.geom.AffineTransform;

public interface BoundingBox {

    AffineTransform getTransform();
    void setTransform(AffineTransform transform);
}
