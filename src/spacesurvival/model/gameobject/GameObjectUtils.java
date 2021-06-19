package spacesurvival.model.gameobject;

import java.awt.Dimension;

import spacesurvival.utilities.RandomUtils;
import spacesurvival.utilities.SystemVariables;
import spacesurvival.utilities.dimension.Screen;
import spacesurvival.model.common.P2d;

public final class GameObjectUtils {

    /**
     * Generate a random position to spawn a certain object.
     * 
     * @param objectDim the object dimension to spawn
     * @return return a random point on an edge
     */
    public static P2d generateSpawnPoint(final Dimension objectDim) {
        int xAxis = 0;
        int yAxis = 0;

        switch (Edge.random()) {
        case TOP:
            xAxis = RandomUtils.RANDOM.nextInt(Screen.WIDTH_FULL_SCREEN);
            yAxis = 0 - (int) objectDim.getHeight();
            break;
        case BOTTOM:
            xAxis = RandomUtils.RANDOM.nextInt(Screen.WIDTH_FULL_SCREEN);
            yAxis = Screen.WIDTH_FULL_SCREEN;
            break;
        case LEFT:
            xAxis = 0 - (int) objectDim.getWidth();
            yAxis = RandomUtils.RANDOM.nextInt(Screen.HEIGHT_FULL_SCREEN);
            break;
        case RIGHT:
            xAxis = Screen.WIDTH_FULL_SCREEN;
            yAxis = RandomUtils.RANDOM.nextInt(Screen.HEIGHT_FULL_SCREEN);
            break;
        default:
            break;
        }

        return new P2d(xAxis, yAxis);
    }

    /**
     * @return a random point inside the game screen
     */
    public static P2d generateRandomPoint() {
        return new P2d(RandomUtils.RANDOM.nextInt((int) (Screen.WIDTH_FULL_SCREEN * SystemVariables.SCALE_X)),
                RandomUtils.RANDOM.nextInt((int) (Screen.HEIGHT_FULL_SCREEN * SystemVariables.SCALE_Y)));
    }

    private GameObjectUtils() {
    }

}
