package model.gameObject;

import java.awt.Dimension;
import java.util.Random;
import model.environment.Point2D;
import utilities.DimensionScreen;

public class GameObjectUtils {

    public static final int SPACESHIP_LIFE = 100;
    public static final int SPACESHIP_LIVES = 3;
    public static final int SPACESHIP_SCALEOF = 100;

    
    public static final int ASTEROID_LIFE = 60;
    public static final int ASTEROID_LIFE_INCREMENT = 0;

    public static final int CHASE_ENEMY_LIFE = 70;
    public static final int CHASE_ENEMY_LIFE_INCREMENT = 10;

    public static final int FIRE_ENEMY_LIFE = 50;
    public static final int FIRE_ENEMY_LIFE_INCREMENT = 5;

    public static final int BOSS_LIFE = 300;
    public static final int BOSS_LIFE_INCREMENT = 20;

   
    public static final V2d ASTEROID_VEL = new V2d();
    public static final V2d CHASE_ENEMY_VEL = new V2d();
    public static final V2d FIRE_ENEMY_VEL = new V2d();
    public static final V2d BOSS_VEL = new V2d();
    
    public static final int SPACESHIP_DAMAGE = 100;

    public static final int ASTEROID_DAMAGE = 25;
    public static final int ASTEROID_DAMAGE_INCREMENT = 0;

    public static final int CHASE_ENEMY_DAMAGE = 50;
    public static final int CHASE_ENEMY_DAMAGE_INCREMENT = 5;

    public static final int FIRE_ENEMY_DAMAGE = 35;
    public static final int FIRE_ENEMY_DAMAGE_INCREMENT = 5;

    public static final int BOSS_DAMAGE = 60;
    public static final int BOSS_DAMAGE_INCREMENT = 10;

    
    public static final int AXIS_NUMBER = Edge.values().length;

    
    public static Point2D generateSpawnPoint(Dimension objectDim) {
    	Random random = new Random();
    	int xAxis = 0;
    	int yAxis = 0;
    	      	
    	switch (Edge.randomAxis()) {
		case TOP:
    		xAxis = random.nextInt(DimensionScreen.WIDTH_FULL_SCREEN);
    		yAxis = 0 - (int) objectDim.getHeight();
		break;
		case BOTTOM:
    		xAxis = random.nextInt(DimensionScreen.WIDTH_FULL_SCREEN);
    		yAxis = DimensionScreen.WIDTH_FULL_SCREEN;
		break;
		case LEFT:
			xAxis = 0 - (int) objectDim.getWidth();
    		yAxis = random.nextInt(DimensionScreen.WIDTH_FULL_SCREEN);
		break;
		case RIGHT:
			xAxis = DimensionScreen.WIDTH_FULL_SCREEN;
    		yAxis = random.nextInt(DimensionScreen.WIDTH_FULL_SCREEN);
		break;
		}

    	return new Point2D(xAxis, yAxis);
    }
    
    public static void main(String[] args) {
		System.out.println(generateSpawnPoint(new Dimension(50, 50)));
	}

}
