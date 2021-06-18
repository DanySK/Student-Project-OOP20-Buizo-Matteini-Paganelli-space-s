package spacesurvival.model.collision.physics;

import spacesurvival.model.common.P2d;
import spacesurvival.model.gameobject.Edge;

public class BoundaryCollision {

    /**
     * Edge created for check in what edge the collision occured.
     */
    private final Edge edge;
    /**
     * P2d where created for check where the collision occured.
     */
    private final P2d where;

    public BoundaryCollision(final Edge edge, final P2d where) {
        this.edge = edge; 
        this.where = where;
    }

    /**
     * Edge created for check in what edge the collision occured.
     * 
     * @return the edge where the collision occured
     */
    public Edge getEdge() {
        return this.edge;
    }

    /**
     * P2d represents where the collision occured.
     * 
     * @return the point where the collision occured
     */
    public P2d getWhere() {
        return this.where;
    }

    /**
     * Return a string describing the boundary collision.
     * 
     * @return a string describing the collision
     */
    @Override
    public String toString() {
        return "BoundaryCollision{" 
                + "edge=" + edge 
                + ", where=" + where
                + '}';
    }
}
