package utilities;

import model.environment.Point2D;

import java.awt.*;

public class DesignJFrame {
    private static final float PROPORTION = 1.2F;

    private static final Dimension SCREEN = Toolkit.getDefaultToolkit().getScreenSize();
    private static final Point2D POINT_CENTER_SCREEN = new Point2D(SCREEN.width / 2, SCREEN.height / 2);

    public static final int GUI_WIDTH = (int) (SCREEN.width / PROPORTION);
    public static final int GUI_HEIGHT = (int) (SCREEN.height / PROPORTION);

    public static final int GUI_X = POINT_CENTER_SCREEN.getX() - (GUI_WIDTH / 2);
    public static final int GUI_Y =  POINT_CENTER_SCREEN.getY() - (GUI_HEIGHT / 2);

    public static final String PATH_MAIN_BACKGROUND = "background/main.png";
}
