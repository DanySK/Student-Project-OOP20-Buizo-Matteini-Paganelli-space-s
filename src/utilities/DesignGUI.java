package utilities;

import java.awt.*;

public class DesignGUI {
    private static final float PROPORTION = 1.2F;

    private static final Dimension SCREEN = Toolkit.getDefaultToolkit().getScreenSize();

    public static final int GUI_WIDTH = (int) (SCREEN.width / PROPORTION);
    public static final int GUI_HEIGHT = (int) (SCREEN.height / PROPORTION);
}
