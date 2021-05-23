package spaceSurvival.utilities;

import java.awt.*;

public class SystemVariables {
//     GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    public static final Dimension SCREEN = Toolkit.getDefaultToolkit().getScreenSize();

    public static final double SCALE_X = GraphicsEnvironment.getLocalGraphicsEnvironment()
                    .getDefaultScreenDevice().getDefaultConfiguration()
                    .getDefaultTransform().getScaleX();

    public static final double SCALE_Y = GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getDefaultScreenDevice().getDefaultConfiguration()
            .getDefaultTransform().getScaleY();

}
