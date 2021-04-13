package utilities;

import model.environment.Point2D;

import java.awt.*;

public class DesignJFrame {
    private static final float PROPORTION_MEDIUM = 1.2F;

    private static final float PROPORTION_MINI = 2F;

    private static final Dimension SCREEN = Toolkit.getDefaultToolkit().getScreenSize();
    private static final Point2D POINT_CENTER_SCREEN = new Point2D(SCREEN.width / 2, SCREEN.height / 2);

    public static final int GUI_WIDTH_FULL_SCREEN = SCREEN.width;
    public static final int GUI_HEIGHT_FULL_SCREEN = SCREEN.height;

    public static final int GUI_WIDTH_MEDIUM = (int) (SCREEN.width / PROPORTION_MEDIUM);
    public static final int GUI_HEIGHT_MEDIUM = (int) (SCREEN.height / PROPORTION_MEDIUM);

    public static final int GUI_WIDTH_MINI = (int) (SCREEN.width / PROPORTION_MINI);
    public static final int GUI_HEIGHT_MINI = (int) (SCREEN.height / PROPORTION_MINI);

    public static final int GUI_X_ZERO = 0;
    public static final int GUI_Y_ZERO = 0;

    public static final int GUI_X_MEDIUM = POINT_CENTER_SCREEN.getX() - (GUI_WIDTH_MEDIUM / 2);
    public static final int GUI_Y_MEDIUM =  POINT_CENTER_SCREEN.getY() - (GUI_HEIGHT_MEDIUM / 2);

    public static final int GUI_X_MINI = POINT_CENTER_SCREEN.getX() - (GUI_WIDTH_MINI / 2);
    public static final int GUI_Y_MINI =  POINT_CENTER_SCREEN.getY() - (GUI_HEIGHT_MINI / 2);

    public static final String PATH_MAIN_BACKGROUND = "background/main.png";
}
