package model.worldEcollisioni.physics.boundingType;

import model.common.P2d;

public interface BoundingBox {

	boolean isCollidingWith(P2d p, double radius);
	
}
