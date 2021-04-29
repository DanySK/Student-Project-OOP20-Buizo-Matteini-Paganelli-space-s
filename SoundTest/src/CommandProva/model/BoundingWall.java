package CommandProva.model;

import common.P2d;

public interface BoundingWall {

	boolean isCollidingWith(P2d p, double radius);
	
}
