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

public final class GameObjectUtils {

    public static P2d generateSpawnPoint(final Dimension objectDim) {
        final Random random = new Random();
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
    	    default:
    	        break;
    	}

    	return new P2d(xAxis, yAxis);
    }

    public static P2d generateRandomPoint() {
    	final Random random = new Random();
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

    private GameObjectUtils() {
    }
}
