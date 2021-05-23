package spaceSurvival.utilities.dimension;

import spaceSurvival.model.common.P2d;
import spaceSurvival.utilities.SystemVariables;

import java.awt.*;

public class Screen {
    private static final float PROPORTION_BIG= 1.1F;
    private static final float PROPORTION_MEDIUM = 1.6F;
    private static final float PROPORTION_MINI = 2.7F;

    public static final Point POINT_ZERO = new Point(0, 0);

    public static final Dimension FULLSCREEN = SystemVariables.SCREEN;
    public static final int WIDTH_FULL_SCREEN = (int) (FULLSCREEN.getWidth());
    public static final int HEIGHT_FULL_SCREEN = (int) (FULLSCREEN.getHeight());

    public static final P2d POINT_CENTER_FULLSCREEN = new P2d((WIDTH_FULL_SCREEN * SystemVariables.SCALE_X / 2),
            (HEIGHT_FULL_SCREEN * SystemVariables.SCALE_Y / 2 ));
    public static final Rectangle RECTANGLE_FULLSCREEN = new Rectangle(POINT_ZERO,
            new Dimension(WIDTH_FULL_SCREEN, HEIGHT_FULL_SCREEN));


    public static final int WIDTH_BIG = (int) (WIDTH_FULL_SCREEN / PROPORTION_BIG);
    public static final int HEIGHT_BIG = (int) (HEIGHT_FULL_SCREEN / PROPORTION_BIG);
    public static final int CENTER_X_BIG = (int) (POINT_CENTER_FULLSCREEN.getX() - (WIDTH_BIG * SystemVariables.SCALE_X / 2));
    public static final int CENTER_Y_BIG = (int) (POINT_CENTER_FULLSCREEN.getY() - (HEIGHT_BIG * SystemVariables.SCALE_Y / 2));
    public static final Dimension DIMENSION_BIG = new Dimension(WIDTH_BIG, HEIGHT_BIG);

    public static final Point POINT_CENTER_BIG = new Point(CENTER_X_BIG, CENTER_Y_BIG);
    public static final Rectangle RECTANGLE_BIG = new Rectangle(POINT_CENTER_BIG, DIMENSION_BIG);


    public static final int WIDTH_MEDIUM = (int) (WIDTH_FULL_SCREEN/ PROPORTION_MEDIUM);
    public static final int HEIGHT_MEDIUM = (int) (HEIGHT_FULL_SCREEN / PROPORTION_MEDIUM);
    public static final int CENTER_X_MEDIUM = (int) (POINT_CENTER_FULLSCREEN.getX() - (WIDTH_MEDIUM * SystemVariables.SCALE_X / 2));
    public static final int CENTER_Y_MEDIUM = (int) (POINT_CENTER_FULLSCREEN.getY() - (HEIGHT_MEDIUM * SystemVariables.SCALE_Y / 2));

    public static final Dimension DIMENSION_MEDIUM = new Dimension(WIDTH_MEDIUM, HEIGHT_MEDIUM);
    public static final Point POINT_CENTER_MEDIUM = new Point(CENTER_X_MEDIUM, CENTER_Y_MEDIUM);
    public static final Rectangle RECTANGLE_MEDIUM = new Rectangle(POINT_CENTER_MEDIUM, DIMENSION_MEDIUM);


    public static final int WIDTH_MINI = (int) (WIDTH_FULL_SCREEN / PROPORTION_MINI);
    public static final int HEIGHT_MINI = (int) (HEIGHT_FULL_SCREEN / PROPORTION_MINI);
    public static final int CENTER_X_MINI = (int) (POINT_CENTER_FULLSCREEN.getX() - (WIDTH_MINI * SystemVariables.SCALE_X / 2));
    public static final int CENTER_Y_MINI = (int) (POINT_CENTER_FULLSCREEN.getY() - (HEIGHT_MINI * SystemVariables.SCALE_X / 2));

    public static final Dimension DIMENSION_MINI = new Dimension(WIDTH_MINI, HEIGHT_MINI);
    public static final Point POINT_CENTER_MINI = new Point(CENTER_X_MINI, CENTER_Y_MINI);
    public static final Rectangle RECTANGLE_MINI = new Rectangle(POINT_CENTER_MINI, DIMENSION_MINI);


    public static int scaleRespectTo(final int scaleOf, final int respectTo){
        return scaleOf * respectTo / 1000;
    }
}
