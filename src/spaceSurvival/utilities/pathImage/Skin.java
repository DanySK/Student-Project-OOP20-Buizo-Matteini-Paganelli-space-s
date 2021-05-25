package spaceSurvival.utilities.pathImage;

import java.nio.file.Paths;

public class Skin {

    public static final String MAIN_FOLDER = "gameObjects";

    public static final String SHIP_FOLDER = "spaceship";

    public static final String TYPE_SHIP = "ship1";

    public static final String SPECIAL = Paths.get(MAIN_FOLDER, SHIP_FOLDER, TYPE_SHIP, "ship1.png").toString();
    public static final String SPECIAL1 = Paths.get(MAIN_FOLDER, SHIP_FOLDER, TYPE_SHIP, "ship1_1.png").toString();
    public static final String SPECIAL2 = Paths.get(MAIN_FOLDER, SHIP_FOLDER, TYPE_SHIP, "ship1_2.png").toString();
    public static final String SPECIAL3 = Paths.get(MAIN_FOLDER, SHIP_FOLDER, TYPE_SHIP, "ship1_3.png").toString();
    public static final String SPECIAL4 = Paths.get(MAIN_FOLDER, SHIP_FOLDER, TYPE_SHIP, "ship1_4.png").toString();

    public static final String STANDARD = Paths.get(MAIN_FOLDER, SHIP_FOLDER, "ship2.png").toString();
    public static final String DELUXE = Paths.get(MAIN_FOLDER, SHIP_FOLDER, "ship3.png").toString();
    public static final String NORMAL = Paths.get(MAIN_FOLDER,SHIP_FOLDER, "ship4.png").toString();
    public static final String ATOMIC = Paths.get(MAIN_FOLDER, SHIP_FOLDER, "ship5.png").toString();

}
