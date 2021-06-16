package spacesurvival.utilities;

import java.awt.*;
import java.nio.file.FileSystems;

public class SystemVariables {
    public static final GraphicsDevice GRAPHICS_DEVICE =  GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    public static final Dimension SCREEN = Toolkit.getDefaultToolkit().getScreenSize();


    public static final double SCALE_X = GraphicsEnvironment.getLocalGraphicsEnvironment()
                    .getDefaultScreenDevice().getDefaultConfiguration()
                    .getDefaultTransform().getScaleX();

    public static final double SCALE_Y = GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getDefaultScreenDevice().getDefaultConfiguration()
            .getDefaultTransform().getScaleY();


    public static final String PATH_SEPARATOR = FileSystems.getDefault().getSeparator();

    public static String OS = System.getProperty("os.name").toLowerCase();
}
