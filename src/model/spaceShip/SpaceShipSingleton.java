package model.spaceShip;

import model.environment.Point2D;
import utilities.DesignSpace;

public class SpaceShipSingleton {
    
    // Eager and unique istance of this class for Threadsafing
    private static SpaceShipSingleton spaceShip = new SpaceShipSingleton(DesignSpace.CENTER_ENVIRONMENT, "spaceShip/maxShip.png");
    
    private Point2D position;
    private String spaceImagePath;
    private int spaceHeight;
    private int spaceWidth;

    
    /** 
    * Invisible class constructor specifying space ship initial position
    */
    private SpaceShipSingleton(final Point2D position, final String path) {
        this.position = position;
        this.spaceImagePath = path;
    }
    
    /**
     * @return space ship static istance
     */
    public static SpaceShipSingleton getSpaceShip() {
        return spaceShip;
    }
    
    /**
     * @return the current space ship position
     */
    public Point2D getPosition() {
        return this.position;
    }
    
    /**
     * @return the current space ship path
     */
    public String getSpaceImagePath() {
        return this.spaceImagePath;
    }


    /**
     * @param newPosition
     *            the new space ship position
     */
    public void setPosition(final Point2D newPosition) {
        this.position = newPosition;
    }
}
