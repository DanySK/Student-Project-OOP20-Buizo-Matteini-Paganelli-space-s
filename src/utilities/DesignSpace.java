package utilities;

import model.environment.Point2D;
import model.image.EngineImage;

import java.awt.*;
import java.net.URL;

public class DesignSpace {
    public static final Point2D CENTER_ENVIRONMENT = new Point2D(DimensionScreen.WIDTH_MEDIUM / 2, DimensionScreen.HEIGHT_MEDIUM / 2);

    public static int SIZE_FONT_MAX = 60;
    public static int SIZE_FONT_BIG = 30;
    public static int SIZE_FONT_MEDIUM = 25;
    public static int SIZE_FONT_MICRO = 20;
    public static int SIZE_FONT_NANO = 15;

    public static final int SIZE_IMAGE_MEDIUM = 70;
    public static final int SIZE_IMAGE_SMALL = 50;

    public static final String TYPE_FONT_STANDARD = "Helvetica";

    public static final Font FONT_BIG_STANDARD = new Font(TYPE_FONT_STANDARD, Font.BOLD, SIZE_FONT_BIG);
    public static final Font FONT_MEDIUM_STANDARD = new Font(TYPE_FONT_STANDARD, Font.BOLD, SIZE_FONT_MEDIUM);
    public static final Font FONT_MICRO_STANDARD = new Font(TYPE_FONT_STANDARD, Font.BOLD, SIZE_FONT_MICRO);
    public static final Font FONT_SMALL_STANDARD = new Font(TYPE_FONT_STANDARD, Font.BOLD, SIZE_FONT_NANO);

    public static final int SIZE_COLUMNS_TEXT = 10;

    public static Color color1 = new Color(90, 165, 232);
    public static Color color2 = new Color(128, 213, 255);
    public static Color color3 = new Color(148, 233, 255);
    public static Color color4 = new Color(58, 241, 255);

    public static Font getFontForTitle(final int size){
        URL fontUrl = ClassLoader.getSystemResource("font/mainFont.ttf");
        Font myFont = null;
        try {
            myFont = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
        } catch (Exception e) {
            System.err.println("Path font no found");
        }
        myFont = myFont.deriveFont(Font.PLAIN,size);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(myFont);

        return myFont;
    }

    public static Font getFontForGame(final int size){
        URL fontUrl = ClassLoader.getSystemResource("font/game.ttf");
        Font myFont = null;
        try {
            myFont = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
        } catch (Exception e) {
            System.err.println("Path font no found");
        }

        myFont = myFont.deriveFont(Font.PLAIN,size);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(myFont);

        return myFont;
    }

}
