package spacesurvival.model.gameobject;

import java.awt.Dimension;
import java.awt.geom.AffineTransform;
import java.util.Random;

import spacesurvival.utilities.SystemVariables;
import spacesurvival.utilities.dimension.Screen;
import spacesurvival.model.common.P2d;
import spacesurvival.model.EngineImage;
import spacesurvival.model.collision.physics.bounding.BoundingBox;
import spacesurvival.model.collision.physics.bounding.CircleBoundingBox;
import spacesurvival.model.collision.physics.bounding.RectBoundingBox;

public class GameObjectUtils {

    public static final int SPACESHIP_LIFE = 100;
    public static final int SPACESHIP_LIVES = 3;

    public static final double SPACESHIP_MAXVEL = 50; 
    public static final double SPACESHIP_ROTATION = 10;

    public static final int ASTEROID_LIFE = 60;
    public static final int ASTEROID_LIFE_INCREMENT = 0;

    public static final int CHASE_ENEMY_LIFE = 70;
    public static final int CHASE_ENEMY_LIFE_INCREMENT = 10;

    public static final int FIRE_ENEMY_LIFE = 50;
    public static final int FIRE_ENEMY_LIFE_INCREMENT = 5;


    public static final int BOSS_LIFE = 1000;
    public static final int BOSS_LIFE_INCREMENT = 20;
    
    public static final int SPACESHIP_DAMAGE = 100;

    public static final int ASTEROID_DAMAGE = 25;
    public static final int ASTEROID_DAMAGE_INCREMENT = 0;

    public static final int CHASE_ENEMY_DAMAGE = 50;
    public static final int CHASE_ENEMY_DAMAGE_INCREMENT = 5;

    public static final int FIRE_ENEMY_DAMAGE = 35;
    public static final int FIRE_ENEMY_DAMAGE_INCREMENT = 5;

    public static final int BOSS_DAMAGE = 60;
    public static final int BOSS_DAMAGE_INCREMENT = 10;

    /*
     * EFFECT / STATUS
     * */

    public static final int HEAL_AMOUNT = 30;
    public static final int LIFE_UP_AMOUNT = 100;

    public static final int FIRE_DAMAGE = 10;
    
    public static final double FROZEN_SLOWDOWN = 0.3;

    public static final int LIFE_GAINED = 50;

    
    public static final int AXIS_NUMBER = Edge.values().length;


    public static P2d generateSpawnPoint(final Dimension objectDim) {
    	Random random = new Random();
    	int xAxis = 0;
    	int yAxis = 0;
    	      	
    	switch (Edge.randomAxis()) {
    	case TOP:
    	    xAxis = random.nextInt(Screen.WIDTH_FULL_SCREEN);
    	    yAxis = 0 - (int) objectDim.getHeight();
    	    break;
    	case BOTTOM:
    	    xAxis = random.nextInt(Screen.WIDTH_FULL_SCREEN);
    	    yAxis = Screen.WIDTH_FULL_SCREEN;
    	    break;
    	case LEFT:
    	    xAxis = 0 - (int) objectDim.getWidth();
    	    yAxis = random.nextInt(Screen.HEIGHT_FULL_SCREEN);
    	    break;
    	case RIGHT:
    	    xAxis = Screen.WIDTH_FULL_SCREEN;
    	    yAxis = random.nextInt(Screen.HEIGHT_FULL_SCREEN);
    	    break;
    	}

    	return new P2d(xAxis, yAxis);
    }

    public static P2d generateRandomPoint() {
    	Random random = new Random();
    	return new P2d(random.nextInt((int) (Screen.WIDTH_FULL_SCREEN * SystemVariables.SCALE_X)),  random.nextInt((int) (Screen.HEIGHT_FULL_SCREEN * SystemVariables.SCALE_Y)));
    }

    public static BoundingBox createRectBoundingBox(final P2d position, final EngineImage engineImage, final AffineTransform transform) {
    	return new RectBoundingBox(new P2d(position.getX() + engineImage.getWidth() / 2, position.getY() + engineImage.getHeight() / 2),
    	        engineImage, transform);
    }

    public static BoundingBox createCircleBoundingBox(final P2d position,
            final EngineImage engineImage, final AffineTransform transform) {
    	return new CircleBoundingBox(position, engineImage.getWidth() / 2, transform);
    }

    /**
     * Method that return the angle in degrees readed from an AffineTransform.
     * 
     * @param transform AffineTransform from which to read the angle
     * @return the angle in degrees
     */
    public static double getRotationAngleInDegrees(final AffineTransform transform) {
        final double m00 = transform.getScaleX();
        final double m01 = transform.getShearX();

        return Math.round(Math.toDegrees(Math.atan2(-m01, m00)));
    }

    /**
     * Method that return the angle in radiants readed from an AffineTransform.
     * 
     * @param transform AffineTransform from which to read the angle
     * @return the angle in radiants
     */
    public static double getRotationAngleInRadiant(final AffineTransform transform) {
        final double m00 = transform.getScaleX();
        final double m01 = transform.getShearX();

        return Math.round(Math.atan2(-m01, m00));
    }

}
