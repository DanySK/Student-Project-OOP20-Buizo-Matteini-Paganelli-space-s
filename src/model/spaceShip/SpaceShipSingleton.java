package model.spaceShip;

import java.awt.Dimension;

import model.MyJImage.JImageRateEngine;
import model.environment.Point2D;
import utilities.DesignSpace;

public class SpaceShipSingleton {
    
    // Eager and unique istance of this class for Threadsafing
    private static SpaceShipSingleton spaceShip = new SpaceShipSingleton(DesignSpace.CENTER_ENVIRONMENT, "spaceShip/maxShip.png");
    
    private Point2D position;
    private JImageRateEngine imageEngine;
    private Dimension dimension;
    
    /** 
    * Invisible class constructor specifying space ship initial position
    */
    private SpaceShipSingleton(final Point2D position, final String imagePath) {
        this.position = position;
        this.imageEngine = new JImageRateEngine(imagePath, 10);
        //this.imageEngine
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
     * @return the current space ship image model
     */
    public JImageRateEngine getSpaceImageEngine() {
        return this.imageEngine;
    }

    /**
     * @return the current space ship dimension
     */
    public Dimension getDimension() {
        return this.dimension;
    }
    
    /**
     * @param newPosition
     *            the new space ship position
     */
    public void setPosition(final Point2D newPosition) {
        this.position = newPosition;
    }
    
    /**
     * @param newDimension
     *            the new space ship position
     */
    public void setDimension(final Dimension newDimension) {
        this.dimension = newDimension;
        System.out.println(this.dimension);
    }
}

