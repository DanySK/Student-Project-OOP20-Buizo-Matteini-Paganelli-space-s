package spacesurvival.model.gameobject;

import java.awt.Dimension;
import java.util.Random;
import spacesurvival.utilities.SystemVariables;
import spacesurvival.utilities.dimension.Screen;
import spacesurvival.model.common.P2d;

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

    private GameObjectUtils() {
    }

}
