package spaceSurvival.utilities.pathImage;

import java.nio.file.Paths;

public class Skin {

    public static final String MAIN_FOLDER = "gameObjects";

    public static final String SHIP_FOLDER = "spaceship";

    public static final String SPECIAL = Paths.get(MAIN_FOLDER, SHIP_FOLDER, "ship1.png").toString();
    public static final String STANDARD = Paths.get(MAIN_FOLDER, SHIP_FOLDER, "ship2.png").toString();
    public static final String DELUXE = Paths.get(MAIN_FOLDER, SHIP_FOLDER, "ship3.png").toString();
    public static final String NORMAL = Paths.get(MAIN_FOLDER,SHIP_FOLDER, "ship4.png").toString();
    public static final String ATOMIC = Paths.get(MAIN_FOLDER, SHIP_FOLDER, "ship5.png").toString();

}
