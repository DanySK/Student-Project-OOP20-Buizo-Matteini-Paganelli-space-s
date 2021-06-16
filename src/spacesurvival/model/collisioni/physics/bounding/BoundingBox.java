package spacesurvival.model.collisioni.physics.bounding;

import spacesurvival.model.common.P2d;

import java.awt.geom.AffineTransform;

public interface BoundingBox {
    boolean isCollidingWith(P2d p, double radius);

    AffineTransform getTransform();
    void setTransform(AffineTransform transform);
}
