package spacesurvival.model.worldEcollisioni.physics.boundingType;

import spacesurvival.model.common.P2d;
import java.awt.geom.AffineTransform;

public interface BoundingBox {
    boolean isCollidingWith(P2d p, double radius);

    AffineTransform getTransform();
    void setTransform(AffineTransform transform);
}
