package spacesurvival.model.gameobject;

import java.awt.Dimension;
import java.awt.geom.AffineTransform;
import java.util.Random;

import spacesurvival.utilities.SystemVariables;
import spacesurvival.utilities.dimension.Screen;
import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;
import spacesurvival.model.EngineImage;
import spacesurvival.model.collisioni.physics.bounding.BoundingBox;
import spacesurvival.model.collisioni.physics.bounding.CircleBoundingBox;
import spacesurvival.model.collisioni.physics.bounding.RectBoundingBox;

public class GameObjectUtils {
    public static final int INFINITY = 0;
    public static final int SPECIAL_MUNITIONS_QUANTITY = 25;
    
    public static final int SPACESHIP_LIFE = 100;
    public static final int SPACESHIP_LIVES = 3;

    public static final int SPACESHIP_SCALEOF = 50;

    public static final double SPACESHIP_ACCELERATION = 1.15;
    public static final double SPACESHIP_DECELERATION = 0.8;
    public static final double SPACESHIP_MAXVEL = 50; 
    public static final double SPACESHIP_STARTING_VELOCITY = 0.0; 
    public static final double SPACESHIP_ROTATION = 10;    
    
    public static final int ASTEROID_LIFE = 60;
    public static final int ASTEROID_LIFE_INCREMENT = 0;

    public static final int CHASE_ENEMY_LIFE = 70;
    public static final int CHASE_ENEMY_LIFE_INCREMENT = 10;

    public static final int FIRE_ENEMY_LIFE = 50;
    public static final int FIRE_ENEMY_LIFE_INCREMENT = 5;

    public static final int BOSS_LIFE = 300;
    public static final int BOSS_LIFE_INCREMENT = 20;

    public static final V2d SPACESHIP_VEL = new V2d(0, 0);
    public static final V2d ASTEROID_VEL = new V2d(5, 0);
    public static final V2d CHASE_ENEMY_VEL = new V2d(0,-3);
    public static final V2d FIRE_ENEMY_VEL = new V2d();
    public static final V2d BOSS_VEL = new V2d(0, 0);
    public static final V2d BULLET_VEL = new V2d(0, -20);
    public static final V2d NO_VEL = new V2d(0, 0);
    
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
    public static final int INVINCIBLE_DURATION = 3000;
    public static final int ON_FIRE_DURATION = 5000;
    public static final int PARALIZED_DURATION = 3000;
    public static final int FROZEN_DURATION = 5000;
    public static final int HEALED_DURATION = 1000;
    public static final int HEAL_AMOUNT = 30;
    public static final int LIFE_UP_AMOUNT = 1;

    public static final int LIVES_INCREASED_DURATION = 1000;

    public static final int FIRE_DAMAGE = 10;
    public static final int FIRE_INTERVAL_DAMAGE = 1000;
    
    public static final double FROZEN_SLOWDOWN = 0.3;

    public static final int LIFE_GAINED = 50;

    
    public static final int AXIS_NUMBER = Edge.values().length;

    
    public static P2d generateSpawnPoint(Dimension objectDim) {
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

}
