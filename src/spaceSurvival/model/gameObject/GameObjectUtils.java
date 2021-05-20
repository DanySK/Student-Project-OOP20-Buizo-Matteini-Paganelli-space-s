package spaceSurvival.model.gameObject;

import java.awt.Dimension;
import java.util.Random;
import spaceSurvival.utilities.dimension.Screen;
import spaceSurvival.model.common.P2d;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.image.EngineImage;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.CircleBoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;

public class GameObjectUtils {
    public static final int INFINITY = 0;
    public static final int SPECIAL_MUNITIONS = 25;
    
    public static final int SPACESHIP_LIFE = 100;
    public static final int SPACESHIP_LIVES = 3;
    public static final int SPACESHIP_SCALEOF = 50;

    
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
    		yAxis = random.nextInt(Screen.WIDTH_FULL_SCREEN);
		break;
		case RIGHT:
			xAxis = Screen.WIDTH_FULL_SCREEN;
    		yAxis = random.nextInt(Screen.WIDTH_FULL_SCREEN);
		break;
		}

    	return new P2d(xAxis, yAxis);
    }

    
    public static BoundingBox createRectBoundingBox(P2d position, EngineImage engineImage) {
    	return new RectBoundingBox(new P2d(position.getX() + engineImage.getWidth()/2, position.getY() + engineImage.getHeight()/2), engineImage);
    	
    	//return new RectBoundingBox(new P2d(position.getX(), position.getY()),
	//							   new P2d(position.getX() + (engineImage.getSize().getWidth()), position.getY() + (engineImage.getSize().getHeight())));
	}
    
    public static BoundingBox createCircleBoundingBox(P2d position, EngineImage engineImage) {
    	return new CircleBoundingBox(position, engineImage.getWidth() / 2);
    }
    


}
