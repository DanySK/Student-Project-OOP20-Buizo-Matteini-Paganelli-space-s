package spacesurvival.utilities.dimension;

import spacesurvival.model.common.P2d;
import spacesurvival.utilities.SystemVariables;

import java.awt.Point;
import java.awt.Dimension;
import java.awt.Rectangle;

public class Screen {
    private static final float PROPORTION_BIG = 0.9F;
    private static final float PROPORTION_MEDIUM = 0.6F;
    private static final float PROPORTION_MINI = 0.4F;

    private static final double FIND_CENTER_X = 2 * SystemVariables.SCALE_X;
    private static final double FIND_CENTER_Y = 2 * SystemVariables.SCALE_Y;

    public static final Point POINT_ZERO = new Point(0, 0);

    public static final Dimension FULLSCREEN = SystemVariables.SCREEN;
    public static final int WIDTH_FULLSCREEN = (int) (FULLSCREEN.getWidth());
    public static final int HEIGHT_FULLSCREEN = (int) (FULLSCREEN.getHeight());
    public static final double CENTER_X_FULLSCREEN = ((WIDTH_FULLSCREEN * SystemVariables.SCALE_X) / FIND_CENTER_X);
    public static final double CENTER_Y_FULLSCREEN = ((HEIGHT_FULLSCREEN * SystemVariables.SCALE_Y) / FIND_CENTER_Y);
    public static final P2d POINT_CENTER_FULLSCREEN = new P2d(CENTER_X_FULLSCREEN, CENTER_Y_FULLSCREEN);
    public static final Point JAVA_POINT_CENTER_FULLSCREEN = new Point((int)POINT_CENTER_FULLSCREEN.getX(), (int)POINT_CENTER_FULLSCREEN.getY());
    public static final Rectangle RECTANGLE_FULLSCREEN = new Rectangle(POINT_ZERO, FULLSCREEN);


    public static final int WIDTH_BIG = (int) (WIDTH_FULLSCREEN * PROPORTION_BIG);
    public static final int HEIGHT_BIG = (int) (HEIGHT_FULLSCREEN * PROPORTION_BIG);
    public static final int CENTER_X_BIG = (int) (POINT_CENTER_FULLSCREEN.getX() - ((WIDTH_BIG * SystemVariables.SCALE_X) / FIND_CENTER_X));
    public static final int CENTER_Y_BIG = (int) (POINT_CENTER_FULLSCREEN.getY() - ((HEIGHT_BIG * SystemVariables.SCALE_Y) / FIND_CENTER_Y));
    public static final Dimension DIMENSION_BIG = new Dimension(WIDTH_BIG, HEIGHT_BIG);
    public static final P2d POINT_CENTER_BIG = new P2d(CENTER_X_BIG, CENTER_Y_BIG);
    public static final Point JAVA_POINT_CENTER_BIG = new Point((int)POINT_CENTER_BIG.getX(), (int)POINT_CENTER_BIG.getY());
    public static final Rectangle RECTANGLE_BIG = new Rectangle(JAVA_POINT_CENTER_BIG, DIMENSION_BIG);

    public static final int WIDTH_MEDIUM = (int) (WIDTH_FULLSCREEN * PROPORTION_MEDIUM);
    public static final int HEIGHT_MEDIUM = (int) (HEIGHT_FULLSCREEN * PROPORTION_MEDIUM);
    public static final int CENTER_X_MEDIUM = (int) (POINT_CENTER_FULLSCREEN.getX() - ((WIDTH_MEDIUM * SystemVariables.SCALE_X) / FIND_CENTER_X));
    public static final int CENTER_Y_MEDIUM = (int) (POINT_CENTER_FULLSCREEN.getY() - ((HEIGHT_MEDIUM * SystemVariables.SCALE_Y) / FIND_CENTER_Y));
    public static final Dimension DIMENSION_MEDIUM = new Dimension(WIDTH_MEDIUM, HEIGHT_MEDIUM);
    public static final P2d POINT_CENTER_MEDIUM = new P2d(CENTER_X_MEDIUM, CENTER_Y_MEDIUM);
    public static final Point JAVA_POINT_CENTER_MEDIUM = new Point((int)POINT_CENTER_MEDIUM.getX(), (int)POINT_CENTER_MEDIUM.getY());
    public static final Rectangle RECTANGLE_MEDIUM = new Rectangle(JAVA_POINT_CENTER_MEDIUM, DIMENSION_MEDIUM);


    public static final int WIDTH_MINI = (int) (WIDTH_FULLSCREEN * PROPORTION_MINI);
    public static final int HEIGHT_MINI = (int) (HEIGHT_FULLSCREEN * PROPORTION_MINI);
    public static final int CENTER_X_MINI = (int) (POINT_CENTER_FULLSCREEN.getX() - ((WIDTH_MINI * SystemVariables.SCALE_X) / FIND_CENTER_X));
    public static final int CENTER_Y_MINI = (int) (POINT_CENTER_FULLSCREEN.getY() - ((HEIGHT_MINI * SystemVariables.SCALE_Y) / FIND_CENTER_Y));
    public static final Dimension DIMENSION_MINI = new Dimension(WIDTH_MINI, HEIGHT_MINI);
    public static final P2d POINT_CENTER_MINI = new P2d(CENTER_X_MINI, CENTER_Y_MINI);
    public static final Point JAVA_POINT_MINI = new Point((int)POINT_CENTER_MINI.getX(), (int)POINT_CENTER_MINI.getY());
    public static final Rectangle RECTANGLE_MINI = new Rectangle(JAVA_POINT_MINI, DIMENSION_MINI);


    public static int scaleRespectTo(final int scaleOf, final int respectTo){
        return scaleOf * respectTo / 1000;
    }
}
